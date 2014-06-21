<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page session="true" buffer="16kb" autoFlush="true" import="java.util.*" %>
<%@ page isThreadSafe="true"%>
<% String vcolumna 		= new String("pedidos.form1.campo"); %>
<% String nota 			= new String("gestiontv.nota"); %>
<% int 	  numcol 		= 13; %>
<%
  String PeriodoIni = request.getParameter("periodoIni");
  String PeriodoFin = request.getParameter("periodoFin");
  %>
<html>
  <head>
    <title>Informe Pedidos</title>
    <link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
    <br>
	<meta name="pagina" content="Pedidos_salida">
    <script language="Javascript"   src="scripts/funciones.js"></script>
<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
 <STYLE TYPE="text/css">
    br.breakhere {page-break-before: always}
	input.likeText { border: 1px solid #fff; }
 </STYLE>     

<script language="JavaScript" type="text/JavaScript">
function init(){
	obj = document.pedidosForm;
	var sysdate = new Date();
	var dia = sysdate.getDate();
	var mes = sysdate.getMonth();
	var ano = ""+sysdate.getYear();	
	ano = ano.substring(ano.length-2,ano.length);
	ano = "20"+ano;	
	mes++;
	if(mes<10){
		mes = "0" + mes;
	}
	if(dia<10){
		dia = "0" + dia;
	}
	var fecha = dia + "/" + mes + "/" + ano;
	obj.fechaInforme.value = fecha;
}
</script>
</head>
<body class="Stylebody" onload="init();">
<html:form action="/pedidos">

<div align="center">
<table border="0" class="StyleTabla_75">
    <tr class="styleHad_left"> 
      <td align="center" width="63%"><font class="StyleTextoTabla"><bean:message key="Pedidos.tit.impP"/></td>
      <td width="37%"><font class="StyleTextoTabla"><bean:message key="pedidos.salida.1"/>
      <input class="likeText" type="text" name="fechaInforme"></font></td>      
    </tr>
    <td></td>
    <tr class="styleHad_left">
      <td><font class="StyleTextoTabla"><bean:message key="Pedidos.ds"/><%=PeriodoIni%></font></td>      
      <td><font class="StyleTextoTabla"><bean:message key="Pedidos.hs"/><%=PeriodoFin%></font></td>
      <td></td>
    </tr>
</table>
<br>
<!-- Tabla pedidos -->	

<logic:present name="pedidosForm">
<table border="0" class="StyleTabla_TodasVentas" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%"><font class="StyleTextoTablaEstadoOC"><bean:message key="actualizaEstadoOC.titfechaHeader"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="actualizaEstadoOC.titpedidoHeader"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="actualizaEstadoOC.titboletasHeader"/></font></td>
		</tr>
  	</table>
  		<table border="0" class="StyleTabla_TodasVentas" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos1"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos2"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos3"/></font></td>
		</tr>	
  	</table>
  <table border="0" width="100%" class="StyleTabla_TodasVentas" align="center">
    <!-- Fila Encabezado -->
     <tr> 
<%
			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);
				if(i==1 || i==13 )
				{
%>
			<td align="center" width="80px"><font class="StyleTextoTablaEstadoOCHeader"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else
				{
%>
			<td align="center"><font class="StyleTextoTablaEstadoOCHeader"><bean:message key="<%=temp%>"/></font></td>	 
<%
				
				}
				}

%>
		</tr>
    <!-- Fila Detalle -->
    <logic:present name="pedidosForm">
	   <logic:iterate id="campos" name="pedidosForm" property="vctDetalles">
	   <tr> 
			<logic:iterate id="elemento" name="campos" indexId="index">
			<logic:equal name="index" value="0">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="1">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="2">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="3">
				<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="4">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="5">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="6">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="7">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="8">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="9">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="10">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="11">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="12">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="13">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			</logic:iterate>
		</tr>
		</logic:iterate>
    </logic:present>
 </table>
 <div align="left">
  		<font class="StyleNota"><bean:message key="<%=nota%>"/></font>
  	</div>
</logic:present>
</div>
</html:form>   
</body>
</html>