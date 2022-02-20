package by.it.academy.Mk_JD2_88_22.HomeTask1.endPoints.servlets;


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


@WebFilter(urlPatterns = {"/mess"})
public class SecurityFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) resp;
    HttpServletRequest request = (HttpServletRequest) req;
    String contextPath = request.getContextPath();
    HttpSession session = request.getSession();
    if ((session != null) && (session.getAttribute("user") != null)) {
      chain.doFilter(req,resp);
    }else{
      response.sendRedirect(contextPath+"view/signIn.jsp");
    }
  }

  @Override
  public void destroy() {

  }
}
