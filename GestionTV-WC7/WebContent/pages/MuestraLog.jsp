<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
	<title><bean:message key="muestralog.tit.pag"/></title>
	<meta name="pagina" content="MuestraLog.jsp">
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/calendario.js"></script>
<script language="javascript" src="pages/scripts/calendario.js"></script>
<script language="javascript">

  function do_cancelar() {
	var obj = document.muestralogForm;

	obj.accion.value="cancelar";
	obj.submit();		
  }
  
function a_onclick(p){
	obj = document.muestralogForm;
	obj.numeroPagina.value = p;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}


function buscar(){
	obj = document.muestralogForm;
	obj.submit();	
}



function btnAnterior_onclick()
{
	obj = document.muestralogForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) - 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}

function btnSiguiente_onclick()
{
	obj = document.muestralogForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) + 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}

function setButton()
{
	obj = document.muestralogForm;
	tp = obj.totalPaginas.value;
	
	if( tp != 0 )
	{		
		p = obj.numeroPagina.value;
		nameButton = "btnPage_" + p;
		document.forms[0].elements[nameButton].disabled = true;		
	}
}

function init(){
	obj = document.muestralogForm;
	
	if(obj.hayDatos.value=="si"){
		setButton();
	}else{
	  alert('<bean:message key="mensaje.nodato"/>');
	}
}
</script>
<body class="Stylebody" onload="init();">
<div align="center">
<font class="StyleHead_left"><bean:message key="muestralog.tit.pag"/></font>
<br>
<html:form action="/muestralog">
<html:hidden property="accion" />	
<html:hidden property="totalPaginas" />
<html:hidden property="numeroPagina" />
<html:hidden property="hayDatos"     />
<html:hidden property="tipo"   />


   <br>
<logic:equal name="muestralogForm" property="hayDatos" value="si">  
	<logic:present name="muestralogForm">
    <table border="0" class="StyleTabla_75" align="center">
    <tr>
		   <td align="center"><font class="StyleTextoTabla"><bean:message key="muestralog.col1"/></font></td>
		   
     </tr>
	 <logic:iterate id="campos" name="muestralogForm" property="vctDetalles">
		<tr>
		  	<logic:iterate id="elemento" name="campos" indexId="index">
				<td class="VectResultDat1" nowrap><font class="VectResultDat1"><bean:write name="elemento"/></font></td>
			</logic:iterate>
		</tr>
	</logic:iterate>	
    </table>
    </logic:present>

    <p>
	<!-- ******************************************************* -->
	<!--                  BOTONES.INICIO                         -->
	<!-- ******************************************************* -->
	<table width="100%" border="0" align="center" class="StyleTabla_100" >
	<tr>
	<td align="left">
		<!-- BOTON ANTERIOR.INICIO -->
		<logic:equal name="muestralogForm" property="numeroPagina" value="1">
	  		<input type="button" name="btnAnterior" value="&nbsp;&nbsp;Anterior&nbsp;&nbsp;" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:equal>
		<logic:notEqual name="muestralogForm" property="numeroPagina" value="1">
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
			 <logic:iterate id="campos" name="muestralogForm" property="listaPagina">
			    &nbsp;<input type="button" name="btnPage_<%=idxBtn++%>" value="<bean:write name='campos'/>" onclick="a_onclick(<bean:write name='campos'/>);" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
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
		<logic:equal name="muestralogForm" property="hayProximoBloque" value="si">
			&nbsp;<input type="button" name="btnSiguiente" value="Siguiente" onclick="btnSiguiente_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:equal>
		<logic:notEqual name="muestralogForm" property="hayProximoBloque" value="si">
			&nbsp;<input type="button" name="btnSiguiente" value="Siguiente" disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
		</logic:notEqual>
		
	<!-- BOTON SIGUIENTE.FIN -->
	</td>

	</tr>
	</table>
	<!-- ******************************************************* -->
	<!--                  BOTONES.FIN                            -->
	<!-- ******************************************************* -->
    </p>
</logic:equal>

	
	<!-- -->
	<br>
	<table border="0" class="StyleTabla_75" align="center">
   <tr>
   <td align="center">		  
		<input type="button" name="btn_cancelar" value=<bean:message key="cargas.form1.boton.cancelar"/> onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
  </td>
  </tr>
  </table>
	<!-- -->
	
</html:form>
</body>
