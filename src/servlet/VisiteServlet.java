package servlet;

import utils.QueryBuilder;
import utils.Visite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class VisiteServlet extends HttpServlet {

    /**
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet VisiteServlet");
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPostOk VisiteServlet");
        Visite visite = new Visite();
        String date = request.getParameter("date");
        String nomEtudiant = request.getParameter("nomEtudiant");
        String note = request.getParameter("note");

        if (!date.isEmpty() && !nomEtudiant.isEmpty() && !note.isEmpty()) {
            visite.setDate(date).setNomEtudiant(nomEtudiant).setNote(Integer.parseInt(note));
            QueryBuilder.handleVisit(visite);
            request.setAttribute("flash_success", "Object visite créé");
            response.sendRedirect("/list");

            return;
        }

        request.getSession().setAttribute("flash_danger", "Object visite non créé");
        response.sendRedirect("/");
    }
}
