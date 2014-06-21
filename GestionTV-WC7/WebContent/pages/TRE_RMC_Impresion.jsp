
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="cl.ripley.GestionTV.struts.form.TRE_RMCForm"%>


<%
	// Obtengo Objecto con parametros de formulario
	
	TRE_RMCForm formulario = (TRE_RMCForm) request.getSession().getAttribute("formulario_tre");
	
	
	String num_tre = formulario.getNumTRE();
	String num_rmc = formulario.getNum_rmc();
	String estado = formulario.getEstado();
	String rut_empresa = formulario.getRutEmpresa();
	String fec_vcto= formulario.getFechaVcto();
	String saldo_disponible = formulario.getSaldoDisponible();
	String glosa_tarjeta = formulario.getGlosaTarjeta();
	String grupo_depto = formulario.getGlosaDepartemento();
	String usuario = formulario.getUsuario();
	Object[] lista_depto = formulario.getSelectDepartamentos();
	
	Date fecha = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>IMPRESION RMC - TRE</title>
<style type="text/css">
<!--
.Estilo12 {font-family: "Courier New", Courier, mono; font-size: 12px;; font-weight: bold; }

.Estilo13 {font-size: 12px}
.Estilo14 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
}

.Estilo15 {font-family: "Courier New", Courier, mono; font-size: 25px;; font-weight: bold; }

-->
</style>
<script language="javascript">
	function do_imprimir() {
		window.print();
	}
	
	
</script>


</head>

<body onload="do_imprimir()">
<table width="650" height="272" border="1" bordercolor="#000000" cellspacing="0">
  <tr>
    <td><img src="images/logo_ripley_negro.gif" border="0" width="210" height="76"></td>
    <td  colspan="3" align="center"><span class="Estilo12">TARJETA REGALO EMPRESAS - TRE </span></td>
  </tr>
  <tr>
    <td height="50" colspan="4" align="left" valign="middle">
    <div align="center"><font color="#c0c0c0" class="Estilo15">Sujeto a Auditor&iacute;a</font> </div>
    <div align="right"><span class="Estilo12">FECHA</span> : 
    <font class="Estilo13"><%=sdf.format(fecha)%></font> </div>
    </td>
         
  </tr>
  <tr>
    <td width="245" ><span class="Estilo12">N&ordm; Tarjeta </span></td>
    <td width="119" class="Estilo13"><%=num_tre%></td>
    <td width="157"><span class="Estilo12">N&ordm; de RMC </span></td>
    <td width="147" class="Estilo13"><%=num_rmc%></td>
  </tr>
  <tr>
    <td><span class="Estilo12">Estado</span></td>
    <td class="Estilo13"><%=estado%></td>
    <td><span class="Estilo12">RUT Empresa </span></td>
    <td class="Estilo13"><%=rut_empresa%></td>
  </tr>
  <tr>
    <td><span class="Estilo12">Fecha Vcmto </span></td>
    <td class="Estilo13"><%=fec_vcto%></td>
    <td><span class="Estilo12">Saldo Disponible</span></td>
    <td class="Estilo13"><%=saldo_disponible%></td>
  </tr>
  <tr>
    <td><span class="Estilo12">Glosa Tarjeta </span></td>
    <td colspan="3" class="Estilo13"><%=glosa_tarjeta%></td>
  </tr>
  <tr>
    <td colspan="4">&nbsp;</td>
  </tr>
  <tr>
    <td><span class="Estilo12">Grupo de Departamentos</span></td>
    <td colspan="3" class="Estilo13"><%=grupo_depto%></td>
  </tr>
  <tr>
    <td><span class="Estilo12">Departamentos</span></td>
    <%
    	String departamentos="";
    	for (int i=0; i < lista_depto.length; i++) {
    		departamentos = lista_depto[i].toString();
    		if (i==0) { %>
    			<td colspan="3" class="Estilo13"><%=departamentos%></td>
    		<%} else {%>
	    		<tr>
	    		<td colspan="1"></td>
	    		<td colspan="3" class="Estilo13"><%=departamentos%></td>
	    		</tr>
    		<%}
    		departamentos="";
    	}
    	
    	System.out.println(departamentos);
    %>
    
    
  </tr>
 </table>
</body>
</html>
