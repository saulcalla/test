<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("cargaVentasWCForm"); %>
<% String vSend 		= new String("buscar"); %>
<% String vForm 		= new String("document.cargaVentasWCForm"); %>
<% String titulogeneral = new String("cargaVentasWC.titGeneral"); %>
<% String titulopagina 	= new String("cargaVentasWC.titPagina"); %>
<% String vaccion 		= new String("/cargaVentasWC"); %>
<% String accioninicio 	= new String("InicioCargaVentasWC"); %>
<% String btncancelar 	= new String("cargaVentasWC.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("cargaVentasWC.form1.boton.buscar"); %>
<% String parametroStockInternet 	= new String("cargaVentasWC.titfiltro1"); %>
<% String parametroDifStockBTTV = new String("cargaVentasWC.titfiltro2"); %>
<% String paramCodigo = new String("cargaVentasWC.titfiltro3"); %>


<% int 	  numcol 		= 7; %>
<script language="javascript">

	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
	var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
	var contador 				  = 0;
	var contador_checkBox_checked = 0;
	var seleccionar 			  = true;
	

	function do_buscar(filtro, lista) {
		var obj = <%=vForm%>;
		obj.accion.value 			 = "buscar";
		obj.registrosPorBloque.value = 10;
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

	function body_onload_GestionTV() {

		obj = <%=vForm%>;
		if(obj.mensaje.value!="") {
				//alert(obj.mensaje.value);
				var res = document.getElementById("resultado");
				res.innerHTML = obj.mensaje.value;
				obj.mensaje.value = "";
		}
		
	}
	
	function acceptNum(evt){
	
		var nav4 = window.Event ? true : false;
		var key = nav4 ? evt.which : evt.keyCode;	
		return (key <= 13 || (key >= 48 && key <= 57));
	
	}
   

</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
</head>
	
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
    	<td>&nbsp;</td>
		</tr>    	
    	<tr>
    	
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=paramCodigo%>"/>
			</td>
			<td class="StyleTextoTabla">
			   	<html:text name="<%=vFormulario%>" property="numOrden" onkeypress="return acceptNum(event)" size="13" maxlength="13" />  			
			</td>
			
      		
			
    	<td>&nbsp;</td>
						
			<td align="center"> 
				<input type="button" name="btn_buscar1" value="Cargar" onclick="do_buscar('filtro1','list1');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			<td align="center">
				<input type="button" name="btnLimpiar" value="Limpiar" onclick="btnLimpiar_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
		 	</td>
		 	
    	</tr>  
	<tr>
    	<td>&nbsp;</td>
		</tr>    	
	</table>
	
	
</html:form>

<div id="resultado">

</div>
</body>


