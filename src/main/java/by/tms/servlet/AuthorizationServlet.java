package by.tms.servlet;

import by.tms.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List <User> users = (List<User>) getServletContext().getAttribute("users");

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                req.getSession().setAttribute("user", user);
            }
        }
    }
}
