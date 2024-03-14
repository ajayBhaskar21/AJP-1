package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.FactoryProvider;
import com.opensymphony.xwork2.ActionSupport;
import com.example.Task;

public class AddTaskAction extends ActionSupport {
    private Task task = new Task();

    public String post() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
            addActionMessage("task added successfully!");
            return SUCCESS;
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            // Handle any exceptions that occur during the book addition process
            addActionError("Error adding task: " + e.getMessage());
            return ERROR;
        } finally {
            // Close the Hibernate session
            session.close();
        }
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
