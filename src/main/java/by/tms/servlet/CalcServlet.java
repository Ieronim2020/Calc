package by.tms.servlet;

import by.tms.service.Calculated;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", loadOnStartup = 1)
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("Calc", "Calc");
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        try {
            if (num1 != null && num2 != null) {
                String result = null;
                Calculated calculated = new Calculated();
                switch (type) {
                    case "add":
                        result = calculated.addition(Double.parseDouble(num1), Double.parseDouble(num2));
                        break;
                    case "dim":
                        result = calculated.diminution(Double.parseDouble(num1), Double.parseDouble(num2));
                        break;
                    case "mul":
                        result = calculated.multiplication(Double.parseDouble(num1), Double.parseDouble(num2));
                        break;
                    case "div":
                        result = calculated.division(Double.parseDouble(num1), Double.parseDouble(num2));
                        break;
                }
                req.setAttribute("result", result);
                req.getRequestDispatcher("/calc.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/calc.jsp").forward(req, resp);
            }
        } catch (ArithmeticException | IOException e) {
            e.printStackTrace();
        }
    }
}
