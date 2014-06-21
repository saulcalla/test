<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
<head>
	<title>Cargas OEM</title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">

<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/FormChek_JS10_NS2.js"></script>
<script language="javascript" src="scripts/calendario.js"></script>
<script language="javascript" src="pages/scripts/calendario.js"></script>


<style>
<!--
.hide { position:absolute; visibility:hidden; }
.show { position:absolute; visibility:visible; }
-->
</style>

<style type="text/css"> 
    #waitpage1 {position: absolute; visibility: hidden; } 
    #waitpage2 {position: absolute; visibility: hidden; } 
    #waitpage3 {position: absolute; visibility: hidden; } 
    #waitpage4 {position: absolute; visibility: hidden; } 
    #waitpage5 {position: absolute; visibility: hidden; } 
    #waitpage6 {position: absolute; visibility: hidden; } 
    #waitpage7 {position: absolute; visibility: hidden; } 
    #waitpage8 {position: absolute; visibility: hidden; }
    #show1 {visibility: visible; } 
    #show2 {visibility: visible; } 
    #show3 {visibility: visible; } 
    #show4 {visibility: visible; } 
    #show5 {visibility: visible; } 
    #show6 {visibility: visible; } 
    #show7 {visibility: visible; } 
    #show8 {visibility: visible; } 
</style> 

<script language="javascript">
    
   var obj = document.cargasForm;
   var ventana;
   
  
  function do_cancelar() {
    var obj = document.cargasForm;
	obj.accion.value="cancelar";
	obj.submit();		
  }
  
  function do_cargar(t) {
  var obj = document.cargasForm;
    if (t == 1){
	  obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	  obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	  obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	  document.all.show1.style.visibility = 'hidden';
	  document.all.waitpage1.style.visibility = 'visible';
      obj.accion.value="cargarProductos";
    }

    if (t == 2){
      obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	  obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;	
	  obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	  document.all.show2.style.visibility = 'hidden';
	  document.all.waitpage2.style.visibility = 'visible';
	  obj.accion.value="cargarCatalogos";
	}

    if (t == 3){
	  obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	  obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;	    
	  obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	  document.all.show3.style.visibility = 'hidden';
	  document.all.waitpage3.style.visibility = 'visible';
      obj.accion.value="cargarPromociones";
    }

    if (t == 4){
	   obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	   obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	   obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	  document.all.show4.style.visibility = 'hidden';
	  document.all.waitpage4.style.visibility = 'visible';
       obj.accion.value="cargarAsociaciones";
    }

    if (t == 5){
       obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	   obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	   obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	  document.all.show5.style.visibility = 'hidden';
	  document.all.waitpage5.style.visibility = 'visible';
       obj.accion.value="cargarZonas";
    }

    if (t == 6){
       obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	   obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	   obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	   document.all.show6.style.visibility = 'hidden';
	   document.all.waitpage6.style.visibility = 'visible';
       obj.accion.value="cargarBundles";
    }
    
    if (t == 7){
       obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	   obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	   obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	   document.all.show7.style.visibility = 'hidden';
	   document.all.waitpage7.style.visibility = 'visible';
       obj.accion.value="cargarLog";
    }
    if (t == 8){
       obj.btn_cargar1.disabled=true;obj.btn_cargar2.disabled=true;obj.btn_cargar3.disabled=true;
	   obj.btn_cargar4.disabled=true;obj.btn_cargar5.disabled=true;obj.btn_cargar6.disabled=true;
	   obj.btn_cargar7.disabled=true;obj.btn_cargar8.disabled=true;
	   document.all.show8.style.visibility = 'hidden';
	   document.all.waitpage8.style.visibility = 'visible';
       obj.accion.value="cargarClientescar";
    }
    obj.submit();		
  }
  


function init1(){
	document.all.waitpage1.style.visibility = 'hidden';
	document.all.waitpage2.style.visibility = 'hidden';
	document.all.waitpage3.style.visibility = 'hidden';
	document.all.waitpage4.style.visibility = 'hidden';
	document.all.waitpage5.style.visibility = 'hidden';
	document.all.waitpage6.style.visibility = 'hidden';
	document.all.waitpage7.style.visibility = 'hidden';
	document.all.waitpage8.style.visibility = 'hidden';
}
  </script>
</head>

<body class="Stylebody" onload="init1();">
<div align="center">
<font class="Stylehead"><bean:message key="cargas.titPagina"/></font>
<html:form action="/cargas">
<html:hidden property="accion" value=""/>

 <logic:present name="cargasForm">
   <table border="0" class="StyleTabla_75" align="center">
		<tr>
			<tr>
			    <td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.campo1"/></font></td>
			    <td ><font class="StyleTextoTabla"><bean:message key="cargas.form1.campo2"/></font></td>
            </tr>
			  
		</tr>
			<tr>
			<!--   Boton 1                                                        -->		
		<tr>
	    	<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col01"/></font></td>
				<td >
					<DIV ID="waitpage1"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
	
					<DIV ID="show1"> 
			    		 <font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec1"/></font>
					</DIV>
			    </td>	

			<td colspan="3"  align="left">		  
			     <input type="button" name="btn_cargar1" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('1');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
     <!--   Boton 2                                                        -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col02"/></font></td>
				<td >
					<DIV ID="waitpage2"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando...">
					</DIV>
			
					<DIV ID="show2"> 
			     		<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec2"/></font>
					</DIV>
		        </td>
			<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar2" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('2');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr> 

	<!--      Boton 3                                                    -->		
	
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col03"/></font></td>
			<td >
					<DIV ID="waitpage3"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando...">
					</DIV>
					<DIV ID="show3"> 
						<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec3"/></font>
					</DIV>
			
	        </td>
			<td colspan="3"  align="left">		  
			   <input type="button" name="btn_cargar3" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('3');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
			
	<!--    Boton 4                                                       -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col04"/></font></td>
			<td>
					<DIV ID="waitpage4"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
					<DIV ID="show4"> 
			    		<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec4"/></font>
					</DIV>
			
		    </td>
			<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar4" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('4');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
	<!--    Boton 5                                                       -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col05"/></td></font>
			<td >
					<DIV ID="waitpage5"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
					<DIV ID="show5"> 
			     		<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec5"/></font>
					</DIV>
			
		    </td>
				<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar5" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('5');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
	<!--     Boton 6                                                      -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col06"/></font></td>
			<td >
					<DIV ID="waitpage6"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
					<DIV ID="show6"> 
			    		<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec6"/></font>
					</DIV>
			
		    </td>
			<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar6" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('6');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
		
		
		<!--     Boton 7                                                     -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col07"/></font></td>
			<td >
					<DIV ID="waitpage7"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
					<DIV ID="show7"> 
			    		<font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec7"/></font>
					</DIV>
			
		    </td>

			<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar7" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('7');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr>
		<!--     Boton 8                                                     -->		
		<tr>
			<td align="center"><font class="StyleTextoTabla"><bean:message key="cargas.form1.col08"/></font></td>
			<td >
					<DIV ID="waitpage8"> 
						  <IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar" ALT="Procesando..."> 
					</DIV>
					<DIV ID="show8"> 
			    	   <font class="StyleTextoTabla"><bean:write name="cargasForm" property="fec8"/></font> 
					</DIV>
			
		    </td>

			<td colspan="3"  align="left">		  
				<input type="button" name="btn_cargar8" value=<bean:message key="cargas.form1.boton.cargar"/> onclick="do_cargar('8');" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
			</td>
		</tr><td></td><td></td></tr>
		<tr>
	</tr>
  </table>
</logic:present>
<br>
<!-- -->
 <tr>
    <td colspan="3"  align="right">		  
	<input type="button" name="btn_cancelar" value=<bean:message key="cargas.form1.boton.cancelar"/> onclick="do_cancelar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    </td>
  </tr>
<!-- -->
	
</html:form>
</body>
</html>
			