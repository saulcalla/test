<html>
<head>
<title>Informe de Visitas</title>
<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<%
  String PeriodoIni  = request.getParameter("periodoIni");
  String PeriodoFin = request.getParameter("periodoFin");
  String path = request.getParameter("path");
 %>
<script>
<!--
function printit()
{
  if (document.all) {
     var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0';
     WebBrowser = WebBrowser + ' CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
     document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
     WebBrowser1.ExecWB(6, 6);
     WebBrowser1.outerHTML = "";
  }
}
//-->

function imprime() {
  if (window.print){
     //return;
    parent.frames[1].focus();
    printit();
    setTimeout('window.close();',10000);
  }
}
   
</script>
<frameset onload="imprime();" rows="100%,*">
   <frame name="X" src="GestionTV_impresora.jsp">
   <frame name="print" src="<%=path%>?periodoIni=<%=PeriodoIni%>&periodoFin=<%=PeriodoFin%>">
   
</frameset>
   <noframes></noframes>
</html>