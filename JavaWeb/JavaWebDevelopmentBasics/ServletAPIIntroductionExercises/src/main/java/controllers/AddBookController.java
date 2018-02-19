package controllers;

import models.bindingModels.AddBookModel;
import services.BookService;
import services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookController extends HttpServlet {
    private BookService bookService;

    public AddBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") == null) {
            resp.sendRedirect("/");
            return;
        }

        req.getRequestDispatcher("/views/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") == null) {
            resp.sendRedirect("/");
            return;
        }

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String pages = req.getParameter("pages");

        this.bookService.saveBook(new AddBookModel(title, author, pages));
        resp.sendRedirect("/shelves");
    }
}