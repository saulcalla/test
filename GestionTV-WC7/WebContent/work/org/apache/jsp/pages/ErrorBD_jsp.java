package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ErrorBD_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
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

      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("     <head>\r\n");
      out.write("          <title>Error BD!</title>\r\n");
      out.write("\t<meta name=\"pagina\"        content=\"ErrorBD.jsp\">\r\n");
      out.write("\t<meta name=\"modificado\"    content=\"Rakesh.Suyal.27Abril2005\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/styles/estylemenu.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/estylemenu.css\">\r\n");
      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write(" window.onerror = null;\r\n");
      out.write(" var bName = navigator.appName;\r\n");
      out.write(" var bVer = parseInt(navigator.appVersion);\r\n");
      out.write(" var NS4 = (bName == \"Netscape\" && bVer >= 4);\r\n");
      out.write(" var IE4 = (bName == \"Microsoft Internet Explorer\" && bVer >= 4);\r\n");
      out.write(" var NS3 = (bName == \"Netscape\" && bVer < 4);\r\n");
      out.write(" var IE3 = (bName == \"Microsoft Internet Explorer\" && bVer < 4);\r\n");
      out.write(" var blink_speed=800;\r\n");
      out.write(" var i=0;\r\n");
      out.write(" \r\n");
      out.write("if (NS4 || IE4) {\r\n");
      out.write("\tif (navigator.appName == \"Netscape\") {\r\n");
      out.write("\t\tlayerStyleRef=\"layer.\";\r\n");
      out.write("\t\tlayerRef=\"document.layers\";\r\n");
      out.write("\t\tstyleSwitch=\"\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tlayerStyleRef=\"layer.style.\";\r\n");
      out.write("\t\tlayerRef=\"document.all\";\r\n");
      out.write("\t\tstyleSwitch=\".style\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//BLINKING\r\n");
      out.write("function Blink(layerName){\r\n");
      out.write("\t if(NS4 || IE4) { \r\n");
      out.write("\t\t if(i%2==0){\r\n");
      out.write("\t\t\t eval(layerRef+'[\"'+layerName+'\"]'+\r\n");
      out.write("\t\t\t styleSwitch+'.visibility=\"visible\"');\r\n");
      out.write("\t\t }else{\r\n");
      out.write("\t\t\t eval(layerRef+'[\"'+layerName+'\"]'+\r\n");
      out.write("\t\t\t styleSwitch+'.visibility=\"hidden\"');\r\n");
      out.write("\t\t }\r\n");
      out.write("\t } \r\n");
      out.write("\r\n");
      out.write("\t if(i<1){\r\n");
      out.write("\t\t i++;\r\n");
      out.write("\t }else{\r\n");
      out.write("\t\t i--\r\n");
      out.write("\t }\r\n");
      out.write("\tsetTimeout(\"Blink('\"+layerName+\"')\",blink_speed);\r\n");
      out.write("}\r\n");
      out.write("//  End -->\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"Stylebody\">\r\n");
      out.write("<body bgcolor=\"#FFFFDE\">\r\n");
      out.write("<center>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<div id=\"prem_hint\" style=\"position:relative; left:0; visibility:hidden\" class=\"prem_hint\">\r\n");
      out.write("\t\t<font color=\"#FF0000\" size=\"4\"><b>");
      if (_jspx_meth_bean_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</b></font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p><font color=\"black\" size=\"4\">Intentar mas tarde...</font></p>\r\n");
      out.write("\t<script language=\"javascript\">Blink('prem_hint');</script>\r\n");
      out.write("\t<img src=\"pages/images/logo_ripley_rojo.gif\" border=\"0\" alt=\"GestionBT\">\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
    _jspx_th_bean_005fmessage_005f0.setKey("errorBdBlink");
    int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
    if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
    return false;
  }
}
