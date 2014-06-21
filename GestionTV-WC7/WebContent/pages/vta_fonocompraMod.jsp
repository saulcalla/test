<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<% String vFormulario = new String("vtafonocompraForm"); %>
<% String vForm = new String("document.vtafonocompraForm"); %>

<html:html> 
<head>
	<title><bean:message key="fonocompra.tit.general"/></title>
	<meta name="pagina"        content="pages/vta_fonocompraMod.jsp">
	<meta name="modificado"    content="vta_foncompraMod.14Julio2006">
	<script language="JavaScript" type="text/JavaScript" src="pages/scripts/funciones.js"></script>
	<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>

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

	<script language="javascript" >

	function do_grabar() {
	    var obj=<%=vForm%>;
        var mensaje = "";
        var mensajeglosa = "";
        var foco = false;
		if(obj.valorCP.value=='S'){
			mensaje = valida_campo_requerido(obj.codigoCP.value,"<bean:message key="fonocompra.cod.producto.cambio"/>","<bean:message key="errors.requerido"/>")
			mensajeglosa = mensajeglosa + mensaje;
			if ( (mensaje!="") && (foco==false ) ) {
			    foco=true;
				obj.codigoCP.focus();
			}
			mensaje="";
			mensaje = valida_campo_requerido(obj.nombreCP.value,"<bean:message key="fonocompra.nom.producto.cambio"/>","<bean:message key="errors.requerido"/>")
			mensajeglosa = mensajeglosa + mensaje;
			if ( (mensaje!="") && (foco==false ) ) {
			    foco=true;
				obj.nombreCP.focus();
			}
			if (mensajeglosa!="") {
				alert(mensajeglosa);
				return;
			}
			
		}
        var foco = false;
		obj.accion.value = "grabar_modificar";
		
		var textestado  = obj.selectEstado.options[obj.selectEstado.selectedIndex].text;
		var valueestado = obj.selectEstado.options[obj.selectEstado.selectedIndex].value;
   	    obj.codEstado.value = valueestado;
   	    obj.glosaEstado.value = textestado;
		
		//valida que estado sea diferente a INGRESADO
		if (obj.codEstado.value == "1"){
			alert("Estado NO válido.");
			obj.selectEstado.focus();
			return;
		//2=RECHAZADO
		}else if (obj.codEstado.value == "2"){ 
			mensaje = valida_campo_requerido(obj.observacion.value,"<bean:message key="fonocompra.observacion"/>","<bean:message key="errors.requerido"/>")
			mensajeglosa = mensajeglosa + mensaje;
			if ( (mensaje!="") && (foco==false ) ) {
				obj.observacion.focus();
				alert(mensajeglosa);
				return;
			}
		//3=APROBADO
		}else if (obj.codEstado.value == "3"){ 
			mensaje = valida_campo_requerido(obj.ordenCompra.value,"<bean:message key="fonocompra.oc"/>","<bean:message key="errors.requerido"/>")
			mensajeglosa = mensajeglosa + mensaje;
			if ( (mensaje!="") && (foco==false ) ) {
				obj.ordenCompra.focus();
				alert(mensajeglosa);
				return;
			}
		}else{
			if (mensajeglosa!="") {
				alert(mensajeglosa);
				return;
			}
		}
		if (mensajeglosa=="") {
			//obj.submit();
			
			obj.accion.value="grabar_modificar";
			document.vtafonocompraForm.submit();
		}
	}

	function do_retornar() {
	    var obj=<%=vForm%>;
		document.all.procesando.style.visibility = 'visible';		
		obj.accion.value = "mostrar";
		obj.submit();
	}

	function boton_enter(e, instruccionEnter, instruccionEscape ) {
		// e: event
	  	var tecla;	
	  	if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;	
		if( tecla == 13)eval( instruccionEnter  );		
		if( tecla == 27)eval( instruccionEscape );	
		return(true);
	}	

	function foco()	{
	    
		//document.all.observacion.focus();
		
		var obj=<%=vForm%>;
		obj.observacion.focus();
		return(true);
	}	

	function init(){
		/*
		document.all.nombreCP.disabled=true;
		document.all.codigoCP.disabled=true;
		document.all.valorCP.value='N'
		*/
		document.all.procesando.style.visibility = 'hidden';
		var obj=<%=vForm%>;
		obj.nombreCP.disabled=true;
		obj.codigoCP.disabled=true;
		obj.valorCP.value='N'
		
	}
	
	Number.prototype.toDecimals=function(n){
   		 n=(isNaN(n))?
     	   2:
     	   n;
   		 var
     	   nT=Math.pow(10,n);
    function pad(s){
            s=s||'.';
            return (s.length>n)?
                s:
               pad(s+'0');            
               
    }
    return (isNaN(this))?
        this:
        (new String(
            Math.round(this*nT)/nT
        )).replace(/(\.\d*)?$/,pad);
	}

   function Selected(selectN,valor) {
      for(i=0;i<selectN.length;i++) {
         if (selectN.options[i].value==valor) {
            selectN.options[i].selected= true;
			break;
         }
      }
   }

	function do_activar(){
	    var obj=document.all;
		if(obj.cambioproducto.checked==true){
			obj.valorCP.value='S'
			obj.nombreCP.disabled=false;
			obj.codigoCP.disabled=false;
		}
		else{
			obj.codigoCP.value="";		
			obj.nombreCP.value="";		
			obj.nombreCP.disabled=true;
			obj.codigoCP.disabled=true;
			obj.valorCP.value='N'
		}
		//alert(obj.valorCP.value);		
	}


	</script>
	
<body class="Stylebody" onload="init(); foco();" onKeyPress="boton_enter(window.event,'do_grabar();','');">
<div align="left">
<html:form action="/vtafonocompra">
    <html:hidden property="accion" value=""/>
	<html:hidden property="mensaje"/>

	<input type="hidden" name="credito"     value='<bean:write name="<%=vFormulario%>" property="credito"/>' >
	<input type="hidden" name="rut"     	value='<bean:write name="<%=vFormulario%>" property="rut"/>' >
   <input type="hidden" name="codEstado" 	value='<bean:write name="<%=vFormulario%>" property="codEstado"/>'>
   <input type="hidden" name="glosaEstado" 	value='<bean:write name="<%=vFormulario%>" property="glosaEstado"/>'>	
   <input type="hidden" name="valorCP" 		value='<bean:write name="<%=vFormulario%>" property="valorCP"/>'>

	<font class="StyleHead_left"><bean:message key="fonocompra.modFuncion.form1"/></font><br><br>
	<table class="StyleTabla_75">
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.estado"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:select name="<%=vFormulario%>" property="selectEstado">
   				<html:optionsCollection name="<%=vFormulario%>" property="collEstado"/>        			
   	  			</html:select>
			</td>
			<td class="StyleTextoTabla">
				&nbsp;
			</td> 
			<td class="StyleTextoTabla">
				&nbsp;      
				<font class="StyleHead_left_12"><bean:message key="fonocompra.cambio.producto"/></font>
				<input type="checkbox" name="cambioproducto" onclick="do_activar();">
				&nbsp;
			</td>
		</tr>
	<tr>
	<td>
		&nbsp;
	</td>
	</tr>
	</table>

	<table class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.credito"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="credito" size="10" maxlength="10" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.ejecutivo"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="ejecutivo" size="40" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.rut"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="rut" size="10" maxlength="10" disabled="true" styleClass="StyleText"/>
				<html:text name="<%=vFormulario%>" property="dv" size="1" maxlength="1" disabled="true" styleClass="StyleText"/>
			</td>

			<td class="StyleTextoTabla">
				<bean:message key="banco.nombres"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="nombres" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>

		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.paterno"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="apellidoPaterno" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.materno"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="apellidoMaterno" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>

		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.calle"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="calle" size="20" maxlength="50" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.numero"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="numero" size="10" maxlength="10" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.departamento"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="departamento" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.comuna"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="comuna" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.villa"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="villa" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.ciudad"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="ciudad" size="20" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.referencia"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="referencia" size="20" maxlength="50" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.telefono1"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="telefono1" size="10" maxlength="20" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.telefono2"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="telefono2" size="10" maxlength="20" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
	</table>


	<table class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.cod.producto"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="codigoProducto" size="15" maxlength="15" disabled="true" styleClass="StyleText"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.num.producto"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="nombreProducto" size="29" maxlength="15" disabled="true" styleClass="StyleText"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.cod.producto.cambio"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="codigoCP" size="20" maxlength="20" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.nom.producto.cambio"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="nombreCP" size="30" maxlength="20" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
		</tr>

		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.oc"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="ordenCompra" size="20" maxlength="15" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="fonocompra.monto.venta"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text name="<%=vFormulario%>" property="monto" size="20" maxlength="20" disabled="true" styleClass="StyleText"/>
			</td>

		</tr>
		</table>		
		<table class="StyleTabla_75" >
			<tr>
			  <td class="StyleTextoTabla">
				<bean:message key="fonocompra.observacion"/>
			  </td>
			  <td class="StyleTextoTabla">
				<html:textarea name="<%=vFormulario%>" cols="50" rows="3" property="observacion" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			  </td>
			</tr>
		</table>
	</br>
    <input type=button name="btn_grabar" value="<bean:message key="fonocompra.boton.grabar"/>" onclick="do_grabar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    <input type=button name="btn_retornar" value="<bean:message key="fonocompra.boton.volver"/>" onclick="do_retornar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    
</html:form>		
	<script language="javascript">
	    var obj=document.all;
		<logic:notEqual name="<%=vFormulario%>" property="collEstado" value="[]">	
			Selected(obj.selectEstado,obj.codEstado.value);
		</logic:notEqual>
		obj.valorCP.value="N";
	</script>
</div>
	
</body>
<logic:notEqual name="<%=vFormulario%>" property="mensaje" value="">
   <script>
	 alert("<bean:write name="<%=vFormulario%>" property="mensaje"/>");		
   </script>
</logic:notEqual>


 <DIV id="procesando"> 
	<font color="#336699" size="2px" weight="normal">
	Procesando...
	</font>
	<IMG SRC="pages/images/progressGIF.gif" NAME="ProgBar"> 
</DIV>

</html:html>
