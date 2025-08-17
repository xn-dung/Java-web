package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.BookDAO;
import dao.OrderListDAO;
import java.util.Arrays;
import model.Book;
import model.Customer;
import model.Order;

@WebServlet(name = "OrderListServlet", urlPatterns = {"/OrderListServlet"})
public class OrderListServlet extends HttpServlet {

    private List<Book> getSelectedBooks(HttpSession session) {
        List<String> selectedIds = (List<String>) session.getAttribute("selectedBooks");
        List<Book> books = new ArrayList<>();

        if (selectedIds != null && !selectedIds.isEmpty()) {
            BookDAO bookDAO = new BookDAO();
            for (String id : selectedIds) {
                try {
                    int bookId = Integer.parseInt(id);
                    Book b = bookDAO.getBookByID(bookId);
                    if (b != null) {
                        books.add(b);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Book> books = getSelectedBooks(session);

        request.setAttribute("orderBooks", books);
        request.getRequestDispatcher("/LoanSlip/orderlist.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("user");

        String[] bookIds = request.getParameterValues("bookId");
        String[] quantities = request.getParameterValues("quantity");

        if (cus != null && bookIds != null && quantities != null) {
            ArrayList<Order> orderItems = new ArrayList<>();
            BookDAO bookDAO = new BookDAO();

            for (int i = 0; i < bookIds.length; i++) {
                try {
                    int bookId = Integer.parseInt(bookIds[i]);
                    int qty = Integer.parseInt(quantities[i]);

                    if (qty > 0) {
                        Book book = bookDAO.getBookByID(bookId);
                        if (book != null) {
                            orderItems.add(new Order(book, qty, book.getRentalPrice()));
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (!orderItems.isEmpty()) {
                OrderListDAO orderlistDAO = new OrderListDAO();
                String todayStr = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                orderlistDAO.insertOrderList(cus, todayStr, orderItems);
            }
        }
        System.out.println("bookIds = " + Arrays.toString(bookIds));
        System.out.println("quantities = " + Arrays.toString(quantities));
       
        response.sendRedirect(request.getContextPath() + "/Home/home.jsp");
    }
}
