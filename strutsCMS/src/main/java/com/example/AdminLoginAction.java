package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import com.example.User;
import com.example.FactoryProvider;

public class AdminLoginAction extends ActionSupport implements ServletRequestAware {
    
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
            if (username == null) {
                addActionError("Admin cannot be empty");
                return ERROR;
            }

            if (username.equals("admin") && password.equals("admin")) {
                // Store username in session
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("adminUsername", username);
                
                addActionMessage("Admin Login successful");
                return SUCCESS;
            } else {
                addActionError("Invalid username or password");
                return ERROR;
            }
        } catch (Exception e) {
            addActionError("Error authenticating Admin: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
    }
}
