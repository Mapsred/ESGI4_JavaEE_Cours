package servlet;

import utils.QueryBuilder;
import utils.Visite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class VisiteServlet extends HttpServlet {

    /**
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Visite visite = new Visite();
        visite.setDate(request.getParameter("date"))
                .setNomEtudiant(request.getParameter("nomEtudiant"))
                .setNote(Integer.parseInt(request.getParameter("note")));

        QueryBuilder.handleVisit(visite);
//        this.getServletContext().getRequestDispatcher("/web/index.html").forward(request, response);
    }

}
