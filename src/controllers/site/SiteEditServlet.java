package controllers.site;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class SiteEditServlet
 */
@WebServlet("/site/edit")
public class SiteEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em =DBUtil.createEntityManager();
        MusicSite edit_site=em.find(MusicSite.class, Integer.parseInt(request.getParameter("id")));
        em.close();
        request.getSession().setAttribute("edit_site_id", edit_site.getId());
        request.setAttribute("edit_site", edit_site);
        request.setAttribute("_token", request.getSession().getId());
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/site/edit.jsp");
        rd.forward(request, response);
    }

}
