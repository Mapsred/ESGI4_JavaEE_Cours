package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import utils.QueryBuilder;
import utils.Visite;

@WebServlet("/visite")
public class VisiteServlet extends HttpServlet {

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Visite visite = new Visite();
        visite.setDate(request.getParameter("date"))
                .setNomEtudiant(request.getParameter("nomEtudiant"))
                .setNote(Integer.parseInt(request.getParameter("note")));

        QueryBuilder.handleVisit(visite);
//        this.getServletContext().getRequestDispatcher("/web/index.html").forward(request, response);
    }

}
