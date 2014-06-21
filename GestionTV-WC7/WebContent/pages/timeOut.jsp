<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
     <head>
          <title>Su sesión ha expirado!</title>
	<meta name="pagina"        content="timeOut.jsp">
	<meta name="modificado"    content="Rakesh.Suyal.14Abril2005">
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemenu.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemenu.css">

<SCRIPT LANGUAGE="JavaScript">
 window.onerror = null;
 var bName = navigator.appName;
 var bVer = parseInt(navigator.appVersion);
 var NS4 = (bName == "Netscape" && bVer >= 4);
 var IE4 = (bName == "Microsoft Internet Explorer" && bVer >= 4);
 var NS3 = (bName == "Netscape" && bVer < 4);
 var IE3 = (bName == "Microsoft Internet Explorer" && bVer < 4);
 var blink_speed=800;
 var i=0;
 
if (NS4 || IE4) {
	if (navigator.appName == "Netscape") {
		layerStyleRef="layer.";
		layerRef="document.layers";
		styleSwitch="";
	}else{
		layerStyleRef="layer.style.";
		layerRef="document.all";
		styleSwitch=".style";
	}
}

//BLINKING
function Blink(layerName){
	 if(NS4 || IE4) { 
		 if(i%2==0){
			 eval(layerRef+'["'+layerName+'"]'+
			 styleSwitch+'.visibility="visible"');
		 }else{
			 eval(layerRef+'["'+layerName+'"]'+
			 styleSwitch+'.visibility="hidden"');
		 }
	 } 

	 if(i<1){
		 i++;
	 }else{
		 i--
	 }
	setTimeout("Blink('"+layerName+"')",blink_speed);
}
//  End -->
</script>
</head>
<body class="Stylebody">
<body bgcolor="#FFFFDE">
<center>
	<br><br>
	<div id="prem_hint" style="position:relative; left:0; visibility:hidden" class="prem_hint">
		<font color="#FF0000" size="4"><b><bean:message key="timeOutBlink"/></b></font>
	</div>
	<p><font color="black" size="4"><bean:message key="timeOut"/></p></font>
	<script language="javascript">Blink('prem_hint');</script>
	<img src="images/logo_ripley_rojo.gif" border="0" alt="Ventas On Line">
</center>
</body>
</html>