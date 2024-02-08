<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Employee</title>
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
        input[type="text"], input[type="email"] {
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
    </style>
</head>
<body>
    <h1>Create Recipe</h1>
    
    <form action="createRecipeServlet" method="post">
        <label for="recipeName">Recipe Name:</label>
        <input type="text" name="recipeName" required>
        
        <label for="ingredients">Ingredients:</label>
        <input type="text" name="ingredients" required>
        
        <label for="instructions">Instructions:</label>
        <input type="text" name="instructions" required>
        
        <label for="difficultyLevel">Difficulty Level:</label>
        <input type="text" name="difficultyLevel" required>
        
        <input type="submit" value="Create Recipe">
    </form>
</body>
</html>
