<%-- 
    Document   : index
    Created on : Feb 3, 2018, 11:12:34 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>

    <body>
        <h1>Log In</h1>

        <%
            if (session.getAttribute("user") != null) {
                response.sendRedirect("LoginServlet");
            }
            
            String msg = (String) session.getAttribute("loginMsg");
            session.removeAttribute("loginMsg");

            if (msg != null) { %>
            <%=msg%>
        <%
            }
        %>

        <form method="post" action="LoginServlet">
            <label for="username">Username:</label><br>
            <input type="text" name="username" id="username">
            <br><br>
            <label for="password">Password:</label><br>
            <input type="password" name="password" id="password">
            <br><br>
            <input type="submit" value="Log In">
        </form>
    </body>
</html>
