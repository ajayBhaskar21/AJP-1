<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%
    // Invalidate the session
    HttpSession session2 = request.getSession(false);
    if (session2 != null) {
        session2.invalidate(); // Invalidates the session, removing any associated session attributes
    }

    // Redirect to the login page after logout
    response.sendRedirect("index.jsp");
%>
