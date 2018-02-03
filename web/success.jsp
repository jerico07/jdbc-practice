<%-- 
    Document   : success
    Created on : Feb 4, 2018, 2:07:11 AM
    Author     : User
--%>

<%@page import="com.java.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        <h1>
            Hello <%=user.getUsername()%>. Your password is <%=user.getPassword()%>.<br>
            <form action="LogoutServlet">
                <input type="submit" value="Log Out">
            </form>
        </h1>
    </body>
</html>
