<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("reporteStockExcelForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.reporteStockExcel"); %>
<% String titulogeneral = new String("reporteStockExcel.titGeneral"); %>
<% String titulopagina 	= new String("reporteStockExcel.titPagina"); %>
<% String vaccion 		= new String("/reporteStockExcel"); %>
<% String accioninicio 	= new String("InicioReporteStockExcel"); %>
<% String btncancelar 	= new String("reporteStockExcel.form1.boton.cancelar"); %>
<% String vcolumna 		= new String("reporteStockExcel.form1.campo"); %>

<% int numcol = 8; %>

<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	
function do_btnExcel()
{
	var obj = <%=vFormulario%>;
	obj.vctExpHead.value = "[[";
	 <%for(int i=1;i<=numcol-1;i++){ 
	 	String tempo= new String(vcolumna+i);%>	
		obj.vctExpHead.value = obj.vctExpHead.value+ "<bean:message key="<%=tempo%>"/>" +", ";
	<%}
	String tempo= new String(vcolumna+numcol);%>
	obj.vctExpHead.value = obj.vctExpHead.value+"<bean:message key="<%=tempo%>"/>";
	obj.vctExpHead.value = obj.vctExpHead.value+"]]";			
	obj.accion.value = "excel";
	obj.submit(); 
}

	
	function do_buscar() {
		var obj = <%=vFormulario%>;
		
		obj.accion.value 			 = "buscar";
		obj.submit();	  	
	}

	
	

	function body_onload_GestionTV() {
		
		window.history.forward(1);
		obj = <%=vFormulario%>;
		
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
				
		if (temp == "si") {
						
			if(obj.mensaje.value!="")
			{

				if(obj.mensaje.value == "Error al Exportar")
				{
					alert(obj.mensaje.value);
				}
				else
				{			
					var wleft     = "left=1100";
    				var wname     = "Excel";
	   		    	var wwidth    = "width=1";
	    			var wheight   = "height=1";
					window.open(obj.exportFile.value,wname,wleft+","+wwidth+","+wheight);				
				}
				obj.mensaje.value = "";
			}
		}
	

		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "no") {

			alert("No hay Datos");
			obj.flagDatosBD.value = "si";
		}		
	}

   

</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<!-- <link rel="stylesheet" type="text/css" href="styles/estylemante.css"> -->
</head>
	<body class="Stylebody" onload="javascript:body_onload_GestionTV();">
	<div align="center">
  	<font class="StyleHead_left"><bean:message key="<%=titulopagina%>"/></font>
  	<br>
<html:form action="<%=vaccion%>">
<!-- INI -- RC & PP -- 26/10/2004 -->

<html:hidden property="accion" value="buscar"/>
  	<html:hidden property="vctExpHead" value=""/>
	<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
	<html:hidden property="exportFile" /> 
<!-- INI -- RC & PP -- 26/10/2004 -->
	<html:hidden property="flagDatosBD"/>

 <br>
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td align="center">
    	<input type="button" name="btnExportar" value="Exportar"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
	
   </td>
   </tr>
   </table>


<!-- END -- RC & PP -- 26/10/2004 -->	
</html:form>
</body>
