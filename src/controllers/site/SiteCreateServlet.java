package controllers.site;

import java.io.IOException;
import java.sql.Timestamp;
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
import models.validators.SiteValidator;
import utils.DBUtil;

/**
 * Servlet implementation class AddSiteCreate
 */
@WebServlet("/site/create")
public class SiteCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token=(String)request.getParameter("_token");
        if(_token !=null&&_token.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();
            MusicSite m=new MusicSite();
            m.setMember((Member)request.getSession().getAttribute("login_member"));
            m.setName(request.getParameter("name"));
            m.setUrl(request.getParameter("url"));
            m.setColor_flag(Integer.parseInt(request.getParameter("color_flag")));

            Timestamp currentTime=new Timestamp(System.currentTimeMillis());
            m.setCreated_at(currentTime);
            m.setUpdated_at(currentTime);
            m.setDelete_flag(0);

            List<String> errors =SiteValidator.validate(m);
            if(errors.size()>0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("musicSite", m);
                request.setAttribute("errors", errors);
                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/site/new.jsp");
                rd.forward(request, response);
            }

            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            em.close();
            response.sendRedirect(request.getContextPath()+"/member/index");
        }
    }

}
