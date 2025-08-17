package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.BookDAO;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Book;

@WebServlet(name = "BookListServlet", urlPatterns = {"/BookListServlet"})
public class BookListServlet extends HttpServlet {
    private List<Book> list;
    private BookDAO bookDao;

    @Override
    public void init() {
        bookDao = new BookDAO();
        list = bookDao.getAllBook();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> selectedIds = (ArrayList<String>) session.getAttribute("selectedBooks");
        if (selectedIds == null) {
            selectedIds = new ArrayList<>();
        }

    
        String bookId = request.getParameter("bookId");
        String checked = request.getParameter("checked");

        if (bookId != null && checked != null) {
            if ("true".equals(checked)) {
                if (!selectedIds.contains(bookId)) {
                    selectedIds.add(bookId);
                }
            } else {
                selectedIds.remove(bookId);
            }
            session.setAttribute("selectedBooks", selectedIds);


            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> selectedIds = (ArrayList<String>) session.getAttribute("selectedBooks");
        if (selectedIds == null) {
            selectedIds = new ArrayList<>();
        }

   
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.trim().isEmpty()) {
            list = bookDao.searchBook(keyword);
        } else {
            list = bookDao.getAllBook();
        }

        request.setAttribute("bookList", list);
        request.getRequestDispatcher("/BookList/booklist.jsp").forward(request, response);
    }
}
