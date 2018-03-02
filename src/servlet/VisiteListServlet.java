package servlet;

import utils.Manager;
import utils.QueryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class VisiteListServlet extends HttpServlet {

    /**
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Manager.isUserValid(req, resp)) {
            return;
        }

        System.out.println("doGet VisiteListServlet");
        req.setAttribute("visits", QueryBuilder.findAllVisits());

        this.getServletContext().getRequestDispatcher("/visites.jsp").forward(req, resp);
    }
}
