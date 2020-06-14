package controllers.member;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Follow;
import models.Member;
import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class MemberShowServlet
 */
@WebServlet("/member/show")
public class MemberShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberShowServlet() {
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
        Member member=em.find(Member.class,Integer.parseInt(request.getParameter("id")));
        Integer favoliteCheck;
        List<MusicSite> musicSites=em.createNamedQuery("getMemberMusicSites",MusicSite.class)
                .setParameter("member",member)
                .getResultList();
        List<Follow> checkFollow=em.createNamedQuery("checkFollow",Follow.class)
                .setParameter("user_id", login_member)
                .setParameter("follow_id", member)
                .getResultList();
        List<MusicSite> fs=em.createNamedQuery("getAllFavoliteSite",MusicSite.class)
                .setParameter("member_id", login_member)
                .getResultList();
        if(login_member.getId()==member.getId()){
            em.close();
            request.setAttribute("check_member", true);
            request.setAttribute("member", member);
            request.setAttribute("musicSites",musicSites);
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/member/show.jsp");
            rd.forward(request, response);
            return;

        }
        if(fs.size()>0){
            favoliteCheck=1;
            request.setAttribute("favoliteCheck", favoliteCheck);
            request.setAttribute("fs", fs);
        }else{
            favoliteCheck=0;
            request.setAttribute("favoliteCheck", favoliteCheck);
        }
        if(checkFollow.size()>0){
            Follow f =em.createNamedQuery("checkFollow",Follow.class)
                    .setParameter("user_id", login_member)
                    .setParameter("follow_id", member)
                    .getSingleResult();
            em.close();
            if(f.getFollow_flag()==1){
                request.setAttribute("check", true);
            }else{
                request.setAttribute("check", false);
            }
        }else{
            em.close();
            request.setAttribute("check", false);

        }
        request.setAttribute("check_member", false);
        request.setAttribute("member", member);
        request.setAttribute("musicSites",musicSites);
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/member/show.jsp");
        rd.forward(request, response);
    }

}
