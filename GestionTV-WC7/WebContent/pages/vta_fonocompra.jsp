<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<% int idx = 0;%>
<% String vFormulario = new String("vtafonocompraForm"); %>
<% String vSend = new String("mostrar"); %>
<% String vForm = new String("document.vtafonocompraForm"); %>
<% String vAncho = new String("75%"); %>

<script language="javascript">	
	var RegporBloq = "<bean:write name="<%=vFormulario%>" property="registrosPorBloque"/>";
    var NumBolq    = "<bean:write name="<%=vFormulario%>" property="nroBloque"/>";
</script>

<html:html locale="true">
<head>
   <title><bean:message key="fonocompra.titPagina"/></title>
   <meta name="pagina"        content="pages/vta_fonocompra.jsp">
   <meta name="modificado"    content="vta_fonocompra.14Julio2006">
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
    	#procesando {position:absolute;left:400px;top=43px;width:10px;visibility:hidden} 
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
	
    function do_cerrar() {
    	var obj=<%=vForm%>;
        document.all.procesando.style.visibility = 'visible';
        obj.accion.value = "cancelar";
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
		}
	}

	function link_onclick(cbActual) {
	    var obj=<%=vForm%>;	 
		if (obj.filas.length==null){
			obj.codigo.value = obj.filas.value;
		}else{
			obj.codigo.value = obj.filas[cbActual].value;
		}
		obj.accion.value = "editar_modificar";
        document.all.procesando.style.visibility = 'visible';
	    obj.submit();
	}


</script>

<body class="Stylebody" onload="javascript:body_onload_GestionTV();">
	<html:form action="/vtafonocompra">
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

<div align="left">
	<font class="StyleHead_left"><bean:message key="fonocompra.titPagina"/></font><br>	
	<br>
	<table width="<%=vAncho%>">
	<tr>
	<td>
		<input type=button name="btn_cerrar" value="<bean:message key="fonocompra.boton.cerrar"/>" onclick="do_cerrar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
	</td>
	</tr>
	</table>

	<table  class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">#</td>
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna1"/></td>
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna2"/></td>
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna3"/></td>								
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna4"/></td>
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna5"/></td>								
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna6"/></td>
			<td class="StyleTextoTabla"><bean:message key="fonocompra.form1.columna7"/></td>
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
						<bean:write name="<%=vFormulario%>" name="elemento"/>
						</html:link>
					</td>
				</logic:equal>
				<logic:equal name="index" value="3"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="4"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="5"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="6"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="7"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>
				<logic:equal name="index" value="8"><td class="VectResultDat1"><bean:write name="elemento"/></td></logic:equal>

			</logic:iterate>
				<%idx++;%>			
		</tr>
		</logic:iterate>				
	</table>

	<logic:equal name="<%=vFormulario%>" property="hayDatos" value="si">
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

<DIV ID="procesando"> 
	<font color="#336699" size="2px" weight="normal">
	Procesando...
	</font>
	<IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar"> 
</DIV>		

</html:html>
