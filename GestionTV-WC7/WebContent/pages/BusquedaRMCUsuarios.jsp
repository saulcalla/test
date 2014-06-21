<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("busquedaRMCForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.busquedaRMCForm"); %>
<% String titulogeneral = new String("busquedaRMC.titGeneral"); %>
<% String titulopagina 	= new String("busquedaRMC.titPagina"); %>
<% String vaccion 		= new String("/BusquedaRMC"); %>
<% String accioninicio 	= new String("InicioBusquedaRMC"); %>
<% String vcolumna 		= new String("busquedaRMC.campo"); %>
<% String btncancelar 	= new String("busquedaRMC.boton.cancelar"); %>
<% String btnbuscar 	= new String("busquedaRMC.boton.buscar"); %>
<% int 	  numcol 		= 13; %>
<script language="javascript">	
	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
    var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
</script>
<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 10;
	lista="0123456789/";
function do_btnExcel()
{
	var obj = document.busquedaRMCForm;
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


	
	
	function valida() {
	
		var obj = <%=vForm%>;
		if (obj.nro_rmc.value != "") {
			return true;
		} else {
			alert('Debe ingresar N° RMC para la búsqueda');
		}	
	
		return false;
	}
	
	
	function do_buscar() {
		var obj = <%=vForm%>;
		
		
		if (valida()) {
			obj.indice.value 			 = "0";
			obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
			obj.nroBloque.value 		 = "1";
			
	  		obj.accion.value 			 = "buscar";
			obj.submit();	  	
		}
	}


	function acceptNum(evt){
	
		var nav4 = window.Event ? true : false;
		var key = nav4 ? evt.which : evt.keyCode;	
		return (key <= 13 || (key >= 48 && key <= 57));
	
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

		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"

		
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;

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
			btnLimpiar_onclick();
		}

		if ("<bean:write name="<%=vFormulario%>" property="hayDatos"/>" == "si") {
			setButton();

		}
		
	
	}
   

</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<!-- <link rel="stylesheet" type="text/css" href="styles/estylemante.css"> -->
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
			   	<html:text name="<%=vFormulario%>" property="nro_rmc" onkeypress="return acceptNum(event)" size="15" maxlength="15" />  			
			</td>
			
			<td align="right"> 
				<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="center">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>		 	
    	</tr>
    	<tr>
    	</tr>    	
    	<tr>
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
				<td class="VectResultDat3"><font class="VectResultDat3"><bean:write name="elemento"/></font></td>
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
