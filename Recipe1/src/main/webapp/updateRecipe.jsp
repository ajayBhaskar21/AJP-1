<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.vignan.Recipe" %>
<%@ page import="com.helper.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Recipe</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>List of Recipes</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Recipe Name</th>
            <th>Ingredients</th>
            <th>Instructions</th>
            <th>Difficulty Level</th>
        </tr>
        
        <% 
   
            Session session2 = FactoryProvider.getFactory().openSession();
            
            try {
                session2.beginTransaction();
                List<Recipe> recipes = session2.createQuery("from Recipe", Recipe.class).getResultList();
                
                for (Recipe i : recipes) {
        %>
                <tr>
                    <td><%= i.getRecipeId() %></td>
                    <td><%= i.getRecipeName() %></td>
                    <td><%= i.getIngredients() %></td>
                    <td><%= i.getInstructions() %></td>
                    <td><%= i.getDifficultyLevel() %></td>
                </tr>
        <%
                }
                session2.getTransaction().commit();
            } finally {
            	session2.close();
            }
        %>
       
    </table>
     <div class="container text-center mt-2">
        <a href="index.jsp" class="btn btn-primary">Home</a>
     </div>
    
    <h2>Update Recipe</h2>
    <form action="updateRecipeServlet" method="post">
        <label for="id">Recipe ID:</label>
        <input type="text" name="id" required>
        
        <label for="ingredients">Ingredients:</label>
        <input type="text" name="ingredients" required>
        
        <label for="instructions">Instructions:</label>
        <input type="text" name="instructions" required>
        
        <label for="difficultyLevel">Difficulty Level:</label>
        <input type="text" name="difficultyLevel" required>
        <input type="submit" value="Update Recipe">
    </form>
</body>
</html>
