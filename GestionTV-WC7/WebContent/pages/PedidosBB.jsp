<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page isThreadSafe="true"%>
<% int 	  numcol 		= 3;%>
<% String vcolumna 		= new String("pedidos.titulo.columna");%>
<script language="javascript" >
function do_cancelar() {
		var obj = document.pedidosForm;
		obj.accion.value="cancelar";
		obj.submit();		
	}
  function body_onload()
  {
	var obj = document.pedidosForm;
	
  	obj.accion.value = "conectaDB2";
	obj.submit();	  	
  }

function do_btnExcel()
{
	var obj = document.pedidosForm;
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

  function do_buscar() {
	var obj = document.pedidosForm;
    // valida campos requeridos
    var mensaje1 = "";
    var mensaje2 = "";
    var mensaje3 = "";
    var mensaje = "";
    var fecinicio = obj.fec_inicio.value;
    var fecfin = obj.fec_fin.value;
    mensaje1 = mensaje1 + valida_campo_requerido(obj.fec_inicio.value,"Fecha Inicio","<bean:message key="error.requerido"/>");
    mensaje2 = mensaje2 + valida_campo_requerido(obj.fec_fin.value,"Fecha Final","<bean:message key="error.requerido"/>");
    if (mensaje1!="") {
       mensaje = mensaje1;
	}
	if (mensaje2!="") {
	      mensaje = mensaje + mensaje2;
	}
    if ( mensaje != "" ) {
       alert (mensaje);
       return;
    }
	// fin valida campos requeridos
    fecinicio = parseInt(fecinicio.substr(6,4)+fecinicio.substr(3,2)+fecinicio.substr(0,2),10);
    fecfin = parseInt(fecfin.substr(6,4)+fecfin.substr(3,2)+fecfin.substr(0,2),10);
    if ( fecinicio > fecfin ) {
       alert ("Fecha Fin debe ser mayor o igual a Fecha Inicio");
       return;
	}
  	obj.accion.value = "buscar";
	obj.submit();	  	

  }

  function btnImprimir_onclick(){
	var obj = document.pedidosForm;
	var ventana;
	
	var aux_path="" ;
    var aux_posicion = location.href;
    var posicion, posicion2;
    
    posicion = aux_posicion.indexOf('//');
    aux_posicion = aux_posicion.substr(posicion + 2, aux_posicion.length - posicion )
    posicion2 = aux_posicion.indexOf('/');
    aux_path = self.location.href.substr(0, posicion+posicion2+2);
	
	
    var parametros = "?periodoIni=" + obj.fec_inicio.value +
				     "&periodoFin=" + obj.fec_fin.value +
				     "&accion=Imprimir&path=" + aux_path + "/GestionTV/pages/Pedidos_salida.jsp";
				     
				     
	var wurl      = "pages/Pedidos_imprimirFrame.jsp" + parametros;
    var wname     = "Imprimir";
	var wleft     = "left=250";
	var wtop      = "top=200";
	var wtoolbar  = "toolbar=no";
	var wlocation = "location=0";
	var wdir      = "directories=no";
	var wstatus   = "status=no";
	var wmenubar  = "menubar=0";
	var wscroll   = "scrollbars=no";
	var wresize   = "resizable=no";
	var wwidth    = "width=510";
	var wheight   = "height=199";
	ventana = window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
	
	 function body_onload_GestionTV() {
		obj = document.pedidosForm;
		var temp = "<bean:write name="pedidosForm" property="hayDatosExportar"/>"	
		if ("<bean:write name="pedidosForm" property="flagDatosBD"/>" == "no") {
			alert("No hay Datos con Parametros Ingresados");
			obj.flagDatosBD.value = "si";
		}
		if (temp == "si") 
		{
		
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
	}
</script>
  <head>
	 <title><bean:message key="pedidos.titGeneral"/></title>
	 <link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	 <link rel="stylesheet" type="text/css" href="styles/estylemante.css">
	 <style type="text/css">
	   input.likeText { border: 1px solid #000; }
     </style>
     <style type="text/css">
	  @media print {
	   .nonprintable {
    	display:    none;
		}
	  }
     </style>
   </head>
<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/calendario.js"></script>
<script language="javascript" src="pages/scripts/calendario.js"></script>
<script language="javascript" src="scripts/funciones.js"></script>


<body class="Stylebody" onload="javascript:body_onload_GestionTV();">
<!-------- Parametros para el calendario ------------------------ -->

	<form name="formularioPadre" method="post" action="">
	  <input type="hidden" name="txtNameFormulario"  value="">
	  <input type="hidden" name="txtNameObjetoText"  value="">
	</form>

<!-------- Fin de paramtros del calendario -------------------- -->

<div align="center">
<font class="StyleHead_left"><bean:message key="pedidos.titPagina"/></font>
<br>
<html:form action="/pedidos">
<html:hidden property="accion" value=""/>	
<html:hidden property="flagDatosBD"/>
<html:hidden property="vctExpHead" value=""/>
<html:hidden property="exportFile" /> 
<input type="hidden" name="mensaje"	value='<bean:write name="pedidosForm" property="mensaje"/>'>
<table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td>
	   <!-- Fecha Inicio -->
	   <font class="StyleTextoTabla"><bean:message key="pedidos.Fec_Ini"/></font>
	  </td>  
	  <td>
	    <html:text property="fec_inicio" size="10" maxlength="10" onkeypress="return valida_caracteres(event,Lis_fecha);" onblur="ValidaFecha(this)"/>
<input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('pedidosForm','fec_inicio');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">		
	  </td>  
	  <td align="center">			
		<input type="button" name="btn_buscar" value="Buscar" onclick="do_buscar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
      <td/>
  </tr>
  <tr>
  </tr>
  <tr>
      <td>
         <!-- Fecha Fin -->
         <font class="StyleTextoTabla"><bean:message key="pedidos.Fec_Fin"/></font>
      </td> 
      <td>
          <html:text property="fec_fin" size="10" maxlength="10" onkeypress="return valida_caracteres(event,Lis_fecha);" onblur="ValidaFecha(this)"/>

	      <input type=button name="BtnFecha" value="C" onclick="goWindowPopupCalendario('pedidosForm','fec_fin');" STYLE="border:1px solid white; height:20px;" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	   </td>  
   </tr>		
   </table>
   <br>
	<logic:present name="pedidosForm">
		<table border="0" class="StyleTabla_75" align="center"> 
		<tr>
		  <tr>
		    <td align="center"><font class="StyleTextoTabla"><bean:message key="pedidos.titulo.columna1"/></font></td>
		    <td align="center"><font class="StyleTextoTabla"><bean:message key="pedidos.titulo.columna2"/></font></td>
		    <td align="center"><font class="StyleTextoTabla"><bean:message key="pedidos.titulo.columna3"/></font></td>
		  </tr>	
		 </tr>
		 <logic:equal name="pedidosForm" property="flagDatosBD" value="si">
		   <logic:iterate id="campos" name="pedidosForm" property="vctDetalles">
		 <tr>
		   	<logic:iterate id="elemento" name="campos" indexId="index">
			<td  class="VectResultDat1 align="center">
		      <font class="VectResultDat1"><bean:write name="elemento"/></font>
			</td>
		    </logic:iterate>
		 </tr>
		 </logic:iterate>
		 	</logic:equal>
		</table>
	</logic:present>
</html:form>
<br>
  <table border="0" class="StyleTabla_75" align="center">
  <tr>
	 <td align="center">

     <input type="button" name="btnCerrar" value="Cancelar" onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">

		<input type="button" name="BtnImprimir" value="Imprimir" onclick="btnImprimir_onclick();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
        	<logic:equal name="pedidosForm" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  onclick="do_btnExcel();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	</logic:equal>		
	<logic:notEqual name="pedidosForm" property="hayDatos" value="si">
		<input type="button" name="btnExportar" value="Exportar"  disabled STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
	</logic:notEqual>

   </td>
   </tr>
   </table>

</body>
