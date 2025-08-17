package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.AccountDAO;
import model.Account;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;

    @Override
    public void init() {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        
        
        try {
            if (accountDAO.checkLogin(account)) {
                HttpSession session = request.getSession();
                session.setAttribute("name", account.getCus().getName());
                session.setAttribute("user", account.getCus());
                response.sendRedirect(request.getContextPath() + "/Home/home.jsp");
            } else {
                request.setAttribute("errorMessage", "Wrong username or password!");
                request.getRequestDispatcher("/Login/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Login/login.jsp").forward(request, response);
    }
}
