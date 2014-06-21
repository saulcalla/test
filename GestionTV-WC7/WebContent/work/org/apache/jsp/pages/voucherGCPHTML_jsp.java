package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class voucherGCPHTML_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  public Object getDependants() {
    return _jspx_dependants;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	// obtengo datos de voucher
	
	String cuenta_car = request.getParameter("cuenta_car");
	String cuenta_gcp = request.getParameter("cuenta_gcp");
	String sucursal = request.getParameter("sucursal");
	String caja = request.getParameter("caja");
	String abono = request.getParameter("abono");
	String total_refina = request.getParameter("total_refina");
	String primer_venc = request.getParameter("primer_venc");
	String cuotas = request.getParameter("cuotas");
	String tasa = request.getParameter("tasa");
	String impresion = request.getParameter("impresion");
	tasa = tasa.replaceAll("PORC","%");
	tasa = tasa.replaceAll("-",",");
	String glosa = request.getParameter("glosa");
	String usuario =request.getParameter("usuario");
	String documento =request.getParameter("documento");
	String cabecera = request.getParameter("cabecera");
	String anulacion = request.getParameter("anulacion");
	String doc_original = request.getParameter("doc_original");
	String v_cuota = request.getParameter("v_cuota");
	
	request.getSession().setAttribute("Conectado","OK");
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");			
	Date fecha = new Date();


	if (impresion == null)
		impresion="";
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".Estilo12 {font-family: \"Courier New\", Courier, mono; font-size: 12px; }\r\n");
      out.write(".Estilo13 {font-size: 12px}\r\n");
      out.write(".Estilo14 {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction do_impresion (id_voucher){\r\n");
      out.write("\r\n");
      out.write("\t\tvar obj = form.impresion;\r\n");
      out.write("\t\tif (obj.value == \"ok\") {\r\n");
      out.write("\r\n");
      out.write("\t//\t\tvar ventimp = window.open(url_voucher, 'popimpr');\r\n");
      out.write("\t//\t\tventimp.document.write();\r\n");
      out.write("\t//\t\tventimp.document.close();\r\n");
      out.write("\t\t\twindow.print();\r\n");
      out.write("\t\t\twindow.close();\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction do_imprimir() {\r\n");
      out.write("\t\twindow.print();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"do_impresion()\">\r\n");
      out.write("<p align=\"left\" class=\"Estilo14\">");
      out.print(cabecera);
      out.write("<DIV align=\"left\">\r\n");
      out.write("\r\n");
      out.write("<form name=\"form\">\r\n");
      out.write("<input type=\"hidden\" name=\"impresion\" value=\"");
      out.print(impresion);
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table width=\"50%\" height=\"70%\" border=\"0\">\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"155\"><span class=\"Estilo12\"> ATENDIDO POR</span></td>\r\n");
      out.write("    <td width=\"161\"><span class=\"Estilo13\">");
      out.print(usuario);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"155\"><span class=\"Estilo12\"> FECHA/HORA TRANSACCION</span></td>\r\n");
      out.write("    <td width=\"161\"><span class=\"Estilo13\">");
      out.print(sdf.format(fecha));
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"155\"><span class=\"Estilo12\"> CUENTA CAR </span></td>\r\n");
      out.write("    <td width=\"161\"><span class=\"Estilo13\">");
      out.print(cuenta_car);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><span class=\"Estilo12\"> NUMERO SUCURSAL EEEEE </span></td>\r\n");
      out.write("    <td><span class=\"Estilo13\">");
      out.print(sucursal);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><span class=\"Estilo12\"> NUMERO CAJA </span></td>\r\n");
      out.write("    <td><span class=\"Estilo13\">");
      out.print(caja);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><span class=\"Estilo12\"> NUMERO DOCUMENTO </span></td>\r\n");
      out.write("    <td><span class=\"Estilo13\">");
      out.print(documento);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><span class=\"Estilo12\"> TARJETA GCP </span></td>\r\n");
      out.write("    <td><span class=\"Estilo13\">");
      out.print(cuenta_gcp);
      out.write("</span></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");
      out.write("  ");
 
  		if (anulacion.equals("true")) { 
      out.write("\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> CAJA ORIGINAL </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(caja);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>  \t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> SUCURSAL ORIGINAL </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(sucursal);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>  \t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> FECHA ORIGINAL</span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(primer_venc);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> DOCTO. ORIGINAL </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(doc_original);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td><span class=\"Estilo12\"> N° CUOTAS ORIGINAL</span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(cuotas);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr> \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td><span class=\"Estilo12\"> TOTAL ANULADO </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(abono);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>   \r\n");
      out.write("  \r\n");
      out.write("  \t");
 	}else { 
      out.write("\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td><span class=\"Estilo12\"> TOTAL ABONADO </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(abono);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> FECHA PRIMER VENCIMIENTO </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(primer_venc);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td><span class=\"Estilo12\"> CUOTAS </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(cuotas);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td height=\"28\"><span class=\"Estilo12\"> VALOR CUOTA</span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(v_cuota);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td><span class=\"Estilo12\"> TOTAL A PAGAR </span></td>\r\n");
      out.write("\t\t    <td><span class=\"Estilo13\">");
      out.print(total_refina);
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td colspan=\"2\"><span class=\"Estilo12\"> ");
      out.print( tasa );
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t\t    <td colspan=\"2\"><span class=\"Estilo12\"> ");
      out.print( glosa );
      out.write("</span></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  ");
} //else 
      out.write("\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>&nbsp;</td>\t\t    \r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>&nbsp;</td>\t\t    \r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>&nbsp;</td>\t\t    \r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  ");
 if (impresion.equals("ok")) { 
      out.write("\t\t  \t\t  \r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t  <td align=\"center\">\r\n");
      out.write("\t\t   <input type=\"button\" name=\"btnImprimir\" value=\"IMPRIMIR\"  onclick=\"do_imprimir();\" STYLE=\"border:1px solid white; width:80px\" onMouseover=\"this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'\" onMouseout=\"style.background='#CCCCCC'; style.border='1px solid white'\">  \r\n");
      out.write("\t\t  </td>\t\t    \r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  ");
 } 
      out.write("\r\n");
      out.write("\t\t  \t\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</DIV>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
}
