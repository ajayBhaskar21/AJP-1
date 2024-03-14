<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Task" %>
<%@ page import="com.example.FactoryProvider" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%
    HttpSession session2 = request.getSession(false);
    if (session2 == null || session2.getAttribute("username") == null) {
        // User is not logged in, redirect to login page
        response.sendRedirect("index.jsp");
    } else {
        // User is logged in, display list of tasks and update form
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
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
            margin: 0;
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
        form {
            width: 50%;
            margin: 20px auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button {
            padding: 10px;
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
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
    <h1>Update Task</h1>
    
    <form action="UpdateTaskAction" method="post">
        <div class="form-group">
               <label for="id">id:</label>
               <input type="text" name="id" required />
           </div>
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
                <input type="submit" value="Update Task" />
            </div>
    </form>
    
    
    
</body>
</html>
<%
    }
%>
