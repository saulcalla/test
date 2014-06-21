package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AperturaCierreGCP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005foption_005fvalue;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005foption_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fform_005faction.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.release();
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

String vFormulario = new String("aperturaCierreGCPForm");
String vSend = new String("buscar");
String vForm = new String("document.aperturaCierreGCPForm");
String titulogeneral = new String("aperturaCierreGCP.titGeneral");
String titulopagina = new String("aperturaCierreGCP.titPagina");
String vaccion = new String("/aperturaCierreGCP");
String accioninicio = new String("InicioAperturaCierreGCP");
String btnactivar = new String("aperturaCierreGCP.btnactivar");
String tituloFecha = new String("aperturaCierreGCP.fecha");
String tituloOpcion = new String("aperturaCierreGCP.opcion");
String paramFechaInicio 	= new String("fec_inicio");

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
      out.write("\t\tobj.accion.value \t= obj.aperturaCierre.value;\r\n");
      out.write("\t\tobj.submit();\t  \t\r\n");
      out.write("\r\n");
      out.write("\t} // do_activar\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tfunction do_desActivar() {\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar num_gcp = obj.numTarjetaGCP.value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// Valido que ingresen datos\r\n");
      out.write("\t\tif (validaFormatoCAR()) {\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\tif (valida_datos()) {\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif (confirm('¿Esta Seguro que desea anular GCP?' )) {\r\n");
      out.write("\t\t\t\t\t\tobj.accion.value \t\t\t = \"desactivar\";\r\n");
      out.write("\t\t\t\t\t\tobj.submit();\t  \t\r\n");
      out.write("\t\t\t\t}\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
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
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f1 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f1.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f1.setParent(null);
      _jspx_th_bean_005fwrite_005f1.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f1.setProperty("flagDatosBD");
      int _jspx_eval_bean_005fwrite_005f1 = _jspx_th_bean_005fwrite_005f1.doStartTag();
      if (_jspx_th_bean_005fwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
      out.write("\" == \"no\") {\r\n");
      out.write("\t\t\talert(\"No hay Datos con Parametros Ingresados\");\r\n");
      out.write("\t\t\tobj.flagDatosBD.value = \"si\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f2 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f2.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f2.setParent(null);
      _jspx_th_bean_005fwrite_005f2.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f2.setProperty("hayDatos");
      int _jspx_eval_bean_005fwrite_005f2 = _jspx_th_bean_005fwrite_005f2.doStartTag();
      if (_jspx_th_bean_005fwrite_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
      out.write("\" == \"si\") {\r\n");
      out.write("\t\t\tsetButton();\r\n");
      out.write("\t\t}\r\n");
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
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f3 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f3.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f3.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f3.setProperty("mensaje");
          int _jspx_eval_bean_005fwrite_005f3 = _jspx_th_bean_005fwrite_005f3.doStartTag();
          if (_jspx_th_bean_005fwrite_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
          out.write("'>\r\n");
          out.write("\t\t\t\r\n");
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
          out.write("   \t\t        <input type=button name=\"BtnFecha\" value=\"C\" onclick=\"goWindowPopupCalendario('aperturaCierreGCPForm','fec_inicio');\" STYLE=\"border:1px solid white; height:20px;\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("    \t\t</td>\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t&nbsp;\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td class=\"StyleTextoTabla\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t");
          //  bean:message
          org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f3 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
          _jspx_th_bean_005fmessage_005f3.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fmessage_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fmessage_005f3.setKey(tituloOpcion);
          int _jspx_eval_bean_005fmessage_005f3 = _jspx_th_bean_005fmessage_005f3.doStartTag();
          if (_jspx_th_bean_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
          out.write("\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td align=\"left\">\r\n");
          out.write("\t\t\t\t\t\t");
          //  html:select
          org.apache.struts.taglib.html.SelectTag _jspx_th_html_005fselect_005f0 = (org.apache.struts.taglib.html.SelectTag) _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname.get(org.apache.struts.taglib.html.SelectTag.class);
          _jspx_th_html_005fselect_005f0.setPageContext(_jspx_page_context);
          _jspx_th_html_005fselect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_html_005fselect_005f0.setName(vFormulario);
          _jspx_th_html_005fselect_005f0.setProperty("aperturaCierre");
          int _jspx_eval_html_005fselect_005f0 = _jspx_th_html_005fselect_005f0.doStartTag();
          if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_html_005fselect_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_html_005fselect_005f0.doInitBody();
            }
            do {
              out.write("\t\t\t\t\t\t\t\r\n");
              out.write("\t\t\t\t\t\t\t");
              if (_jspx_meth_html_005foption_005f0(_jspx_th_html_005fselect_005f0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t");
              if (_jspx_meth_html_005foption_005f1(_jspx_th_html_005fselect_005f0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_html_005fselect_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.popBody();
            }
          }
          if (_jspx_th_html_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname.reuse(_jspx_th_html_005fselect_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fhtml_005fselect_005fproperty_005fname.reuse(_jspx_th_html_005fselect_005f0);
          out.write("\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t</tr>\r\n");
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
          out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnActivar\" value=\"INSERTAR\"\r\n");
          out.write("\t\t\t\t\t\t\tonclick=\"do_activar();\"\r\n");
          out.write("\t\t\t\t\t\t\tSTYLE=\"border:1px solid white; width:80px\"\r\n");
          out.write("\t\t\t\t\t\t\tonMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\"\r\n");
          out.write("\t\t\t\t\t\t\tonMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
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

  private boolean _jspx_meth_html_005foption_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fselect_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_005foption_005f0 = (org.apache.struts.taglib.html.OptionTag) _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_005foption_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005foption_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fselect_005f0);
    _jspx_th_html_005foption_005f0.setValue("apertura");
    int _jspx_eval_html_005foption_005f0 = _jspx_th_html_005foption_005f0.doStartTag();
    if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005foption_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005foption_005f0.doInitBody();
      }
      do {
        out.write("APERTURA");
        int evalDoAfterBody = _jspx_th_html_005foption_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005foption_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.reuse(_jspx_th_html_005foption_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.reuse(_jspx_th_html_005foption_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005foption_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fselect_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_005foption_005f1 = (org.apache.struts.taglib.html.OptionTag) _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_005foption_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005foption_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fselect_005f0);
    _jspx_th_html_005foption_005f1.setValue("cierre");
    int _jspx_eval_html_005foption_005f1 = _jspx_th_html_005foption_005f1.doStartTag();
    if (_jspx_eval_html_005foption_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005foption_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005foption_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005foption_005f1.doInitBody();
      }
      do {
        out.write("CIERRE");
        int evalDoAfterBody = _jspx_th_html_005foption_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005foption_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005foption_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.reuse(_jspx_th_html_005foption_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005foption_005fvalue.reuse(_jspx_th_html_005foption_005f1);
    return false;
  }
}
