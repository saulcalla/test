<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<title><bean:message key="gestiontv.titulo"/></title>
   <script language="JavaScript" src="pages/scripts/funciones.js"></script>
</head>
<body class="Stylebody">
<body bgcolor="#FFFFDE">
<div align="center" class="subtitulo"><strong><font color="#000000" size="5"><bean:message key="gestiontv.titulo"/></font></strong></div>
	<table border="1" align="center" bordercolor="#FFFFCC">
		<tr>
			<td><div align="center"><img src="pages/images/logo_ripley_negro.gif" width="180" height="62" border="0" alt="Gestion TV"></div></td>
		</tr>
		<tr>
			<br>
			<font color="#000066" size="2" align="center">
				<div align="center"><bean:message key="gestiontv.version.aplicacion"/></div>
			</font>	  
		</tr>
	 	<tr>
			<td><div align="center"><img src="pages/images/logo_ripley_rojo.gif" border="0" alt="Gestion TV"></div></td>
		</tr>  
	</table>
<p align="center">
	<strong><bean:message key="gestiontv.glosa1"/><br></strong>
	<strong><bean:message key="gestiontv.glosa2"/><br></strong>
	<strong><bean:message key="gestiontv.glosa3"/><br></strong>
	<strong><bean:message key="gestiontv.glosa4"/><br></strong>
</p>
</body>
</html>



