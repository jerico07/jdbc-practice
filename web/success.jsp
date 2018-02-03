<%-- 
    Document   : success
    Created on : Feb 4, 2018, 2:07:11 AM
    Author     : User
--%>

<%@page import="java.util.List"%>
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
        <br>
        <h2>REGISTER:</h2>
        <form method="post" action="RegistrationServlet">
            <label for="username">Username:</label><br>
            <input type="text" name="username" id="username">
            <br><br>
            <label for="password">Password:</label><br>
            <input type="password" name="password" id="password">
            <br><br>
            <input type="submit" value="Register">
        </form>
        <h2>CHANGE PASSWORD:</h2>
        <form method="post" action="ChangePassServlet">
            <label for="password2">New Password:</label><br>
            <input type="password" name="password" id="password2">
            <br><br>
            <input type="submit" value="Update">
        </form>
        <br>
        <h2>USER LIST:</h2>
        <form method="post" action="ChangeUserPassServlet">
            <table border="1px">
                <tr>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>EDIT PASSWORD</th>
                </tr>
                <%
                    int i = 0;
                    for (User u : (List<User>) request.getAttribute("list")) {
                %>
                <tr>
                    <td><%=u.getUsername()%></td>
                    <td><%=u.getPassword()%></td>
                    <td>
                        <input type="text" value="<%=u.getPassword()%>" name="password<%=i%>">
                    </td>
                    <input type="hidden" value="<%=u.getUsername()%>" name="username<%=i%>">
                </tr>
                <%
                        i++;
                    }
                %>
            </table>
            <br>
            <input type="submit" value="Update Passwords">
        </form>
    </body>
</html>
