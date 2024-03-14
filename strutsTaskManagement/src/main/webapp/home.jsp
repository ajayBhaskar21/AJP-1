<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.io.IOException" %>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 != null && session.getAttribute("username") != null) {
        // Username is in session, display the content
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Management</title>
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
        .operation-links {
            text-align: center;
            margin-top: 20px;
        }
        .operation-links a {
            margin: 0 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #4CAF50; /* Dark green */
            color: #fff;
            border: 1px solid #005600; /* Dark green */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .operation-links a:hover {
            background-color: #449d44; /* Medium green */
        }
    </style>
</head>
<body>
    <h1>Task Management</h1>
    
    <div class="operation-links">
        <s:a href="addTask.jsp">Add Task</s:a>
        <s:a href="displayTasks.jsp">Display Tasks</s:a>
        <s:a href="updateTask.jsp">Update Task</s:a>
        <s:a href="deleteTask.jsp">Delete Task</s:a>
        <s:a href="logout.jsp">logout</s:a>
    </div>
</body>
</html>
<%
    } else {
        // Redirect to index.jsp if username is not in session
        response.sendRedirect("index.jsp");
    }
%>
