<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe="true"%>
<%
String vFormulario = new String("activacionGCPForm");
String vSend = new String("buscar");
String vForm = new String("document.activacionGCPForm");
String titulogeneral = new String("activacionGcp.titGeneral");
String titulopagina = new String("activacionGcp.titPagina");
String vaccion = new String("/activacionGCP");
String accioninicio = new String("InicioActivacionGCP");
String btnactivar = new String("activacionGcp.btnactivar");
String titulotarjetaGcp = new String("activacionGcp.tarjetaGcp");
String tituloMontoActivacion = new String("activacionGcp.montoActivacion");
String tituloNumCuotas = new String("activacionGcp.numCuotas");
String titulotarjetaCar = new String("activacionGcp.titulotarjetaCar");
String titulomail = new String("activacionGcp.titulomail");

int numcol = 18;
%>

<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	var K_REGISTROS_POR_PAGINA 	  = 10;
	lista="0123456789/";

	function valida_datos () {		
		var obj = <%=vForm%>;
		
		var largo_tarj = obj.numTarjetaCAR.value.length; 
		
		
		
		if (largo_tarj < 16 ) {
			alert("ERROR:: DEBE INGRESAR Nº DE TARJETA RIPLEY.");
			return(false);		
		}
		
		
		if (obj.numTarjetaGCP.value == "" ) {
			alert("ERROR:: DEBE INGRESAR Nº DE GCP.");
			return(false);		
		}
			
		if (obj.numTarjetaCAR.value == "" ) {
			alert("ERROR:: DEBE INGRESAR Nº DE TARJETA RIPLEY.");
			return(false);		
		}
		
		if (obj.montoActivacion.value == "" ) {
			alert("ERROR:: DEBE INGRESAR EL MONTO DE ACTIVACION.");
			return(false);		
		}
		
		
		if (largo_tarj == 16) {
		
			obj.anio_vencimiento.disabled=false;
			obj.mes_vencimiento.disabled=false;
			obj.cvv.disabled=false;
									
			if (obj.cvv.value == "") {
				alert("ERROR:: DEBE INGRESAR Nº DE CVV.");
				return(false);		
			}
					
			if (obj.cvv.value.length < 3) {
				alert("ERROR:: Nº DE CVV DEBE SER DE LARGO 3");
				return(false);		
			}
			
		}
				
		return(true);	
	}

	function do_limpiar() {
		var obj = <%=vForm%>;
		obj.numTarjetaGCP.value = "";
		obj.numTarjetaCAR.value = "";
		obj.montoActivacion.value = "";
		obj.montoActivacion.value = "";
		obj.numTarjetaGCP.focus();
		obj.accion.value 			 = "InicioActivacionGCP";
		obj.submit();	  	
	}	
	
	function do_impresion (id_voucher){

		var obj = <%=vForm%>;
		var v = <%=vForm%>.link_voucher;
		var url_voucher = v.value+"&impresion=ok";
		var ventimp = window.open(url_voucher,'400x560','toolbar=no,status=no,scrolling=no, scrollbars=yes,location=no,menubar=no,directories=no,resizable=no,width=580,height=660');
	}
	
	
	function do_cft (){
		
		var obj = <%=vForm%>;
		var v = <%=vForm%>.numTarjetaCAR.value;
		if (v == "628156") {
			obj.anio_vencimiento.disabled=false;
			obj.mes_vencimiento.disabled=false;
			obj.cvv.disabled=false;			
		} 
		
		if (v.length < 6) {
			obj.anio_vencimiento.disabled=true;
			obj.mes_vencimiento.disabled=true;
			obj.cvv.disabled=true;			
		} 
		
		
	}
	
	function do_activar() {
		var obj = <%=vForm%>;
		// Valido que ingresen datos
		
		var monto_act = obj.montoActivacion.value;
			
		 
		if (valida_datos()) {			
				if (confirm('¿Esta Seguro que desea activar GCP por el monto $ ' + monto_act)) {
					obj.accion.value 	= "activar";
					obj.submit();	  	
				}
		}
		
	} // do_activar
	
	

	function do_desActivar() {
		var obj = <%=vForm%>;
		
		var num_gcp = obj.numTarjetaGCP.value;
		
		// Valido que ingresen datos
		if (valida_datos()) {			
			
				if (confirm('¿Esta Seguro que desea anular GCP?' )) {
						obj.accion.value 			 = "desactivar";
						obj.submit();	  	
				}			
			
		}
	}

	function do_enviarEmail() {
		var obj = <%=vForm%>;
		var email = obj.mailCliente.value;
		if (validarEmail(email)) {			
			if (confirm('¿Esta Seguro que desea enviar mail a : ' + email)) {
				obj.accion.value 	= "enviarMail";
				obj.submit();	  	
			}
		}
	
	} // do_enviarEmail
	
	
	function validarEmail(valor) {
  	  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(valor)){
		return (true)
	  } else {
	   alert("La dirección de email es incorrecta.");
	   return (false);
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
		var temp = "<bean:write name="<%=vFormulario%>" property="temp"/>"
		var activacion = "<bean:write name="<%=vFormulario%>" property="activacion"/>";

		if (temp == "si") {
				
			if(obj.mensaje.value != "") {
				alert(obj.mensaje.value);				
			}
		}
		else {
		
			obj.numTarjetaGCP.value = "";
			obj.numTarjetaCAR.value = "";
			obj.montoActivacion.value = "0";
	
		}
			
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "no") {
			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}
		
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "CFT") {
				obj.anio_vencimiento.disabled=false;
				obj.mes_vencimiento.disabled=false;
				obj.cvv.disabled=false;
		}

		if ("<bean:write name="<%=vFormulario%>" property="hayDatos"/>" == "si") {
			setButton();
		}
		
		if (activacion == "ok") {
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
			
			<html:hidden property="opcion"  />
			
			<input type="hidden" name="mensaje"
			value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
			
			<input type="hidden" name="link_voucher"
				value='<bean:write name="<%=vFormulario%>" property="linkVoucherHTML" />'>

			<%
			int idx = 1;
			%>
			<!-- END -- RC & PP -- 26/10/2004 -->
			<table width="30%" align="center" class="StyleTabla_75">
				<tr>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="<%=titulotarjetaGcp%>" />
					</td>
					<td class="StyleTextoTabla">
						<html:text name="<%=vFormulario%>" property="numTarjetaGCP"
							onkeypress="return acceptNum(event);" size="30" maxlength="20"  />
							
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="<%=tituloMontoActivacion%>" />
					</td>
					<td class="StyleTextoTabla">
						<html:text name="<%=vFormulario%>" property="montoActivacion"
							onkeypress="return acceptNum(event)" size="30" maxlength="20" />
						&nbsp;&nbsp;&nbsp;
						<bean:message key="<%=tituloNumCuotas%>" />

						<html:select property="numCuotas">							
							<html:option value="01">01</html:option>
							<html:option value="03">03</html:option>
							<html:option value="04">04</html:option>
							<html:option value="05">05</html:option>
							<html:option value="06">06</html:option>
							<html:option value="07">07</html:option>
							<html:option value="08">08</html:option>
							<html:option value="09">09</html:option>
							<html:option value="10">10</html:option>
							<html:option value="11">11</html:option>
							<html:option value="12">12</html:option>
						</html:select>
					</td>

				</tr>
				<tr>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="<%=titulotarjetaCar%>" />
					</td>
					<td class="StyleTextoTabla">
						<html:text name="<%=vFormulario%>" property="numTarjetaCAR"
							onkeypress="return acceptNum(event)" size="30" maxlength="18" onkeydown="do_cft();" />
					</td>
				</tr>
				
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="activacionGcp.mes" />
					</td>
					<td class="StyleTextoTabla">
						<html:select property="mes_vencimiento" disabled="true">							
								<option value = "01">Enero</option>
		                        <option value = "02">Febrero</option>
								<option value = "03">Marzo</option>
                               	<option value = "04">Abril</option>
                               	<option value = "05">Mayo</option>
                               	<option value = "06">Junio</option>
                               	<option value = "07">Julio</option>
                               	<option value = "08">Agosto</option>
								<option value = "09">Septiembre</option>
                               	<option value = "10">Octubre</option>
                               	<option value = "11">Noviembre</option>
                               	<option value = "12">Diciembre</option>

						</html:select>
												
					</td>
				</tr>
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="activacionGcp.anio" />
					</td>
					<td class="StyleTextoTabla">
						<html:select property="anio_vencimiento" disabled="true">							
							<option value = "2008">2008</option>
							<option value = "2009">2009</option>
							<option value = "2010">2010</option>
							<option value = "2011">2011</option>
							<option value = "2012">2012</option>
							<option value = "2013">2013</option>
							<option value = "2014">2014</option>
							<option value = "2015">2015</option>
							<option value = "2016">2016</option>
							<option value = "2017">2017</option>
							<option value = "2018">2018</option>
							<option value = "2019">2019</option>
							<option value = "2020">2020</option>
							<option value = "2021">2021</option>
							<option value = "2022">2022</option>

						</html:select>
												
					</td>
				</tr>
				
				
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="StyleTextoTabla">
						<bean:message key="activacionGcp.cvv" />
					</td>
					<td class="StyleTextoTabla">
						<html:text name="<%=vFormulario%>" property="cvv"
							onkeypress="return acceptNum(event)" size="3" maxlength="3" onkeydown="do_cft();" disabled="true"  />
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
						<input type="button" name="btnActivar" value="ACTIVAR"
							onclick="do_activar();"
							STYLE="border:1px solid white; width:80px"
							onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'"
							onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					</td>
					<td align="center">
						<input type="button" name="btnLimpiar" value="LIMPIAR"
							onclick="do_limpiar();"
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

					<td align="center">
						<input type="button" name="btnDesActivar" value="ANULAR"
							onclick="do_desActivar();"
							STYLE="border:1px solid white; width:80px"
							onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'"
							onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					</td>
					
				</tr>
			</table>


			<br>
		
						
			<logic:equal name="<%=vFormulario%>" property="activacion" value="ok">
				
				<br>
				<table border="0" class="StyleTabla_75" align="center">
					<tr>
						<td class="StyleTextoTabla">
							<bean:message key="<%=titulomail%>" />
						</td>
						<tr>
				</tr>						
						<td class="StyleTextoTabla">
						
							<html:text name="<%=vFormulario%>" property="mailCliente"
								size="60" maxlength="60" />
							<input type="button" name="btnEnviarEmail" value="ENVIAR"
								onclick="do_enviarEmail();"
								STYLE="border:1px solid white; width:80px"
								onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'"
								onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
						</td>
					</tr>
				</table>
			</logic:equal>



		</html:form>
</body>

