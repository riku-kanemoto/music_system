package controllers.site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MusicSite;

/**
 * Servlet implementation class AddSiteIndexServlet
 */
@WebServlet("/site/new")
public class SiteNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("musicSite", new MusicSite());
        String make_acount=(String) request.getSession().getAttribute("test");
        request.setAttribute("make_acount", make_acount);
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/site/new.jsp");
        rd.forward(request, response);
    }

}
