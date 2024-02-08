package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helper.FactoryProvider;
import com.vignan.Recipe; // Make sure to import your Employee entity class

@WebServlet("/deleteRecipeServlet")
public class deleteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the recipe to delete from the form
        int recipeId = Integer.parseInt(request.getParameter("id"));

        // Create a Hibernate  Session
        Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            Recipe recipe = session.get(Recipe.class, recipeId);

            // Delete the employee if found
            if (recipe != null) {
                session.remove(recipe);
                response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Recipe deleted</h1>");
        		out.println("<h1 style='text-align:center;'><a href='listRecipes.jsp'>View all Recipes</a></h1>");
  
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Recipe Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='listRecipes.jsp'>View all Recipes</a></h1>");
            }

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        
    }
}
