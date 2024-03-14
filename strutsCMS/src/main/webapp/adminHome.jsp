<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Content Management System</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: #4CAF50;
            color: #fff;
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
            background-color: #4CAF50;
            color: #fff;
            border: 1px solid #388E3C;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .operation-links a:hover {
            background-color: #388E3C;
        }
    </style>
</head>
<body>
<%
    // Check if the user is logged in
    HttpSession session2 = request.getSession(false);
    if (session2 == null || session2.getAttribute("adminUsername") == null) {
        // User is not logged in, redirect to login page
        response.sendRedirect("adminLogin.jsp");
    } else {
        // User is logged in, display user home page
%>
    <h1>Admin Home</h1>
    
    <div class="operation-links">
        <s:a href="addArticle.jsp">Add Article</s:a>
        <s:a href="displayArticles.jsp">Display Articles</s:a>
        <s:a href="updateArticle.jsp">Update Article</s:a>
        <s:a href="deleteArticle.jsp">Delete Article</s:a>
        
        <s:a href="logout.jsp">logout</s:a>
    </div>
<%
    }
%>
</body>
</html>
