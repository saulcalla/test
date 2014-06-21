<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>


<%
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
<p align="left" class="Estilo14"><%=cabecera%><DIV align="left">

<form name="form">
<input type="hidden" name="impresion" value="<%=impresion%>" />


<table width="50%" height="70%" border="0">
  
  <tr>
    <td width="155"><span class="Estilo12"> ATENDIDO POR</span></td>
    <td width="161"><span class="Estilo13"><%=usuario%></span></td>
  </tr>
  
  <tr>
    <td width="155"><span class="Estilo12"> FECHA/HORA TRANSACCION</span></td>
    <td width="161"><span class="Estilo13"><%=sdf.format(fecha)%></span></td>
  </tr>
  <tr>
    <td width="155"><span class="Estilo12"> CUENTA CAR </span></td>
    <td width="161"><span class="Estilo13"><%=cuenta_car%></span></td>
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
    <td><span class="Estilo12"> NUMERO DOCUMENTO </span></td>
    <td><span class="Estilo13"><%=documento%></span></td>
  </tr>
  <tr>
    <td><span class="Estilo12"> TARJETA GCP </span></td>
    <td><span class="Estilo13"><%=cuenta_gcp%></span></td>
  </tr>

  <% 
  		if (anulacion.equals("true")) { %>
		  
		  <tr>
		    <td height="28"><span class="Estilo12"> CAJA ORIGINAL </span></td>
		    <td><span class="Estilo13"><%=caja%></span></td>
		  </tr>  		  
		  <tr>
		    <td height="28"><span class="Estilo12"> SUCURSAL ORIGINAL </span></td>
		    <td><span class="Estilo13"><%=sucursal%></span></td>
		  </tr>  		  
		  <tr>
		    <td height="28"><span class="Estilo12"> FECHA ORIGINAL</span></td>
		    <td><span class="Estilo13"><%=primer_venc%></span></td>
		  </tr>
		  <tr>
		    <td height="28"><span class="Estilo12"> DOCTO. ORIGINAL </span></td>
		    <td><span class="Estilo13"><%=doc_original%></span></td>
		  </tr>  
		  <tr>
		    <td><span class="Estilo12"> N° CUOTAS ORIGINAL</span></td>
		    <td><span class="Estilo13"><%=cuotas%></span></td>
		  </tr> 
		  
		  <tr>
		    <td><span class="Estilo12"> TOTAL ANULADO </span></td>
		    <td><span class="Estilo13"><%=abono%></span></td>
		  </tr>   
  
  	<% 	}else { %>
		  <tr>
		    <td><span class="Estilo12"> TOTAL ABONADO </span></td>
		    <td><span class="Estilo13"><%=abono%></span></td>
		  </tr>
		  
		  <tr>
		    <td height="28"><span class="Estilo12"> FECHA PRIMER VENCIMIENTO </span></td>
		    <td><span class="Estilo13"><%=primer_venc%></span></td>
		  </tr>
		  
		  <tr>
		    <td><span class="Estilo12"> CUOTAS </span></td>
		    <td><span class="Estilo13"><%=cuotas%></span></td>
		  </tr>
		  
		  <tr>
		    <td height="28"><span class="Estilo12"> VALOR CUOTA</span></td>
		    <td><span class="Estilo13"><%=v_cuota%></span></td>
		  </tr>
		  
		  <tr>
		    <td><span class="Estilo12"> TOTAL A PAGAR </span></td>
		    <td><span class="Estilo13"><%=total_refina%></span></td>
		  </tr>
		  <tr>
		    <td colspan="2"><span class="Estilo12"> <%= tasa %></span></td>
		  </tr>
		  
	      <tr>
		    <td colspan="2"><span class="Estilo12"> <%= glosa %></span></td>
		  </tr>
		  <%} //else %>
		  
		  <tr>
		    <td>&nbsp;</td>		    
		  </tr>
		  
		  <tr>
		    <td>&nbsp;</td>		    
		  </tr>
		  
		  <tr>
		    <td>&nbsp;</td>		    
		  </tr>
		  
		  	
</table>

</form>


</DIV>

</body>
</html>
