<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page errorPage="error.jsp"%>
<html>
<head>
<title>Imprime Informe</title>
<meta name="page" content="OtrosOrigenes_Imp.jsp">
<meta name="ModificadoPor" 	content="RCid">
<meta name="modificado" content="10 Enero 2006">
</head>
<script>
<!--
function printit()
{
  if (document.all) 
  {
     var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0';
     WebBrowser = WebBrowser + ' CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
     document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
     WebBrowser1.ExecWB(6, 8);
     WebBrowser1.outerHTML = "";
  }
}
function imprime() 
{
  if (window.print)
  {
     parent.frames[1].focus();
     printit();
     setTimeout('window.close();',10000);
  };
}
//-->
</script>
<frameset onload="imprime();" rows="100%,*%">   	  
   <frame name="X" src="GestionTV_impresora.jsp">
   <frame name="1" src="OtrosOrigenes_Informe.jsp" noresize>
   <noframes></noframes>
</html>