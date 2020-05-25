package controllers.toppage;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class TopPageIndesxServlet
 */
@WebServlet("/index.html")
public class TopPageIndesxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopPageIndesxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em=DBUtil.createEntityManager();
        List <MusicSite> music_site=em.createNamedQuery("getAllMusicSites",MusicSite.class)
                .getResultList();
        em.close();

        request.setAttribute("music_site", music_site);
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/toppage/index.jsp");
        rd.forward(request, response);

    }

}
