<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("refinanciacionForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.refinanciacionForm"); %>
<% String titulogeneral = new String("refinanciacion.titGeneral"); %>
<% String titulopagina 	= new String("refinanciacion.titPagina"); %>
<% String vaccion 		= new String("/refinanciacion"); %>
<% String accioninicio 	= new String("InicioRefinanciacion"); %>
<% String vcolumna 		= new String("refinanciacion.form1.campo"); %>
<% String btncancelar 	= new String("refinanciacion.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("refinanciacion.form1.boton.buscar"); %>
<% String parametro 	= new String("refinanciacion.titfecha"); %>
<% String horario_param	= new String("refinanciacion.tithorario"); %>

<% String paramfiltro 	= new String("fec_inicio"); %>
<% int numcol = 5; %>
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
	var obj = <%=vForm%>;
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
		
		if (obj.<%=paramfiltro%>.value == "") {
			alert("No se admiten campos vacios");
			return(true);
		}
		return(false);
	}

	function do_buscar() {
		var obj = <%=vForm%>;
		
		if (validaCampoNulo()) {
			return;
		}
		obj.indice.value 			 = "0";
		obj.registrosPorBloque.value = K_REGISTROS_POR_PAGINA;
		obj.nroBloque.value 		 = "1";
  		obj.accion.value 			 = "buscar";
		obj.submit();	  	
	}

	function btnLimpiar_onclick(){
		var obj = <%=vFormulario%>;
		
		obj.accion.value = "<%=accioninicio%>";
		obj.submit();	
	}
	
	function do_cancelar() {
		var obj = <%=vFormulario%>;
		
		obj.accion.value = "cancelar";
		obj.submit();		
	}

	function body_onload_GestionTV() {

		window.history.forward(1);
		obj = <%=vForm%>;
		obj.fec_inicio.focus();
		var temp = "<bean:write name="<%=vFormulario%>" property="hayDatos"/>"
		//var temp = "<bean:write name="<%=vFormulario%>" property="hayDatosExportar"/>"

		if (temp == "si") {
			setItemSelect(obj);
			setDisabled_btnPage(true , obj);

			K_REGISTROS_POR_PAGINA        = obj.registrosPorBloque.value;
			obj.btn_buscar.disabled       = true;
			obj.horario.disabled       = true;
			obj.<%=paramfiltro%>.disabled = true;

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
<!-- INI -- RC & PP -- 26/10/2004 -->

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
    			<html:text name="<%=vFormulario%>" property="<%=paramfiltro%>" size="10" maxlength="10" onkeypress="return valida_caracteres(event,lista);" onblur="ValidaFecha(this)" />
		        <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('refinanciacionForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    		</td>
						
    	</tr>
    	<tr>
    	</tr>
    	
    	<tr>
			<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=horario_param%>"/>
			</td>

			<td class="StyleTextoTabla">
				<html:select property="horario">
   				<html:option value="0">TODAS</html:option>
   				<html:option value="MANANA">MAÑANA</html:option>
   				<html:option value="TARDE">TARDE</html:option>
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
	</table>
<!-- INI -- RC & PP -- 26/10/2004 -->
	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
	<%@ include file="registrosPorPagina.txt" %>
<!-- END -- RC & PP -- 26/10/2004 -->	
	<table border="0"class="StyleTabla_BT_TV" align="center" > 
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
		<logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles">
			<tr> 
				<logic:iterate id="elemento" name="campos" indexId="index">
					<td class="VectResultDat1"><font class="VectResultDat1"><bean:write name="elemento"/></font></td>
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
	
   </td>
   </tr>
   </table>


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

