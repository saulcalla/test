<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page isThreadSafe="true"%>
<% String vFormulario 	= new String("actualizaestadosForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.actualizaestadosForm"); %>
<% String titulogeneral = new String("actualizaestados.titGeneral"); %>
<% String titulopagina 	= new String("actualizaestados.titPagina"); %>
<% String vaccion 		= new String("/actualizaestados"); %>
<% String accioninicio 	= new String("InicioActualizaEstados"); %>
<% String vcolumna 		= new String("actualizaestados.form1.campo"); %>
<% String btncancelar 	= new String("actualizaestados.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("actualizaestados.form1.boton.buscar"); %>
<% String parametroIni 	= new String("actualizaestados.titfechaIni"); %>
<% String parametroFin 	= new String("actualizaestados.titfechaFin"); %>
<% String paramfiltroIni = new String("num_Oc"); %>
<% String numeroOrden = new String("num_Oc2"); %>
<% String check1 = new String("check_1"); %>
<% String check2 = new String("check_2"); %>

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



function alternar(){
var obj = <%=vForm%>;
if(obj.check_2.checked)
	obj.check_2.checked = false;


}
function alternar2(){

if(obj.check_1.checked)
	obj.check_1.checked = false;


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
  
  function validaCampoNulo3() {
		
		return(false);
	} 
	function validaCampoNulo2() {
		var obj = <%=vForm%>;
		
		if (obj.<%=paramfiltroIni%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
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
  


function btnActualiza_onclick() {
		var obj = <%=vForm%>;
		
		if (validaCampoNulo3()) {
			return;
		}
		
		if ("<bean:write name="<%=vFormulario%>" property="estado7"/>" == "si") {
			if(obj.check_1.checked)
				obj.est.value = "1"
			else
				obj.est.value = "0"
			
		}
		else if ("<bean:write name="<%=vFormulario%>" property="estado1"/>" == "si") {
		obj.est.value = "0"
		
		}
		
		else if ("<bean:write name="<%=vFormulario%>" property="estado0"/>" == "si") {
		obj.est.value = "7"
		
		}
		
		
		
  		obj.accion.value 			 = "actualiza";
		obj.submit();	  	
	}
	function do_buscar() {
		var obj = <%=vForm%>;
		
		if (validaCampoNulo2()) {
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
 
	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		
		if("<bean:write name="<%=vFormulario%>" property="mensaje"/>"!="")
			{
				
					alert("<bean:write name="<%=vFormulario%>" property="mensaje"/>");
				
				
				
			}
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
				
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.<%=paramfiltroIni%>.disabled = true;
			
			
			
		}
	
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "no") {
			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}
			
				
		if ("<bean:write name="<%=vFormulario%>" property="grabado"/>" == "si") {
		
		alert("Estado actualizado correctamente");
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
<!-- INI -- RC & PP -- 26/10/2004 -->
	<html:hidden property="totalRegistros"/>
	<html:hidden property="est"/>
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
				<html:text name="<%=vFormulario%>" property="<%=paramfiltroIni%>" size="10" maxlength="20" />
			   
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
	
	
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	

  	<table border="0" class="StyleTabla_EstadosOC" align="center" > 
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    <font class="StyleTextoTablaEstadoOC">
			    
			    <bean:message key="actualizaestados.titHeaderDatos1"/>
			   	<bean:write name="<%=vFormulario%>" property="num_Oc2"/>
			    
			    </font>
			</td>
		    <td align="left" width="35%"><font class="StyleTextoTablaEstadoOC">
		    	<bean:message key="actualizaestados.titHeaderDatos2"/><bean:write name="<%=vFormulario%>" property="fecha_Cre"/>
		    	</font>
		    </td>
		    <td align="left" width="35%">
		    	<font class="StyleTextoTablaEstadoOC">
		    	<bean:message key="actualizaestados.titHeaderDatos3"/>
		    	<bean:write name="<%=vFormulario%>" property="estado"/>
		    	</font>
		    </td>
		</tr>
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    
			</td>
		    <td align="left" width="35%">
		    </td>
		    <td align="left" width="35%">
		    	
		    </td>
		</tr>	
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    
			</td>
		    <td align="left" width="35%">
		    </td>
		    <td align="left" width="35%">
		    	
		    </td>
		</tr>
		<logic:equal name="<%=vFormulario%>" property="estado7" value="si">	
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    <html:checkbox name="<%=vFormulario%>" property="<%=check1%>" onclick="alternar()"><bean:message key="actualizaestados.estado71"/></html:checkbox>
			</td>
		    <td align="left" width="35%">
		    <html:checkbox name="<%=vFormulario%>" property="<%=check2%>" onclick="alternar2()"><bean:message key="actualizaestados.estado70"/></html:checkbox>
		    </td>
		    <td align="left" width="35%">
		    	
		    </td>
		</tr>
		</logic:equal>
		<logic:equal name="<%=vFormulario%>" property="estado0" value="si">
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    <html:checkbox name="<%=vFormulario%>" property="<%=check1%>"><bean:message key="actualizaestados.estado07"/></html:checkbox>
			</td>
		    <td align="left" width="35%">
		    
		    </td>
		    <td align="left" width="35%">
		    	
		    </td>
		</tr>	
		</logic:equal>
		<logic:equal name="<%=vFormulario%>" property="estado1" value="si">
		<tr>
		    <td align="left" style="padding-left:30px;" width="30%">
			    <html:checkbox name="<%=vFormulario%>" property="<%=check1%>"><bean:message key="actualizaestados.estado10"/></html:checkbox>
			</td>
		    <td align="left" width="35%">
		    
		    </td>
		    <td align="left" width="35%">
		    	
		    </td>
		</tr>	
		</logic:equal>	
  	</table>
<!-- END -- RC & PP -- 26/10/2004 -->	
	
	</logic:equal>
	<br>
 <table border="0" class="StyleTabla_TodasVentas" align="center">
  <tr>
	 <td align="center">

     	<input type="button" name="btnCerrar" value="Cancelar"  onclick="do_cancelar();" STYLE="border:1px solid white; width:120px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
     	<logic:equal name="<%=vFormulario%>" property="estadocorrecto" value="si">
     		<input type="button" name="BtnActualizar" value="Cambiar Estado" onclick="btnActualiza_onclick();" STYLE="border:1px solid white; width:120px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">	
		</logic:equal>		
	

   </td>
   </tr>
    
   </table>

<!-- INI -- RC & PP -- 26/10/2004 -->   	  
	
<!-- END -- RC & PP -- 26/10/2004 -->	
</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		
</body>
