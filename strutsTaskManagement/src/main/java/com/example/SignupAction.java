package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;


public class SignupAction extends ActionSupport {
	
    private User user = new User();

    public String post() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            addActionMessage("user registered successfully!");
            return SUCCESS;
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            // Handle any exceptions that occur during the book addition process
            addActionError("Error creating user: " + e.getMessage());
            return ERROR;
        } finally {
            // Close the Hibernate session
            session.close();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
