<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("todasventasForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.todasventasForm"); %>
<% String titulogeneral = new String("todasVentas.titGeneral"); %>
<% String titulopagina 	= new String("todasVentas.titPagina"); %>
<% String nota 			= new String("gestiontv.nota"); %>
<% String vaccion 		= new String("/todasventas"); %>
<% String accioninicio 	= new String("InicioTodasVentas"); %>
<% String vcolumna 		= new String("todasVentas.form1.campo"); %>
<% String btncancelar 	= new String("todasVentas.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("todasVentas.form1.boton.buscar"); %>
<% String parametroIni 	= new String("todasVentas.titfechaIni"); %>
<% String parametroFin 	= new String("todasVentas.titfechaFin"); %>


<% String paramfiltroIni 	= new String("fec_inicio"); %>
<% String paramfiltroFin 	= new String("fec_fin"); %>
<% int 	  numcol 		= 14; %>
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

function do_btnExcel(){
	var obj = document.todasventasForm;
	obj.vctExpHeadNota.value="[["+ "<bean:message key="<%=nota%>"/>";
	obj.vctExpHeadNota.value = obj.vctExpHeadNota.value+"]]";
	obj.vctExpHead.value = "[[";
	 <%for(int i=1;i<=numcol-1;i++){ 
	 	String tempo= new String(vcolumna+i);%>	
		obj.vctExpHead.value = obj.vctExpHead.value+ "<bean:message key="<%=tempo%>"/>" +", ";
	<%}
	String tempo= new String(vcolumna+numcol);%>
	obj.vctExpHead.value = obj.vctExpHead.value+"<bean:message key="<%=tempo%>"/>";
	obj.vctExpHead.value = obj.vctExpHead.value+"]]";			
	var valuesucursal = obj.selectSucursal.options[obj.selectSucursal.selectedIndex].value;
    obj.codSucursal.value = valuesucursal;
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
		var valuesucursal = obj.selectSucursal.options[obj.selectSucursal.selectedIndex].value;
   	    obj.codSucursal.value = valuesucursal;
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
	/*  //	var temp = "<bean:write name="<%=vFormulario%>" property="hayDatosExportar"/>"*/
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true, obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.<%=paramfiltroIni%>.disabled = true;
			obj.<%=paramfiltroFin%>.disabled = true;
			obj.selectSucursal.disabled = true;
			//RCid
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
			
			
			//Fin
			
		}
	
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "no") {
			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}

		if ("<bean:write name="<%=vFormulario%>" property="hayDatos"/>" == "si") {
			setButton();
		}
	}

   function Selected(selectN,valor) {
      for(i=0;i<selectN.length;i++) {
         if (selectN.options[i].value==valor) {
            selectN.options[i].selected= true;
			break;
         }
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
	<html:hidden property="vctExpHeadNota" value=""/>
	<html:hidden property="exportFile" /> 
	<input type="hidden" name="contador"           value='<bean:write name="<%=vFormulario%>" property="contador"/>'>
	<input type="hidden" name="indice"             value='<bean:write name="<%=vFormulario%>" property="indice" />' >
	<input type="hidden" name="registrosPorBloque" value='<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>'>
	<input type="hidden" name="nroBloque"          value='<bean:write name="<%=vFormulario%>" property="nroBloque"/>'>
	<input type="hidden" name="hayProximoBloque"   value='<bean:write name="<%=vFormulario%>" property="hayProximoBloque"/>'>
	<input type="hidden" name="mensaje"			   value='<bean:write name="<%=vFormulario%>" property="mensaje"/>'>
    <input type="hidden" name="codSucursal" 	   value='<bean:write name="<%=vFormulario%>" property="codSucursal"/>'>
<%
	int idx = 1;
%>
<!-- END -- RC & PP -- 26/10/2004 -->
  	<table width="30%" align="center" class="StyleTabla_TodasVentas">
    	<tr>
		</tr>    	
    	<tr>
    	</tr>    	
  		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametroIni%>"/>
				<html:text name="<%=vFormulario%>" property="<%=paramfiltroIni%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
			    <input type=button name="BtnFechaIni" value="C" onclick="goWindowPopupCalendario('todasventasForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <bean:message key="<%=parametroFin%>"/>
				<html:text name="<%=vFormulario%>" property="<%=paramfiltroFin%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
			    <input type=button name="BtnFechaFin" value="C" onclick="goWindowPopupCalendario('todasventasForm','fec_fin');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			    
			</td>
   			<td class="StyleTextoTabla">
    			<html:select property="selectSucursal">
   				<html:optionsCollection name="<%=vFormulario%>" property="collSucursal"/> 
   				<html:option value="1">Mobile</html:option>			  				 	
   	  			</html:select>
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
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPaginaTodasVentas.txt" %>
<!-- END -- RC & PP -- 26/10/2004 -->
	<table border="0" class="StyleTabla_TodasVentas" align="center" > 
		<tr>
<%
			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);
				if(i==4)
				{
%>
			<td align="center" width="110px"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else if(i==5)
				{
%>
			<td align="center" width="110px"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else if(i==11)
				{
%>
			<td align="center" width="80px"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else if(i==9)
				{
%>
			<td align="center" width="80px"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
				}
				else
				{
%>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
<%
				
				}
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
  	<div align="left">
  		<font class="StyleNota"><bean:message key="<%=nota%>"/></font>
  	</div>
	</logic:equal>
	<br>
	<p align="center">
 <table border="0" class="StyleTabla_TodasVentas" align="center">
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

   	</p>
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
<script>
    var obj=<%=vForm%>;
	<logic:notEqual name="<%=vFormulario%>" property="collSucursal" value="[]">	
		Selected(obj.selectSucursal,obj.codSucursal.value);
	</logic:notEqual>
</script>
