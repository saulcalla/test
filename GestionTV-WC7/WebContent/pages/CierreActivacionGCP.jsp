<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe="true"%>
<%
String vFormulario = new String("cierreActivacionGCPForm");
String vSend = new String("buscar");
String vForm = new String("document.cierreActivacionGCPForm");
String titulogeneral = new String("cierreActivacionGCP.titGeneral");
String titulopagina = new String("cierreActivacionGCP.titPagina");
String vaccion = new String("/cierreActivacionGCP");
String accioninicio = new String("InicioCierreActivacionGCP");
String btnactivar = new String("cierreActivacionGCP.btnactivar");
String tituloFecha = new String("cierreActivacionGCP.fecha");
String paramFechaInicio 	= new String("fec_inicio");
request.getSession().setAttribute("Conectado","OK");
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
		obj.accion.value 	= "cierre";
		obj.submit();	  	

	} // do_activar
	
	

	function do_impresion (id_voucher){

		var obj = <%=vForm%>;
		var v = <%=vForm%>.link_voucher;
		var url_voucher = v.value+"&impresion=ok";
		var ventimp = window.open(url_voucher,'400x560','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=580,height=660');
	}


	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		var temp = "<bean:write name="<%=vFormulario%>" property="temp"/>"

		var cierre = "<bean:write name="<%=vFormulario%>" property="cierre"/>";

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
		
		if (cierre == "ok") {
			obj.btnImpresion.disabled = false;
			var obj = <%=vForm%>;
			var v = <%=vForm%>.link_voucher;
			var url_voucher = v.value+"&impresion=no";
			var ventimp = window.open(url_voucher,'400x560','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=580,height=660');
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

			<input type="hidden" name="link_voucher"
				value='<bean:write name="<%=vFormulario%>" property="linkVoucherHTML" />'>
							

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
   		        <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('cierreActivacionGCPForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>			
				</tr>
				<tr>
				
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
						<input type="button" name="btnActivar" value="GENERAR"
							onclick="do_activar();"
							STYLE="border:1px solid white; width:80px"
							onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'"
							onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					</td>				
				
					<td align="center">
							<input type="button" disabled="disabled" name="btnImpresion" value="IMPRESION"
								onclick="do_impresion();"
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
