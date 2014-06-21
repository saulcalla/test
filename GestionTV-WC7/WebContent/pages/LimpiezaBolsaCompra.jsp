<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- INI -- RC & PP -- 26/10/2004 -->
<%@ page isThreadSafe	= "true"%>
<% String vFormulario 	= new String("limpiezaBolsaCompraForm"); %>
<% String vSend 		= new String("limpiar"); %>
<% String vForm 		= new String("document.limpiezaBolsaCompraForm"); %>
<% String titulogeneral = new String("limpiezaBolsaCompra.titGeneral"); %>
<% String titulopagina 	= new String("limpiezaBolsaCompra.titPagina"); %>
<% String vaccion 		= new String("/limpiezaBolsaCompra"); %>
<% String accioninicio 	= new String("InicioLimpiezaBolsaCompra"); %>
<% String btncancelar 	= new String("limpiezaBolsaCompra.form1.boton.cancelar"); %>
<% String btnbuscar 	= new String("limpiezaBolsaCompra.form1.boton.buscar"); %>
<% String parametroStockInternet 	= new String("limpiezaBolsaCompra.titfiltro1"); %>
<% String parametroDifStockBTTV = new String("limpiezaBolsaCompra.titfiltro2"); %>
<% String paramCodigo = new String("limpiezaBolsaCompra.titfiltro3"); %>



<!-- END -- RC & PP -- 26/10/2004 -->

<script language="javascript">

	
	function validaCampoNulo() {
			return(false);
	}

	function do_buscar(filtro, lista) {
		var obj = <%=vForm%>;
		
		var v_rut = obj.rut.value;
		var indr = v_rut.indexOf('-');
		var indp = v_rut.indexOf('.');
		var largo = v_rut.length;
		if (indr >= 0 || indp >= 0) {
			alert("Debe ingresar rut sin puntos y sin guion (123456789)")
			return false;			
		}
				
		
  		obj.accion.value 			 = "limpiar";
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
		window.history.forward(1);
		obj = <%=vForm%>;
		
		if(obj.mensaje.value!="") {
			alert(obj.mensaje.value);				
			obj.mensaje.value = "";			
		}
	}  

</script>
<head>
	<title><bean:message key="<%=titulogeneral%>"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
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
  	<html:hidden property="accion" value="limpiar"/>
  	<html:hidden property="vctExpHead" value=""/>
	<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>

<%
	int idx = 1;
%>
<!-- END -- RC & PP -- 26/10/2004 -->
  	<table width="30%" align="center" class="StyleTabla_75">
    	<tr>
		</tr>    	
    	<tr>
    	
    	<td>&nbsp;</td>
			<td class="StyleTextoTabla">
				<bean:message key="<%=paramCodigo%>"/>
			</td>
			<td align="center" class="StyleTextoTabla">
			   	<html:text name="<%=vFormulario%>" property="rut" size="9" maxlength="9" />  			
			</td>
			<td align="left"> 
				<input type="button" name="btn_buscar1" value="LIMPIAR" onclick="do_buscar('filtro1','list1');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">  	
			</td>    		
			
    	</tr>  
    	<tr><td>&nbsp;</td></tr>
    	    	

	</table>
	
	
</html:form>
<!-------- Parametros para el calendario ---------------------- -->
<form name="formularioPadre" method="post" action="">
	<input type="hidden" name="txtNameFormulario" value="">
	<input type="hidden" name="txtNameObjetoText" value="">
</form>
<!-------- Fin de paramtros del calendario -------------------- -->    		
</body>


