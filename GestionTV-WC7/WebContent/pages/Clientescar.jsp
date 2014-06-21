<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<% String vFormulario = new String("clientescarForm"); %>
<% String vForm = new String("document.clientescarForm"); %>
<% String vcolumna = new String("clientescar.col"); %>
<% int numcol = 17; %>

<head>
	<title><bean:message key="clientescar.titGeneral"/></title>
	<meta name="pagina" content="Clientescar.jsp">
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>
<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/calendario.js"></script>
<script language="javascript" src="pages/scripts/calendario.js"></script>
<script language="javascript">

  function do_cancelar() {
	var obj = document.clientescarForm;

	obj.accion.value="cancelar";
	obj.submit();		
  }
  
function a_onclick(p){
	obj = document.clientescarForm;
	obj.numeroPagina.value = p;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}


function buscar(){
	obj = document.clientescarForm;
	obj.submit();	
}



function btnAnterior_onclick()
{
	obj = document.clientescarForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) - 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}

function btnSiguiente_onclick()
{
	obj = document.clientescarForm;

	obj.numeroPagina.value = parseInt(obj.numeroPagina.value,10) + 1;
	obj.accion.value       = "BuscarPagina";
	obj.submit();	
}


function init(){
	obj = document.clientescarForm;
	if(obj.hayDatos.value=="si"){

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
	var obj = document.clientescarForm;
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

</script>
<body class="Stylebody" onload="init();">
<div align="center">
<font class="StyleHead_left"><bean:message key="clientescar.titPagina"/></font>
<br>
<html:form action="/clientescar">
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

<br>
 	  <table border="0" class="StyleTabla_75" align="center">
   <tr>
   <td align="center">		  
	    <input type="button" name="btnExportar" value="Exportar" onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	    <input type="button" name="btn_cancelar" value="Cancelar" onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	</td>
	</tr>
	</table>
	<!-- -->
</html:form>
</body>
