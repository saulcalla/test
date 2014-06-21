package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GestionTV_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      cl.ripley.GestionTV.struts.action.MenuAction objAction = null;
      synchronized (session) {
        objAction = (cl.ripley.GestionTV.struts.action.MenuAction) _jspx_page_context.getAttribute("objAction", PageContext.SESSION_SCOPE);
        if (objAction == null){
          objAction = new cl.ripley.GestionTV.struts.action.MenuAction();
          _jspx_page_context.setAttribute("objAction", objAction, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
 
String strMenu = (String) request.getSession().getAttribute("strMenu"); 

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("   <title>");
      if (_jspx_meth_bean_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("   <meta name=\"pagina\"        content=\"index.jsp\">\r\n");
      out.write("   <meta name=\"modificado\"    content=\"rcid.04Agosto2004\">\r\n");
      out.write("   <script language=\"javascript\" src=\"scripts/funciones.js\"></script>\r\n");
      out.write("   <script language=\"JavaScript\" src=\"scripts/slidemenu-v3.js\" type=\"text/javascript\"></script>\r\n");
      out.write("   <script language=\"JavaScript\">\r\n");
      out.write("      var cadenaString=\"");
      out.print(strMenu);
      out.write("\";\r\n");
      out.write("   </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"menuIzq_body\" leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("   <script language=\"JavaScript\" src=\"scripts/creamenu-v3.js\" type=\"text/javascript\"></script>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_bean_005fmessage_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f0 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f0.setParent(null);
    _jspx_th_bean_005fmessage_005f0.setKey("gestiontv.titulo");
    int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
    if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
    return false;
  }
}
