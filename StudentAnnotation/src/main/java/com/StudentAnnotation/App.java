package com.StudentAnnotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	Student obj = new Student(10, "Ajay", "CSE");
    	
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	session.persist(obj);
    	
    	tx.commit();
    	
    	factory.close();
    	
    	
    }
}
