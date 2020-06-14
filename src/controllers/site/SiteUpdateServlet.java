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

import models.MusicSite;
import models.validators.SiteValidator;
import utils.DBUtil;

/**
 * Servlet implementation class SiteUpdateServlet
 */
@WebServlet("/site/update")
public class SiteUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token=(String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){

            EntityManager em =DBUtil.createEntityManager();

            MusicSite site=em.find(MusicSite.class,(Integer)(request.getSession().getAttribute("edit_site_id")));

            site.setName(request.getParameter("name"));
            site.setUrl(request.getParameter("url"));

            site.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors=SiteValidator.validate(site);
            if(errors.size()>0){
                em.close();
                request.setAttribute("errors", errors);
                request.setAttribute("edit_site", site);
                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/site/edit.jsp");
                rd.forward(request, response);
            }else{
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().removeAttribute("edit_site_id");
                response.sendRedirect(request.getContextPath()+"/mysite");
            }
        }
    }

}
