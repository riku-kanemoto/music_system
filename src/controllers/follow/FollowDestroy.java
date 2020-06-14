package controllers.follow;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Follow;
import models.Member;
import utils.DBUtil;

/**
 * Servlet implementation class FollowDestroy
 */
@WebServlet("/follow/destroy")
public class FollowDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowDestroy() {
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
        Member follow_member=em.find(Member.class, Integer.parseInt(request.getParameter("id")));
        Follow f=em.createNamedQuery("checkFollow",Follow.class)
                .setParameter("user_id", login_member)
                .setParameter("follow_id", follow_member)
                .getSingleResult();
        f.setFollow_flag(0);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        response.sendRedirect(request.getContextPath()+"/member/show?id="+request.getParameter("id"));
    }

}
