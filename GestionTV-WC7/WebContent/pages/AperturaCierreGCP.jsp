<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe="true"%>
<%
String vFormulario = new String("aperturaCierreGCPForm");
String vSend = new String("buscar");
String vForm = new String("document.aperturaCierreGCPForm");
String titulogeneral = new String("aperturaCierreGCP.titGeneral");
String titulopagina = new String("aperturaCierreGCP.titPagina");
String vaccion = new String("/aperturaCierreGCP");
String accioninicio = new String("InicioAperturaCierreGCP");
String btnactivar = new String("aperturaCierreGCP.btnactivar");
String tituloFecha = new String("aperturaCierreGCP.fecha");
String tituloOpcion = new String("aperturaCierreGCP.opcion");
String paramFechaInicio 	= new String("fec_inicio");
%>

<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 10;
	lista="0123456789/";

	

	
	function do_activar() {
		var obj = <%=vForm%>;
		obj.accion.value 	= obj.aperturaCierre.value;
		obj.submit();	  	

	} // do_activar
	
	

	function do_desActivar() {
		var obj = <%=vForm%>;
		
		var num_gcp = obj.numTarjetaGCP.value;
		
		// Valido que ingresen datos
		if (validaFormatoCAR()) {
		 
			if (valida_datos()) {			
			
				if (confirm('¿Esta Seguro que desea anular GCP?' )) {
						obj.accion.value 			 = "desactivar";
						obj.submit();	  	
				}			
			}
		}
	}


	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		var temp = "<bean:write name="<%=vFormulario%>" property="temp"/>"

		if (temp == "si") {
	
			
			if(obj.mensaje.value != "") {
				alert(obj.mensaje.value);				
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
	<title><bean:message key="<%=titulogeneral%>" />
	</title>
	<link rel="stylesheet" type="text/css"
		href="pages/styles/estylemante.css">
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
		<font class="StyleHead_left"><bean:message
				key="<%=titulopagina%>" />
		</font>
		<br>
		<html:form action="<%=vaccion%>">
		

			<html:hidden property="accion" value="buscar" />
			
			<input type="hidden" name="mensaje"
			value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
			

			<%
			int idx = 1;
			%>
			<!-- END -- RC & PP -- 26/10/2004 -->
			<table width="10%" align="center" class="StyleTabla_75">
				<tr>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla" align="right">
						<bean:message key="<%=tituloFecha%>" />
					</td>
					<td class="StyleTextoTabla" align="left">
   	  			<html:text name="<%=vFormulario%>" property="<%=paramFechaInicio%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
   		        <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('aperturaCierreGCPForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>			
				</tr>
				<tr>
				
				</tr>
				<tr>
				<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla" align="right">
						<bean:message key="<%=tituloOpcion%>" />
					</td>
					<td align="left">
						<html:select name="<%=vFormulario%>" property="aperturaCierre">							
							<html:option value="apertura">APERTURA</html:option>
							<html:option value="cierre">CIERRE</html:option>
						</html:select>
					</td>

				</tr>
				<tr>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>

				</tr>
				<tr>
				</tr>
				<tr>
				</tr>

			</table>
			<br>
			<table border="0" class="StyleTabla_75" align="center">
				<tr>
					<td align="center">
						<input type="button" name="btnActivar" value="INSERTAR"
							onclick="do_activar();"
							STYLE="border:1px solid white; width:80px"
							onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'"
							onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					</td>
									
					
				</tr>
			</table>


			<br>
</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		
</body>
