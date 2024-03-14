package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import com.opensymphony.xwork2.ActionSupport;

import com.example.User;
import com.example.FactoryProvider;

public class LoginAction extends ActionSupport implements ServletRequestAware {
    
    private String username;
    private String password;
    private HttpServletRequest request;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String post() {
        Session session = FactoryProvider.getFactory().openSession();
        try {
            if (username == null || username.isEmpty()) {
                addActionError("Username cannot be empty");
                return ERROR;
            }

            // Find user by username
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.select(root).where(builder.equal(root.get("username"), username));
            Query<User> query = session.createQuery(criteria);
            User existingUser = query.uniqueResult();

            if (existingUser != null && existingUser.getPassword().equals(password)) {
                // Store username in session
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("username", username);
                
                addActionMessage("Login successful");
                return SUCCESS;
            } else {
                addActionError("Invalid username or password");
                return ERROR;
            }
        } catch (Exception e) {
            addActionError("Error authenticating user: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
    }
}
