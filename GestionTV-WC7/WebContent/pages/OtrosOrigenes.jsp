<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<% String vForm			= new String("document.otrosOrigenesForm");%>
<% String vFormulario	= new String("otrosOrigenesForm"); %>
<% int numcol			= 21;%>
<% String vcolumna		= new String("otrosOrigenes.col");%>
<% String param1		= new String("otrosOrigenes.fec_inicio"); %>
<% String accioninicio	= new String("InicioOtrosOrigenes"); %>


<html>
	<head>
		<title><bean:message key="otrosOrigenes.titGeneral"/></title>
		<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
		<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
		<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
  		<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
  		<script language="javascript" src="scripts/calendario.js"></script>
  		<script language="javascript" src="pages/scripts/calendario.js"></script>
  		<script language="javascript" src="pages/scripts/funciones.js"></script>
  		<script language="javascript" src="scripts/funciones.js"></script>
		
		<script language="javascript">	

			lista="0123456789/";
			
			function do_Imprimir(){
				var wurl      = "pages/OtrosOrigenes_Imp.jsp";
			    var wname     = "Informe";
				var wleft     = "left=250";
				var wtop      = "top=200";
				var wtoolbar  = "toolbar=no";
				var wlocation = "location=0";
				var wdir      = "directories=no";
				var wstatus   = "status=no";
				var wmenubar  = "menubar=0";
				var wscroll   = "scrollbars=no";
				var wresize   = "resizable=no";
				var wwidth    = "width=350";
				var wheight   = "height=200";
				ventana = window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
			}
			function do_Exportar(){
				var obj = <%=vForm%>;
				obj.vctExpHead.value = "[[";
				 <%for(int j=1;j<=numcol-1;j++){ 
				 	String tempo= new String(vcolumna+j);%>	
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
				if (obj.fec_inicio.value == "") {
					alert("No se admiten campos vacios");
					obj.fec_inicio.focus();
					return(true);
				}
				else{
					if (obj.fec_final.value == "") {
						alert("No se admiten campos vacios");
						obj.fec_final.focus();
						return(true);
					}
				}
				return(false);
			}
			function validaMayor(){
				var obj = <%=vForm%>;
				var fec_inicio = parseInt(obj.fec_inicio.value.substr(6,4)+obj.fec_inicio.value.substr(3,2)+obj.fec_inicio.value.substr(0,2),10);
			    var fec_fin    = parseInt(obj.fec_final.value.substr(6,4)+obj.fec_final.value.substr(3,2)+obj.fec_final.value.substr(0,2),10);
	    		if (fec_inicio > fec_fin) {
	   		    	alert ("Fecha Fin debe ser mayor o igual a Fecha Inicio");
	   		    	obj.fec_inicio.focus();
	       			return(true);
				}
				return(false);				
			}
			function validaAdministrador() {
				var obj = <%=vForm%>;
				if('<bean:write name="<%=vFormulario%>" property="accesoRangos"/>' == "NO") {
					var mesIni=(parseInt(obj.fec_inicio.value.substr(3,2),10));
					var mesFin=(parseInt(obj.fec_final.value.substr(3,2),10));
					var anoIni=(parseInt(obj.fec_inicio.value.substr(6,4),10));
					var anoFin=(parseInt(obj.fec_final.value.substr(6,4),10));
				
					if( (mesIni != mesFin) || (anoIni != anoFin)){
						alert("Perfil no autorizado, para consultar información en diferentes meses");
						return(true);
					}
				}
				else{
					if('<bean:write name="<%=vFormulario%>" property="accesoRangos"/>' == "SI") {
						return(false);
					}
				}
				return(false);
			}
			function do_Buscar() {
				var obj = <%=vForm%>;
				if (validaCampoNulo()) {
					return;
				}
				if (validaMayor()) {
					return;
				}
				if( validaAdministrador()){
					return;
				}
				obj.accion.value 	 = "buscar";
				obj.submit();	  	
			}
			function do_Cancelar() {
				var obj = <%=vForm%>;
				obj.accion.value = "cancelar";
				obj.submit();		
			}
			function do_Limpiar() {
				var obj = <%=vForm%>;
				obj.accion.value 	 = "InicioOtrosOrigenes";
				obj.submit();	  	
			}	
			function body_onload_GestionTV() {
				var obj = <%=vForm%>;
				if ('<bean:write name="<%=vFormulario%>" property="hayDatos"/>' == "") {
					obj.fec_inicio.focus();
				}
				if ('<bean:write name="<%=vFormulario%>" property="hayDatos"/>' == "no") {
					alert("No hay Datos con Parametros Ingresados");
					obj.hayDatos.value = "si";
				}
				if ('<bean:write name="<%=vFormulario%>" property="hayDatosExportar"/>' == "si"){
					if(obj.mensaje.value!=""){
						if(obj.mensaje.value == "Error al Exportar"){
							alert(obj.mensaje.value);
						}
						else{			
							var wleft     = "left=1100";
	    					var wname     = "Excel";
				   	    	var wwidth    = "width=1";
				    		var wheight   = "height=1";
							window.open(obj.exportFile.value,wname,wleft+","+wwidth+","+wheight);				
						}
						obj.mensaje.value = "";
					}		
				}
			}
		</script>	
	</head>
	<body class="Stylebody" onload="body_onload_GestionTV();">
		<div align="center">
	  		<font class="StyleHead_left"><bean:message key="otrosOrigenes.titGeneral"/></font>
			<html:form action="/otrosOrigenes">
		  		<html:hidden property="accion" value="buscar"/>
		  		<input type="hidden" name="accesoRangos"	value='<bean:write name="otrosOrigenesForm" property="accesoRangos"/>'>
		  		<input type="hidden" name="hayDatos"	value='<bean:write name="otrosOrigenesForm" property="hayDatos"/>'>
		  		<html:hidden property="exportFile" /> 
				<html:hidden property="vctExpHead" value=""/>
				<input type="hidden" name="mensaje"	value='<bean:write name="otrosOrigenesForm" property="mensaje"/>'>
				
	  			<table border="0" class="StyleTabla_75" align="center">
					<tr>
			   			<td>
			   				<font class="StyleTextoTabla"><bean:message key="otrosOrigenes.fec_inicio"/></font>
			   			</td>	
			   			<td>
			   			    <html:text property="fec_inicio" size="10" maxlength="10" onkeypress="return valida_caracteres(event,Lis_fecha);" onblur="ValidaFecha(this)"/>
						    <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('otrosOrigenesForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					    </td> 
					    <td>
					    			    	
					    	<logic:equal name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="btn_buscar" value="Buscar" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:equal>		
							<logic:notEqual name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="btn_buscar" value="Buscar" onclick="do_Buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:notEqual>
					    	
					    	
					    </td> 
	  				</tr>
					<tr>
						<td>
	  						<font class="StyleTextoTabla"><bean:message key="otrosOrigenes.fec_final"/></font>
	  					</td>
	  					<td>	
	  						<html:text property="fec_final" size="10" maxlength="10" onkeypress="return valida_caracteres(event,Lis_fecha);" onblur="ValidaFecha(this)"/>
						    <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('otrosOrigenesForm','fec_final');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	  					</td>
	  				    <td>
					    	<input type="button" name="btn_Limpiar" value="Limpiar" onclick="do_Limpiar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
					    </td> 
	  				</tr>	
				</table>	
		  		
		  		<br>
		  		
		  		<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
					<table border="0"class="StyleTabla_75" align="center" > 
						<tr>
	<%						for (int i = 1; i <= numcol; i++) {        %>
	<%							String temp = new String(vcolumna + i);%>
							<td align="center"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 
	<%						}%>
						</tr>
						<logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles">
							<tr> 
								<logic:iterate id="elemento" name="campos" indexId="index">
									<logic:equal name="index" value="0">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="1">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="2">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="3">
										<td class="VctResultDato_Char"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="4">
										<td class="VctResultDato_Char"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="5">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="6">
										<td class="VctResultDato_Char"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="7">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="8">
										<td class="VctResultDato_Char"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="9">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="10">
										<td class="VctResultDato_Char"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="11">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="12">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="13">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="14">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="15">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="16">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="17">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="18">
										<td class="VctResultDato_Numerico"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="19">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									<logic:equal name="index" value="20">
										<td class="VctResultDato_Normal"><bean:write name="elemento"/></td>
									</logic:equal>
									
								</logic:iterate>
							</tr>
						</logic:iterate>
	  				</table>
	  				<br>
				</logic:equal>
		  				  		
  				<table border="0" class="StyleTabla_75" align="center">
					<tr>
						<td align="center">
							<input type="button" name="btnCerrar" value="Cancelar" onclick="do_Cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							
							<logic:equal name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="BtnImprimir" value="Imprimir" onclick="do_Imprimir();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:equal>		
							<logic:notEqual name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="BtnImprimir" value="Imprimir" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:notEqual>
							
							
				        	<logic:equal name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="btnExportar" value="Exportar"  onclick="do_Exportar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:equal>		
							<logic:notEqual name="otrosOrigenesForm" property="hayDatos" value="si">
								<input type="button" name="btnExportar" value="Exportar"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
							</logic:notEqual>

					   </td>	
				   </tr>
				</table>
		  			
		  	
			</html:form>
		<!-------- Parametros para el calendario ------------------------ -->
			<form name="formularioPadre" method="post" action="">
				<input type="hidden" name="txtNameFormulario" value="">
				<input type="hidden" name="txtNameObjetoText" value="">
			</form>
		<!-------- Fin de paramtros del calendario -------------------- -->				
		</div>	
	</body>
</html>