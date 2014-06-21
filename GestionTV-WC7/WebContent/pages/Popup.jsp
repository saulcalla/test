<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<% int idx = 0;%>
<script language="javascript" >

var obj=document.popupForm;

function do_agregar(){
	var obj=document.popupForm;
	obj.accion.value = "agregar";
	obj.submit();
}


function do_cancelar() {
	var obj = document.popupForm;
	obj.accion.value="cancelar";
	obj.submit();		
}

function radio_onclick(num,element,estado,prop,url){
	var obj=document.popupForm;
	var cont=num;
	
	setBtn("si",cont);//desactiva los demas radio
	
	//obj.BtnAgregar.disabled = true;
	
	estado.disabled = false;
	prop.disabled = false;
	url.disabled = false;

}

</script>	
<html>
<head>
	<title><bean:message key="popup.tit.pag"/></title>
	<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	<link rel="stylesheet" type="text/css" href="styles/estylemante.css">
</head>

<body class="Stylebody" onload="init();">

<div align="center">
<font class="StyleHead_left"><bean:message key="popup.tit.pag"/></font>
<html:form action="/popup">
  <html:hidden property="accion" value=""/>
  <html:hidden property="glosa_est"  value=""/>
  <html:hidden property="glosa_prop"  value=""/>
  <html:hidden property="glosa_url"  value=""/>
  <html:hidden property="idpopup"  value=""/>
  
  <table border="0" class="StyleTabla_75" align="center">
	<tr>  
	      <td><font class="StyleTextoTabla"><bean:message key="popup.col0"/></font></td>
	      <td><font class="StyleTextoTabla"><bean:message key="popup.col1"/></font></td>
		  <td><font class="StyleTextoTabla"><bean:message key="popup.col2"/></font></td>
  		  <td><font class="StyleTextoTabla"><bean:message key="popup.col3"/></font></td>
  		  <td><font class="StyleTextoTabla"><bean:message key="popup.col4"/></font></td>
	</tr>
		<logic:iterate id="campos" name="popupForm" property="vctDetalles">
		   <tr>
			  <logic:iterate id="elemento" name="campos" indexId="index">
		  		<logic:equal name="index" value="0">		  
					<td class="VectResultDat1_centro">
					   <input type="radio" name="radio_<%=idx%>" onclick="radio_onclick(<%=idx%>,this,document.popupForm.estado_<%=idx%>,document.popupForm.prop_<%=idx%>,document.popupForm.url_<%=idx%>);"/>
					</td>
				</logic:equal>	
				<logic:equal name="index" value="0"> <!-- Popup id -->
				    <td class="VectResultDat1">
				       <input class="VectResultDat1" size="4" maxlength="4" type="text" name="idpopup_<%=idx%>" onblur="this.disabled=true;" onchange="" value='<bean:write name='elemento'/>' disabled>
				    </td>
				</logic:equal>
				<logic:equal name="index" value="1"> <!-- Estado -->
				    <td class="VectResultDat1">
				       <input class="VectResultDat1" size="1" maxlength="1" type="text" name="estado_<%=idx%>" onblur="this.disabled=true;" onchange="" value='<bean:write name='elemento'/>' disabled>
				    </td>
				 </logic:equal>
          	  	 <logic:equal name="index" value="2"> <!-- Propiedades -->
				    <td class="VectResultDat1">
				       <input class="VectResultDat1" size="90" maxlength="100" type="text" name="prop_<%=idx%>" onblur="this.disabled=true;" onchange="" value='<bean:write name='elemento'/>' disabled>
				    </td>  
				 </logic:equal>
				 <logic:equal name="index" value="3"> <!-- Url -->
				    <td class="VectResultDat1">
				       <input class="VectResultDat1" size="50"maxlength="80" type="text" name="url_<%=idx%>" onblur="this.disabled=true;update(<%=idx%>,this,document.popupForm.idpopup_<%=idx%>,document.popupForm.estado_<%=idx%>,document.popupForm.prop_<%=idx%>,document.popupForm.url_<%=idx%>);" onchange="" value='<bean:write name='elemento'/>' disabled>
				     </td>  
				 </logic:equal>
			 </logic:iterate>
		  </tr>
		  <%idx++;%>
	  </logic:iterate>
  </table>
  <br>
  <p align="center">
   	    <td> 
          <html:button property="btnCerrar" onclick="do_cancelar();"> 
    	     <bean:message key="popup.boton.cerrar"/> 
          </html:button> 
        </td>
   </p>
 </html:form> 
<script language="javascript" >
//desactiva y activa radio

function setBtn(val,num){

	var obj=document.popupForm;
	var cont=num;
	<%int i=0;%>
	if(val=="si"){
	  <%for(i=0;i<=idx-1;i++){%>
        if(<%=i%>==cont)	  
	 		obj.radio_<%=i%>.disabled=false;
		else
			obj.radio_<%=i%>.disabled=true;
	  <%}%>	
	}
	else{
	 if(val=="no"){
		 <%for(i=0;i<=idx-1;i++){%>
			obj.radio_<%=i%>.disabled=false;
		 <%}%>	
	 }
   } 	 	
}	
function update(num,element,CtrlIdpopup,estado,prop,url){

	var obj=document.popupForm;
	var cont=num;
	
	alert("Este registro sera modificado");
	
	setBtn("no",cont);//activa los demas radio
	//obj.BtnAgregar.disabled = false;
		
	obj.glosa_est.value  =  estado.value;
	obj.glosa_prop.value =  prop.value; 
	obj.glosa_url.value  =  url.value;
	obj.idpopup.value    =  CtrlIdpopup.value;
		
	obj.accion.value     = "ModificarPopup";	
	obj.submit();
}
function init(){
	var obj=document.popupForm;
	
 }
   </script>	 
 </body>
</html>






