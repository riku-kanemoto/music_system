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

import models.Member;
import models.MusicSite;
import utils.DBUtil;

/**
 * Servlet implementation class MemberIndexServlet
 */
@WebServlet("/member/index")
public class MemberIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em=DBUtil.createEntityManager();

        Member login_member=(Member)request.getSession().getAttribute("login_member");
        Integer favoliteCheck;

        List<MusicSite> fs=em.createNamedQuery("getAllFavoliteSite",MusicSite.class)
                .setParameter("member_id",login_member)
                .getResultList();

        List<MusicSite> musicSites=em.createNamedQuery("getMyMusicSites",MusicSite.class)
                .setParameter("member", login_member)
                .getResultList();
        if(fs.size()==0){
            favoliteCheck=0;
            request.setAttribute("favoliteCheck", favoliteCheck);
            request.setAttribute("musicSites", musicSites);
        }else{
            favoliteCheck=1;
            request.setAttribute("favoliteCheck", favoliteCheck);
            request.setAttribute("musicSites", musicSites);
            request.setAttribute("fs",fs);
        }

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/member/index.jsp");
        rd.forward(request, response);
    }

}
