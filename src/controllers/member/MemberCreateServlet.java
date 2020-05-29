package controllers.member;

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
import utils.DBUtil;
import utils.EncryptUtil;
import validators.MemberValidator;

/**
 * Servlet implementation class MemberCreateServlet
 */
@WebServlet("/member/create")
public class MemberCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token=(String)request.getParameter("_token");
        if(_token !=null &&_token.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();
            Member m=new Member();

            m.setName(request.getParameter("name"));
            m.setAdress(request.getParameter("adress"));
            m.setPassword(
                    EncryptUtil.getPasswordEncrypt(request.getParameter("password"),
                            (String)this.getServletContext().getAttribute("salt")
                            )
                    );
            m.setAdmin_flag(0);
            m.setDelete_flag(0);
            Timestamp currentTime=new Timestamp(System.currentTimeMillis());
            m.setCreated_at(currentTime);
            m.setUpdated_at(currentTime);
            List<String> errors=MemberValidator.validate(m, true, true);
            if(errors.size()>0){
                em.close();
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("errors", errors);
                request.setAttribute("member",m);
                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/member/new.jsp");
                rd.forward(request, response);

            }else{
                em.getTransaction().begin();
                em.persist(m);
                em.getTransaction().commit();
                em.close();
                response.sendRedirect(request.getContextPath()+"/member/index");
            }
        }
    }

}
