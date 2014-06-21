package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AuditoriaGCP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
    _jspx_dependants.add("/pages/registrosPorPagina.txt");
    _jspx_dependants.add("/pages/paginacion.txt");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fform_005faction.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_005fsize_005fproperty_005fonkeypress_005fonblur_005fname_005fmaxlength_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.release();
    _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.release();
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

    java.lang.Object _jspx_elemento_1 = null;
    java.lang.Integer _jspx_index_1 = null;

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
      out.write("<!-- INI -- RC & PP -- 26/10/2004 -->\r\n");
      out.write("\r\n");
 String vFormulario 	= new String("auditoriaGCPForm"); 
      out.write('\r');
      out.write('\n');
 String vSend 		= new String("buscar"); 
      out.write('\r');
      out.write('\n');
 String vForm 		= new String("document.auditoriaGCPForm"); 
      out.write('\r');
      out.write('\n');
 String titulogeneral = new String("auditoriaGCP.titGeneral"); 
      out.write('\r');
      out.write('\n');
 String titulopagina 	= new String("auditoriaGCP.titPagina"); 
      out.write('\r');
      out.write('\n');
 String vaccion 		= new String("/auditoriaGCP"); 
      out.write('\r');
      out.write('\n');
 String accioninicio 	= new String("InicioAuditoriaGCP"); 
      out.write('\r');
      out.write('\n');
 String vcolumna 		= new String("auditoriaGCP.campo"); 
      out.write('\r');
      out.write('\n');
 String btncancelar 	= new String("auditoriaGCP.boton.cancelar"); 
      out.write('\r');
      out.write('\n');
 String btnbuscar 	= new String("auditoriaGCP.boton.buscar"); 
      out.write('\r');
      out.write('\n');
 String parametroFechaInicio 	= new String("auditoriaGCP.titfechainicio"); 
      out.write('\r');
      out.write('\n');
 String parametroFechaHasta = new String("auditoriaGCP.titfechanueva"); 
      out.write('\r');
      out.write('\n');
 String paramFechaInicio 	= new String("fec_inicio"); 
      out.write("\r\n");
      out.write("\r\n");
 int 	  numcol 		= 18; 
      out.write("\r\n");
      out.write("<script language=\"javascript\">\t\r\n");
      out.write("\tvar RegporBloq = \"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f0 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f0.setParent(null);
      _jspx_th_bean_005fwrite_005f0.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f0.setProperty("registrosPorBloque");
      int _jspx_eval_bean_005fwrite_005f0 = _jspx_th_bean_005fwrite_005f0.doStartTag();
      if (_jspx_th_bean_005fwrite_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
      out.write("\";\r\n");
      out.write("    var NumBolq    = \"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f1 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f1.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f1.setParent(null);
      _jspx_th_bean_005fwrite_005f1.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f1.setProperty("nroBloque");
      int _jspx_eval_bean_005fwrite_005f1 = _jspx_th_bean_005fwrite_005f1.doStartTag();
      if (_jspx_th_bean_005fwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
      out.write("\";\r\n");
      out.write("</script>\r\n");
      out.write("<!-- END -- RC & PP -- 26/10/2004 -->\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tvar contador \t\t\t\t  = 0;\r\n");
      out.write("\tvar contador_checkBox_checked = 0;\r\n");
      out.write("\tvar seleccionar \t\t\t  = true;\r\n");
      out.write("\tvar K_REGISTROS_POR_PAGINA \t  = 10;\r\n");
      out.write("\tlista=\"0123456789/\";\r\n");
      out.write("\t\r\n");
      out.write("function do_btnExcel()\r\n");
      out.write("{\r\n");
      out.write("\tvar obj = document.auditoriaGCPForm;\r\n");
      out.write("\tobj.vctExpHead.value = \"[[\";\r\n");
      out.write("\t ");
for(int i=1;i<=numcol-1;i++){ 
	 	String tempo= new String(vcolumna+i);
      out.write("\t\r\n");
      out.write("\t\tobj.vctExpHead.value = obj.vctExpHead.value+ \"");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f0 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f0.setParent(null);
      _jspx_th_bean_005fmessage_005f0.setKey(tempo);
      int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
      if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      out.write("\" +\", \";\r\n");
      out.write("\t");
}
	String tempo= new String(vcolumna+numcol);
      out.write("\r\n");
      out.write("\tobj.vctExpHead.value = obj.vctExpHead.value+\"");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f1 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f1.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f1.setParent(null);
      _jspx_th_bean_005fmessage_005f1.setKey(tempo);
      int _jspx_eval_bean_005fmessage_005f1 = _jspx_th_bean_005fmessage_005f1.doStartTag();
      if (_jspx_th_bean_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
      out.write("\";\r\n");
      out.write("\tobj.vctExpHead.value = obj.vctExpHead.value+\"]]\";\t\t\t\r\n");
      out.write("\r\n");
      out.write(" \tobj.accion.value = \"excel\";\r\n");
      out.write("\tobj.submit(); \r\n");
      out.write("}\r\n");
      out.write("\tfunction validaCampoNulo() {\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tif(obj.");
      out.print(paramFechaInicio);
      out.write(".value == \"\" ) {\r\n");
      out.write("\t\t\talert(\"Debe ingresar Datos de busqueda\");\r\n");
      out.write("\t\t\treturn(true);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn(false);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction do_buscar() {\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (validaCampoNulo()) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tobj.indice.value \t\t\t = \"0\";\r\n");
      out.write("\t\tobj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;\r\n");
      out.write("\t\tobj.nroBloque.value \t\t = \"1\";\r\n");
      out.write("\t\t\r\n");
      out.write("  \t\tobj.accion.value \t\t\t = \"buscar\";\r\n");
      out.write("\t\tobj.submit();\t  \t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction acceptNum(evt){\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar nav4 = window.Event ? true : false;\r\n");
      out.write("\t\tvar key = nav4 ? evt.which : evt.keyCode;\t\r\n");
      out.write("\t\treturn (key <= 13 || (key >= 48 && key <= 57));\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction btnLimpiar_onclick(){\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tobj.accion.value = \"");
      out.print(accioninicio);
      out.write("\";\r\n");
      out.write("\t\tobj.submit();\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction do_cancelar() {\r\n");
      out.write("\t\tvar obj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tobj.accion.value = \"cancelar\";\r\n");
      out.write("\t\tobj.submit();\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction body_onload_GestionTV() {\r\n");
      out.write("\t\twindow.history.forward(1);\r\n");
      out.write("\t\tobj = ");
      out.print(vForm);
      out.write(";\r\n");
      out.write("\r\n");
      out.write("\t\tvar temp = \"");
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
      out.write("\"\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (temp == \"si\") {\r\n");
      out.write("\t\t\tsetItemSelect(obj);\r\n");
      out.write("\t\t\tsetDisabled_btnPage(true , obj);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tK_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;\r\n");
      out.write("\t\t\tobj.btn_buscar.disabled       = true;\r\n");
      out.write("\t\t\tobj.");
      out.print(paramFechaInicio);
      out.write(".disabled = true;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(obj.mensaje.value!=\"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tif(obj.mensaje.value == \"Error al Exportar\")\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\talert(obj.mensaje.value);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
      out.write("\t\t\t\t\tvar wleft     = \"left=1100\";\r\n");
      out.write("    \t\t\t\tvar wname     = \"Excel\";\r\n");
      out.write("\t   \t\t    \tvar wwidth    = \"width=1\";\r\n");
      out.write("\t    \t\t\tvar wheight   = \"height=1\";\r\n");
      out.write("\t\t\t\t\twindow.open(obj.exportFile.value,wname,wleft+\",\"+wwidth+\",\"+wheight);\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tobj.mensaje.value = \"\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f3 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f3.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f3.setParent(null);
      _jspx_th_bean_005fwrite_005f3.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f3.setProperty("flagDatosBD");
      int _jspx_eval_bean_005fwrite_005f3 = _jspx_th_bean_005fwrite_005f3.doStartTag();
      if (_jspx_th_bean_005fwrite_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
      out.write("\" == \"no\") {\r\n");
      out.write("\t\t\talert(\"No hay Datos con Parametros Ingresados\");\r\n");
      out.write("\t\t\tobj.flagDatosBD.value = \"si\";\r\n");
      out.write("\t\t\tbtnLimpiar_onclick();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f4 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f4.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f4.setParent(null);
      _jspx_th_bean_005fwrite_005f4.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f4.setProperty("hayDatos");
      int _jspx_eval_bean_005fwrite_005f4 = _jspx_th_bean_005fwrite_005f4.doStartTag();
      if (_jspx_th_bean_005fwrite_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
      out.write("\" == \"si\") {\r\n");
      out.write("\t\t\tsetButton();\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (\"");
      //  bean:write
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f5 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
      _jspx_th_bean_005fwrite_005f5.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fwrite_005f5.setParent(null);
      _jspx_th_bean_005fwrite_005f5.setName(vFormulario);
      _jspx_th_bean_005fwrite_005f5.setProperty("actualiza");
      int _jspx_eval_bean_005fwrite_005f5 = _jspx_th_bean_005fwrite_005f5.doStartTag();
      if (_jspx_th_bean_005fwrite_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
      out.write("\" == \"si\") {\r\n");
      out.write("\r\n");
      out.write("\t\t\tobj.fec_inicio.disabled = true;\r\n");
      out.write("\t\t\tobj.btn_buscar.disabled = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f2 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f2.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f2.setParent(null);
      _jspx_th_bean_005fmessage_005f2.setKey(titulogeneral);
      int _jspx_eval_bean_005fmessage_005f2 = _jspx_th_bean_005fmessage_005f2.doStartTag();
      if (_jspx_th_bean_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
      out.write("</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"pages/styles/estylemante.css\">\r\n");
      out.write("\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/estylemante.css\"> -->\r\n");
      out.write("</head>\r\n");
      out.write("\t<script language=\"javascript\" src=\"pages/scripts/FormChek_JS10_NS2.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"scripts/FormChek_JS10_NS2.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"scripts/calendario.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"pages/scripts/calendario.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"pages/scripts/funciones.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"scripts/funciones.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"scripts/paginacion.js\"></script>\r\n");
      out.write("  \t<script language=\"javascript\" src=\"pages/scripts/paginacion.js\"></script>\r\n");
      out.write("\t<body class=\"Stylebody\" onload=\"javascript:body_onload_GestionTV();\">\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("  \t<font class=\"StyleHead_left\">");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f3 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f3.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f3.setParent(null);
      _jspx_th_bean_005fmessage_005f3.setKey(titulopagina);
      int _jspx_eval_bean_005fmessage_005f3 = _jspx_th_bean_005fmessage_005f3.doStartTag();
      if (_jspx_th_bean_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
      out.write("</font>\r\n");
      out.write("  \t<br>\r\n");
      //  html:form
      org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_005faction.get(org.apache.struts.taglib.html.FormTag.class);
      _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_html_005fform_005f0.setParent(null);
      _jspx_th_html_005fform_005f0.setAction(vaccion);
      int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
      if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  \t");
          if (_jspx_meth_html_005fhidden_005f0(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("  \t");
          if (_jspx_meth_html_005fhidden_005f1(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t<input type=\"hidden\" name=\"mensaje\"   value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f6 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f6.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f6.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f6.setProperty("mensaje");
          int _jspx_eval_bean_005fwrite_005f6 = _jspx_th_bean_005fwrite_005f6.doStartTag();
          if (_jspx_th_bean_005fwrite_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f6);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f6);
          out.write("'>\r\n");
          out.write("\t");
          if (_jspx_meth_html_005fhidden_005f2(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write(" \r\n");
          out.write("<!-- INI -- RC & PP -- 26/10/2004 -->\r\n");
          out.write("\t");
          if (_jspx_meth_html_005fhidden_005f3(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_html_005fhidden_005f4(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_html_005fhidden_005f5(_jspx_th_html_005fform_005f0, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t<input type=\"hidden\" name=\"contador\"           value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f7 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f7.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f7.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f7.setProperty("contador");
          int _jspx_eval_bean_005fwrite_005f7 = _jspx_th_bean_005fwrite_005f7.doStartTag();
          if (_jspx_th_bean_005fwrite_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f7);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f7);
          out.write("'>\r\n");
          out.write("\t<input type=\"hidden\" name=\"indice\"             value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f8 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f8.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f8.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f8.setProperty("indice");
          int _jspx_eval_bean_005fwrite_005f8 = _jspx_th_bean_005fwrite_005f8.doStartTag();
          if (_jspx_th_bean_005fwrite_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f8);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f8);
          out.write("' >\r\n");
          out.write("\t<input type=\"hidden\" name=\"registrosPorBloque\" value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f9 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f9.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f9.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f9.setProperty("registrosPorBloque");
          int _jspx_eval_bean_005fwrite_005f9 = _jspx_th_bean_005fwrite_005f9.doStartTag();
          if (_jspx_th_bean_005fwrite_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f9);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f9);
          out.write("'>\r\n");
          out.write("\t<input type=\"hidden\" name=\"nroBloque\"          value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f10 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f10.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f10.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f10.setProperty("nroBloque");
          int _jspx_eval_bean_005fwrite_005f10 = _jspx_th_bean_005fwrite_005f10.doStartTag();
          if (_jspx_th_bean_005fwrite_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f10);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f10);
          out.write("'>\r\n");
          out.write("\t<input type=\"hidden\" name=\"hayProximoBloque\"   value='");
          //  bean:write
          org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f11 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
          _jspx_th_bean_005fwrite_005f11.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fwrite_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fwrite_005f11.setName(vFormulario);
          _jspx_th_bean_005fwrite_005f11.setProperty("hayProximoBloque");
          int _jspx_eval_bean_005fwrite_005f11 = _jspx_th_bean_005fwrite_005f11.doStartTag();
          if (_jspx_th_bean_005fwrite_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f11);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f11);
          out.write("'>\r\n");
          out.write("\r\n");

	int idx = 1;

          out.write("\r\n");
          out.write("<!-- END -- RC & PP -- 26/10/2004 -->\r\n");
          out.write("  \t<table width=\"30%\" align=\"center\" class=\"StyleTabla_75\">\r\n");
          out.write("    \t<tr>\r\n");
          out.write("\t\t</tr>    \t\r\n");
          out.write("    \t\r\n");
          out.write("  \t\t<tr> \r\n");
          out.write("\t\t\t<td>&nbsp;</td>\r\n");
          out.write("\t\t\t<td class=\"StyleTextoTabla\">\r\n");
          out.write("\t\t\t\t");
          //  bean:message
          org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f4 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
          _jspx_th_bean_005fmessage_005f4.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fmessage_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_bean_005fmessage_005f4.setKey(parametroFechaInicio);
          int _jspx_eval_bean_005fmessage_005f4 = _jspx_th_bean_005fmessage_005f4.doStartTag();
          if (_jspx_th_bean_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f4);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f4);
          out.write("\r\n");
          out.write("\t\t\t</td>\r\n");
          out.write("   \t\t\t<td class=\"StyleTextoTabla\">\r\n");
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
          out.write("   \t\t        <input type=button name=\"BtnFecha\" value=\"C\" onclick=\"goWindowPopupCalendario('auditoriaGCPForm','fec_inicio');\" STYLE=\"border:1px solid white; height:20px;\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
          out.write("    \t\t</td>\t\t\t\r\n");
          out.write("\t\t\t\r\n");
          out.write("\r\n");
          out.write("\t\t\t<td>&nbsp;</td>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\r\n");
          out.write("\t\t\t<td align=\"right\"> \r\n");
          out.write("\t\t\t\t<input type=\"button\" name=\"btn_buscar\" value=\"Buscar\" onclick=\"do_buscar();\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \t\r\n");
          out.write("\t\t\t</td>    \t\t\r\n");
          out.write("\t\t\t<td align=\"center\">\r\n");
          out.write("\t\t\t\t<input type=\"button\" name=\"btnLimpiar\" value=\"Limpiar\" onclick=\"btnLimpiar_onclick();\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \t\r\n");
          out.write("\t\t \t</td>\r\n");
          out.write("\r\n");
          out.write("    \t</tr>\r\n");
          out.write("    \t<tr>\r\n");
          out.write("    \t</tr>    \t\r\n");
          out.write("    \t<tr>\r\n");
          out.write("    \t</tr>    \r\n");
          out.write("    \t\r\n");
          out.write("\r\n");
          out.write("\t</table>\r\n");
          out.write("<!-- INI -- RC & PP -- 26/10/2004 -->\r\n");
          out.write("\t");
          //  logic:equal
          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f0 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
          _jspx_th_logic_005fequal_005f0.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fequal_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_logic_005fequal_005f0.setName(vFormulario);
          _jspx_th_logic_005fequal_005f0.setProperty("hayDatos");
          _jspx_th_logic_005fequal_005f0.setValue("si");
          int _jspx_eval_logic_005fequal_005f0 = _jspx_th_logic_005fequal_005f0.doStartTag();
          if (_jspx_eval_logic_005fequal_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              out.write('	');
              out.write("<!-- INICIO TABLA SELECT ITEM POR PAGINACION-->\r\n");
              out.write("<table class=\"StyleTabla_75\">\r\n");
              out.write("\t<tr align=\"right\">\r\n");
              out.write("    \t<td class=\"StyleTextoTabla\">Registros por Página : \r\n");
              out.write("        \t<select name=\"SelectItemsPorPagina\" onchange=\"selectItemsPorPagina_onchange(");
              out.print(vForm);
              out.write(',');
              out.write('\'');
              out.print(vSend);
              out.write("');\">\r\n");
              out.write("        \t   \t<option value=\"10\">10</option>\r\n");
              out.write("\t\t\t    <option value=\"15\">15</option> \r\n");
              out.write("         \t\t<option value=\"20\">20</option> \r\n");
              out.write("         \t\t<option value=\"30\">30</option> \r\n");
              out.write("\t         \t<option value=\"35\">35</option>\r\n");
              out.write("\t         \t<option value=\"40\">40</option>\r\n");
              out.write("\t         \t<option value=\"45\">45</option> \r\n");
              out.write("         \t\t<option value=\"50\">50</option> \r\n");
              out.write("      \t\t</select>\r\n");
              out.write("\t\t</td>\r\n");
              out.write("\t</tr>\r\n");
              out.write("</table>\r\n");
              out.write("\t\r\n");
              out.write("<!-- FIN TABLA SELECT ITEM POR PAGINACION-->\r\n");
              out.write("\r\n");
              out.write("<!-- TOTAL REGISTROS.INICIO -->\r\n");
              out.write("<table class=\"StyleTabla_75\">\r\n");
              out.write("\t<tr>\r\n");
              out.write("\t\t<td class=\"StyleTextoTabla\">Total Registros :&nbsp;");
              //  bean:write
              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f12 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
              _jspx_th_bean_005fwrite_005f12.setPageContext(_jspx_page_context);
              _jspx_th_bean_005fwrite_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f0);
              _jspx_th_bean_005fwrite_005f12.setName(vFormulario);
              _jspx_th_bean_005fwrite_005f12.setProperty("totalRegistros");
              int _jspx_eval_bean_005fwrite_005f12 = _jspx_th_bean_005fwrite_005f12.doStartTag();
              if (_jspx_th_bean_005fwrite_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f12);
                return;
              }
              _005fjspx_005ftagPool_005fbean_005fwrite_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f12);
              out.write("</td>\r\n");
              out.write("\t</tr>\r\n");
              out.write("</table>\r\n");
              out.write("<!-- TOTAL REGISTROS.FIN -->\r\n");
              out.write("\r\n");
              out.write("<br>\t\r\n");
              out.write("\t\r\n");
              out.write("\t");
              out.write("\r\n");
              out.write("<!-- END -- RC & PP -- 26/10/2004 -->\t\r\n");
              out.write("\t<table border=\"0\"class=\"StyleTabla_BT_TV\" align=\"center\" > \r\n");
              out.write("\t\t<tr>\r\n");

			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);

              out.write("\r\n");
              out.write("\t\t\t<td align=\"center\"><font class=\"StyleTextoTabla\">");
              //  bean:message
              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f5 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
              _jspx_th_bean_005fmessage_005f5.setPageContext(_jspx_page_context);
              _jspx_th_bean_005fmessage_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f0);
              _jspx_th_bean_005fmessage_005f5.setKey(temp);
              int _jspx_eval_bean_005fmessage_005f5 = _jspx_th_bean_005fmessage_005f5.doStartTag();
              if (_jspx_th_bean_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f5);
                return;
              }
              _005fjspx_005ftagPool_005fbean_005fmessage_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f5);
              out.write("</font></td>\t \r\n");
              out.write("\t\t");
 } 
              out.write("\r\n");
              out.write("\t\t</tr>\r\n");
              out.write("\t\t");
              //  logic:iterate
              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f0 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
              _jspx_th_logic_005fiterate_005f0.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fiterate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f0);
              _jspx_th_logic_005fiterate_005f0.setId("campos");
              _jspx_th_logic_005fiterate_005f0.setName(vFormulario);
              _jspx_th_logic_005fiterate_005f0.setProperty("vctDetalles");
              int _jspx_eval_logic_005fiterate_005f0 = _jspx_th_logic_005fiterate_005f0.doStartTag();
              if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.Object campos = null;
                if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_logic_005fiterate_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_logic_005fiterate_005f0.doInitBody();
                }
                campos = (java.lang.Object) _jspx_page_context.findAttribute("campos");
                do {
                  out.write("\r\n");
                  out.write("\t\t<tr> \r\n");
                  out.write("\t\t\t");
                  //  logic:iterate
                  org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f1 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
                  _jspx_th_logic_005fiterate_005f1.setPageContext(_jspx_page_context);
                  _jspx_th_logic_005fiterate_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f0);
                  _jspx_th_logic_005fiterate_005f1.setId("elemento");
                  _jspx_th_logic_005fiterate_005f1.setName("campos");
                  _jspx_th_logic_005fiterate_005f1.setIndexId("index");
                  int _jspx_eval_logic_005fiterate_005f1 = _jspx_th_logic_005fiterate_005f1.doStartTag();
                  if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object elemento = null;
                    java.lang.Integer index = null;
                    if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_logic_005fiterate_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_logic_005fiterate_005f1.doInitBody();
                    }
                    elemento = (java.lang.Object) _jspx_page_context.findAttribute("elemento");
                    index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t<td class=\"VectResultDat1\"><font class=\"VectResultDat1\">");
                      if (_jspx_meth_bean_005fwrite_005f13(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("</font></td>\r\n");
                      out.write("\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_005fiterate_005f1.doAfterBody();
                      elemento = (java.lang.Object) _jspx_page_context.findAttribute("elemento");
                      index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.popBody();
                    }
                  }
                  if (_jspx_th_logic_005fiterate_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f1);
                    return;
                  }
                  _005fjspx_005ftagPool_005flogic_005fiterate_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f1);
                  out.write("\r\n");
                  out.write("\t\t</tr>\r\n");
                  out.write("\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fiterate_005f0.doAfterBody();
                  campos = (java.lang.Object) _jspx_page_context.findAttribute("campos");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.popBody();
                }
              }
              if (_jspx_th_logic_005fiterate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
              out.write("\r\n");
              out.write("  \t</table>\r\n");
              out.write("\t");
              int evalDoAfterBody = _jspx_th_logic_005fequal_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fequal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f0);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f0);
          out.write("\r\n");
          out.write("\t<br>\r\n");
          out.write("  <table border=\"0\" class=\"StyleTabla_75\" align=\"center\">\r\n");
          out.write("  <tr>\r\n");
          out.write("\t <td align=\"center\">\r\n");
          out.write("\r\n");
          out.write("     \t<input type=\"button\" name=\"btnCerrar\" value=\"Cancelar\"  onclick=\"do_cancelar();\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \r\n");
          out.write("     \t\t");
          //  logic:equal
          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f1 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
          _jspx_th_logic_005fequal_005f1.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fequal_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_logic_005fequal_005f1.setName(vFormulario);
          _jspx_th_logic_005fequal_005f1.setProperty("hayDatos");
          _jspx_th_logic_005fequal_005f1.setValue("si");
          int _jspx_eval_logic_005fequal_005f1 = _jspx_th_logic_005fequal_005f1.doStartTag();
          if (_jspx_eval_logic_005fequal_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t<input type=\"button\" name=\"btnExportar\" value=\"Exportar\"  onclick=\"do_btnExcel();\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \r\n");
              out.write("\t");
              int evalDoAfterBody = _jspx_th_logic_005fequal_005f1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fequal_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f1);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f1);
          out.write("\t\t\r\n");
          out.write("\t");
          //  logic:notEqual
          org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_005fnotEqual_005f0 = (org.apache.struts.taglib.logic.NotEqualTag) _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEqualTag.class);
          _jspx_th_logic_005fnotEqual_005f0.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fnotEqual_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_logic_005fnotEqual_005f0.setName(vFormulario);
          _jspx_th_logic_005fnotEqual_005f0.setProperty("hayDatos");
          _jspx_th_logic_005fnotEqual_005f0.setValue("si");
          int _jspx_eval_logic_005fnotEqual_005f0 = _jspx_th_logic_005fnotEqual_005f0.doStartTag();
          if (_jspx_eval_logic_005fnotEqual_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t<input type=\"button\" name=\"btnExportar\" value=\"Exportar\"  disabled STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \r\n");
              out.write("\t");
              int evalDoAfterBody = _jspx_th_logic_005fnotEqual_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fnotEqual_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f0);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f0);
          out.write("\r\n");
          out.write("\r\n");
          out.write("   </td>\r\n");
          out.write("   </tr>\r\n");
          out.write("   </table>\r\n");
          out.write("\r\n");
          out.write("<!-- INI -- RC & PP -- 26/10/2004 -->   \t  \r\n");
          out.write("\t");
          //  logic:equal
          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f2 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
          _jspx_th_logic_005fequal_005f2.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fequal_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
          _jspx_th_logic_005fequal_005f2.setName(vFormulario);
          _jspx_th_logic_005fequal_005f2.setProperty("hayDatos");
          _jspx_th_logic_005fequal_005f2.setValue("si");
          int _jspx_eval_logic_005fequal_005f2 = _jspx_th_logic_005fequal_005f2.doStartTag();
          if (_jspx_eval_logic_005fequal_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t");
              out.write("<!-- ******************************************************* -->\r\n");
              out.write("<!--                  BOTONES.INICIO                         -->\r\n");
              out.write("<!-- ******************************************************* -->\r\n");
              out.write("<table width=\"75%\" border=\"0\" >\r\n");
              out.write("\t<tr>\r\n");
              out.write("\t\t<td align=\"left\">\r\n");
              out.write("\t\t\t<!-- BOTON ANTERIOR.INICIO -->\r\n");
              out.write("\t\t\t");
              //  logic:equal
              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f3 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
              _jspx_th_logic_005fequal_005f3.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fequal_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
              _jspx_th_logic_005fequal_005f3.setName(vFormulario);
              _jspx_th_logic_005fequal_005f3.setProperty("indice");
              _jspx_th_logic_005fequal_005f3.setValue("0");
              int _jspx_eval_logic_005fequal_005f3 = _jspx_th_logic_005fequal_005f3.doStartTag();
              if (_jspx_eval_logic_005fequal_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t  \t\t\t<input type=\"button\" name=\"btnAnterior\"  value=\"&nbsp;&nbsp;Anterior&nbsp;&nbsp;\" disabled STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
                  out.write("\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fequal_005f3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_005fequal_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f3);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f3);
              out.write("\r\n");
              out.write("\t\t\t");
              //  logic:notEqual
              org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_005fnotEqual_005f1 = (org.apache.struts.taglib.logic.NotEqualTag) _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEqualTag.class);
              _jspx_th_logic_005fnotEqual_005f1.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fnotEqual_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
              _jspx_th_logic_005fnotEqual_005f1.setName(vFormulario);
              _jspx_th_logic_005fnotEqual_005f1.setProperty("indice");
              _jspx_th_logic_005fnotEqual_005f1.setValue("0");
              int _jspx_eval_logic_005fnotEqual_005f1 = _jspx_th_logic_005fnotEqual_005f1.doStartTag();
              if (_jspx_eval_logic_005fnotEqual_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t  \t\t\t<input type=\"button\" name=\"btnAnterior\"  value=\"&nbsp;&nbsp;Anterior&nbsp;&nbsp;\" onclick=\"btnAnterior_onclick(");
                  out.print(vForm);
                  out.write(',');
                  out.write('\'');
                  out.print(vSend);
                  out.write("');\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
                  out.write("\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fnotEqual_005f1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_005fnotEqual_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f1);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f1);
              out.write("\t\r\n");
              out.write("\t\t\t<!-- BOTON ANTERIOR.FIN -->\r\n");
              out.write("\t\t</td>\r\n");
              out.write("\t\t<td>\r\n");
              out.write("\t\t\t");
int idxBtn = 0;
              out.write("\r\n");
              out.write("\t\t\t<!-- PAGINAS.INICIO [1] [2] [3] ... -->\r\n");
              out.write("\t\t\t<table width=\"100%\" border=\"0\" align=\"center\">\r\n");
              out.write("\t \t\t\t<tr>\r\n");
              out.write("\t\t\t\t\t<td class=\"StyleText\">  \r\n");
              out.write("\t\t\t\t\t\t");
              //  logic:iterate
              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f2 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
              _jspx_th_logic_005fiterate_005f2.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fiterate_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
              _jspx_th_logic_005fiterate_005f2.setId("campos");
              _jspx_th_logic_005fiterate_005f2.setName(vFormulario);
              _jspx_th_logic_005fiterate_005f2.setProperty("listaPagina");
              int _jspx_eval_logic_005fiterate_005f2 = _jspx_th_logic_005fiterate_005f2.doStartTag();
              if (_jspx_eval_logic_005fiterate_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.Object campos = null;
                if (_jspx_eval_logic_005fiterate_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_logic_005fiterate_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_logic_005fiterate_005f2.doInitBody();
                }
                campos = (java.lang.Object) _jspx_page_context.findAttribute("campos");
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t&nbsp;<input type=\"button\" name=\"btnPage_");
                  out.print(idxBtn++);
                  out.write("\" value=\"");
                  if (_jspx_meth_bean_005fwrite_005f14(_jspx_th_logic_005fiterate_005f2, _jspx_page_context))
                    return;
                  out.write("\" onclick=\"a_onclick(");
                  if (_jspx_meth_bean_005fwrite_005f15(_jspx_th_logic_005fiterate_005f2, _jspx_page_context))
                    return;
                  out.write(',');
                  out.print(vForm);
                  out.write(',');
                  out.write('\'');
                  out.print(vSend);
                  out.write("');\" STYLE=\"border:1px solid white; width:20px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
                  out.write("\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fiterate_005f2.doAfterBody();
                  campos = (java.lang.Object) _jspx_page_context.findAttribute("campos");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_logic_005fiterate_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.popBody();
                }
              }
              if (_jspx_th_logic_005fiterate_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f2);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fiterate_005fproperty_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f2);
              out.write("\r\n");
              out.write("\t\t\t\t\t</td>\r\n");
              out.write("\t\t\t\t</tr>\r\n");
              out.write("\t\t\t</table>\r\n");
              out.write("\t\t\t<input type=\"hidden\" name=\"hiddenTotalPaginas\" value=\"");
              out.print(idxBtn);
              out.write("\">\r\n");
              out.write("\t\t\t<!-- PAGINAS.FIN [1] [2] [3] ... -->\r\n");
              out.write("\t\t</td>\r\n");
              out.write("\t\t<td align=\"right\">\r\n");
              out.write("\t\t\t<!-- BOTON SIGUIENTE.INICIO -->\r\n");
              out.write("\t\t\t");
              //  logic:equal
              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f4 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
              _jspx_th_logic_005fequal_005f4.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fequal_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
              _jspx_th_logic_005fequal_005f4.setName(vFormulario);
              _jspx_th_logic_005fequal_005f4.setProperty("hayProximoBloque");
              _jspx_th_logic_005fequal_005f4.setValue("si");
              int _jspx_eval_logic_005fequal_005f4 = _jspx_th_logic_005fequal_005f4.doStartTag();
              if (_jspx_eval_logic_005fequal_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t&nbsp;<input type=\"button\" name=\"btnSiguiente\" value=\"Siguiente\" onclick=\"btnSiguiente_onclick(");
                  out.print(vForm);
                  out.write(',');
                  out.write('\'');
                  out.print(vSend);
                  out.write("');\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
                  out.write("\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fequal_005f4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_005fequal_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f4);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f4);
              out.write("\r\n");
              out.write("\t\t\t");
              //  logic:notEqual
              org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_005fnotEqual_005f2 = (org.apache.struts.taglib.logic.NotEqualTag) _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEqualTag.class);
              _jspx_th_logic_005fnotEqual_005f2.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fnotEqual_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
              _jspx_th_logic_005fnotEqual_005f2.setName(vFormulario);
              _jspx_th_logic_005fnotEqual_005f2.setProperty("hayProximoBloque");
              _jspx_th_logic_005fnotEqual_005f2.setValue("si");
              int _jspx_eval_logic_005fnotEqual_005f2 = _jspx_th_logic_005fnotEqual_005f2.doStartTag();
              if (_jspx_eval_logic_005fnotEqual_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t&nbsp;<input type=\"button\" name=\"btnSiguiente\" value=\"Siguiente\" disabled STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">\r\n");
                  out.write("\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_005fnotEqual_005f2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_005fnotEqual_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f2);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fnotEqual_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f2);
              out.write("\r\n");
              out.write("\t\t\t<!-- BOTON SIGUIENTE.FIN -->\r\n");
              out.write("\t\t</td>\r\n");
              out.write("\t</tr>\r\n");
              out.write("</table>\r\n");
              out.write("<!-- ******************************************************* -->\r\n");
              out.write("<!--                  BOTONES.FIN                            -->\r\n");
              out.write("<!-- ******************************************************* -->\r\n");
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_logic_005fequal_005f2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fequal_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f2);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fequal_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f2);
          out.write("\r\n");
          out.write("<!-- END -- RC & PP -- 26/10/2004 -->\t\r\n");
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

  private boolean _jspx_meth_html_005fhidden_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f1 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f1.setProperty("vctExpHead");
    _jspx_th_html_005fhidden_005f1.setValue("");
    int _jspx_eval_html_005fhidden_005f1 = _jspx_th_html_005fhidden_005f1.doStartTag();
    if (_jspx_th_html_005fhidden_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fvalue_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f2 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f2.setProperty("exportFile");
    int _jspx_eval_html_005fhidden_005f2 = _jspx_th_html_005fhidden_005f2.doStartTag();
    if (_jspx_th_html_005fhidden_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f3 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f3.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f3.setProperty("totalRegistros");
    int _jspx_eval_html_005fhidden_005f3 = _jspx_th_html_005fhidden_005f3.doStartTag();
    if (_jspx_th_html_005fhidden_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f3);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f4 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f4.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f4.setProperty("flagDatosBD");
    int _jspx_eval_html_005fhidden_005f4 = _jspx_th_html_005fhidden_005f4.doStartTag();
    if (_jspx_th_html_005fhidden_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f4);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f5 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f5.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    _jspx_th_html_005fhidden_005f5.setProperty("totalPaginas");
    int _jspx_eval_html_005fhidden_005f5 = _jspx_th_html_005fhidden_005f5.doStartTag();
    if (_jspx_th_html_005fhidden_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f5);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f13 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f13.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    _jspx_th_bean_005fwrite_005f13.setName("elemento");
    int _jspx_eval_bean_005fwrite_005f13 = _jspx_th_bean_005fwrite_005f13.doStartTag();
    if (_jspx_th_bean_005fwrite_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f13);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f14 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f14.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f2);
    _jspx_th_bean_005fwrite_005f14.setName("campos");
    int _jspx_eval_bean_005fwrite_005f14 = _jspx_th_bean_005fwrite_005f14.doStartTag();
    if (_jspx_th_bean_005fwrite_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f14);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f15 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f15.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f2);
    _jspx_th_bean_005fwrite_005f15.setName("campos");
    int _jspx_eval_bean_005fwrite_005f15 = _jspx_th_bean_005fwrite_005f15.doStartTag();
    if (_jspx_th_bean_005fwrite_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f15);
    return false;
  }
}
