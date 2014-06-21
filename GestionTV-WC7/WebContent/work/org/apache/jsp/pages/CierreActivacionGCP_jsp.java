package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CierreActivacionGCP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fform_005faction.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.release();
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
      out.write("<!-- INI -- RC & PP -- 26/10/2004 -->\r\n");
      out.write("\r\n");

String vFormulario = new String("cierreActivacionGCPForm");
String vSend = new String("buscar");
String vForm = new String("document.cierreActivacionGCPForm");
String titulogeneral = new String("cierreActivacionGCP.titGeneral");
String titulopagina = new String("cierreActivacionGCP.titPagina");
String vaccion = new String("/cierreActivacionGCP");
String accioninicio = new String("InicioCierreActivacionGCP");
String btnactivar = new String("cierreActivacionGCP.btnactivar");
String tituloFecha = new String("cierreActivacionGCP.fecha");
String paramFechaInicio 	= new String("fec_inicio");
request.getSession().setAttribute("Conectado","OK");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- END -- RC & PP -- 26/10/2004 -->\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tvar contador \t\t\t\t  = 0;\r\n");
      out.write("\tvar contador_checkBox_checked = 0;\r\n");
      out.write("\tvar seleccionar \t\t\t  = true;\r\n");
      out.write("\tvar K_REGISTROS_POR_PAGINA \t  = 10;\r\n");
      out.write("\tlista=\"0123456789/\";\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\tfunction do_activar() {\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\tobj.accion.value \t= \"cierre\";\r\n");
      out.write("\t\tobj.submit();\t  \t\r\n");
      out.write("\r\n");
      out.write("\t} // do_activar\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tfunction do_impresion (id_voucher){\r\n");
      out.write("\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\tvar v = ");
      out.print(vForm);
      out.write(".link_voucher;\r\n");
      out.write("\t\tvar url_voucher = v.value+\"&impresion=ok\";\r\n");
      out.write("\t\tvar ventimp = window.open(url_voucher,'400x560','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=580,height=660');\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction body_onload_GestionTV() {\r\n");
      out.write("\t\twindow.history.forward(1);\r\n");
      out.write("\t\tobj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\tvar temp = \"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f0 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f0.setParent(null);
      _jspx_th_bean_005fwrite_005f0.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f0.setProperty("temp");
      int _jspx_eval_bean_005fwrite_005f0 = _jspx_th_bean_005fwrite_005f0.doStartTag();
      if (_jspx_th_bean_005fwrite_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
      out.write("\"\r\n");
      out.write("\r\n");
      out.write("\t\tvar cierre = \"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f1 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f1.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f1.setParent(null);
      _jspx_th_bean_005fwrite_005f1.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f1.setProperty("cierre");
      int _jspx_eval_bean_005fwrite_005f1 = _jspx_th_bean_005fwrite_005f1.doStartTag();
      if (_jspx_th_bean_005fwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("\t\tif (temp == \"si\") {\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(obj.mensaje.value != \"\") {\r\n");
      out.write("\t\t\t\talert(obj.mensaje.value);\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f2 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f2.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f2.setParent(null);
      _jspx_th_bean_005fwrite_005f2.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f2.setProperty("flagDatosBD");
      int _jspx_eval_bean_005fwrite_005f2 = _jspx_th_bean_005fwrite_005f2.doStartTag();
      if (_jspx_th_bean_005fwrite_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
      out.write("\" == \"no\") {\r\n");
      out.write("\t\t\talert(\"No hay Datos con Parametros Ingresados\");\r\n");
      out.write("\t\t\tobj.flagDatosBD.value = \"si\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f3 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f3.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f3.setParent(null);
      _jspx_th_bean_005fwrite_005f3.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f3.setProperty("hayDatos");
      int _jspx_eval_bean_005fwrite_005f3 = _jspx_th_bean_005fwrite_005f3.doStartTag();
      if (_jspx_th_bean_005fwrite_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
      out.write("\" == \"si\") {\r\n");
      out.write("\t\t\tsetButton();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (cierre == \"ok\") {\r\n");
      out.write("\t\t\tobj.btnImpresion.disabled = false;\r\n");
      out.write("\t\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\tvar v = ");
      out.print(vForm);
      out.write(".link_voucher;\r\n");
      out.write("\t\t\tvar url_voucher = v.value+\"&impresion=no\";\r\n");
      out.write("\t\t\tvar ventimp = window.open(url_voucher,'400x560','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=580,height=660');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f0 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f0.setParent(null);
      _jspx_th_bean_005fmessage_005f0.setKey(titulogeneral);
      int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
      if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      out.write("\r\n");
      out.write("\t</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\t\thref=\"pages/styles/estylemante.css\">\r\n");
      out.write("\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/estylemante.css\"> -->\r\n");
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\" src=\"pages/scripts/FormChek_JS10_NS2.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"scripts/FormChek_JS10_NS2.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"scripts/calendario.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"pages/scripts/calendario.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"pages/scripts/funciones.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"scripts/funciones.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"scripts/paginacion.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"pages/scripts/paginacion.js\"></script>\r\n");
      out.write("<body class=\"Stylebody\" onload=\"javascript:body_onload_GestionTV();\">\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<font class=\"StyleHead_left\">");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f1 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f1.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f1.setParent(null);
      _jspx_th_bean_005fmessage_005f1.setKey(titulopagina);
      int _jspx_eval_bean_005fmessage_005f1 = _jspx_th_bean_005fmessage_005f1.doStartTag();
      if (_jspx_th_bean_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
      out.write("\r\n");
      out.write("\t\t</font>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t");
      //  html:form
      org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_005faction.get(org.apache.struts.taglib.html.FormTag.class);
      _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_html_005fform_005f0.setParent(null);
      _jspx_th_html_005fform_005f0.setAction(vaccion);
      int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
      if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\r\n");
          out.write("\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_html_005fhidden_005f0(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\r\n");
          out.write("\t\t\t<input type=\"hidden\" name=\"mensaje\"\r\n");
          out.write("\t\t\tvalue='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f4 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f4.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f4.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f4.setProperty("mensaje");
          int _jspx_eval_bean_005fwrite_005f4 = _jspx_th_bean_005fwrite_005f4.doStartTag();
          if (_jspx_th_bean_005fwrite_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
          out.write("'>\r\n");
          out.write("\r\n");
          out.write("\t\t\t<input type=\"hidden\" name=\"link_voucher\"\r\n");
          out.write("\t\t\t\tvalue='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f5 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f5.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f5.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f5.setProperty("linkVoucherHTML");
          int _jspx_eval_bean_005fwrite_005f5 = _jspx_th_bean_005fwrite_005f5.doStartTag();
          if (_jspx_th_bean_005fwrite_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
          out.write("'>\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\r\n");
          out.write("\t\t\t");

			int idx = 1;
			
          out.write("\r\n");
          out.write("\t\t\t<!-- END -- RC & PP -- 26/10/2004 -->\r\n");
          out.write("\t\t\t<table width=\"10%\" align=\"center\" class=\"StyleTabla_75\">\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t&nbsp;\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td class=\"StyleTextoTabla\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t");
          //  bean:message
          org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f2 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
          _jspx_th_bean_005fmessage_005f2.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fmessage_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fmessage_005f2.setKey(tituloFecha);
          int _jspx_eval_bean_005fmessage_005f2 = _jspx_th_bean_005fmessage_005f2.doStartTag();
          if (_jspx_th_bean_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
          out.write("\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td class=\"StyleTextoTabla\" align=\"left\">\r\n");
          out.write("   \t  \t\t\t");
          //  html:text
          org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f0 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
          _jspx_th_html_005ftext_005f0.setPageContext(_jspx_page_context);
          _jspx_th_html_005ftext_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_html_005ftext_005f0.setName(vFormulario);
          _jspx_th_html_005ftext_005f0.setProperty(paramFechaInicio);
          _jspx_th_html_005ftext_005f0.setSize("10");
          _jspx_th_html_005ftext_005f0.setMaxlength("10");
          _jspx_th_html_005ftext_005f0.setOnkeypress("return valida_caracteres(event,lista);");
          _jspx_th_html_005ftext_005f0.setOnblur("ValidaFecha(this)");
          int _jspx_eval_html_005ftext_005f0 = _jspx_th_html_005ftext_005f0.doStartTag();
          if (_jspx_th_html_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
          out.write("\r\n");
          out.write("   \t\t        <input type=button name=\"BtnFecha\" value=\"C\" onclick=\"goWindowPopupCalendario('cierreActivacionGCPForm','fec_inicio');\" STYLE=\"border:1px solid white; height:20px;\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("    \t\t</td>\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t&nbsp;\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("\t\t\t<br>\r\n");
          out.write("\t\t\t<table border=\"0\" class=\"StyleTabla_75\" align=\"center\">\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnActivar\" value=\"GENERAR\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"do_activar();\"\r\n");
          out.write("\t\t\t\t\t\t\tSTYLE=\"border:1px solid white; width:80px\"\r\n");
          out.write("\t\t\t\t\t\t\tonMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\"\r\n");
          out.write("\t\t\t\t\t\t\tonMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("\t\t\t\t\t</td>\t\t\t\t\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t\t<td align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"button\" disabled=\"disabled\" name=\"btnImpresion\" value=\"IMPRESION\"\r\n");
          out.write("\t\t\t\t\t\t\t\tonclick=\"do_impresion();\"\r\n");
          out.write("\t\t\t\t\t\t\t\tSTYLE=\"border:1px solid white; width:80px\"\r\n");
          out.write("\t\t\t\t\t\t\t\tonMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\"\r\n");
          out.write("\t\t\t\t\t\t\t\tonMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\t\t\t\t\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t<br>\r\n");
          int evalDoAfterBody = _jspx_th_html_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fhtml_005fform_005faction.reuse(_jspx_th_html_005fform_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fhtml_005fform_005faction.reuse(_jspx_th_html_005fform_005f0);
      out.write("\r\n");
      out.write("<!-------- Parametros para el calendario ---------------------- -->\r\n");
      out.write("<form name=\"formularioPadre\" method=\"post\" action=\"\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"txtNameFormulario\" value=\"\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"txtNameObjetoText\" value=\"\">\r\n");
      out.write("</form>\r\n");
      out.write("<!-------- Fin de paramtros del calendario -------------------- -->    \t\t\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_html_005fhidden_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f0 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f0.setProperty("accion");
    _jspx_th_html_005fhidden_005f0.setValue("buscar");
    int _jspx_eval_html_005fhidden_005f0 = _jspx_th_html_005fhidden_005f0.doStartTag();
    if (_jspx_th_html_005fhidden_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
    return false;
  }
}
