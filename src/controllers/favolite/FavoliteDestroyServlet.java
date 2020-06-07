package controllers.favolite;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Favolite;
import models.Member;
import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class FavoliteDestroyServlet
 */
@WebServlet("/destroy/favolite")
public class FavoliteDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoliteDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em =DBUtil.createEntityManager();
        Member login_member=(Member)request.getSession().getAttribute("login_member");
        MusicSite site=em.find(MusicSite.class,Integer.parseInt(request.getParameter("id")));
        Favolite f=em.createNamedQuery("getFavoliteCheck",Favolite.class)
                .setParameter("member_id",login_member)
                .setParameter("site_id", site)
                .getSingleResult();
        f.setFavolite_flag(0);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        response.sendRedirect(request.getContextPath()+"/member/index");
    }
}
