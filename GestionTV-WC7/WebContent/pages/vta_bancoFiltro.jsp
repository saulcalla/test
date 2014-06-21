<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<% String vFormulario = new String("bancoForm"); %>
<%  String vForm = new String("document.bancoForm");%>
<html:html locale="true"> 
<head>
   <title><bean:message key="banco.tit.general"/></title>
   <meta name="pagina"        content="pages/vta_bancofiltro.jsp">
   <meta name="modificado"    content="vta_bancofiltro.14Julio2006">
   <script language="javascript" src="pages/scripts/funciones.js"></script>
   <script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
   <script language="javascript" src="pages/scripts/calendario.js"></script>
   <script language="javascript" src="scripts/funciones.js"></script>
   <script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
   <script language="javascript" src="scripts/calendario.js"></script>
</head>
   <script language="javascript">
      function do_buscar() {
         var obj = <%=vForm%>;
         var mensaje = "";


		if(obj.nombreFiltro.value!="" || obj.paternoFiltro.value!="" || obj.maternoFiltro.value!=""){
			//paterno y materno son requeridos
	         mensajeNombre = "";
    	     mensajeNombre = valida_campo_requerido(obj.nombreFiltro.value,"<bean:message key="banco.nombres"/>","<bean:message key="errors.requerido"/>")
	         if (mensajeNombre!="") {
    	        alert(mensajeNombre);
	            document.bancoForm.nombreFiltro.focus();
            	return;
         	}

	         mensajePaterno = "";
    	     mensajePaterno = valida_campo_requerido(obj.paternoFiltro.value,"<bean:message key="banco.paterno"/>","<bean:message key="errors.requerido"/>")
	         if (mensajePaterno!="") {
    	        alert(mensajePaterno);
	            document.bancoForm.paternoFiltro.focus();
            	return;
         	}
	         mensajeMaterno = "";
    	     mensajeMaterno = valida_campo_requerido(obj.maternoFiltro.value,"<bean:message key="banco.materno"/>","<bean:message key="errors.requerido"/>")
	         if (mensajeMaterno!="") {
    	        alert(mensajeMaterno);
	            document.bancoForm.maternoFiltro.focus();
            	return;
         	}
		}

		if(obj.rutFiltro.value!=""){
			obj.tipoFiltro.value="1";
		}
		else if (obj.nombreFiltro.value!="" || obj.paternoFiltro.value!="" || obj.maternoFiltro.value!=""){
			obj.tipoFiltro.value="2";
		}
		else if (obj.creditoFiltro.value!=""){
			obj.tipoFiltro.value="3";
		}
		else if (obj.fechaFiltro.value!=""){
			obj.tipoFiltro.value="4";
		}
		else{
			//filtro solo estado
			obj.tipoFiltro.value="0";
		}

         if(validaFecha()){	
			var valueestado = obj.selectEstadoFiltro.options[obj.selectEstadoFiltro.selectedIndex].value;
	   	    obj.codEstadoFiltro.value = valueestado;
	         obj.accion.value = "buscar";
	         obj.submit();
         }else{
			alert("Fecha fuera de rango");
		}	
      }
      function boton_enter(e, instruccionEnter, instruccionEscape ) {
         // e: event
         var tecla;		
         if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;
         if( tecla == 13)eval( instruccionEnter  );		
         if( tecla == 27)eval( instruccionEscape );	
         return(true);
      }
      function do_cerrar() {
         var obj = <%=vForm%>;
         obj.accion.value = "cancelar";
         obj.submit();
      }
      function foco() {
         window.document.bancoForm.rutFiltro.focus();
      }	
      
 //****Valida que día corresponda al mes
	function validaFecha(){
	var obj = <%=vForm%>;
	
	var fIni = obj.fechaFiltro.value;
	var arrIni = fIni.split("/");
	var dia = arrIni[1];
	var mes = arrIni[0];
					
		if(dia==02 && mes>28){
			return false;
		}else if(dia==01 && mes>31){
			return false;
		}else if(dia==03 && mes>31){
			return false;
		}else if(dia==04 && mes>30){
			return false;
		}else if(dia==05 && mes>31){
			return false;
		}else if(dia==06 && mes>30){
			return false;
		}else if(dia==07 && mes>31){
			return false;
		}else if(dia==08 && mes>31){
			return false;
		}else if(dia==09 && mes>30){
			return false;
		}else if(dia==10 && mes>31){
			return false;
		}else if(dia==11 && mes>30){
			return false;
		}else if(dia==12 && mes>31){
			return false;
		}else{
			return true;
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
<body class="Stylebody" onload="foco();">
   <div align="left">
   <h3><font class="StyleHead_left">
      <bean:message key="banco.titPagina"/>
   </font></h3>
   <html:form action="/banco">
   <html:hidden property="accion" value=""/>	
   <html:hidden property="tipoFiltro" value=""/>	
   <input type="hidden" name="codEstadoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="codEstadoFiltro"/>'>
   <input type="hidden" name="glosaEstadoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="glosaEstadoFiltro"/>'>	

      <table class="StyleTabla_75">
         <tr>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.rut"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="rutFiltro" size="10" maxlength="10" onkeypress="return valida_caracteres(event,digits);"/>
				<html:text property="dvFiltro" size="1" maxlength="1" onkeypress="return valida_caracteres(event,LDV);" onblur="validar_rut(rutFiltro,dvFiltro,mensaje);"/>
			</td>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.nombres"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="nombreFiltro" size="10" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>							
		 </tr>
         <tr>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.paterno"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="paternoFiltro" size="10" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.materno"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="maternoFiltro" size="10" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>							
		 </tr>
         <tr>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.credito"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="creditoFiltro" size="10" maxlength="10" onkeypress="return valida_caracteres(event,digits);"/>
			</td>							

            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.fecha"/>
            </td>		
			<td  class="StyleTextoTabla" colspan="2" width="30%">								
			   <html:text property="fechaFiltro"  size="10" maxlength="10" onblur="ValidaFecha(this)"/>
			  <img src="pages/images/cal.gif" border="0" alt="Calendario" style="cursor: hand;" onclick="goWindowPopupCalendario('bancoForm','fechaFiltro');">
			</td>							
		 </tr>
         <tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.estado"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:select property="selectEstadoFiltro">
   				<html:optionsCollection name="<%=vFormulario%>" property="collEstadoFiltro"/>        			
   	  			</html:select>
			</td>
		 </tr>
      </table>
      </br>
	  <input type=button name="btn_buscar" value="<bean:message key="banco.boton.buscar"/>" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
	  <input type=button name="btn_cerrar" value="<bean:message key="banco.boton.cerrar"/>" onclick="do_cerrar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
   </html:form>

	<script language="javascript">
	    var obj=<%=vForm%>;
		<logic:notEqual name="<%=vFormulario%>" property="collEstadoFiltro" value="[]">	
			Selected(obj.selectEstadoFiltro,obj.codEstadoFiltro.value);
		</logic:notEqual>
	</script>

   </div>
<logic:notEqual name="bancoForm" property="mensaje" value="">
	<script>
		alert("<bean:write name="bancoForm" property="mensaje"/>");		
	</script>
</logic:notEqual>
<!-------- Parametros para el calendario ------------------------ -->
	<form name="formularioPadre" method="post" action="">
	  <input type="hidden" name="txtNameFormulario"  value="">
	  <input type="hidden" name="txtNameObjetoText"  value="">
	</form>
<!-------- Fin de paramtros del calendario -------------------- -->
</body>
</html:html>
