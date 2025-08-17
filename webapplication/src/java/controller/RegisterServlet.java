package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.AccountDAO;
import model.Account;
import model.Customer;
import model.Address;
import dao.AddressDAO;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private AccountDAO accountDAO;
    private AddressDAO addressDAO;

    @Override
    public void init() {
        accountDAO = new AccountDAO();
        addressDAO = new AddressDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Register/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        Customer cus = new Customer(name, tel, email);
        Account acc = new Account();
        acc.setUsername(username);
        acc.setPassword(password);
        acc.setCus(cus);
        
        if (!accountDAO.addNewAccount(acc)) {
            request.setAttribute("errorMessage", "Username is already in use!");
            request.getRequestDispatcher("/Register/register.jsp").forward(request, response);
        } else {
            cus.setId(acc.getCus().getId());
            Address add = new Address();
            add.setCity(city);
            add.setCountry(country);
            add.setCus(cus);
            add.setStreet(street);
            if(!addressDAO.addNewAddress(add)){
                request.setAttribute("errorMessage", "Your address is invalid");
                request.getRequestDispatcher("/Register/register.jsp").forward(request, response);
            }
            else{
                response.sendRedirect(request.getContextPath() + "/Login/login.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Register new user servlet";
    }
}
