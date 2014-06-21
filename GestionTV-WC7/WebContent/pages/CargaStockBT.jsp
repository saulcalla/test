<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe="true"%>
<% String vFormulario 	= new String("cargaStockBTForm"); %>
<% String vForm 		= new String("document.reporteregaloForm"); %>
<% String titulogeneral = new String("stockBT.titGeneral"); %>
<% String titulopagina 	= new String("stockBT.titPagina"); %>
<% String vaccion 		= new String("/cargastockbt"); %>


<!-- END -- RC & PP -- 26/10/2004 -->

<head>
	<title><bean:message key="<%=titulogeneral%>" />
	</title>
	<link rel="stylesheet" type="text/css"
		href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<body class="Stylebody">
	<div align="center">
		<font class="StyleHead_left"><bean:message
				key="<%=titulopagina%>" />
		</font>
		<br>
		<html:form action="<%=vaccion%>">

			<br>
			<br>
			<logic:equal name="<%=vFormulario%>" property="mensaje" value="">
				<bean:message key="cargaOkBT" />
				<br><br>
				<bean:message key="tot_registros" />
				<bean:write name="<%=vFormulario%>" property="tot_registros" />
			</logic:equal>
			
			<logic:notEqual name="<%=vFormulario%>" property="mensaje" value="">
				<bean:message key="errorCargaBT" />
				<br><br>
				<bean:write name="<%=vFormulario%>" property="mensaje" />
			</logic:notEqual>

			<!-- END -- RC & PP -- 26/10/2004 -->
		</html:form>
</body>



