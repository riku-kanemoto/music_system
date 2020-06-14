package controllers.follow;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

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
 * Servlet implementation class FollowAddServlet
 */
@WebServlet("/follow/add")
public class FollowAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em=DBUtil.createEntityManager();
            Member login_member=(Member)request.getSession().getAttribute("login_member");
            Member follow_member=em.find(Member.class, Integer.parseInt(request.getParameter("id")));
            Timestamp currentTime=new Timestamp(System.currentTimeMillis());
            List<Follow> checkFollow=em.createNamedQuery("checkFollow",Follow.class)
                    .setParameter("user_id", login_member)
                    .setParameter("follow_id", follow_member)
                    .getResultList();
            if(checkFollow.size()>0){
                Follow f=em.createNamedQuery("checkFollow",Follow.class)
                        .setParameter("user_id", login_member)
                        .setParameter("follow_id", follow_member)
                        .getSingleResult();
                f.setFollow_flag(1);
                f.setFollow_at(currentTime);
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

            }else{
                Follow f=new Follow();
                f.setUser_id(login_member);
                f.setFollow_id(follow_member);
                f.setFollow_flag(1);
                f.setFollow_at(currentTime);
                em.getTransaction().begin();
                em.persist(f);
                em.getTransaction().commit();
                em.close();
            }
            response.sendRedirect(request.getContextPath()+"/member/show?id="+request.getParameter("id"));

    }

}
