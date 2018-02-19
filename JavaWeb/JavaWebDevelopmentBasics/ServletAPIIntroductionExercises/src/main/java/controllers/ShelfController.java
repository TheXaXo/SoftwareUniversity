package controllers;

import models.viewModels.ViewBookModel;
import services.BookService;
import services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shelves")
public class ShelfController extends HttpServlet {
    private BookService bookService;

    public ShelfController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") == null) {
            resp.sendRedirect("/");
            return;
        }

        List<ViewBookModel> books = this.bookService.getAllBooks();
        req.setAttribute("books", books);

        req.getRequestDispatcher("/views/shelves.jsp").forward(req, resp);
    }
}