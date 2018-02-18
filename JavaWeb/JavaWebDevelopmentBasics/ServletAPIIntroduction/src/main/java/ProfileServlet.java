import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null) {
            req.setAttribute("username", req.getSession().getAttribute("username"));
            req.getRequestDispatcher("/WEB-INF/views/profile-success.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "You are not logged in.");
            req.getRequestDispatcher("/WEB-INF/views/profile-error.jsp").forward(req, resp);
        }
    }
}