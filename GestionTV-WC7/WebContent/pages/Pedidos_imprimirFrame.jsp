<html>
<head>
<title>Informe de Pedidos</title>
</head>
<%
  String PeriodoIni = request.getParameter("periodoIni");
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
     alert(document.body.innerHTML);
     document.body.insertAdjacentHTML('beforeEnd', WebBrowser); 
     alert(document.body.innerHTML);            
	
     WebBrowser1.ExecWB(6, 6);
     WebBrowser1.outerHTML = "";
  }
}
//-->

function imprime() {
  if (window.print()){
	  setTimeout('window.close()',1000);
     //return;
	parent.frames[1].focus();
    printit();
    setTimeout('window.close()',1000);
  }
}


</script>

<frameset onload="imprime();" rows="50%,50%">
   <frame name="X" src="GestionTV_impresora.jsp">
   <frame name="print" src="<%=path%>?periodoIni=<%=PeriodoIni%>&periodoFin=<%=PeriodoFin%>">
</frameset>
   <noframes></noframes>
  
</html>