<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #fff;
            text-align: center;
            padding: 20px 0;
            background-color: #4CAF50; /* Dark green */
            margin: 0;
        }
        .form-container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
            overflow: hidden;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"], .form-group input[type="date"], .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"] {
            background-color: #4CAF50; /* Dark green */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #449d44; /* Medium green */
        }
    </style>
</head>
<body>
    <h1>Add Task</h1>

    <div class="form-container">
        <%
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
        %>
        <form action="AddTaskAction" method="post">
            <div class="form-group">
                <label for="Name">Name:</label>
                <input type="text" name="task.name" required />
            </div>
            <div class="form-group">
                <label for="Description">Description:</label>
                <input type="text" name="task.description" required />
            </div>
            <div class="form-group">
                <label for="isbn">Due Date:</label>
                <input type="date" name="task.dueDate" required />
            </div>
            
            <div class="form-group">
                <label for="Priority">Priority:</label>
                <input type="number" name="task.priority" required />
            </div>
            <div class="form-group">
                <input type="submit" value="Add Task" />
            </div>
        </form>
        <%
            } else {
                // Redirect to index.jsp if not logged in
                response.sendRedirect("index.jsp");
            }
        %>
    </div>
</body>
</html>
