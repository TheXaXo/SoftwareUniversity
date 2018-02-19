package controllers;

import services.BookService;
import services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shelves/delete/*")
public class BookDeleteController extends HttpServlet {
    private BookService bookService;

    public BookDeleteController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookTitle = req.getPathInfo().substring(1);
        this.bookService.deleteBookByTitle(bookTitle);

        resp.sendRedirect("/shelves");
    }
}