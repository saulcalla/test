<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<% String vFormulario = new String("bancoForm"); %>
<% String vForm = new String("document.bancoForm"); %>
<html> 
<head>
	<title><bean:message key="banco.tit.general"/></title>
	<meta name="pagina"        content="pages/vta_bancoIng.jsp">
	<meta name="modificado"    content="vta_bancoIng.14Julio2006">
	<script language="JavaScript" type="text/JavaScript" src="pages/scripts/funciones.js"></script>
	<script language="javascript" src="pages/scripts/FormChek_JS10_NS2.js"></script>

	<style type="text/css"> 
    	#procesando {position:absolute;left:400px;top=15px;width:10px;visibility:hidden} 
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
		
		// valida campos requeridos
        var mensajeglosa = "";
        var foco = false;

        var mensaje = "";
		mensaje = valida_campo_requerido(obj.credito.value,"<bean:message key="banco.credito"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.credito.focus();
		}
		mensaje = "";
		mensaje = valida_campo_requerido(obj.rut.value,"<bean:message key="banco.rut"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.rut.focus();
		}
		//valida rut, controla casos en el cual NO se toma accion onBlur
		validar_rut(obj.rut,obj.dv,mensaje);

		mensaje = "";
		mensaje = valida_campo_requerido(obj.nombres.value,"<bean:message key="banco.nombres"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.nombres.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.apellidoPaterno.value,"<bean:message key="banco.paterno"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.apellidoPaterno.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.apellidoMaterno.value,"<bean:message key="banco.materno"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.apellidoMaterno.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.calle.value,"<bean:message key="banco.calle"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.calle.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.numero.value,"<bean:message key="banco.numero"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.numero.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.ciudad.value,"<bean:message key="banco.ciudad"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.ciudad.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.comuna.value,"<bean:message key="banco.comuna"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.comuna.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.telefono1.value,"<bean:message key="banco.telefono1"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.telefono1.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.codigoProducto.value,"<bean:message key="banco.codigoProducto"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.codigoProducto.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.nombreProducto.value,"<bean:message key="banco.nombreProducto"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.nombreProducto.focus();
		}

		mensaje = "";
		mensaje = valida_campo_requerido(obj.monto.value,"<bean:message key="banco.monto"/>","<bean:message key="errors.requerido"/>")
		mensajeglosa = mensajeglosa + mensaje;
		if ( (mensaje!="") && (foco==false ) ) {
		    foco=true;
			obj.monto.focus();
		}

		if (mensajeglosa!="") {
			alert(mensajeglosa);
			return;
		}
		   	    
		document.all.procesando.style.visibility = 'visible';		
		obj.accion.value = "grabar_nuevo";		
		obj.submit();
	}

	function do_retornar() {
	    var obj=<%=vForm%>;
		document.all.procesando.style.visibility = 'visible';		
		obj.accion.value = "mostrar";
		obj.submit();
	}

	function boton_enter(e, instruccionEnter, instruccionEscape )	{
		// e: event
	  	var tecla;
  		if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;
		if( tecla == 13)eval( instruccionEnter  );		
		if( tecla == 27)eval( instruccionEscape );
		return(true);
	}

	function foco()	{
	    var obj=<%=vForm%>;
		obj.credito.focus();
		return(true);
	}	

	function init(){
	
		document.all.procesando.style.visibility = 'hidden';
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

	</script>
	
<body class="Stylebody" onload="init(); foco();" onload="foco();">
<div align="left">
<html:form action="/banco">
    <html:hidden property="accion" value=""/>	
	<html:hidden property="mensaje"/>
    
	<font class="StyleHead_left"><bean:message key="banco.ingFuncion.form1"/></font><br><br>
	<table class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.credito"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="credito" size="10" maxlength="10" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.ejecutivo"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="ejecutivo" size="35" maxlength="25" disabled="true" styleClass="StyleText"/>
			</td>

		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.rut"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="rut" size="10" maxlength="10" onkeypress="return valida_caracteres(event,LNUM);"/>
				<html:text property="dv" size="1" maxlength="1" onkeypress="return valida_caracteres(event,LDV);" onblur="validar_rut(rut,dv,mensaje);"/>
			</td>

			<td class="StyleTextoTabla">
				<bean:message key="banco.nombres"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="nombres" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LNOMBRES);"/>
			</td>

		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.paterno"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="apellidoPaterno" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LPATERNO);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.materno"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="apellidoMaterno" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LPATERNO);"/>
			</td>

		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.calle"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="calle" size="20" maxlength="50" onkeypress="return valida_caracteres(event,LCALLE);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.numero"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="numero" size="10" maxlength="9" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.ciudad"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="ciudad" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.comuna"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="comuna" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.departamento"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="departamento" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.villa"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="villa" size="20" maxlength="25" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.referencia"/>
			</td> 
			<td >
				<html:text property="referencia" size="30" maxlength="50" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
			<td class="StyleTextoTabla">
				&nbsp;
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.telefono1"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="telefono1" size="10" maxlength="20" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.telefono2"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="telefono2" size="10" maxlength="20" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
		</tr>
	</table>
	<table class="StyleTabla_75">
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.codigoProducto"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="codigoProducto" size="15" maxlength="25" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
			<td class="StyleTextoTabla">
				<bean:message key="banco.nombreProducto"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="nombreProducto" size="40" maxlength="50" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
		</tr>
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.monto"/>
			</td> 
			<td class="StyleTextoTabla">
				<html:text property="monto" size="10" maxlength="10" onkeypress="return valida_caracteres(event,LNUM);"/>
			</td>
		</tr>
	</table>
	<table class="StyleTabla_75" >
		<tr>
			<td class="StyleTextoTabla">
				<bean:message key="banco.observacion"/>
			</td>
			<td class="StyleTextoTabla">
				<html:textarea cols="50" rows="3" property="observacion" onkeypress="return valida_caracteres(event,LGLOSA);"/>
			</td>
		</tr>
	</table>
	
	
	</br>

    <input type=button name="btn_grabar" value="<bean:message key="banco.boton.grabar"/>" onclick="do_grabar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">
    <input type=button name="btn_retornar" value="<bean:message key="banco.boton.volver"/>" onclick="do_retornar();" STYLE="border:1px solid white; width:80px" onMouseover="this.style.cursor = 'hand'; style.background='#F0F0F0'; style.border='1px solid gray'" onMouseout="style.background='#CCCCCC'; style.border='1px solid white'">

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

</html>
