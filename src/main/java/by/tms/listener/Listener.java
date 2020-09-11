package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {


    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("users", new ArrayList<>());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            se.getSession().setAttribute("connection", DriverManager.getConnection(
//                    "jdbc:mysql://localhost/store?serverTimezone=UTC", "root", "Bthjybv19841030"));
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
        try{
            Class.forName("org.postgresql.Driver");
            se.getSession().setAttribute("connection", DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "q12345"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Connection connection = (Connection)se.getSession().getAttribute("connection");
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
