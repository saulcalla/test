<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
   <title><bean:message key="gestiontv.titulo.aplicacion"/></title>
   <meta name="pagina"        content="index.jsp">
   <meta name="modificado"    content="mmoyan.04Agosto2004">
</head>
<frameset cols="160,*" frameborder="NO" border="0" framespacing="0"> 
   <frame src="pages/GestionTV_menu.jsp"     name="leftFrame" scrolling="no" noresize>
   <frame src="pages/GestionTV_centro.jsp"  name="centro">
</frameset>
<noframes>
   <body>
   </body>
</noframes>
</html>
