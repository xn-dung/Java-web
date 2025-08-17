<%-- 
    Document   : home
    Created on : Aug 16, 2025, 9:53:21 PM
    Author     : dungc
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    HttpSession sess = request.getSession(false);
    String fullName = (String) sess.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Home/home.css"/>
</head>
<body>
    <div class="navbar">
        <div class="nav-left">
            Hello, <%= fullName %>
        </div>
        <div class="nav-right">
            <form action="${pageContext.request.contextPath}/LogoutServlet" method="post" style="display:inline;">
                <button type="submit" class="logout-btn">Logout</button>
            </form>
        </div>
    </div>

    <div class="content">
        <h1>Welcome to Home Page</h1>
        <div class="center-btn">
            <a href="${pageContext.request.contextPath}/BookListServlet" class="order-btn">Make Order List</a>
        </div>
    </div>
</body>
</html>
