<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%
    HttpSession session2 = request.getSession(false);
    if (session2 != null) {
        session2.invalidate(); // Invalidate the current session
    }
    response.sendRedirect("index.jsp"); // Redirect to index.jsp
%>
