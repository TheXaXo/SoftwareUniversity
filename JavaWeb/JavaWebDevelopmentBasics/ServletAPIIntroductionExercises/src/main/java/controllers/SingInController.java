package controllers;

import models.bindingModels.LoginModel;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/singin")
public class SingInController extends HttpServlet {
    private UserService userService;

    public SingInController() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") != null) {
            resp.sendRedirect("/");
            return;
        }

        req.getRequestDispatcher("/views/singin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") != null) {
            resp.sendRedirect("/");
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginModel loginModel = this.userService.findByUsernameAndPassword(username, password);

        if (loginModel == null) {
            resp.sendRedirect("/singin");
            return;
        }

        req.getSession().setAttribute("LOGIN_MODEL", loginModel);
        resp.sendRedirect("/");
    }
}