package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.service.UserServiceImpl;
import by.tms.service.exceptions.DuplicateUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        User user = new User(login, name, password);

//            List<User> users = (List<User>) getServletContext().getAttribute("users");
//            users.add(user);
        try {
            UserServiceImpl.getInstance((Connection) req.getSession().getAttribute("connection")).createUser(user);
        } catch (DuplicateUserException e) {
            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        }


        resp.sendRedirect("/");
//        } else {
//            req.getRequestDispatcher("/reg").forward(req, resp);
//        }
    }
}
