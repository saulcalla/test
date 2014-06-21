<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<% String vcolumna = new String("estadodesp.col"); %>
<% int numcol = 2; %>
<script language="javascript" >
function do_cancelar() {
		var obj = document.productosinstockForm;
		obj.accion.value="cancelar";
		obj.submit();		
	}
function do_btnExcel()
{
	var obj = document.productosinstockForm;
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

function body_onload_GestionTV()
{
	obj = document.productosinstockForm;	
	var temp="<bean:write name="productosinstockForm" property="hayDatos" />"
	
	if(temp=="si"){

		if(obj.mensaje.value!=""){
			if(obj.mensaje.value == "Error al Exportar"){
					alert(obj.mensaje.value);
			}
			else{			
				var wleft     = "left=1100";
    			var wname     = "Excel";
	   		    var wwidth    = "width=1";
	    		var wheight   = "height=1";
				window.open(obj.exportFile.value,wname,wleft+","+wwidth+","+wheight);				
			}
			obj.mensaje.value = "";
		}
	}
}
</script>
<html>
<head>
	<title><bean:message key="productoSinStock.titGeneral"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<body class="Stylebody" onload="body_onload_GestionTV();">
  <div align="center">
  <font class="StyleHead_left"><bean:message key="productoSinStock.titPagina"/></font>
  <!-- Para la accion -->
  <html:form action="/productosinstock">
   <html:hidden property="accion" value=""/>
   <html:hidden property="vctExpHead" value=""/>
   	<input type="hidden" name="mensaje"   value='<bean:write name="productosinstockForm" property="mensaje" />'>
	<html:hidden property="exportFile" /> 
   <logic:present name="productosinstockForm">  
     <table border="0" class="StyleTabla_75" align="center">
	    <tr>
	      <!-- Nombre de las columnas a desplegar -->			
   		  <td><font class="StyleTextoTabla"><bean:message key="productoSinStock.titulo.columna1"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="productoSinStock.titulo.columna2"/></font></td>
	   	</tr>
		<logic:iterate id="campos" name="productosinstockForm" property="vctDetalles">
			<tr>
			  	<logic:iterate id="elemento" name="campos" indexId="index">
					<td class="VectResultDat1"><font class="VectResultDat1"><bean:write name="elemento"/></font></td>
				</logic:iterate>
			</tr>
		</logic:iterate>	
     </table>
     </logic:present>
  <br>
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td align="center">
     <input type="button" name="btnCerrar" value="Cancelar"  onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
     	<logic:equal name="productosinstockForm" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	</logic:equal>		
	<logic:notEqual name="productosinstockForm" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	</logic:notEqual>
   </td>
   </tr>
   </table>
</html:form>
</body>
</html>
 	
