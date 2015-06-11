package servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by dennis on 29.05.2015.
 */



public class ControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}


    /**
     * This filter checks user session.
     * If user has no session - then this filter creates one.
     * After that - check if sessin in new, in case of true - redirects to login page.
     * If user has session, filter do nothing - passes to Controller.
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if ((session.isNew())) {
            System.out.println("Session is timeout, redirecting to login page");
            response.sendRedirect("/Controller");
        } else {
            System.out.println("Everything is OK");
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {}
}
