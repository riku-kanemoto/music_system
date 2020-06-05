package controllers.favolite;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FavoliteAddServlet
 */
@WebServlet("/FavoliteAddServlet")
public class FavoliteAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoliteAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token=(String)request.getParameter("_token");
        if(_token !=null && _token.equals(request.getSession().getId())){
            EntityManager em =DBUtil.createEntityManager();
            Member login_member=(Member)request.getSession().getAttribute("login_member");
            MusicSite site=em.find(MusicSite.class,Integer.parseInt(request.getParameter("id")));
            List<Favolite> fl=em.createNamedQuery("getFavoliteCheck",Favolite.class)
                    .setParameter("member_id",login_member)
                    .setParameter("site_id", site)
                    .getResultList();
            if(fl.size()>0){
                Favolite f=em.createNamedQuery("getFavoliteCheck",Favolite.class)
                        .setParameter("member_id",login_member)
                        .setParameter("site_id", site)
                        .getSingleResult();
                f.setFavolite_flag(1);
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                response.sendRedirect(request.getContextPath()+"/member/index");
            }
        }
    }

}
