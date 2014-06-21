package cl.ripley.framework.util;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter
  implements Filter
{
  public FilterConfig filterConfig;
  private String loginUrl;
  private String timeOutUrl;

  public void init(FilterConfig filterConfig)
  {
    this.filterConfig = filterConfig;

    this.loginUrl = filterConfig.getInitParameter("loginUrl");
    this.timeOutUrl = filterConfig.getInitParameter("timeOutUrl");

    if (this.loginUrl == null) this.loginUrl = "";
    if (this.timeOutUrl == null) this.timeOutUrl = "";
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException
  {
    HttpServletRequest httpRequest = (HttpServletRequest)request;

    String requestedSessionID = httpRequest.getRequestedSessionId();
    HttpSession session = httpRequest.getSession(false);

    boolean lExito = true;
    try
    {
      if ((requestedSessionID != null) || (session != null))
      {
        if ((session.isNew()) && 
          (!requestedSessionID.equals(session.getId())))
        {
          if (!isLoginAction(httpRequest))
          {
            if (session != null) session.removeAttribute("AppUserInfo");

            RequestDispatcher rd = request.getRequestDispatcher(this.timeOutUrl);
            rd.forward(request, response);
            lExito = false;
          }
        }
      }
    }
    catch (NullPointerException npe) {
      System.out.println("npe.printStackTrace()=" + npe.toString());
      if (session != null) session.removeAttribute("AppUserInfo");

      RequestDispatcher rd = request.getRequestDispatcher(this.timeOutUrl);
      rd.forward(request, response);
      lExito = false;
    } catch (ServletException se) {
      System.out.println("se.printStackTrace()=" + se.toString());
      if (session != null) session.removeAttribute("AppUserInfo");

      RequestDispatcher rd = request.getRequestDispatcher(this.timeOutUrl);
      rd.forward(request, response);
      lExito = false;
    }

    if (lExito)
    {
      filterChain.doFilter(request, response);
    }
  }

  private boolean isLoginAction(HttpServletRequest request)
  {
    String path = request.getServletPath();
    if (path.equals(this.timeOutUrl)) return true;
    if (this.loginUrl.indexOf(path) >= 0) return true;
    return false;
  }

  public void destroy()
  {
  }
}