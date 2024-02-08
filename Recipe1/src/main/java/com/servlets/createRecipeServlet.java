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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.helper.FactoryProvider;
import com.vignan.Recipe;

@WebServlet("/createRecipeServlet")
public class createRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public createRecipeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String recipeName = request.getParameter("recipeName");
		String ingredients = request.getParameter("ingredients");
		String instructions = request.getParameter("instructions");
		String difficultyLevel = request.getParameter("difficultyLevel");
		
		Recipe recipe = new Recipe(recipeName, ingredients, instructions, difficultyLevel);
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(recipe);
		tx.commit();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='text-align:center;'>Recipe is added successfully</h1>");
		out.println("<h1 style='text-align:center;'><a href='listRecipes.jsp'>View all Recipes</a></h1>");
	}

}
