<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<% String vFormulario = new String("bundlesForm"); %>
<% String vForm = new String("document.bundlesForm"); %>
<% String vcolumna = new String("bundles.col"); %>
<% int numcol = 8; %>
<html>
<head>
	<title><bean:message key="bundles.titGeneral"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/calendario.js"></script>
<script language="javascript" src="pages/scripts/calendario.js"></script>

<script language="javascript">

function do_cancelar() {
		var obj = document.bundlesForm;
		obj.accion.value="cancelar";
		obj.submit();		
	}

function a_onclick(p){
	obj = document.bundlesForm;
	obj.numeroPagina.value = p;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}


function buscar(){
	obj = document.bundlesForm;
	obj.submit();	
}



function btnAnterior_onclick()
{
	obj = document.bundlesForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) - 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}

function btnSiguiente_onclick()
{
	obj = document.bundlesForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) + 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}

function setButton()
{
	obj = document.bundlesForm;
	tp = obj.totalPaginas.value;
	
	if( tp != 0 )
	{		
		p = obj.numeroPagina.value;
		nameButton = "btnPage_" + p;
		document.forms[0].elements[nameButton].disabled = true;		
	}
}

function init(){
	obj = document.bundlesForm;
	
	if(obj.hayDatos.value=="si"){
		setButton();

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

	}else{
	  alert('<bean:message key="mensaje.nodato"/>');
	}
}


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
	//alert(obj.vctExpHead.value);
 	obj.accion.value = "excel";
	obj.submit(); 
}	



</script>
<body class="Stylebody" onload="init();">
<div align="center">
<font class="StyleHead_left"><bean:message key="bundles.titPagina"/></font>
<!-- Para la accion -->
<html:form action="/bundles">
<html:hidden property="accion" value=""/>
<html:hidden property="totalPaginas" />
<html:hidden property="numeroPagina" />
<html:hidden property="hayDatos"     />
<html:hidden property="tipo"   />
<html:hidden property="vctExpHead" value=""/>
<html:hidden property="VctDetTotales" value=""/>
<html:hidden property="exportFile" />
<input type="hidden" name="mensaje"   value='<bean:write name="<%=vFormulario%>" property="mensaje" />'>


<br>
<logic:equal name="bundlesForm" property="hayDatos" value="si">  
  <table border="0" class="StyleTabla_75" align="center">
	<tr>
	      <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna1"/></font></td>	
   		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna2"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna3"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna4"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna5"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna6"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna7"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="bundles.titulo.columna8"/></font></td>
	</tr>
		<logic:iterate id="campos" name="bundlesForm" property="vctDetalles">
			<tr>
			  	<logic:iterate id="elemento" name="campos" indexId="index">
					<td class="VectResultDat1"><font class="VectResultDat1"><bean:write name="elemento"/></font></td>
				</logic:iterate>
			</tr>
		</logic:iterate>	
  </table>
  <br>
    <p>
	<!-- ******************************************************* -->
	<!--                  BOTONES.INICIO                         -->
	<!-- ******************************************************* -->
	<table width="100%" border="0" align="center" class="StyleTabla_100" >
	
	<tr>
	<td></td>
	<td align="center">
		
	</td>
	<td></td>
	</tr>
	
	<tr></tr>
	
	<tr>
	<td align="left">
		<!-- BOTON ANTERIOR.INICIO -->
		<logic:equal name="bundlesForm" property="numeroPagina" value="1">
	  		<input type="button" name="btnAnterior"  value="&nbsp;&nbsp;Anterior&nbsp;&nbsp;" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:equal>
		<logic:notEqual name="bundlesForm" property="numeroPagina" value="1">
	  		<input type="button" name="btnAnterior"  value="&nbsp;&nbsp;Anterior&nbsp;&nbsp;" onclick="btnAnterior_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:notEqual>	
		<!-- BOTON ANTERIOR.FIN -->
	</td>	
	<td>
		<% int idxBtn=1;%>
		<!-- PAGINAS.INICIO [1] [2] [3] ... -->
		<table width="100%" border="0" align="center">
			 <tr>
			 <td class="StyleText">  
			 <div align="center">
			 <logic:iterate id="campos" name="bundlesForm" property="listaPagina">
			    &nbsp;<input type="button" name="btnPage_<%=idxBtn++%>" value="<bean:write name='campos'/>" onclick="a_onclick(<bean:write name='campos'/>);" STYLE="border:1px solid white; width:20px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			 </logic:iterate>
			 </div>
			 </td>
			 </tr>
		</table>
		<input type="hidden" name="totalPaginas" value="<%=idxBtn%>">
		<!-- PAGINAS.FIN [1] [2] [3] ... -->
	</td>

	<td align="right">
		<!-- BOTON SIGUIENTE.INICIO -->
		<logic:equal name="bundlesForm" property="hayProximoBloque" value="si">
			&nbsp;<input type="button" name="btnSiguiente" value="Siguiente" onclick="btnSiguiente_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:equal>
		<logic:notEqual name="bundlesForm" property="hayProximoBloque" value="si">
			&nbsp;<input type="button" name="btnSiguiente" value="Siguiente" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:notEqual>
		
	<!-- BOTON SIGUIENTE.FIN -->
	</td>

	</tr>
	</table>
	<!-- ******************************************************* -->
	<!--                  BOTONES.FIN                            -->
	<!-- ******************************************************* -->
    <p>
</logic:equal>
	<!-- -->
   <br>
  	  <table border="0" class="StyleTabla_75" align="center">
   <tr>
   <td align="center">		  
     <input type="button" name="btn_cancelar" value="Cancelar" onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
     <input type="button" name="btnExportar" value="Exportar" onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
  </td>
  </tr>
  </table>

</html:form>
</html>
 	
