<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>


<%
	// obtengo datos de voucher
	String sucursal = request.getParameter("sucursal");
	String caja = request.getParameter("caja");
	String activacion = request.getParameter("activacion");
	String anulacion = request.getParameter("anulacion");
	String total = request.getParameter("total");
	String impresion = request.getParameter("impresion");
	String usuario =request.getParameter("usuario");
	String fec_inicio = request.getParameter("fec_inicio");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");			
	Date fecha = new Date();

	request.getSession().setAttribute("Conectado","OK");
 %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">
<!--
.Estilo12 {font-family: "Courier New", Courier, mono; font-size: 12px; }
.Estilo13 {font-size: 12px}
.Estilo14 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
}
-->
</style>
<script language="javascript">
	function do_impresion (id_voucher){

		var obj = form.impresion;
		if (obj.value == "ok") {

	//		var ventimp = window.open(url_voucher, 'popimpr');
	//		ventimp.document.write();
	//		ventimp.document.close();
			window.print();
			window.close();		
		}
	}
	
	
	function do_imprimir() {
		window.print();
	}
	
	
</script>

</head>

<body onload="do_impresion()">
<p align="left" class="Estilo14">INFORME CIERRE ACTIVACION-ANULACION GCP <DIV align="left">
<font face="Garamond" size="2"><%=sdf.format(fecha)%></font>
</p>
<form name="form">
<input type="hidden" name="impresion" value="<%=impresion%>" />


<table width="70%" height="70%" border="0">
  
  <tr>
    <td width="155"><span class="Estilo12"> USUARIO </span></td>
    <td width="161"><span class="Estilo13"><%=usuario%></span></td>
  </tr>
  
  <tr>
    <td width="155"><span class="Estilo12"> FECHA CIERRE</span></td>
    <td width="161"><span class="Estilo13"><%=fec_inicio%></span></td>
  </tr>
    
  <tr>
    <td><span class="Estilo12"> NUMERO SUCURSAL </span></td>
    <td><span class="Estilo13"><%=sucursal%></span></td>
  </tr>
  
  <tr>
    <td><span class="Estilo12"> NUMERO CAJA </span></td>
    <td><span class="Estilo13"><%=caja%></span></td>
  </tr>    
  <tr>
    <td><span class="Estilo12"> TOTAL ACTIVACION GCP </span></td>
    <td><span class="Estilo13"><%=activacion%></span></td>
  </tr>
  
  <tr>
    <td height="28"><span class="Estilo12"> TOTAL ANULACIÓN GCP </span></td>
    <td><span class="Estilo13"><%=anulacion%></span></td>
  </tr>
  
  <tr>
    <td><span class="Estilo12"> TOTAL VENTA </span></td>
    <td><span class="Estilo13"><%=total%></span></td>
  </tr>
  	  
  <tr>
    <td>&nbsp;</td>		    
  </tr>
  
  <tr>
    <td>&nbsp;</td>		    
  </tr>
  
  <tr>
    <td>&nbsp;</td>		    
  </tr>
  		  		  
  <tr>
  <td align="center">
   <input type="button" name="btnImprimir" value="IMPRIMIR"  onclick="do_imprimir();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
  </td>    
  </tr>		  	
</table>
</form>

</DIV>

</body>
</html>
