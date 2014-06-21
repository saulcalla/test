<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page session="true" buffer="16kb" autoFlush="true" import="java.util.*" %>
<%@ page isThreadSafe="true"%>
<%
  String PeriodoIni = request.getParameter("periodoIni");
  String PeriodoFin = request.getParameter("periodoFin");
  %>
<html>
<head>
<title>Informe Visitas</title>
  <link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
  <link rel="stylesheet" type="text/css" href="styles/estylemante.css">
<br>
	<meta name="pagina" content="Visitas_salida">
    <script language="Javascript"   src="scripts/funciones.js"></script>
<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
<STYLE TYPE="text/css">
    br.breakhere {page-break-before: always}
	input.likeText { border: 1px solid #fff; }
</STYLE>     

<script language="JavaScript" type="text/JavaScript">

function init(){
	obj = document.visitasForm;
	var sysdate = new Date();
	var fecha = sysdate.getDate();
	var mes = sysdate.getMonth();
	var ano = sysdate.getYear();
	mes++;
	if(mes<10){
		mes = "0" + mes;
	}
	if(fecha<10){
		fecha = "0" + fecha;
	}
	fecha = fecha + "/" + mes + "/" + ano;
	obj.fechaInforme.value = fecha;
}
</script>
</head>
<body class="Stylebody" onload="init();">
<html:form action="/visitas">

<div align="center">
<table border="0" class="StyleTabla_75">
    <tr class="styleHad_left"> 
      <td align="center" width="63%"><font class="StyleTextoTabla"><bean:message key="tit.general.Vis"/></font></td>
      <td width="37%"><font class="StyleTextoTabla"><bean:message key="Visitas.salida.1"/><input class="likeText" type="text" name="fechaInforme"></font></td>      
    </tr>
    <td></td>
    <tr class="styleHad_left">
      <td><font class="StyleTextoTabla"><bean:message key="Visitas.ds"/><%=PeriodoIni%></font></td>      
      <td><font class="StyleTextoTabla"><bean:message key="Visitas.hs"/><%=PeriodoFin%></font></td>
      <td></td>
    </tr>
</table>
<br>
<!-- Tabla visitas -->	

<logic:present name="visitasForm">
  <table border="0" width="100%" class="StyleTabla_75" align="center">
    <!-- Fila Encabezado -->
     <tr class="styleHad"> 
       <td align="center"><font class="StyleTextoTabla"><bean:message key="visitas.titulo.columna1"/></font></td>
       <td align="center"><font class="StyleTextoTabla"><bean:message key="visitas.titulo.columna2"/></font></td>
	   <td align="center"><font class="StyleTextoTabla"><bean:message key="visitas.titulo.columna3"/></font></td>
     </tr>
    <!-- Fila Detalle -->
    <logic:present name="visitasForm">
	   <logic:iterate id="campos" name="visitasForm" property="vctDetalles">
	     <tr>
	       <logic:iterate id="elemento" name="campos" indexId="index">
		   <td  class="VectResultDat1 align="center">
		     <font class="VectResultDat1"><bean:write name="elemento"/></font>
	 	   </td>
	       </logic:iterate>
		 </tr>
	   </logic:iterate>
    </logic:present>
 </table>
</logic:present>
</div>
</html:form>   
</body>
</html>