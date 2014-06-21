<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page isThreadSafe="true"%>
<% String vFormulario   = new String("productosRChannelForm");%>
<% String vSend 		= new String("buscar");%>
<% String vForm 		= new String("document.productosRChannelForm");%>
<% String titulogeneral = new String("productosRChannel.titGeneral");%>
<% String titulopagina  = new String("productosRChannel.titPagina");%>
<% String vaccion 		= new String("/productosRChannel");%>
<% String accioninicio  = new String("InicioProductoChannel");%>
<% String vcolumna 		= new String("productosRChannel.form1.campo");%>
<% String btncancelar 	= new String("productosRChannel.form1.boton.cancelar");%>
<% String btnbuscar 	= new String("productosRChannel.form1.boton.buscar");%>
<% String parametro 	= new String("productosRChannel.titfecha");%>
<% String paramfiltro 	= new String("fec_inicio");%>
<% String vAncho		= new String("75%");%>
<% int 	  numcol 		= 5;%>

<script language="javascript">	
	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
    var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
</script>

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 10;
	lista="0123456789/";
function do_btnExcel()
{
	var obj = document.productosRChannelForm;
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
		
		if(obj.<%=paramfiltro%>.value == "") {
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
		obj.indice.value 			 = "0";
		obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
		obj.nroBloque.value 		 = "1";
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

	function do_btnPdf(){
        var obj = <%=vForm%>;
    	var ventana;		
		obj.accion.value="ExportarPdf";
		var wname     = "Reporte";
		var wtoolbar  = "toolbar=no";
		var wlocation = "location=0";
		var wdir      = "directories=no";
		var wstatus   = "status=yes";
		var wmenubar  = "menubar=0";
		var wscroll   = "scrollbars=yes";
		var wresize   = "resizable=yes";
		var wwidth    = "width=700";
		var wheight   = "height=400";		
		var wtop       = "top=" + parseInt(((screen.height - 400) / 2) - 0);
		var wleft      = "left=" + parseInt(((screen.width - 700) / 2) - 0);		
		ventana = window.open('', wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);	
		obj.target=wname;
		obj.submit();
	}
    function setForm(){//PDF
		var obj = <%=vForm%>;
		obj.target = "_self";
		window.opener=self;
		obj.accion.value="buscar"
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
			obj.<%=paramfiltro%>.disabled = true;
			
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
  	<html:hidden property="vctExpHead" value=""/>
	<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
	<html:hidden property="exportFile" /> 
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
  	<table width="30%" align="center" class="StyleTabla_75">
    	<tr>
		</tr>    	
    	<tr>
    	</tr>    	
  		<tr> 
			<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametro%>"/>
			</td>
   			<td class="StyleTextoTabla">
   	  			<html:text name="<%=vFormulario%>" property="<%=paramfiltro%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
   		        <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('productosRChannelForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>
			<td align="right"> 
				<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="left">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
    	</tr>
    	<tr>
    	</tr>    	
    	<tr>
    	</tr>    	

	</table>
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPagina.txt" %>
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
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td align="center">

     	<input type="button" name="btnCerrar" value="Cancelar"  onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
   		<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
			<input type="button" name="btnExportar" value="Expor CSV"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
			<input type="button" name="btnExportarPdf" value="Expor PDF" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
		</logic:equal>		
		<logic:notEqual name="<%=vFormulario%>" property="hayDatos" value="si">
			<input type="button" name="btnExportar" value="Expor CSV"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
			<input type="button" name="btnExportarPdf" value="Expor PDF"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
		</logic:notEqual>

   </td>
   </tr>
   </table>
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
		<%@ include file="paginacion.txt"%>
	</logic:equal>
</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		

