<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("ReporteStock_BT_TvForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.ReporteStock_BT_TvForm"); %>
<% String titulogeneral = new String("reporteStockBtTv.titGeneral"); %>
<% String titulopagina 	= new String("reporteStockBtTv.titPagina"); %>
<% String vaccion 		= new String("/reporteStockBtTv"); %>
<% String accioninicio 	= new String("InicioStockBTTV"); %>
<% String vcolumna 		= new String("reporteStockBtTv.form1.campo"); %>
<% String btncancelar 	= new String("reporteStockBtTv.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("reporteStockBtTv.form1.boton.buscar"); %>
<% String parametroStockInternet 	= new String("reporteStockBtTv.titfiltro1"); %>
<% String parametroDifStockBTTV = new String("reporteStockBtTv.titfiltro2"); %>
<% String paramCodigo = new String("reporteStockBtTv.titfiltro3"); %>


<% int 	  numcol 		= 7; %>
<script language="javascript">	
	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
    var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
</script>
<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 40;
	lista="0123456789/";
	
function do_btnExcel()
{
	var obj = document.ReporteStock_BT_TvForm;
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
	
	function validaCampoNulo() {
			return(false);
	}

	function do_buscar(filtro, lista) {
		var obj = <%=vForm%>;
		
		if (filtro == "filtro1") {
			obj.opcion_filtro.value  = obj.list1.options[obj.list1.selectedIndex].value	
		}		
		else {
			obj.opcion_filtro.value  = obj.list2.options[obj.list2.selectedIndex].value		
		}
				
		obj.indice.value 			 = "0";
		obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
		obj.nroBloque.value 		 = "1";
		obj.filtro.value 			 = filtro
  		obj.accion.value 			 = "buscar";
		obj.submit();	  	
	}
	
	
	function btnLimpiar_onclick(){
		var obj = <%=vForm%>;
		
		obj.accion.value = "<%=accioninicio%>";
		obj.submit();	
	}
	
	function do_cancelar() {
		var obj = <%=vForm%>;
		
		obj.accion.value = "cancelar";
		obj.submit();		
	}

	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		obj.list1.focus();
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
		
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;

			
			obj.list1.disabled = true;
			obj.list2.disabled = true;
			obj.codProducto.disabled = true;
			
			if (obj.filtro.value == "filtro1")
				 obj.list1.value = obj.opcion_filtro.value
			else
				if (obj.filtro.value == "filtro2")
					obj.list2.value = obj.opcion_filtro.value
				
		
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

			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}

		if ("<bean:write name="<%=vFormulario%>" property="hayDatos"/>" == "si") {
			obj.btn_buscar1.disabled 	= true;
			obj.btn_buscar2.disabled 	= true;
		}
	}
	
	function acceptNum(evt){
	
		var nav4 = window.Event ? true : false;
		var key = nav4 ? evt.which : evt.keyCode;	
		return (key <= 13 || (key >= 48 && key <= 57));
	
	}
   

</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
</head>
	<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
  	<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
  	<script language="javascript" src="scripts/calendario.js"></script>
  	<script language="javascript" src="pages/scripts/calendario.js"></script>
  	<script language="javascript" src="pages/scripts/funciones.js"></script>
  	<script language="javascript" src="scripts/funciones.js"></script>
  	<script language="javascript" src="scripts/paginacion.js"></script>
  	<script language="javascript" src="pages/scripts/paginacion.js"></script>
	<body class="Stylebody" onload="javascript:body_onload_GestionTV();">
	<div align="center">
  	<font class="StyleHead_left"><bean:message key="<%=titulopagina%>"/></font>
  	<br>
<html:form action="<%=vaccion%>">
  	<html:hidden property="accion" value="buscar"/>
  	<html:hidden property="vctExpHead" value=""/>
	<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
	<html:hidden property="exportFile" /> 
<!-- INI -- RC & PP -- 26/10/2004 -->
	<html:hidden property="totalRegistros"/>
	<html:hidden property="flagDatosBD"/>
	<html:hidden property="totalPaginas"/>	
	<input type="hidden" name="contador"           value='<bean:write name="<%=vFormulario%>" property="contador"/>'>
	<input type="hidden" name="indice"             value='<bean:write name="<%=vFormulario%>" property="indice" />' >
	<input type="hidden" name="registrosPorBloque" value='<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>'>
	<input type="hidden" name="nroBloque"          value='<bean:write name="<%=vFormulario%>" property="nroBloque"/>'>
	<input type="hidden" name="hayProximoBloque"   value='<bean:write name="<%=vFormulario%>" property="hayProximoBloque"/>'>
	<input type="hidden" name="filtro"   value='<bean:write name="<%=vFormulario%>" property="filtro"/>'>
	<input type="hidden" name="opcion_filtro"   value='<bean:write name="<%=vFormulario%>" property="opcion_filtro"/>'>

<%
	int idx = 1;
%>
<!-- END -- RC & PP -- 26/10/2004 -->
  	<table width="30%" align="center" class="StyleTabla_75">
    	<tr>
		</tr>    	
    	<tr>
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametroStockInternet%>"/>
			</td>
	    	<td class="StyleTextoTabla">
		    	<select name="list1" onchange="select()">
					<option selected value="todos">Todos</option>
					<option value="con_stock">Con Stock</option>
					<option value="sin_stock">Sin Stock</option>
				</select>
				
			</td>
			
			<td align="left"> 
				<input type="button" name="btn_buscar1" value="Buscar" onclick="do_buscar('filtro1','list1');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="left">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
    	</tr>  
    	<tr><td>&nbsp;</td></tr>
    	 	
  		<tr> 
			<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametroDifStockBTTV%>"/>
			</td>
   			<td class="StyleTextoTabla">
   	  			<select name="list2">
					<option selected value="todos">Todos</option>
					<option value="con_diferencia">Con Diferencia</option>
					<option value="sin_diferencia">Sin Diferencia</option>
				</select>

    		</td>			
    		
			<td align="left"> 
				<input type="button" name="btn_buscar2" value="Buscar" onclick="do_buscar('filtro2','list2');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="left">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
    	</tr>
    	<tr><td>&nbsp;</td></tr>
    	<tr>
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=paramCodigo%>"/>
			</td>
			<td class="StyleTextoTabla">
			   	<html:text name="<%=vFormulario%>" property="codProducto" onkeypress="return acceptNum(event)" size="13" maxlength="13" />  			
			</td>
			
    	</tr>  

	</table>
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPagina.txt" %>
<!-- END -- RC & PP -- 26/10/2004 -->	
	<table border="0"class="StyleTabla_BT_TV" align="center" > 
		<tr>
<%
			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);				
%>
				<td align="center"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
			}
%>
		</tr>
		<logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles">
		<tr> 
			<logic:iterate id="elemento" name="campos" indexId="index">
				<td class="VectResultDatBT_TV"><font class="VectResultDatBT_TV"><bean:write name="elemento"/></font></td>
			</logic:iterate>
		</tr>
		</logic:iterate>
  	</table>
	</logic:equal>
	<br>
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td align="center">

     	<input type="button" name="btnCerrar" value="Cancelar"  onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
     		<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
	</logic:equal>		
	<logic:notEqual name="<%=vFormulario%>" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
	</logic:notEqual>

   </td>
   </tr>
   </table>

<!-- INI -- RC & PP -- 26/10/2004 -->   	  
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
		<%@ include file="paginacion.txt"%>
	</logic:equal>
<!-- END -- RC & PP -- 26/10/2004 -->	
</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		
</body>


