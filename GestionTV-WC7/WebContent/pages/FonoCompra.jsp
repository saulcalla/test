<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe="true"%>
<% String vFormulario   = new String("fonocompraForm");%>
<% String vSend 		= new String("buscar");%>
<% String vForm 		= new String("document.fonocompraForm");%>
<% String titulogeneral = new String("fonoCompra.titGeneral");%>
<% String titulopagina  = new String("fonoCompra.titPagina");%>
<% String vaccion 		= new String("/fonocompra");%>
<% String accioninicio  = new String("InicioFonoComprasMes");%>
<% String vcolumna 		= new String("fonoCompra.form1.campo");%>
<% String btncancelar 	= new String("fonoCompra.form1.boton.cancelar");%>
<% String btnbuscar 	= new String("fonoCompra.form1.boton.buscar");%>
<% String parametro1 	= new String("fonoCompra.titfechai");%>
<% String parametro2 	= new String("fonoCompra.titfechaf");%>
<% String paramfiltro1 	= new String("fec_inicio");%>
<% String paramfiltro2 	= new String("fec_fin");%>
<% String vAncho		= new String("75%");%>
<% int 	  numcol 		= 8;%>

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
	var obj = document.fonocompraForm;
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
		var obj = <%=vForm%>;
		
		if (obj.<%=paramfiltro1%>.value == "" || obj.<%=paramfiltro2%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
		}
		return(false);
	}

	function do_buscar() {
		var obj = <%=vForm%>;
		
		if (validaCampoNulo()) {
			return;
		}
		 // valida campos requeridos
	    var mensaje1   = "";
	    var mensaje2   = "";
	    var mensaje3   = "";
	    var mensaje    = "";
	    var fec_inicio = obj.<%=paramfiltro1%>.value;
	    var fec_fin    = obj.<%=paramfiltro2%>.value;
	    mensaje1 = mensaje1 + valida_campo_requerido(obj.<%=paramfiltro1%>.value,"Fecha Inicio","<bean:message key="error.requerido"/>");
	    mensaje2 = mensaje2 + valida_campo_requerido(obj.<%=paramfiltro2%>.value,"Fecha Final","<bean:message key="error.requerido"/>");
	    if (mensaje1 != "") {
	       mensaje = mensaje1;
		}
		
		if (mensaje2 != "") {
		      mensaje = mensaje + mensaje2;
		}
	    if ( mensaje != "" ) {
	       alert (mensaje);
	       return;
	    }
	    
		// fin valida campos requeridos
	    fec_inicio = parseInt(fec_inicio.substr(6,4)+fec_inicio.substr(3,2)+fec_inicio.substr(0,2),10);
	    fec_fin    = parseInt(fec_fin.substr(6,4)+fec_fin.substr(3,2)+fec_fin.substr(0,2),10);
	    if (fec_inicio > fec_fin) {
	       alert ("Fecha Fin debe ser mayor o igual a Fecha Inicio");
	       return;
		}
			
		obj.indice.value 			 = "0";
		obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
		obj.nroBloque.value 		 = "1";
  		obj.accion.value 			 = "buscar";
		obj.submit();	  	
	}

	function btnLimpiar_onclick() {
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
		obj.fec_inicio.focus();
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
		//var temp = "<bean:write name="<%=vFormulario%>" property="hayDatosExportar"/>"
		
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.<%=paramfiltro1%>.disabled = true;
			obj.<%=paramfiltro2%>.disabled = true;
			
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
			setButton();
		}
	}
</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
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
<!-- INI -- RC & PP -- 26/10/2004 -->
	<html:hidden property="totalRegistros"/>
	<html:hidden property="flagDatosBD"/>
	<html:hidden property="totalPaginas"/>	
  	<html:hidden property="vctExpHead" value=""/>
	<html:hidden property="exportFile" /> 
	<input type="hidden" name="contador"           value='<bean:write name="<%=vFormulario%>" property="contador"/>'>
	<input type="hidden" name="indice"             value='<bean:write name="<%=vFormulario%>" property="indice" />' >
	<input type="hidden" name="registrosPorBloque" value='<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>'>
	<input type="hidden" name="nroBloque"          value='<bean:write name="<%=vFormulario%>" property="nroBloque"/>'>
	<input type="hidden" name="hayProximoBloque"   value='<bean:write name="<%=vFormulario%>" property="hayProximoBloque"/>'>
	<input type="hidden" name="mensaje"			   value='<bean:write name="<%=vFormulario%>" property="mensaje"/>'>
<%
	int idx = 1;
%>
<!-- END -- RC & PP -- 26/10/2004 -->
  	<table width="30%" align="center" class="StyleTabla_75">
  		<tr> 
			<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametro1%>"/>
			</td>
   			<td class="StyleTextoTabla">
    			<html:text property="<%=paramfiltro1%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
		<input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('fonocompraForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">    			
    		</td>
			<td class="StyleTextoTabla"> 
<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">				
			</td>    		
    	</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		    <td class="StyleTextoTabla">
				<bean:message key="<%=parametro2%>"/>
			</td>
   			<td class="StyleTextoTabla">
    			<html:text property="<%=paramfiltro2%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
    			
   			<input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('fonocompraForm','fec_fin');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>
			<td class="StyleTextoTabla">
				 <input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		 	</td>
  		</tr>
		<tr></tr>
	</table>
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPagina.txt" %>
<!-- END -- RC & PP -- 26/10/2004 -->	
	<table border="0"class="StyleTabla_75" align="center" > 
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
				<td class="VectResultDat1"><font class="VectResultDat1"><bean:write name="elemento"/></font></td>
			</logic:iterate>
		</tr>
		</logic:iterate>
  	</table>
	</logic:equal>
	<br>
	<p align="center">
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
		<%@ include file="paginacion.txt" %>
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
