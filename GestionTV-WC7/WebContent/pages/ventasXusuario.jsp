<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("ventasXusuarioForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.ventasXusuarioForm"); %>
<% String titulogeneral = new String("ventasXusuario.titGeneral"); %>
<% String titulopagina 	= new String("ventasXusuario.titPagina"); %>
<% String vaccion 		= new String("/ventasXusuario"); %>
<% String accioninicio 	= new String("InicioVentasXusuario"); %>
<% String vcolumna 		= new String("ventasXusuario.form1.campo"); %>
<% String btncancelar 	= new String("ventasXusuario.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("ventasXusuario.form1.boton.buscar"); %>
<% String parametro 	= new String("ventasXusuario.titfecha"); %>
<% String parametroEjecutivo 	= new String("ventasXusuario.titSelectEjecutivo"); %>
<% String paramfiltro 	= new String("fec_inicio"); %>
<% int 	  numcol 		= 13; 
  int cont = 0;
	%>
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
	var obj = document.ventasXusuarioForm;
	obj.vctExpHead.value = "[[";
	 <%for(int i=1;i<=numcol-1;i++){ 
	 	String tempo= new String(vcolumna+i);%>	
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
		
		if(obj.<%=paramfiltro%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
		}
		return(false);
	}

	function do_buscar() {
		var obj = <%=vForm%>;
		
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


	function cbCodigo_onclick( ) {
	    var obj=<%=vForm%>;
	    
		alert(obj.ventas.value);
	}
	
	function body_onload_GestionTV() {
		window.history.forward(1);
		obj = <%=vForm%>;
		obj.fec_inicio.focus();
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
		var resp = "<bean:write name="<%=vFormulario%>" property="respuesta"/>"
		
		if (resp != "") {
			alert(resp);
			//btnLimpiar_onclick();
		}
		
		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);
			
			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.<%=paramfiltro%>.disabled = true;
			obj.selectEjecutivoFiltro.disabled = true;
			obj.BtnFecha.disabled = true;
			
			
			
			
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

   function Selected(selectN,valor) {
      for(i=0;i<selectN.length;i++) {
         if (selectN.options[i].value==valor) {
            selectN.options[i].selected= true;
			break;
         }
      }
   }
   
	
	function btnActualizar_onclick() {
		var obj = <%=vForm%>;
		var ventas = new Array();
		var cont = 0;

		// verifico que existan registros 'marcados' para actualizar
		
		for(var n=0;n<obj.check.length;n++) {
				if (obj.check[n].checked == true && obj.check[n].disabled == false) {
					ventas[cont] = obj.check[n].value;
					cont++;
				}			
		}
		
		if (ventas.length == 0) {
			alert("Debe seleccionar un registro antes de actualizar")
			return false;
		}
		
		obj.indice.value 			 = "0";
		obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
		obj.nroBloque.value 		 = "1";	
		obj.ventasTC.value 			 =  ventas;
		obj.accion.value 			 = "actualizar";		
		obj.submit();	  	
		
		
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
	<html:hidden property="flagDatosBD"/>
	<html:hidden property="totalPaginas"/>	
	<input type="hidden" name="contador"           value='<bean:write name="<%=vFormulario%>" property="contador"/>'>
	<input type="hidden" name="indice"             value='<bean:write name="<%=vFormulario%>" property="indice" />' >
	<input type="hidden" name="registrosPorBloque" value='<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>'>
	<input type="hidden" name="nroBloque"          value='<bean:write name="<%=vFormulario%>" property="nroBloque"/>'>
	<input type="hidden" name="hayProximoBloque"   value='<bean:write name="<%=vFormulario%>" property="hayProximoBloque"/>'>
	<input type="hidden" name="ventasTC" 		   value='<bean:write name="<%=vFormulario%>" property="ventasTC"/>'>
	<input type="hidden" name="respuesta" 		   value='<bean:write name="<%=vFormulario%>" property="respuesta"/>'>

<%
	int idx = 1;
%>
<!-- END -- RC & PP -- 26/10/2004 -->
  	<table width="30%" align="center" class="StyleTabla_75">
    	<tr>
		</tr>    	
    	<tr>
    	</tr>    	
  		<tr> 
			<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametro%>"/>
			</td>
   			<td class="StyleTextoTabla">
   	  			<html:text name="<%=vFormulario%>" property="<%=paramfiltro%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)"/>
   		        <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('ventasXusuarioForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>
			
				
			<td align="right"> 
				<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="center">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
		 	
		 	
		 	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="no">
			<td align="left">
				<input type="button" name="btnActualizar" value="Actualizar" onclick="btnActualizar_onclick();" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
			</logic:equal>
			
			<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
			<td align="left">
				<input type="button" name="btnActualizar" value="Actualizar" onclick="btnActualizar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
			</logic:equal>	 	
    	</tr>
    	
    	<tr> 
    	<tr>
    	</tr> 
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=parametroEjecutivo%>"/>
			</td>
			
    	<td class="StyleTextoTabla">
			<html:select property="selectEjecutivoFiltro">
   				<html:optionsCollection name="<%=vFormulario%>" property="collEjecutivoFiltro"/>        			
   	  		</html:select>
		</td>
    	</tr>
    	<tr>
    	</tr>    	
    	<tr>
    	</tr>    	

	</table>
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPagina.txt" %>
<!-- END -- RC & PP -- 26/10/2004 -->	
	<table border="0"class="StyleTextoTabla" align="center" > 
		<tr>

<%
			for (int i = 1; i <= numcol; i++) {
				String temp = new String(vcolumna + i);
%>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="<%=temp%>"/></font></td>	 

<%
		}
%>
		</tr>
		
		
		<logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles" indexId="ind">
		<tr> 

			<logic:iterate id="elemento" name="campos" indexId="index">

					<!-- Si es el primer registro, genero el checkBox -->
					<logic:equal name="index" value="0">
					
					<td align="center">
					<logic:equal name="elemento" value="T">
						<input type="checkbox" id="check" disabled checked="checked" name="check" value=""/>
					</logic:equal>
					
					<logic:notEqual name="elemento" value="T">
						<input type="checkbox" id="check" name="check" value='<bean:write name="elemento"/>'/>
					</logic:notEqual>
					
					
					
					</td>
					
					</logic:equal>
					
					<logic:greaterThan name="index" value="0">
						<td class="VectResultDat1" align="center"><font class="VectResultDat1"><bean:write name="elemento"/></font></td>				 
					</logic:greaterThan>
					
			</logic:iterate>
			
		</tr>

		</logic:iterate>
		
  	</table>
	</logic:equal>
	<br>
  <table border="0" class="StyleTabla_75" align="center">
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

