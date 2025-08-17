<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign in</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Login/login.css"/>
</head>
<body>
 <div class="login-container">
     <h2 class="login-title">
          <strong>Welcome</strong>
     </h2>
     <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <label>Username</label>
        <input
          name="username"
          class="login-input"
          type="text"
          placeholder="username"
          required
        />
        <label>Password</label>
        <input
          name="password"
          class="login-input"
          type="password"
          placeholder="password"
          required
        />
        <button class="login-btn" type="submit">
          Login
        </button>
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <div class="login-error"><%= errorMessage %></div>
            <% } 
        %>
      </form>
      <a class="login-register-link" href="./Register/register.jsp">
          Sign up
        </a>
     
 </div>
</body>
</html>