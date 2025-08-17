<%-- 
    Document   : register
    Created on : Aug 16, 2025, 10:33:29?AM
    Author     : dungc
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Register</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Register/register.css"/>
    </head>
    <body>
        <div class="register-container">
            <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
              <h2 class="register-title">Register Form</h2>
              <label>Username: </label>
              <input
                class="register-input"
                type="text"
                name ="username"
                placeholder="Type your username"
                required
              />
              <label>Password: </label>
              <input
                class="register-input"
                type="password"
                name="password"
                placeholder="type your password"
                required
              />
              <br />
              <label>Full Name: </label>
              <input
                class="register-input"
                type="text"
                name="name"
                placeholder="type your full name"
                required
              />
              <label>Street: </label>
              <input
                class="register-input"
                type="text"
                name="street"
                placeholder="type your street"
                required
              />
              <br />
              <label>City:</label>
              <input
                class="register-input"
                type="text"
                name="city"
                placeholder="Type your city"
                required
              />
              <label>Country:</label>
              <input
                class="register-input"
                type="text"
                name="country"
                placeholder="Type your country"
                required
              />
              <br/>
              <label>Phone Number: </label>
              <input
                class="register-input"
                type="text"
                name="tel"
                placeholder="Type your phone number"
                required
              />
              <label>Email:</label>
              <input
                class="register-input"
                type="email"
                name="email"
                placeholder="Type your email"
              />
              <hr />
              <button class="register-btn" type="submit">
                Submit
              </button>
                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
                    <% if (errorMessage != null) { %>
                        <div class="register-error"><%= errorMessage %></div>
                    <% } 
                %>
            </form>
          </div>
    </body>
</html>
