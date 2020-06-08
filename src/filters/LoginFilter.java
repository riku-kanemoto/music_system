package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Member;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        String context_path=((HttpServletRequest)request).getContextPath();
        String servlet_path=((HttpServletRequest)request).getServletPath();
        HttpSession session=((HttpServletRequest)request).getSession();
        Member m=(Member)session.getAttribute("login_member");

        if(!servlet_path.matches("/css.*")){
            if(!servlet_path.matches("/toppage.*")){
                if(!servlet_path.equals("/site/new")){

                if(!servlet_path.equals("/login")){
                    if(m==null ){
                        ((HttpServletResponse)response).sendRedirect(context_path+"/toppage/index");
                        return;
                    }

                }else{
                    if(m !=null){
                        ((HttpServletResponse)response).sendRedirect(context_path+"/member/index");
                        return;
                    }
            }
            }
            if(m==null){
                 String test="サイトを追加するにはアカウントを登録してください";
                 session.setAttribute("test", test);
                }else{
                    String test="";
                    session.setAttribute("test", test);
                }
        }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
