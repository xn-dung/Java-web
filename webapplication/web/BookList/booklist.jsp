<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/BookList/booklist.css">
    <script>
        function toggleBookSelection(checkbox) {
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/BookListServlet", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("bookId=" + checkbox.value + "&checked=" + checkbox.checked);
        }
    </script>
</head>
<body>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/Home/home.jsp">Home</a>
        <form action="${pageContext.request.contextPath}/BookListServlet" method="get" class="search-bar">
            <input type="text" name="keyword" placeholder="Type your book title ">
            <button type="submit">Search</button>
        </form>
    </div>

    <h2>List of Books</h2>

    <table>
        <tr>
            <th>Select</th>
            <th>ID</th>
            <th>Title</th>
            <th>Year</th>
            <th>Author</th>
            <th>Rental Price</th>
        </tr>
        <%
            List<Book> books = (List<Book>) request.getAttribute("bookList");
            List<String> selectedIds = (List<String>) session.getAttribute("selectedBooks");
            if (selectedIds == null) selectedIds = new ArrayList<>();

            if (books != null) {
                for (Book b : books) {
                    boolean checked = selectedIds.contains(String.valueOf(b.getId()));
        %>
        <tr>
            <td>
                <input type="checkbox" 
                       value="<%= b.getId() %>" 
                       <%= checked ? "checked" : "" %>
                       onchange="toggleBookSelection(this)">
            </td>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getYearOfPublication() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getRentalPrice() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <!-- Form Submit Order -->
    <form action="${pageContext.request.contextPath}/OrderListServlet" method="get" style="text-align:center; margin:20px;">
        <button type="submit" class="submit-btn">Submit Order</button>
    </form>
</body>
</html>
