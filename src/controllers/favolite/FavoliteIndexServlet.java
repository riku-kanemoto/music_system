package controllers.favolite;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Member;
import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class FavoliteIndexServlet
 */
@WebServlet("/favolite/index")
public class FavoliteIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoliteIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em =DBUtil.createEntityManager();

        Member login_member=(Member)request.getSession().getAttribute("login_member");

        List<MusicSite> musicSites=em.createNamedQuery("getAllFavoliteSite",MusicSite.class)
                .setParameter("member_id", login_member)
                .getResultList();
        if(musicSites.size()>0){
            request.setAttribute("musicSites", musicSites);
        }else{
            request.setAttribute("haserror", true);
        }
        RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/favolite/index.jsp");
        rd.forward(request, response);
    }
}
