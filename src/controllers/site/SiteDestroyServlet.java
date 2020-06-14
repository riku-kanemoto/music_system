package controllers.site;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class SiteDestroyServlet
 */
@WebServlet("/site/destroy")
public class SiteDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em =DBUtil.createEntityManager();

        MusicSite site=em.find(MusicSite.class, Integer.parseInt(request.getParameter("id")));
        site.setDelete_flag(1);
        site.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath()+"/mysite");
    }

}
