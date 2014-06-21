<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page isThreadSafe="true"%>
<% String vFormulario 	= new String("pedidosForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.pedidosForm"); %>
<% String titulogeneral = new String("pedidos.titGeneral"); %>
<% String titulopagina 	= new String("pedidos.titPagina"); %>
<% String nota 			= new String("gestiontv.nota"); %>
<% String vaccion 		= new String("/pedidos"); %>
<% String accioninicio 	= new String("InicioPedidos"); %>
<% String vcolumna 		= new String("pedidos.form1.campo"); %>
<% String btncancelar 	= new String("pedidos.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("pedidos.form1.boton.buscar"); %>
<% String parametroIni 	= new String("pedidos.titfechaIni"); %>
<% String parametroFin 	= new String("pedidos.titfechaFin"); %>
<% String paramfiltroIni = new String("fec_inicio"); %>
<% String paramfiltroFin = new String("fec_fin"); %>
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
	var obj = document.pedidosForm;
	obj.vctExpHeadNota.value="[["+ "<bean:message key="<%=nota%>"/>";
	obj.vctExpHeadNota.value = obj.vctExpHeadNota.value+"]]";
	obj.vctExpHead.value = "[[";
	 <%for(int i=1;i<=numcol-1;i++){ 
	 	if(i==1)
	 	{
	 	%>
	 	obj.vctExpHead.value = obj.vctExpHead.value+ "Fecha" +", ";
	 	<%
	 	}
	 	else
	 	{
	 	String tempo= new String(vcolumna+i);%>	
		obj.vctExpHead.value = obj.vctExpHead.value+ "<bean:message key="<%=tempo%>"/>" +", ";
	<%	}
	 	
	}
	String tempo= new String(vcolumna+numcol);%>
	obj.vctExpHead.value = obj.vctExpHead.value+"<bean:message key="<%=tempo%>"/>";
	obj.vctExpHead.value = obj.vctExpHead.value+"]]";			

 	obj.accion.value = "excel";
	obj.submit(); 
}
	function validaCampoNulo() {
		var obj = <%=vForm%>;
		
		if (obj.<%=paramfiltroIni%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
		}
		if (obj.<%=paramfiltroFin%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
		}
		if (obj.<%=paramfiltroFin%>.value <= obj.<%=paramfiltroIni%>.value) {
		 //Obtiene los datos del formulario  
			   CadenaFecha1 = obj.<%=paramfiltroIni%>.value;
			   CadenaFecha2 = obj.<%=paramfiltroFin%>.value; 
			     
			   //Obtiene dia, mes y año  
			   var fecha1 = new fecha( CadenaFecha1 ); 
			   var fecha2 = new fecha( CadenaFecha2 ); 
			    			     
			   //Obtiene objetos Date  
			   var miFecha1 = new Date( fecha1.anio, fecha1.mes, fecha1.dia );  
			   var miFecha2 = new Date( fecha2.anio, fecha2.mes, fecha2.dia ); 
			  
			   if( miFecha2.getTime()< miFecha1.getTime())
			   {
			   	alert("Fecha Final debe ser mayor a Fecha Inicio");
			   	return(true);
			   }else
			   {
			   return(false);
			   }
		
			
			return(true);
		}
		if (obj.<%=paramfiltroFin%>.value > obj.<%=paramfiltroIni%>.value) {
			 //Obtiene los datos del formulario  
			   CadenaFecha1 = obj.<%=paramfiltroFin%>.value;
			   CadenaFecha2 = obj.<%=paramfiltroIni%>.value; 
			     
			   //Obtiene dia, mes y año  
			   var fecha1 = new fecha( CadenaFecha1 ); 
			   var fecha2 = new fecha( CadenaFecha2 ); 
			    			     
			   //Obtiene objetos Date  
			   var miFecha1 = new Date( fecha1.anio, fecha1.mes, fecha1.dia );  
			   var miFecha2 = new Date( fecha2.anio, fecha2.mes, fecha2.dia ); 
			  
			   //Resta fechas y redondea  
			   var diferencia = miFecha1.getTime() - miFecha2.getTime();  
			   var dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));  
			   var segundos = Math.floor(diferencia / 1000);  
			   if(dias>30)
			   {
			   alert("La diferencia entre Fechas no debe ser superior a 30 días");
			   	return(true);
			   }else
			   {
			   return(false);
			   }
					
		}
		return(false);
	}
  
	  
	function fecha( cadena ) {  
	  
	   //Separador para la introduccion de las fechas  
	   var separador = "/";  
	  
	   //Separa por dia, mes y año  
	   if ( cadena.indexOf( separador ) != -1 ) {  
	        var posi1 = 0;
	        var posi2 = cadena.indexOf( separador, posi1 + 1 );  
	        var posi3 = cadena.indexOf( separador, posi2 + 1 );  
	        this.dia = cadena.substring( posi1, posi2 );
	        this.mes = cadena.substring( posi2 + 1, posi3 );  
	        this.anio = cadena.substring( posi3 + 1, cadena.length );  
	   } else {  
	        this.dia = 0;
	        this.mes = 0; 
	        this.anio = 0;     
	   }  
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
  function btnImprimir_onclick(){
	var obj = document.pedidosForm;
	var ventana;
	
	var aux_path="" ;
    var aux_posicion = location.href;
    var posicion, posicion2;
    
    posicion = aux_posicion.indexOf('//');
    aux_posicion = aux_posicion.substr(posicion + 2, aux_posicion.length - posicion )
    posicion2 = aux_posicion.indexOf('/');
    aux_path = self.location.href.substr(0, posicion+posicion2+2);
	
	var fini = obj.fec_inicio.value;
	var arrFeIni = fini.split("/");
	fini = arrFeIni[2]+"-"+arrFeIni[1]+"-"+arrFeIni[0];
	var ffin = obj.fec_fin.value;
	var arrFeFin = ffin.split("/");
	ffin = arrFeFin[2]+"-"+arrFeFin[1]+"-"+arrFeFin[0];
    var parametros = "?periodoIni=" + fini +
				     "&periodoFin=" + ffin +				     
				     "&accion=Imprimir&path=Pedidos_salida.jsp";
				     
				     
	var wurl      = "pages/Pedidos_imprimirFrame.jsp" + parametros;
    var wname     = "Imprimir";
	var wleft     = "left=250";
	var wtop      = "top=200";
	var wtoolbar  = "toolbar=no";
	var wlocation = "location=0";
	var wdir      = "directories=no";
	var wstatus   = "status=no";
	var wmenubar  = "menubar=0";
	var wscroll   = "scrollbars=no";
	var wresize   = "resizable=no";
	var wwidth    = "width=510";
	var wheight   = "height=199";
	ventana = window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		obj.fec_inicio.focus();
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
				
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.<%=paramfiltroIni%>.disabled = true;
			obj.<%=paramfiltroFin%>.disabled = true;
			
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
  	<html:hidden property="vctExpHeadNota" value=""/>
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
  	<table width="30%" align="center" class="StyleTabla_TodasVentas">
    	<tr>
		</tr>    	
    	<tr>
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametroIni%>"/>
				<html:text name="<%=vFormulario%>" property="<%=paramfiltroIni%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
			    <input type=button name="BtnFechaIni" value="C" onclick="goWindowPopupCalendario('pedidosForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <bean:message key="<%=parametroFin%>"/>
				<html:text name="<%=vFormulario%>" property="<%=paramfiltroFin%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
			    <input type=button name="BtnFechaFin" value="C" onclick="goWindowPopupCalendario('pedidosForm','fec_fin');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			    
			</td>
   			<td class="StyleTextoTabla">
    			
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
	</table>
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="no">
	<table border="0" class="StyleTabla_EstadosOC" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titfechaHeader"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titpedidoHeader"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titboletasHeader"/></font></td>
		</tr>
  	</table>
	</logic:equal>
	
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPaginaTodasVentas.txt" %>
	<table border="0" class="StyleTabla_TodasVentas" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titfechaHeader"/></font></td>
		    <td align="left"  width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titpedidoHeader"/></font></td>
		    <td align="left"  width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titboletasHeader"/></font></td>
		</tr>	
  	</table>
  	<table border="0" class="StyleTabla_EstadosOC" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos1"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos2"/></font></td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC"><bean:message key="pedidos.titHeaderDatos3"/></font></td>
		</tr>	
  	</table>
<!-- END -- RC & PP -- 26/10/2004 -->	
	<table border="0"class="StyleTabla_EstadosOCTop" align="center" > 
		<tr>
<%
			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);
				if(i==1 || i==13 )
				{
%>
			<td align="center" width="80px"><font class="StyleTextoTablaEstadoOCHeader"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else
				{
%>
			<td align="center"><font class="StyleTextoTablaEstadoOCHeader"><bean:message key="<%=temp%>"/></font></td>	 
<%
				
				}
				}

%>
		</tr>
		<logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles">
		<tr> 
			<logic:iterate id="elemento" name="campos" indexId="index">
			<logic:equal name="index" value="0">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="1">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="2">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="3">
				<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="4">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="5">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="6">
					<td  align="center" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="7">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="8">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="9">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="10">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="11">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="12">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			<logic:equal name="index" value="13">
					<td  align="right" class="VectResultDatOC"><bean:write name="elemento"/></td>
			</logic:equal>
			</logic:iterate>
		</tr>
		</logic:iterate>
  	</table>
  	<div align="left">
  		<font class="StyleNota"><bean:message key="<%=nota%>"/></font>
  	</div>
	</logic:equal>
	<br>
 <table border="0" class="StyleTabla_TodasVentas" align="center">
  <tr>
	 <td align="center">

     	<input type="button" name="btnCerrar" value="Cancelar"  onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
     		<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
     	<input type="button" name="BtnImprimir" value="Imprimir" onclick="btnImprimir_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">	
		<input type="button" name="btnExportar" value="Exportar"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
	</logic:equal>		
	<logic:notEqual name="<%=vFormulario%>" property="hayDatos" value="si">
	<input type="button" name="BtnImprimir" value="Imprimir" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
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
