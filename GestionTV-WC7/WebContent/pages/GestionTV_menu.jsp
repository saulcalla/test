<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="objAction"  class="cl.ripley.GestionTV.struts.action.MenuAction" scope="session" />
<% 
String strMenu = (String) request.getSession().getAttribute("strMenu"); 
%>
<html>
<head>
   <title><bean:message key="gestiontv.titulo"/></title>
   <meta name="pagina"        content="index.jsp">
   <meta name="modificado"    content="rcid.04Agosto2004">
   <script language="javascript" src="scripts/funciones.js"></script>
   <script language="JavaScript" src="scripts/slidemenu-v3.js" type="text/javascript"></script>
   <script language="JavaScript">
      var cadenaString="<%=strMenu%>";
   </script>
</head>
<body class="menuIzq_body" leftmargin="0" topmargin="0">
   <script language="JavaScript" src="scripts/creamenu-v3.js" type="text/javascript"></script>	
</body>
</html>	
