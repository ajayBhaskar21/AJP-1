<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Task" %>
<%@ page import="com.example.FactoryProvider" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%
    HttpSession session3 = request.getSession(false);
    if (session3 == null || session3.getAttribute("username") == null) {
        // User is not logged in, redirect to login page
        response.sendRedirect("index.jsp");
    } else {
        // User is logged in, display list of tasks
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Tasks</title>
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
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
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
        .container {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            margin-top: 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
            border: 1px solid #388E3C; /* Changed border color */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #388E3C; /* Changed hover color */
        }
    </style>
</head>
<body>
    <h1>List of Tasks</h1>
    
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Due Date</th>
            <th>Priority</th>
            
        </tr>
        
        <% 
   
            Session session1 = FactoryProvider.getFactory().openSession();
            
            try {
                session1.beginTransaction();
                List<Task> tasks = session1.createQuery("from Task").getResultList();
                
                for (Task i : tasks) {
        %>
                <tr>
                    <td><%= i.getId() %></td>
                    <td><%= i.getName() %></td>
                    <td><%= i.getDescription() %></td>
                    <td><%= i.getDueDate() %></td>
                    <td><%= i.getPriority() %></td>
                    
                </tr>
        <%
                }
                session1.getTransaction().commit();
            } finally {
                if (session1 != null && session1.isOpen()) {
                    session1.close();
                }
            }
        %>
        
    </table>
    <div class="container text-center mt-2">
            <a href="index.jsp" class="btn btn-primary">Home</a>
        </div>
</body>
</html>
<%
    }
%>
