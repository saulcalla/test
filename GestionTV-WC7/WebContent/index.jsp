<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<% String rutUsuario = request.getParameter("rut");
   String sistemaUsuario = request.getParameter("sistema");
   String claveUsuario = request.getParameter("clv");
   String nombreUsuario = request.getParameter("usuario");
 %>
<html>
<head>
  <title><bean:message key="gestiontv.titulo.aplicacion" /></title>
  <meta name="pagina"        content="index.jsp">
  <meta name="modificado"    content="mmoyan.04Agosto2004">
  <script language="javascript">
     function body_onload() {
	   var obj = document.menuForm;
	   obj.submit();	  	
     }
  </script>
</head>
<body class="Stylebody" onload="body_onload();">
   <html:form action="/menu">
	  <!-- PROPERTY DEL FORMULARIO -->
	  <html:hidden property="accion" value="menuIndex"/>	
      <html:hidden property="rutUsuario" value="<%=rutUsuario%>"/>	    
	  <html:hidden property="sistema" value="<%=sistemaUsuario%>"/>	
	  <html:hidden property="clave" value="<%=claveUsuario%>"/>		
	  <html:hidden property="nombreUsuario" value="<%=nombreUsuario%>"/>		
   </html:form>
</body>
</html>