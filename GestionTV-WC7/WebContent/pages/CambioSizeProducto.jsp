<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("borradoPromocionesForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.borradoPromocionesForm"); %>
<% String titulogeneral = new String("cambioSizeProducto.titGeneral"); %>
<% String titulopagina 	= new String("cambioSizeProducto.titPagina"); %>
<% String vaccion 		= new String("/borradoPromociones"); %>
<% String vcolumna 		= new String("cambioFechaBoleta.campo"); %>
<% String btncancelar 	= new String("cambioSizeProducto.boton.cancelar"); %>
<% String btnbuscar 	= new String("cambioSizeProducto.boton.buscar"); %>

<% int 	  numcol 		= 5; %>

<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 10;
	lista="0123456789/";

	function validaCampoNulo() {
		var obj = <%=vForm%>;
						
		if(obj.theFile.value == "" ) {
			alert("Debe cargar archivo con los datos de la promocion.");
			return(false);
		}
		
		return true;
	}

	
	
	function do_buscar() {
		var obj = <%=vForm%>;
		
		if (validaCampoNulo()) {
			obj.accion.value = "pre_tama�o";
			obj.submit();	  	
		}
		
		return false;
	}

	function do_actualiza() {
		var obj = <%=vForm%>;
		obj.accion.value = "act_tama�o";
		obj.submit();	  	
	}
	
	function onLoad() {
		var obj = <%=vForm%>;
		
		if(obj.mensaje.value!=""){
			alert(obj.mensaje.value);
		}
				
		if (obj.hayDatos.value == "si") {
			obj.tipoBorrado.disabled = true;						
		}
		
		if(obj.actualiza.value =="OK"){
			btnLimpiar_onclick();
		}
		
	}
	function btnLimpiar_onclick(){
		var obj = <%=vFormulario%>;
		obj.accion.value = "InicioBorradoPromociones";		
		obj.submit();	
	}
	
	function do_cancelar() {
	
		var obj = <%=vForm%>;
		obj.accion.value = "InicioBorradoPromociones";
		obj.submit();		
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
	<body class="Stylebody" onload="onLoad()">
	<div align="center">
  	<font class="StyleHead_left"><bean:message key="<%=titulopagina%>"/></font>
  	<br>
<html:form action="<%=vaccion%>" method="post" enctype="multipart/form-data">
  	
  	<html:hidden property="accion" value=""/>
  	
  	<input type="hidden" name="mensaje" value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
			
	<input type="hidden" name="hayDatos" value='<bean:write name="<%=vFormulario%>" property="hayDatos" />'>
	
	<input type="hidden" name="actualiza" value='<bean:write name="<%=vFormulario%>" property="actualiza" />'>
  	
	 
<!-- INI -- RC & PP -- 26/10/2004 -->
	

<%
	int idx = 1;
%>
<table>
<tr>
<td align="center" colspan="2">
<font size="4">Selecciona el archivo</font>
</tr>

<tr>
<td align="left" colspan="2">
<font color="red"><html:errors/></font>
</tr>



<tr>
<td align="right"> 
Archivo
</td>
<td align="left">
<html:file property="theFile"/> 
</td>
</tr>

<tr>
</tr>


</table>

<br>

<table border="0" align="center">
  <tr>
	 <td align="center">
		<logic:empty name="<%=vFormulario%>" property="preview">
			<input type="button" name="btnCargar" value="Cargar Archivo" onclick="do_buscar();">
			
		</logic:empty >
		
		<logic:notEmpty name="<%=vFormulario%>" property="preview">
		<input type="button" name="btnLimpiar" value="Cancelar Borrado" onclick="btnLimpiar_onclick()">
					
		    <input type="button" name="btnBorrar" value="Borrar Promocion" onclick="do_actualiza()">
					
		
		</logic:notEmpty>
   	 </td>
   </tr>
 </table>
   

<br>
<logic:notEmpty name="<%=vFormulario%>" property="preview">

	<logic:equal name="<%=vFormulario%>" property="tipoBorrado" value="1">
		<table width="70%">
		<tr align="left">BORRADO PROMOCION CUYO HIJO ES :</tr>
		<logic:iterate name="<%=vFormulario%>" property="preview" id="value">			
			<tr>
			<td align="left" class="VectResultDat1">
			  <bean:write name="value" />
			</tr>
		</logic:iterate>
	
		</table>	
	</logic:equal>
	
	<logic:equal name="<%=vFormulario%>" property="tipoBorrado" value="2">
		<table width="70%">
		<tr align="left">BORRADO PROMOCION ASOCIADA AL PADRE :</tr>
		<logic:iterate name="<%=vFormulario%>" property="preview" id="value">			
			<tr>
			<td align="left" class="VectResultDat1">
			  <bean:write name="value" />
			</tr>
		</logic:iterate>
	
		</table>	
	</logic:equal>
	
	<logic:equal name="<%=vFormulario%>" property="tipoBorrado" value="3">
		<table width="70%">
		<tr align="left">BORRADO ASOCIADA AL PADRE E HIJO :</tr>
		<logic:iterate name="<%=vFormulario%>" property="preview" id="value">			
			<tr>
			<td align="left" class="VectResultDat1">
			  <bean:write name="value" />
			</tr>
		</logic:iterate>
	
		</table>	
	</logic:equal>
	
</logic:notEmpty>


</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		
</body>
