package controllers.follow;

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
import utils.DBUtil;

/**
 * Servlet implementation class FollowIndexServlet
 */
@WebServlet("/follow/index")
public class FollowIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowIndexServlet() {
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
        String error;
        List<Member> follow_members=em.createNamedQuery("getAllFollowMembers",Member.class)
                .setParameter("user_id", login_member)
                .getResultList();
        em.close();
        if(follow_members.size()>0){
            error="";
            request.setAttribute("error", error);
            request.setAttribute("follow_members", follow_members);
        }else{
            error="フォローしている人がいません。";
            request.setAttribute("error", error);
        }
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/follow/index.jsp");
        rd.forward(request, response);
    }

}
