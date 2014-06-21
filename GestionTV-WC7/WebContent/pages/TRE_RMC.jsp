<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("treRMCForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.treRMCForm"); %>
<% String titulogeneral = new String("treRMC.titGeneral"); %>
<% String titulopagina 	= new String("treRMC.titPagina"); %>
<% String vaccion 		= new String("/tre_rmc"); %>
<% String accioninicio 	= new String("InicioTRE_RMC"); %>
<% String vcolumna 		= new String("treRMC.campo"); %>
<% String btncancelar 	= new String("treRMC.boton.cancelar"); %>
<% String btnbuscar 	= new String("treRMC.boton.buscar"); %>
<% int 	  numcol 		= 7; %>

<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	lista="0123456789/";

	
	function do_buscar() {
		var obj = <%=vForm%>;
		obj.accion.value 			 = "buscar";
		obj.submit();
	}


	function do_imprimir() {
		var obj = <%=vForm%>;
		obj.accion.value 			 = "Imprimir";
		obj.submit();
	}
	
	function do_grabar() {
		var obj = <%=vForm%>;
		obj.glosaSucursal.value = obj.selectSucursal.options[obj.selectSucursal.selectedIndex].text;
		obj.codSucursal.value = obj.selectSucursal.options[obj.selectSucursal.selectedIndex].value;
		
		if (obj.glosaSucursal.value == "TODAS") {
			alert("Debe seleccionar sucursal.");
			return false;
		} 
		
		if (obj.numTRE.value == "") {
			alert("Debe ingresar Nº de RMC.");
			return false;
		} else {			
			obj.accion.value 			 = "Grabar";
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
		obj.btnGrabar.disabled = true;
		obj.btnImprimir.disabled = true;		
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
		
		if(obj.mensaje.value!="") {
			obj.btn_buscar.disabled       = true;
			alert(obj.mensaje.value);
			obj.mensaje.value = "";				
		}
		
	
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "NO") {
			btnLimpiar_onclick();
		}

		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "si") {
			obj.btnGrabar.disabled = false;				
		}
		
		if ("<bean:write name="<%=vFormulario%>" property="hayDatosExportar"/>" == "si") {
			obj.btnGrabar.disabled = true;	
			obj.btnImprimir.disabled = false;			
		}
		
		if ("<bean:write name="<%=vFormulario%>" property="accion"/>" == "Imprimir") {
			var ventimp = window.open('pages/TRE_RMC_Impresion.jsp','600x600','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=795,height=450');
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
	<input type="hidden" name="glosaSucursal" value='<bean:write name="<%=vFormulario%>" property="glosaSucursal" />'>
	<input type="hidden" name="codSucursal" value='<bean:write name="<%=vFormulario%>" property="codSucursal" />'>
	
	<html:hidden property="exportFile" /> 
<!-- INI -- RC & PP -- 26/10/2004 -->
	
	<html:hidden property="flagDatosBD"/>
	

<%
	int idx = 1;
%>

  	<table width="30%" align="center" class="StyleTabla_75">
    	<tr>
		</tr>    	
    	

    	<tr> 
			<td align="center"><bean:message key="treRMC.busqueda"/></td>

			<td align="left"> 
				<html:text name="<%=vFormulario%>" property="numTRE" onkeypress="return acceptNum(event)" size="15" maxlength="15" />  	
			</td>
			<td align="center"> 
				<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>
			
			<td align="center">
		     	<input type="button" name="btnCerrar" value="Limpiar"  onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
		    </td>    		
				
    	</tr>
    	<tr>
    	</tr>    	
    	<tr>
    	</tr>    
    	

	</table>

	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
		<br>
		<table width="95%">
		<tr>
			<td width="85%" valign="top"> 
				<table align="left" >
			    	<tr class="StyleText">DATOS DE LA TARJETA</tr>    	
			    
			    	<tr> 
						<td class="StyleText">Rut Empresa</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="rutEmpresa" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Glosa Tarjeta</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="glosaTarjeta" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Estado</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="estado" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Area</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="area" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Nº Convenio</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="numConvenio" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Nº Lote</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="numLote" /></td>				
			    	</tr>
			    	<tr> 
						<td class="StyleText">Fecha Vcto.</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="fechaVcto" /></td>
						<td class="StyleText">Fecha Vcto. Origen</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="fechaVctoOrigen" /></td>				
			    	</tr>
			    	
			    	<tr> 
						<td class="StyleText">Monto Otorgado</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="montoOtorgado" /></td>				
			    	</tr>
			    	
			    	<tr> 
						<td class="StyleText">Saldo Disponible</td>
						<td class="VectResultDat_tre"><bean:write name="<%=vFormulario%>" property="saldoDisponible" /></td>				
			    	</tr>    
				</table>
			</td> 
			<td align="left" valign="top" width="15%"> 
				<table align="left" width="98%">
					<tr class="StyleText"> Grupo de Departamentos </tr>
					<tr class="VectResultDat_tre"> <html:text property="glosaDepartemento" size="37" disabled="true"></html:text></tr>
					<tr class="StyleText">Departamentos</tr>
					<tr>
						
		   				<html:select property="hayProximoBloque" size="10" styleClass="VectResultDat_tre">

						<html:options styleClass="VectResultDat_tre" name="<%=vFormulario%>" property="selectDepartamentos" />                          
						
						</html:select>
		   				
		   				
												
					</tr>
				</table>
			</td>
		</tr>
		
	</table>
		
		
		<table>
		<tr>
			<td align="left" class="VectResultTit">Nº RMC </td>
			<td align="center"> 
				<html:text property="num_rmc" size="15" onkeypress="return acceptNum(event)"></html:text>
			<td align="left" class="VectResultTit">SUCURSAL</td>
			<td align="right">
				<html:select property="selectSucursal" >
   				<html:optionsCollection name="<%=vFormulario%>" property="collSucursal"/>        			
   	  			</html:select>
				 
				
			</td>
		</tr> 
		</table>	
	
	</logic:equal>
	<br>
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	<td align="center">
		<input disabled="true" type="button" name="btnGrabar" value="Grabar" onclick="do_grabar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		<input disabled="true" type="button" name="btnImprimir" value="Imprimir"  onclick="do_imprimir();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  
	</td>    		
   </tr>
   </table>

</html:form>
    		
</body>
