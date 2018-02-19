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

@WebServlet("/singup")
public class SignUpController extends HttpServlet {
    private UserService userService;

    public SignUpController() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") != null) {
            resp.sendRedirect("/");
            return;
        }

        req.getRequestDispatcher("/views/singup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("LOGIN_MODEL") != null) {
            resp.sendRedirect("/");
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (this.userService.findByUsernameAndPassword(username, password) != null || !password.equals(confirmPassword)) {
            resp.sendRedirect("/singup");
            return;
        }

        LoginModel loginModel = new LoginModel(username, password);
        this.userService.createUser(loginModel);

        resp.sendRedirect("/singin");
    }
}