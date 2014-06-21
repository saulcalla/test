<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<% int idx = 0;%>
<% String vFormulario = new String("bancoForm"); %>
<% String vSend = new String("mostrarAdm"); %>
<% String vForm = new String("document.bancoForm"); %>
<% String vAncho = new String("75%"); %>

<script language="javascript">	
	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
    var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
</script>

<html:html locale="true">
<head>
   <title><bean:message key="banco.adm.tit.general"/></title>
   <meta name="pagina"        content="pages/vta_adm.jsp">
   <meta name="modificado"    content="vta_adm.14Julio2006">
   <script language="javascript" src="pages/scripts/funciones.js"></script>
   	<script language="javascript" src="scripts/funciones.js"></script>
   <script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
   <script language="javascript">	
      var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
      var NumBolq = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
   </script>
   <script language="javascript" src="pages/scripts/paginacion.js"></script>
   <script language="javascript" src="scripts/paginacion.js"></script>
   

	<style type="text/css"> 
    	#procesando {position:absolute;left:400px;top=13px;width:10px;visibility:hidden} 
	</style> 


</head>

	<logic:messagesPresent>
    <bean:message key="errors.header"/>
    <ul>
    <html:messages id="error">
      <li><bean:write name="error"/></li>
    </html:messages>
    </ul><hr>
	</logic:messagesPresent>	

<script language="javascript">
var contador = 0;
	
      function do_buscar() {
         var obj = <%=vForm%>;
         var mensaje = "";

		var valueejecutivo = obj.selectEjecutivoFiltro.options[obj.selectEjecutivoFiltro.selectedIndex].value;
			
		if(obj.rutFiltro.value!="" || obj.dvFiltro.value!=""){
			if(obj.dvFiltro.value!="" && obj.rutFiltro.value!="" ){
				obj.tipoFiltro.value="1";
				var cx=validar_rut(obj.rutFiltro,obj.dvFiltro,mensaje)
				if(cx==true){
					obj.tipoFiltro.value="1";
				}else{
					return;
				}
			}else{
				alert("Debe ingresar RUT y DV");
				return;
			}	
		}
		else if (obj.creditoFiltro.value!=""){
			obj.tipoFiltro.value="3";
		}
		else if (obj.fechaFiltro.value!=""){
			obj.tipoFiltro.value="4";
		}
		//ejecutivo=0 (TODOS)
		else if (valueejecutivo!="0"){
			obj.tipoFiltro.value="5";
		}
		else{
			//filtro solo estado
			obj.tipoFiltro.value="0";
		}
			
        if(validaFecha()){	
			var valueestado = obj.selectEstadoFiltro.options[obj.selectEstadoFiltro.selectedIndex].value;
	   	    obj.codEstadoFiltro.value = valueestado;
	   	    obj.codEjecutivoFiltro.value = valueejecutivo;
	        obj.accion.value = "buscarAdm";
	        obj.submit();
         }else{
			alert("Fecha fuera de rango");
		}	
	}



    function do_cerrar() {
    	var obj=<%=vForm%>;
        document.all.procesando.style.visibility = 'visible';
        obj.accion.value = "cancelar";
        obj.submit();
    }

	function link_onclick(cbActual) {
	    var obj=<%=vForm%>;	 
		if (obj.filas.length==null){
			obj.codigo.value = obj.filas.value;
		}else{
			obj.codigo.value = obj.filas[cbActual].value;
		}
		obj.accion.value = "editar_modificar_adm";
        document.all.procesando.style.visibility = 'visible';
	    obj.submit();
	}


	function do_limpiar() {
    	var obj=<%=vForm%>;
        document.all.procesando.style.visibility = 'visible';
        obj.accion.value = "InicioAdm";
        obj.submit();
    }

	function body_onload_GestionTV() {
	    var obj=<%=vForm%>;	 
		if ("<bean:write name="<%=vFormulario%>" property="flagDatosBD"/>" == "no") {
			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}
	
		if ("<bean:write name="<%=vFormulario%>" property="hayDatos"/>" == "si") {
			setItemSelect(obj);
			setButton();
			obj.rutFiltro.disabled=true;
			obj.dvFiltro.disabled=true;
			obj.nombreFiltro.disabled=true;
			obj.paternoFiltro.disabled=true;
			obj.maternoFiltro.disabled=true;
			obj.creditoFiltro.disabled=true;
			obj.fechaFiltro.disabled=true;
			obj.selectEstadoFiltro.disabled=true;
			obj.selectEjecutivoFiltro.disabled=true;			

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


</script>

<body class="Stylebody" onload="javascript:body_onload_GestionTV();">
	<html:form action="/banco">
	<html:hidden property="accion" value=""/>
	<html:hidden property="codigo" value=""/>
	<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>
	<html:hidden property="totalRegistros"/>
	<html:hidden property="flagDatosBD"/>
	<html:hidden property="totalPaginas"/>	
	<input type="hidden" name="contador"           value='<bean:write name="<%=vFormulario%>" property="contador"/>'>
	<input type="hidden" name="indice"             value='<bean:write name="<%=vFormulario%>" property="indice" />' >
	<input type="hidden" name="registrosPorBloque" value='<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>'>
	<input type="hidden" name="nroBloque"          value='<bean:write name="<%=vFormulario%>" property="nroBloque"/>'>
	<input type="hidden" name="hayProximoBloque"   value='<bean:write name="<%=vFormulario%>" property="hayProximoBloque"/>'>

	<input type="hidden" name="tipoFiltro"           value='<bean:write name="<%=vFormulario%>" property="tipoFiltro"/>'>
    <input type="hidden" name="codEstadoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="codEstadoFiltro"/>'>
    <input type="hidden" name="glosaEstadoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="glosaEstadoFiltro"/>'>	
    <input type="hidden" name="codEjecutivoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="codEjecutivoFiltro"/>'>
    <input type="hidden" name="glosaEjecutivoFiltro" 	value='<bean:write name="<%=vFormulario%>" property="glosaEjecutivoFiltro"/>'>	


<div align="left">
	<font class="StyleHead_left"><bean:message key="banco.adm.titPagina"/></font><br>	
	<br>
      <table class="StyleTabla_75">
         <tr>
            <td  class="StyleTextoTabla" width="20%">
            	<bean:message key="banco.rut"/>
            </td>		
			<td  class="StyleTextoTabla" width="30%">								
				<html:text property="rutFiltro" size="10" maxlength="10" onkeypress="return valida_caracteres(event,digits);" />
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
			<td class="StyleTextoTabla">
				<bean:message key="banco.ejecutivo"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:select property="selectEjecutivoFiltro">
   				<html:optionsCollection name="<%=vFormulario%>" property="collEjecutivoFiltro"/>
   	  			</html:select>
			</td>

		 </tr>
	
      </table>

	<br>
	<table width="<%=vAncho%>">
	<tr>
	<td>
    	<input type=button name="btn_buscar" value="<bean:message key="banco.boton.buscar"/>" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
    	<input type=button name="btn_limpiar" value="<bean:message key="banco.boton.limpiar"/>" onclick="do_limpiar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
		<input type=button name="btn_cerrar" value="<bean:message key="banco.boton.cerrar"/>" onclick="do_cerrar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
	</td>
	</tr>
	</table>

	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<table  class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">#</td>
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna1"/></td>
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna2"/></td>								
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna3"/></td>
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna4"/></td>								
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna5"/></td>
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna6"/></td>								
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna7"/></td>
			<td class="StyleTextoTabla"><bean:message key="banco.form1.columna8"/></td>			
		</tr>
		<logic:iterate id="campos" name="<%=vFormulario%>" property="vctTabla">
	 	<tr>
	  		<logic:iterate id="elemento" name="campos" indexId="index">
				<logic:equal name="index" value="0"><td class="VectResultDat1_centro"><bean:write name="elemento"/></td></logic:equal>
				
				<logic:equal name="index" value="1">
		         		<input type="hidden" name="filas" value='<bean:write name="elemento"/>'>           
				</logic:equal>
				<logic:equal name="index" value="2">
					<td class="VectResultDat1" >
						<html:link href="#" onclick="link_onclick(<%=idx%>);" >
						<bean:write name="elemento"/>
						</html:link>
					</td>
				</logic:equal>
				

				<logic:equal name="index" value="3"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="4"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="5"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="6"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="7"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="8"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="9"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>			
			</logic:iterate>
			<%idx++;%>			
		</tr>
		</logic:iterate>				
	</table>
		<%@ include file="registrosPorPagina.txt" %>
		<%@ include file="paginacion.txt" %>
	</logic:equal>
	<br>	
</div>
</html:form>
</body>

<logic:notEqual name="<%=vFormulario%>" property="mensaje" value="">
	<script>
		alert("<bean:write name="<%=vFormulario%>" property="mensaje"/>");		
	</script>
</logic:notEqual>
<logic:notEqual name="<%=vFormulario%>" property="collEstadoFiltro" value="[]">	
	<script>
	var obj=<%=vForm%>;
	Selected(obj.selectEstadoFiltro,obj.codEstadoFiltro.value);
	</script>
</logic:notEqual>
<logic:notEqual name="<%=vFormulario%>" property="collEjecutivoFiltro" value="[]">	
	<script>
	var obj=<%=vForm%>;
	Selected(obj.selectEjecutivoFiltro,obj.codEjecutivoFiltro.value);
	</script>
</logic:notEqual>

	<form name="formularioPadre" method="post" action="">
	  <input type="hidden" name="txtNameFormulario"  value="">
	  <input type="hidden" name="txtNameObjetoText"  value="">
	</form>


<DIV ID="procesando"> 
	<font color="#336699" size="2px" weight="normal">
	Procesando...
	</font>
	<IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar"> 
</DIV>		

</html:html>
