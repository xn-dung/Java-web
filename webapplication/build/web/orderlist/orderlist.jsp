<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/OrderList/orderlist.css"/>
    <script>
        function updateTotal() {
            let rows = document.querySelectorAll("#orderTable tbody tr");
            let total = 0;
            rows.forEach(row => {
                let price = parseFloat(row.querySelector(".price").innerText);
                let qty = parseInt(row.querySelector(".qty").value) || 0;
                total += price * qty;
            });
            document.getElementById("totalPrice").innerText = total.toFixed(2);
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Your Order</h2>

        <form action="${pageContext.request.contextPath}/OrderListServlet" method="post">
            <table id="orderTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Rental Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Book> books = (List<Book>) request.getAttribute("orderBooks");
                        if (books != null) {
                            for (Book b : books) {
                    %>
                    <tr>
                        <td>
                            <%= b.getId() %>
                            <input type="hidden" name="bookId" value="<%= b.getId() %>">
                        </td>
                        <td><%= b.getTitle() %></td>
                        <td class="price"><%= b.getRentalPrice() %></td>
                        <td>
                            <input type="number" name="quantity" class="qty" value="1" min="1" onchange="updateTotal()">
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>

            <div class="total">
                <strong>Total: $<span id="totalPrice">0.00</span></strong>
            </div>

            <div class="actions">
                <button type="submit">Create</button>
            </div>
        </form>
    </div>

    <script>updateTotal();</script>
</body>
</html>
