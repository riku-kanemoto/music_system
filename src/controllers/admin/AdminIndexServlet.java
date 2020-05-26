package controllers.admin;

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
 * Servlet implementation class AdminIndexServlet
 */
@WebServlet("/admin/index")
public class AdminIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em=DBUtil.createEntityManager();

        List<Member> members=em.createNamedQuery("getAllMembers",Member.class)
                .getResultList();

        em.close();

        request.setAttribute("members", members);
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
        rd.forward(request, response);
    }

}
