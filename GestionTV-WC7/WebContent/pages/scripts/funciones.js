
SELECCIONAR_TODO = "Sel. Todo"
DESELECCIONAR_TODO="Des. Todo"

function getArchivoJs()
{
	alert("Compostura y Cortinaje.funciones.js 04/11/2003");
}
// ------------------------------------------------------
// MODULO INICIO: códigos menú izquierdo - Portal Sistemas
// ------------------------------------------------------
	JS_COD_INTRANET_DESA                 = 100;
	JS_COD_INTRANET_INFORMATICA          = 200;
	JS_COD_MANTENEDOR_PORTAL             = 300;
	JS_COD_RRHH_INFOPER                  = 15;
	JS_COD_MANTENEDOR_PORTAL             =  6;
	JS_COD_INTRANET_DESARROLLO           = 16;
	JS_COD_INTRANET_INFORMATICA          = 20;
	JS_COD_PORTAL_PROVEEDORES_DESARROLLO = 21;
	JS_COD_PORTAL_PROVEEDORES_PRODUCCION = 22;
	JS_COD_INCENTIVO_VENDEDORES          =  7;
	JS_COD_PRE_EMISION_TARJETA           = 14;
    JS_COD_RECEPCION_BIGTICKET           = 182;

	JS_COD_COMPOSTURA_Y_CORTINAJE        = 23;
	JS_COD_RCWEB_DESARROLLO              = 12;
	JS_COD_RCWEB_PRODUCCION              = 13;
	JS_COD_INTRANET_RIPLEY               = 19;
	JS_COD_GESFIN                        = 75;
	JS_COD_GESCOM                        = 76;
	JS_COD_GESPER                        = 77;
	JS_COD_CUBICACION                    = 120;	
	JS_COD_AUDITORIA                     = 130;
	JS_COD_LANPASS                       = 84;

// ------------------------------------------------------
// MODULO FIN: códigos menú izquierdo - Portal Sistemas
// ------------------------------------------------------

// ------------------------------------------------------
// MODULO INICIO: íconos linkeables - Portal Sistemas
// ------------------------------------------------------
	JS_COD_MARKETING                     = 80;
	JS_COD_RRHH                          = 81;
	JS_COD_INFORMATICA                   = 82;
	JS_COD_ADM_Y_FINANZAS                = 83;
	
	JS_COD_COMPRAS                       = 91;
	JS_COD_CREDITO                       = 92;
	JS_COD_SUCURSALES                    = 93;
	JS_COD_ALMACENAJE                    = 94;
	JS_COD_VENTA                         = 95;
	JS_COD_COBRANZA                      = 96;
	JS_COD_GESFIN                        = 97;
	JS_COD_GESCOM                        = 98;
	JS_COD_GESPER                        = 99;
// ------------------------------------------------------
// MODULO FIN: códigos linkeables - Portal Sistemas
// ------------------------------------------------------




// ---------------------------------------------------------------------------------
//                                MODULO INICIO: setear hoja estilo 
// ---------------------------------------------------------------------------------
anchoPant = screen.width;
altoPant  = screen.height;
//window.status = anchoPant + "x" + altoPant;

RESOLUCION_800x600  = "800x600";
RESOLUCION_1024x768 = "1024x768";

document.write('<link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">');
document.write('<link rel="stylesheet" type="text/css" href="styles/estylemante.css">');

if( anchoPant == 800 && altoPant == 600)
{
	resolucionPant = RESOLUCION_800x600;
	document.write('<link rel="stylesheet" type="text/css" href="pages/styles/e800x600.css">');
	document.write('<link rel="stylesheet" type="text/css" href="styles/e800x600.css">');
	//alert("RESOLUCION_800x600");
}else{
    // Por default es: anchoPant == 1024 && altoPant == 768 
	resolucionPant = RESOLUCION_1024x768;
	document.write('<link rel="stylesheet" type="text/css" href="pages/styles/e1024x768.css">');
	document.write('<link rel="stylesheet" type="text/css" href="styles/e1024x768.css">');
	//alert("RESOLUCION_1024x768");
}
function isRESOLUCION_800x600()
{
	anchoPant = screen.width;
	altoPant  = screen.height;

	if( anchoPant == 800 && altoPant == 600)
	{
		return(true);
	}else{
		return(false);
	}
}
function isRESOLUCION_1024x768()
{
	anchoPant = screen.width;
	altoPant  = screen.height;

	if( anchoPant == 1024 && altoPant == 768)
	{
		return(true);
	}else{
		return(false);
	}
}
// ---------------------------------------------------------------------------------
//                                MODULO FIN: setear hoja estilo 
// ---------------------------------------------------------------------------------


//CONSTANTES

LMAY = "ABCDEFGHIJKLMN#OPQRSTUVWXYZ"; // Mayúsculas
LMIN = "qwertyuiopasdfghjkl#zxcvbnm"; // Minúsculas
LNUM = "0123456789"; 				  // Números


//DATOS PATICULAR
LNOMBRES = LMAY + LMIN + LNUM + " " + "#";
LPATERNO = LMAY + LMIN + " " + "#";
LMATERNO = LMAY + LMIN + " " + "#";
LRUT     = LNUM;
LDV      = LNUM + "Kk";
//DATOS LABORAL
LEMPRESA = LMAY + LMIN + LNUM + "." + " " + "#";
LCALLE   = LMAY + LMIN + LNUM + "'." + "\"" + " " + "#"; 
LRESTO   = LMAY + LMIN + LNUM + "'." + "\"" + " " + "#"; 
LEMAIL   = LMAY + LMIN + LNUM + "@-_." + "#"; 
LFECHA   = LNUM + "-/";
LFECHA_COMPOSTURA   = LNUM + "/";
LCASILLA = LMAY + LMIN + LNUM + "." + " " + "#";
LPOSTAL  = LMAY + LMIN + LNUM + ".-" + " " + "#";
LSECCION_DPTO = LMAY + LMIN + " " + "#";
LCARGO   = LMAY + LMIN + " " + "#";
LRenLiq  = LNUM;
LPARAM   = LMAY + LMIN + LNUM + "|°!#$&/()=?¡¿*{}[]-_ <>:;,.+";

LMAYGLOSA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Mayúsculas
LMINGLOSA = "qwertyuiopasdfghjklzxcvbnm"; // Minúsculas
LNUMGLOSA = "0123456789"; 				  // Números
LGLOSA   = LMAYGLOSA + LMINGLOSA + LNUMGLOSA + "|°!$/()=?¡*{}[]-_ <>:;,.+";
LCONTEXTO   = LMAYGLOSA + LMINGLOSA + LNUMGLOSA + "/()=?*{}[]-_.+&";
LGLOSACONTEXTO   = LMAYGLOSA + LMINGLOSA + LNUMGLOSA + " ";

//NUMERO DE LA DIRECCION
LNUMDIR  = LMAY + LMIN + LNUM + "/"; 

Lis_alfabetica   = "ABCDEFGHIJKLMN#OPQRSTUVWXYZ" + "qwertyuiopasdfghjkl#zxcvbnm" + " ";
Lis_numerica     = "0123456789";
Lis_alfanumerica = Lis_numerica + Lis_alfabetica;

Lis_car_empresa = Lis_alfanumerica + "._-";
Lis_car_email   = Lis_alfanumerica + "@-_."; 
Lis_car_rut     = Lis_numerica;
Lis_car_calle   = Lis_alfanumerica + "'/-_" + "\""; 
Lis_car_resto   = Lis_car_calle;

colorFondoPlomoGlobal  = "cccccc";
colorFondoBlancoGlobal = "ffffff";
colorLetraNegraGlobal  = "000000";


plomo               = "CCCCCC";
rojo                = "FF0000";
verde               = "408080";
plomoOscuro         = "999999";
negro               = "000000";
amarilloCrema       = "ffffcc";

COLOR_PLOMO_OSCURO = "999999";
COLOR_MOSTAZA = "CC9900";  
COLOR_CAFE    = "996600";
COLOR_BURDEO  = "990000";

COLOR_TAB_ACCESO_DIRECTO = COLOR_PLOMO_OSCURO;
COLOR_TAB_APOYO          = COLOR_MOSTAZA; 
COLOR_TAB_GESTION        = COLOR_CAFE; 
COLOR_TAB_OPERACIONES    = COLOR_BURDEO; 

/*
	INDICE DE FUNCIONES

function setStatusBar(){
function getFecha(obj_dia,obj_mes,obj_yea,delimitador)
function getValueSelect(obj_select)
function valida_caracteres(event,Lista)
function validar_txt(obj_txt,mensaje)
function validar_rut(obj_rut,obj_dv,mensaje)
function espacios(str)
function boton_enter(e, instruccionEnter, instruccionEscape )
function valida_email(obj_email)
function calcula_rut(rut,dv)
function mc_trim(s){
function valida_longuitud_numero(obj_txt,min,max)
function SetOptionValue( obj_sel, x )
function BtnAntSig( verBtnAnterior , verBtnSiguiente )
function doSelectYear()
function getFechaActual(){
function doLimpiar( strNombreDelFormulario )
//
//
//****************************************************************************************
//                                  Módulo: Inserta Puntos 
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan dos funciones
// function insertapuntos(strval)
// function Right(strvar,intcant)
//
//
//****************************************************************************************
//                          Módulo: Elimina los ceros de la izquierda
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan tres funciones
// function primer_cero(texto)
// function elimina_un_cero(texto,i)
// function elimina_ceros_izq(texto) --> función principal
//
//
//****************************************************************************************
//                          Módulo: Obtener Dígito Verificador
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan tres funciones
// function primer_cero(texto)
// function elimina_un_cero(texto,i)
// function elimina_ceros_izq(texto) --> función principal


//function trim(s)
//function doSetOption( sel, opt )
//function ValidaFecha( objTextFecha ) 
//function getValueTextAll( strNombreDelFormulario )
//function jsClock(forNom,txtNom)
//
//****************************************************************************************
//                                  Módulo: Inserta Hora Actual 
//****************************************************************************************
// modificadoPor.mcoronae.28ago2002
// Se necesitan dos funciones
// function setHoraActual()
// function jsClock(forNom,txtNom)
//
// forNom es una variable de tipo String. Representa el nombre del formulario
// txtNom es una variable de tipo String. Representa el nombre del objeto text
//
//

//function valida_celular(obj_txt)
//function elimina_primer_caracter(str)
//function seleccioneOptionObjSelect( ObjSelect , valueSelect , mensaje )


//****************************************************************************************
//                                  Módulo: Salto Automático
//****************************************************************************************
	// Autor : mcoronae
	// Creado: 11sep2002
	// Se necesitan 6 funciones

	// ------------------------- PROTOTIPOS --------------------------
	//
	// function classSalto()      Constructor. Crea un nuevo objeto. 
	// function setContador( x )  Cambia a un nuevo valor el atributo contador
	// function getContador()     Obtiene el valor del atributo contador
	// function incremento()      Incrementa en una unidad el atributo contador
	// function saltoAutomatico  ( e , objTextOrigen , objDestino , objSalto, nCaracteres ) Administra el salto automático
	// function saltoAutomaticoDV( e , objTextOrigen , objDestino , objSalto, nCaracteres ) Administra el salto automático


// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
//
	// function goWindowPopupCalendario( nameFormulario , nameObjetoText)
	// function limpiarObjetosText( objFor )

function limpiarObjetosText( objFor )
function setObjText( objText , strValor )
function validarNumero( objText )
function setLabelCodArea( codArea )
function existeValueObjText( objText )
function getMinRangoForFono( codRegion , codComuna )
function getMaxRangoForFono( codRegion , codComuna )
function setColorObjText( objText , colorFondo , colorLetra )
function validarObjSelect( objSelect , valorEsperado , mensaje )


--- autor.mce.30oct2002 --
function setObjSelect( obj_sel, x )
function creaObjSelect( objSelect , arr )
function creaObjSelectNumCargas( objSelect )

--- autor.mce.31oct2002 --
function setColorObj( objeto , colorFondo , colorLetra )

--- autor.mce.22nov2002 --
function validar_fechaNac(fechaNac,edadMinima,edadMaxima)

--- autor.mce.28nov2002 --
function saltoAutomatico2( e , objTextOrigen , objDestino , nCaracteres , instruccionExecute)

--- autor.mce.24dic2002 --
	function setMensajeError(error)

--- autor.mce.04feb2003 --
function setTextObjSelect( sel, opt )

--- autor.mce.11feb2003 --
function getTextSelect(obj_select)

*/


var text = "     Intranet Ripley - Sistema de Crédito  2002 v2.0 - Chile   " ; //Texto
var lonText = text.length; //Longuitud del texto

function setStatusBar(){
	text = text.substring(1,lonText-1) + text.charAt(0);
	window.status = text;
	setTimeout("setStatusBar()",150);
}
function getFecha(obj_dia,obj_mes,obj_yea,delimitador)
{
	return(getValueSelect(obj_dia) + delimitador + getValueSelect(obj_mes) + delimitador + getValueSelect(obj_yea));
}
function getValueSelect(obj_select)
{
	i = obj_select.selectedIndex;

	if( i == (-1) )
		str = "-1"; //No existe índice seleccionado
	else
		str = obj_select.options[i].value;

	return(str);
}
function espacios(str)
{
	var lon = str.length;  	// Longuitud del string
	var tem = ""; 			// Variable temporal
	var con = 0;			// Contador;

	for( i = 0 ; i < lon ; i++ ){
		if( str.charAt(i) == " " ){
			con = con + 1;
		}
	}
	if( con == str.length )return(""); else	return(str);
}
function validar_rut(obj_rut,obj_dv,mensaje)
{
	siguiente = validar_txt(obj_rut,mensaje);
	if( !siguiente )return(siguiente);

	valor = obj_rut.value;
	if( valor == "0" || valor == "00000000"){
		alert("¡ El RUT 0 no está permitido. Ingrese otro RUT !");
		obj_rut.value = "";
		obj_dv.value  = "";
		obj_rut.focus();
		return(false);
	}	
	siguiente = calcula_rut(obj_rut,obj_dv);

	return(siguiente);
}
function validar_txt(obj_txt,mensaje)
{
	var valor = "";

	if( obj_txt.disabled == false )
	{
		valor = espacios(obj_txt.value);
		if(  valor == "" ){
			obj_txt.value = "";		alert(mensaje);		obj_txt.focus();		return(false);
		}else{
			obj_txt.value = mc_trim(obj_txt.value);
			return(true);
		}
	}
	return( true );
}
function valida_caracteres(e,Lista)
{
	// e: event
	var tecla, buscar = Lista;		
  	if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;

   	c = String.fromCharCode(tecla);	
	if( buscar.indexOf(c) == -1 )return(false);else return(true);

}
function boton_enter(e, instruccionEnter, instruccionEscape )
{
	// e: event
  	var tecla;

  	if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;

	if( tecla == 13)eval( instruccionEnter  );
	if( tecla == 27)eval( instruccionEscape );

	return(true);
}
function valida_email(obj_email)
{
	str = obj_email.value

	if( str.length > 0 ){
		mensaje = "El email no es válido. Inténte nuevamente.";
		buscar = str.indexOf("@");if( buscar == -1){alert(mensaje);obj_email.focus();return(false);}
		buscar = str.indexOf(".");if( buscar == -1){alert(mensaje);obj_email.focus();return(false);}
	}
	return(true);//Retornar true porque es opcional el e-mail.
}
function calcula_rut(rut,dv)
{
	//Entrada válida: el rut sin puntos, 11813714
	//Objetos:
	//rut       objeto text, name: Rut
	//dv        objeto text, name: dv
	//Retorna true si el rut es correcto. En caso contrario, false.

   Sum = 0;   digito = 0;   factor = 2;
   largo = rut.value.length;

   while (largo !== 0){
	Sum = Sum + (rut.value.substring(largo, largo-1) * factor);
	if (factor == 7){	factor = 2;		}
	else{
		factor = factor + 1;
	}
	largo = largo - 1;
   }
  
	d = 11 - Sum % 11;
    if (d == "10"){
		digito = "K";    
	}else{
		if (d == "11"){	digito = 0;  }else{ digito = d; }
	}
	
   if (digito == dv.value.toUpperCase()  ){	
      return true; 
    }else{
	  alert("¡ El RUT ingresado no es correcto ! ");
	  rut.focus();
	  return false;
	}

}//End Function


function mc_trim(s){
	sNew = "";
	if (s.length > 0){
	  for (i = 0; i < s.length; i++){
	    if (s.substring(i, i + 1) != " "){
	      for (j = s.length; j >= i; j--){
	       if (s.substring(j - 1, j) != " "){
	         sNew = s.substring(i, j);
	         break;
	       }
	      }
	      break;
	    }
	  }
	}  
	return sNew;
}
function valida_longuitud_numero(obj_txt,min,max,prmMensaje)
{
	str = obj_txt.value;
	lon = str.length;  	

	if( lon > 0 ){

		if( !validarNumero( obj_txt ) )return( false );

		if( lon < min  || lon > max){
			if( min == max )
				mensaje = prmMensaje + "El rango permitido es de " + min + " dígitos";
			else
				mensaje = prmMensaje + "El rango permitido es de " + min + " a " + max + " dígitos";

			alert(mensaje);
			obj_txt.focus();
			return(false);
		}
	}
	return(true);
}
function SetOptionValue( obj_sel, x )
{
  var lon = obj_sel.length;

  for( i = 0; i < lon ; i++ )
  {
    if( obj_sel.options[i].value == x )
    {
      obj_sel.selectedIndex = i;
      return(true);
    }
  }
  if( i == lon ){
      obj_sel.selectedIndex = 0;  
  }
  return(false);
}
// ************************************************************************************
// **************************** Módulo: Botones Anterior Siguiente ******************** 
// ************************************************************************************
function BtnAntSig( verBtnAnterior , verBtnSiguiente )
{
	//Parámetros:
	//  verBtnAnterior  <-- true o false
	//  verBtnSiguiente <-- true o false

    document.write('<table width="97%" align="center" cellspacing="1"><tr><td align="right">');

	if( verBtnAnterior )
    document.write('<input type="button" name="btn_Anterior" value="Anterior" style="width:80px" onclick="doSiguiente(0)" >');
	else
    document.write('<input type="button" name="btn_Anterior" value="Anterior" style="width:80px" disabled  onclick="doSiguiente(0)" > ');

	document.write('&nbsp;&nbsp;&nbsp;');

	if( verBtnSiguiente )
    document.write('<input type="button" name="btn_Siguiente" value="Siguiente"  style="width:80px" onclick="doSiguiente(1)">');
	else
    document.write('<input type="button" name="btn_Siguiente" value="Siguiente"  style="width:80px" disabled onclick="doSiguiente(1)" >');

    document.write('</td></tr></table>');

}
// ************************************************************************************
// **************************** Fin Módulo: Botones Anterior Siguiente ******************** 
// ************************************************************************************
function doSelectYear( prm_year ) 
{
	var fecha = new Date();
	var y = fecha.getYear();
	
	document.write('<select name="select_year_cartola" class="fontSelect" onchange="doNuevaBusqueda()">');
	for( var i = 1999 ; i <= y ; i++ ) {
			  document.write('<option value='+i+'>'+i+'</option>');
	}
	document.write('</select>');
	SetOptionValue( select_year_cartola, prm_year );
}
function getFechaActual(){
	var diaSemana = new Array('Domingo', 'Lunes', 'Martes','Miércoles', 'Jueves', 'Viernes','Sábado');
	var mesName = new Array('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre');
	var fecha = new Date();
	var dia = fecha.getDay(); 
	var mes = fecha.getMonth();
	var ano = fecha.getYear();
	var numero = fecha.getDate();
		
	FechaActual = diaSemana[dia] + " " + numero + " de " + mesName[mes] + " de " + ano;
	//return( FechaActual );
	document.write("<b class='ObjFecha'>" + FechaActual + "</b>");
}
function doLimpiar( strNombreDelFormulario ){
	var numTexts = document.forms[strNombreDelFormulario].elements.length;
		
	for( i = 0 ; i < numTexts ; i++ ){	    
		if( document.forms[strNombreDelFormulario].elements[i].type == "text")
		   document.forms[strNombreDelFormulario].elements[i].value = "";
	}
}
//****************************************************************************************
//                                  Módulo: Inserta Puntos 
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan dos funciones
// function insertapuntos(strval)
// function Right(strvar,intcant)

function insertapuntos(strval){
	var A = new Array();
	var strtemp = strval;
					
	strtemp = new Number(strtemp);
	strtemp = new String(strtemp);
	if (strtemp.length > 3){
		for(var i = 0; strtemp.length > 3; i++){
		  A[i] = Right(strtemp,3);
		  strtemp /= 1000;
		  strtemp=new String(strtemp);
		  if (strtemp.indexOf('.') != -1)
		    strtemp = strtemp.substr(0,strtemp.indexOf('.'));
		}
		for(i-- ;i >= 0 ;i--)
			strtemp = strtemp + "." + A[i];
	}
	return(strtemp);			
}  
function Right(strvar,intcant){
	strtemp = "";
	intlargo = strvar.length -1;
	for(i = 1;i <= intcant; i++){
	 strtemp = strtemp + strvar.charAt(intlargo);
	 intlargo--;	
	}					
	strtmp2=""
	for(intlargo = strtemp.length -1; intlargo >=0; intlargo--)
		strtmp2 = strtmp2 + strtemp.charAt(intlargo);
					
	return(strtmp2);
}
//****************************************************************************************
//                                  Fin Módulo: Inserta Puntos 
//****************************************************************************************



//****************************************************************************************
//                          Módulo: Elimina los ceros de la izquierda
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan tres funciones
// function primer_cero(texto)
// function elimina_un_cero(texto,i)
// function elimina_ceros_izq(texto) --> función principal

function primer_cero(texto)
{
	var un_cero="0";

	for(var i=0;i<texto.length;i++)
	{
		ch = texto.charAt(i);
		if( ch == un_cero )
			return i
		else
			return -1
	}
	return -1
}
function elimina_un_cero(texto,i)
{
	if( i != -1)
	{
		pd = texto.substring(i+1,texto.length);
		pi = texto.substring(0,i);
		return(pi + pd);		 
	}
	return texto;
}
function elimina_ceros_izq(texto)
{
	p = primer_cero(texto);
	while( p != -1 )
	{
		texto = elimina_un_cero(texto,p);
		p = primer_cero(texto);
	}

	if( texto.length == "0" )texto = "0";

	return(texto);
}
//****************************************************************************************
//                          Fin Módulo: Elimina los ceros de la izquierda
//****************************************************************************************



//****************************************************************************************
//                          Módulo: Obtener Dígito Verificador
//****************************************************************************************
// modificadoPor.mcoronae.23ago2002
// Se necesitan tres funciones
// function primer_cero(texto)
// function elimina_un_cero(texto,i)
// function elimina_ceros_izq(texto) --> función principal

function getDigVerificador( strRut )
{
	//Entrada válida: el rut sin puntos, 11813714
	//Objetos:
	//rut       objeto text, name: Rut

   Sum = 0;   digito = 0;   factor = 2;
   largo = strRut.length;

   while (largo !== 0){
	Sum = Sum + (strRut.substring(largo, largo-1) * factor);
	if (factor == 7){	factor = 2;		}
	else{
		factor = factor + 1;
	}
	largo = largo - 1;
   }
  
	d = 11 - Sum % 11;
    if (d == "10"){    digito = "K";    }
	else{
		if (d == "11"){	digito = 0;  }else{ digito = d; }
	}
	return(digito);

}//End Function
//****************************************************************************************
//                          Fin Módulo: Obtener Dígito Verificador
//****************************************************************************************
//
//
//
function trim(s){
	sNew = "";
	if (s.length > 0){
	  for (i = 0; i < s.length; i++){
	    if (s.substring(i, i + 1) != " "){
	      for (j = s.length; j >= i; j--){
	       if (s.substring(j - 1, j) != " "){
	         sNew = s.substring(i, j);
	         break;
	       }
	      }
	      break;
	    }
	  }
	}  
	return sNew;
}
function doSetOption( sel, opt )
{
  var l = sel.length;
  var i = 0;

 
  for( i = 0; i < l ; i++ )
  {
    if( sel.options[i].value == opt )
    {
      sel.selectedIndex = i;
      return(true);
    }
  }
  return(false);
}
function ValidaFecha(obj) 
 {
  var error="Fecha incorrecta :";

  if (!((obj.value == null) || (obj.value.length == 0)))
  {
     var vfecha=obj.value.match(/[0-9][0-9]\/[0-9][0-9]\/[0-9][0-9][0-9][0-9]/)
     if (!vfecha)
     {
        alert("Fecha incorrecta en formato [dd/mm/yyyy]");    
        obj.value = "";
        obj.focus();
     }
     else
     {
        var xDia=obj.value.substr(0,2);
        if (!((xDia >= 1) && (xDia <= 31))){
            error=error+"\n"+"día "+xDia+" fuera de rango [1-31]"; 
           alert(error);   
           obj.value = "";
           obj.focus();
		   return;
		}

        var xMes=obj.value.substr(3,2);
        if (!((xMes >= 1) && (xMes <= 12))){
           error=error+"\n"+"mes "+xMes+" fuera de rango [1-12]"; 
           alert(error);   
           obj.value = "";
           obj.focus();
		   return;
		}

        var xAno=obj.value.substr(6,4);
        if (!((xAno>= 1900) && (xAno <= 2200))){
           error=error+"\n"+"año "+xAno+" fuera de rango [1900-2200]";
           alert(error);   
           obj.value = "";
           obj.focus();
		   return;
		}
     }
  }
}
function getValueTextAll( strNombreDelFormulario ){
	var numTexts = document.forms[strNombreDelFormulario].elements.length;

	for( i = 0 ; i < numTexts ; i++ ){	    
		if( document.forms[strNombreDelFormulario].elements[i].type == "text"){
		   val = document.forms[strNombreDelFormulario].elements[i].value;
		   nom = document.forms[strNombreDelFormulario].elements[i].name;
   		   if(  !confirm( nom + "-->" + val + " ¿ Desea continuar ? ")  )return;
		}
	}
}
function getValueTextHiddenAll( strNombreDelFormulario ){
	var numTexts = document.forms[strNombreDelFormulario].elements.length;

	for( i = 0 ; i < numTexts ; i++ ){	    
		if( document.forms[strNombreDelFormulario].elements[i].type == "hidden"){
		   val = document.forms[strNombreDelFormulario].elements[i].value;
		   nom = document.forms[strNombreDelFormulario].elements[i].name;
   		   if(  !confirm( nom + "-->" + val + " ¿ Desea continuar ? ")  )return;
		}
	}
}
//****************************************************************************************
//                                  Módulo: Inserta Hora Actual 
//****************************************************************************************
// modificadoPor.mcoronae.28ago2002
// Se necesitan dos funciones
// function setHoraActual(forNom,txtNom)
// function jsClock(forNom,txtNom)
//
// forNom es una variable de tipo String. Representa el nombre del formulario
// txtNom es una variable de tipo String. Representa el nombre del objeto text
//
function setHoraActual(){
	document.write('<form name="formHoraActual" method="post" action="">');
	document.write('<p align="right">');
	document.write('    <input type="text" name="txtHora" value="" size="14" class="ObjHora">');
	document.write('</p>');
	document.write('</form>');

	forNom = "formHoraActual"; // Set Nombre del Formulario
	txtNom = "txtHora";        // Set Nombre del objeto text
	jsClock(forNom,txtNom);
}
function jsClock(forNom,txtNom){
	var time = new Date();
	var hour = time.getHours();
	var minute = time.getMinutes();
	var second = time.getSeconds();
	
	var hora = " " + ((hour > 12)? hour - 12 : hour );
	hora += ((minute < 10 )? ":0" : ":" ) + minute;
	hora += ((second < 10 )? ":0" : ":" ) + second;
	hora += ((hour  >= 12 )? " P.M. " : " A.M. " )
	document.forms[forNom].elements[txtNom].value = hora;
	id = setTimeout( "jsClock('"+forNom+"','" + txtNom + "')", 1000 );
}
//****************************************************************************************
//                                  Fin Módulo: Inserta Hora Actual 
//****************************************************************************************
//
//
function valida_celular(obj_txt)
{
	var str = trim(obj_txt.value);	// string
	var lon = str.length;			// longuitud del string
	var siguiente = true;			// booleano	
	var car = ""; 					// caracter
	var longuitud = 8;
	
	if( lon > 0 ){
		if( lon != longuitud ){
			mensaje = "El rango permitido para el Teléfono Celular es de " + longuitud + " dígitos";
			alert(mensaje);
			obj_txt.focus();
			return(false);
		}
	}
	if( lon > 0 ){
		car = str.charAt(0);
	
		if( car != 9 && car != 8 ){
			alert("El Teléfono Celular debe comenzar por 8 ó 9");
			obj_txt.focus();
			return(false);
		}
	}

	return(true);
}
function elimina_primer_caracter(str)
{
	var lon = str.length;

	if( lon > 0  ){
		return(str.substring(1,lon));
	}
	return("");
}
function seleccioneOptionObjSelect( ObjSelect , valueSelect , mensaje )
{	
	cod = getValueSelect( ObjSelect ) ;
	if( cod == valueSelect ){
		alert( mensaje );
		ObjSelect.focus();
		return(false);
	}
	return(true);
}
//****************************************************************************************
//                                  Módulo: Salto Automático
//****************************************************************************************
	// Autor : mcoronae
	// Creado: 11sep2002
	// Se necesitan 6 funciones

	// ------------------------- PROTOTIPOS --------------------------
	//
	// function classSalto()      Constructor. Crea un nuevo objeto. 
	// function setContador( x )  Cambia a un nuevo valor el atributo contador
	// function getContador()     Obtiene el valor del atributo contador
	// function incremento()      Incrementa en una unidad el atributo contador
	// function saltoAutomatico  ( e , objTextOrigen , objDestino , objSalto, nCaracteres , instruccionExecute) Administra el salto automático
	// function saltoAutomaticoDV( e , objTextOrigen , objDestino , objSalto, nCaracteres , instruccionExecute) Administra el salto automático
	
	// -------------------------- PARAMETROS DEL MÉTODO saltoAutomatico ---------------------------
	//
	// function saltoAutomatico  ( e , objTextOrigen , objDestino , objSalto, nCaracteres , instruccionExecute)
	//
	// e             es un objeto de window.event
	// objTextOrigen es un objeto Text
	// objDestino    es un objeto que puede ser un objeto Text o un objeto botón
	// objSalto      es un objeto personalizado para realizar el salto automático
	// nCaracteres   es la cantidad de caracteres que se deben teclear para realizar el salto automático
	// instruccionExecute instrucción que se desea ejecutar al cumplirse los nCaracteres válidamente ingresados

	// ----------- Observaciones -------------------
	//
	// saltoAutomaticoDV es similar a saltoAutomatico. 
	// La diferencia es que saltoAutomaticoDV acepta números y las letra k, K
	// saltoAutomatico acepta sólo números.

	function classSalto()
	{
		this.contador = 0;
		this.setContador = setContador;
		this.getContador = getContador;
		this.incremento  = incremento;
		return( this );
	}
	function setContador( x ){	this.contador = x; }
	function getContador()   {	return( this.contador );}
	function incremento()    {	this.contador++ ; }
	
	function saltoAutomatico( e , objTextOrigen , objDestino , objSalto, nCaracteres , instruccionExecute)
	{	
		var tecla;
		
		if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;
	
		valor = objTextOrigen.value.length;		
		//window.status = valor;
		if( valor == nCaracteres ){
			objDestino.focus();
			if( instruccionExecute != null )eval( instruccionExecute );
		}		
	}
	function saltoAutomaticoDV( e , objTextOrigen , objDestino , objSalto, nCaracteres , instruccionExecute)
	{	
		var tecla;
		
		if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;
	
		valor = objTextOrigen.value.length;		
		//window.status = valor;
		if( valor == nCaracteres ){
			objDestino.focus();
			if( instruccionExecute != null )eval( instruccionExecute );
		}		
	}
//****************************************************************************************
//                                  Fin Módulo: Salto Automático 
//****************************************************************************************


// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
//
function goWindowPopupCalendario( nameFormulario , nameObjetoText)
{
	document.formularioPadre.txtNameFormulario.value = nameFormulario;
	document.formularioPadre.txtNameObjetoText.value = nameObjetoText;

	var wurl      = "pages/Calendario.html";	
	var wleft     = "left=350";
    var wtop      = "top=300";
    var wname     = "Autorización";
    var wtoolbar  = "toolbar=no";
    var wlocation = "location=0";
    var wdir      = "directories=no";
    var wstatus   = "status=no";
    var wmenubar  = "menubar=0";
    var wscroll   = "scrollbars=no";
    var wresize   = "resizable=no";
    var wwidth    = "width=270";
    var wheight   = "height=270";

    window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 FIN MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
function limpiarObjetosText( objFor )
{
	var nObj = objFor.elements.length ; // Cantidad de Objetos del Formulario
	var valor = "";
	 
	for( var i = 0 ; i < nObj ; i++ )
	{
		if( objFor.elements[i].type == "text" )
		{
			 valor = trim( objFor.elements[i].value ); 
			 
			 objFor.elements[i].value = valor ;					
			 
			if( valor.length == 0 )objFor.elements[i].value = "";					
		}
	}
}
function setObjText( objText , strValor )
{
	if( strValor == null )strValor = "";

	objText.value = strValor;
}
function validarNumero( objText )
{	
	valor = objText.value;

	if( isNaN( valor ) ){
		alert("Ingrese un número");
		objText.value = "";
		objText.focus();
		return(false);
	}
	return(true);
}
function setLabelCodArea( codArea )
{
	document.write('<table><tr><td class="objLabelCodArea">'+codArea+'</td></tr></table>');
}
function existeValueObjText( objText )
{
	objText.value = trim( objText.value )

	if(  objText.value.length > 0 )
		return(true);
	else
		return(false);
}
function getMinRangoForFono( codRegion , codComuna )
{
	if( codRegion == "0"){	// Región Metropolitana
		min = 7; 
	}else{
		// Otras Regiones
		min = 6; 
	}	
	return(min);
}
function getMaxRangoForFono( codRegion , codComuna )
{
	if( codRegion == "0"){	// Región Metropolitana
		max = 7;
//	}else if( codRegion == "9" && codComuna == "9-30" ){
	}else if( codRegion == "9" ){
		// Temuco		 
		max = 7;
	}else{
		// Otras Regiones
		max = 6;
	}	
	return(max);
}
function setColorObjText( objText , colorFondo , colorLetra )
{
	objText.style.background = colorFondo;
	objText.style.color      = colorLetra;
}
function validarObjSelect( objSelect , valorEsperado , mensaje )
{	
	if( objSelect.disabled == false )
	{
		valor = getValueSelect( objSelect );	
		if( valor == valorEsperado ) // valorEsperado = 0 --> 0:Seleccione
		{
			alert( mensaje );
			objSelect.focus();
			return(false);		
		}
	}
	return(true);		
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: setBlinkText 
// --------------------------------------------------------------------------------------------------------------------
//
// Se usa un objeto de tipo css: objBlinkText que debería estar en el archivo estilo.css
//
function setBlinkText(forName,txtName,blinkText){

	document.write('<input type="text" name="'+txtName+'" value="" size="14" class="objBlinkText" readonly>');

	jsClockBlink(forName,txtName,blinkText,0);
}
function jsClockBlink(forName,txtName,blinkText,i){

	if( i == 1 )
 	{
	 	document.forms[forName].elements[txtName].value = "";
		i = 0;	
	}else{
	 	document.forms[forName].elements[txtName].value = blinkText;	
		i = 1;	
	}

	id = setTimeout( "jsClockBlink('"+forName+"','" + txtName + "','" + blinkText + "'," + i + ")", 500 );
}
function setBlinkText_version2(forName,txtName,blinkText,size){

	document.write('<input type="text" name="'+txtName+'" value="" size="'+size+'" class="objBlinkText" readonly>');

	jsClockBlink(forName,txtName,blinkText,0);
}

// --------------------------------------------------------------------------------------------------------------------
//                                                 FIN MODULO: setBlinkText 
// --------------------------------------------------------------------------------------------------------------------
function stringSplit ( string, delimiter ) { 
    if ( string == null || string == "" ) { 
        return null; 
    } else if ( string.split != null ) { 
        return string.split ( delimiter ); 
    } else { 
        var ar = new Array(); 
        var i = 0; 
        var start = 0; 
        while( start >= 0 && start < string.length ) { 
             var end = string.indexOf ( delimiter, start ) ; 
             if( end >= 0 ) { 
                 ar[i++] = string.substring ( start, end ); 
                 start = end+1; 
             } else { 
                 ar[i++] = string.substring ( start, string.length ); 
                 start = -1; 
             } 
        } 
        return ar; 
    } 
} 
function creaObjSelectRegion( arrRegion , objSelectReg )
{
	// Se utiliza la función trim()
	var CadenaRegion="";
	var pos = "";
	var nRegiones = arrRegion.length;

	objSelectReg.length = nRegiones; 
	
    for ( var i=0; i < arrRegion.length; i++ ) 
	{
	     CadenaRegion = trim(arrRegion[i][0]);
	     pos = CadenaRegion.indexOf('/', 0 );
		 objSelectReg.options[i].value  = CadenaRegion.substring(0,pos);
         objSelectReg.options[i].text   = CadenaRegion.substring(pos+1,CadenaRegion.length);
    }   
}
function creaObjSelectComuna( arrComuna , objSelectCom , codReg )
{
	// Se utiliza la función trim()

	var indice   = parseInt(codReg);
	var pos = "";
	var nComunas = arrComuna[indice].length;
	
	objSelectCom.length = nComunas; 

	for( var j=0 ; j < nComunas ; j++ ) 
	{
         CadenaComuna = trim(arrComuna[indice][j]);
		 pos = CadenaComuna.indexOf('/', 0 );
         objSelectCom.options[j].value = CadenaComuna.substring(0,pos);
         objSelectCom.options[j].text  = CadenaComuna.substring(pos+1,CadenaComuna.length);
    }         
}
function creaObjetosSelectRegionComuna( arrRegion , arrComuna , objSelectReg , objSelectCom , codReg , codCom ) 
{
	creaObjSelectRegion( arrRegion , objSelectReg );
	creaObjSelectComuna( arrComuna , objSelectCom , codReg );
	doSetOption(objSelectCom,codCom); 
    doSetOption(objSelectReg,codReg); 
}
function updateObjSelectComuna( arrRegion, arrComuna, objSelectReg, objSelectCom )
{
	// Se utiliza la función trim()
	
	var arreglo;
    var sel = objSelectReg.selectedIndex;

    if ( sel >= 0 && sel < arrRegion.length ){ 
        arreglo = arrComuna[sel];
	}else{
        arreglo = new Array ();
	}    
    objSelectCom.length = arreglo.length;

    for( var i = 0; i < arreglo.length; i++ ) 
	{
      var CadenaComuna = trim( arreglo[i] );
	  var pos = CadenaComuna.indexOf('/', 0 );
      objSelectCom.options[i].value = CadenaComuna.substring(0,pos);
	  objSelectCom.options[i].text  = CadenaComuna.substring(pos+1,CadenaComuna.length);
    }
	SetOptionValue(objSelectCom,"0-0"); 

}
function updateCodArea( arrArea , objSelectCom , objTextArea )
{
	// Se utiliza la funcion trim()
		
	var CadenaComuna = "";
	var pos = "";
	var ValorComuna = "";
  	var codComuna = "";

	  codComuna = objSelectCom.options[objSelectCom.selectedIndex].value;
	  for( var i = 0; i < arrArea.length; i++ ) 
	   {
		  CadenaComuna = trim( arrArea[i] );
		  pos = CadenaComuna.indexOf('/', 0 );
		  ValorComuna = CadenaComuna.substring(0,pos);
		  if( ValorComuna == codComuna )
		  {
			var TextComuna  = CadenaComuna.substring(pos+1,CadenaComuna.length);
			objTextArea.value = TextComuna;
			return;
		  }
	   }
	  objTextArea.value = "";
	  return;
}

// *******************************************************************************************************************
// FUNCIONES PARA LAS PAGINAS CON EL SUFIJO "FIJO" - SISTEMA LOCAL: MI PC
// *******************************************************************************************************************


// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
//
function goWindowPopupCalendarioFIJO( nameFormulario , nameObjetoText)
{
	document.formularioPadre.txtNameFormulario.value = nameFormulario;
	document.formularioPadre.txtNameObjetoText.value = nameObjetoText;

	var wurl      = "CalendarioFIJO.html";	
	var wleft     = "left=350";
    var wtop      = "top=300";
    var wname     = "Autorización";
    var wtoolbar  = "toolbar=no";
    var wlocation = "location=0";
    var wdir      = "directories=no";
    var wstatus   = "status=no";
    var wmenubar  = "menubar=0";
    var wscroll   = "scrollbars=no";
    var wresize   = "resizable=no";
    var wwidth    = "width=270";
    var wheight   = "height=270";

    window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 FIN MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------

// autor.mce.30oct2002
function setObjSelect( obj_sel, x )
{
  var lon = obj_sel.length;

  for( i = 0; i < lon ; i++ )
  {
    if( obj_sel.options[i].value == x )
    {
      obj_sel.selectedIndex = i;
      return(true);
    }
  }
  return(false);
}
// autor.mce.30oct2002
function creaObjSelect( objSelect , arr )
{
	// Se utiliza la función trim()
	var Cadena="";
	var pos = "";
	var nElementos = parseInt(arr.length);

	if( nElementos > 0 )
	{
		objSelect.length = nElementos; 
		
		for ( var i = 0 ; i < nElementos ; i++ ) 
		{
			 Cadena = trim(arr[i]);
			 pos = Cadena.indexOf('/', 0 );
			 objSelect.options[i].value  = Cadena.substring(0,pos);
			 objSelect.options[i].text   = Cadena.substring(pos+1,Cadena.length);
		}   
	}
}
// autor.mce.30oct2002
function creaObjSelectNumCargas( objSelect )
{
	var nElementos = 16;

	objSelect.length = nElementos; 
	
	for ( var i = 0 ; i < nElementos ; i++ ) 
	{
		 objSelect.options[i].value  = i;
		 objSelect.options[i].text   = i;
	}   
}
// autor.mce.31oct2002
function setColorObj( objeto , colorFondo , colorLetra )
{
	//alert("setColorObj");
	objeto.style.background = colorFondo;
	objeto.style.color      = colorLetra;
}
function validar_fechaNac(fechaNac,edadMinima,edadMaxima)
{
	 var fecha   = fechaNac; 
	 var edadMin = edadMinima;
	 var edadMax = edadMaxima;
	 var ano, difMes, difDia, mensaje;
	
	// FECHA ACTUAL. 
	// Formato Fecha: dd/mm/yyyy	
	//
	var fecAct = new Date();
	var diaAct = fecAct.getDate();      // Formato día: dd
	var mesAct = fecAct.getMonth()+1;   // Formato mes: mm
	var anoAct = fecAct.getFullYear();  // Formato año: yyyy
	//fecActFormat = diaAct + "/" + mesAct + "/" + anoAct;
	
	// FECHA NACIMIENTO
	// Formato Fecha: dd/mm/yyyy	
	//
	var diaFecNac = parseInt(fecha.substring(0,2)); // Formato día: dd
	var mesFecNac = parseInt(fecha.substring(3,5)); // Formato mes: mm
	var anoFecNac = parseInt(fecha.substring(6,11));// Formato año: yyyy
	//fechaFormat = diaFecNac + "/" + mesFecNac + "/" + anoFecNac;
	
	ano = anoAct - anoFecNac;
	
	// ---------------------------------------------------------------------------------
	// inicio Caso: 18 años
	// ---------------------------------------------------------------------------------
	if( ano == edadMin )
	{
		// Descripción: Determina si el aval tiene 18 años o está por cumplir los 18.
		difMes = mesFecNac - mesAct; 
	
		if( difMes == 0 )
		{
			difDia = diaFecNac - diaAct; 
			if( difDia == 0 )
			{
				alert("El aval está de cumpleaños. Hoy cumple 18 años");				
				return(true);
			}
			else if( difDia == 1 )
			{
				mensaje = "Falta un día para cumplir 18 años";
				alert( mensaje + "\n\nEdad Fuera de Rango. La edad es desde " + edadMin + " hasta " + edadMax + " años cumplidos");		
				return(false);
			}
			else if( difDia > 1 )
			{
				mensaje = "Faltan " + difDia + " días para cumplir 18 años";		
				alert( mensaje + "\n\nEdad Fuera de Rango. La edad es desde " + edadMin + " hasta " + edadMax + " años cumplidos");		
				return(false);
			}
			else
			{
				return(true);
			}			
		}
		else if( difMes > 0 )
		{
			mensaje = "El aval aún no cumple 18 años";
			alert( mensaje + "\n\nEdad Fuera de Rango. La edad es desde " + edadMin + " hasta " + edadMax + " años cumplidos");		
			return(false);
		}
	}
	// ---------------------------------------------------------------------------------
	// fin Caso: 18 años
	// ---------------------------------------------------------------------------------

	if( ano < edadMin || ano > edadMax )	
	{
		alert("Edad Fuera de Rango. La edad es desde " + edadMin + " hasta " + edadMax + " años cumplidos");		
		objFecNac.focus();
		return(false);
	}
	return(true);
}

// autor.mce.28nov2002	
	function saltoAutomatico2( e , objTextOrigen , objDestino , nCaracteres , instruccionExecute)
	{	
		var tecla;
		
		if (navigator.appName == "Netscape")tecla = e.which; else tecla = e.keyCode;
	
		valor = objTextOrigen.value.length;		
		//window.status = valor;
		if( valor == nCaracteres ){
			objDestino.focus();
			if( instruccionExecute != null )eval( instruccionExecute );
		}		
	}
	function setMensajeError(error){

		if( error.length > 3 )
			document.write("<b class='ObjError'>&nbsp;&nbsp;&nbsp;" + error + "</b><br><br>");
	}

// inicio.mcoronae.04feb2003
function setTextObjSelect( sel, opt )
{
  var l = sel.length;
  var i = 0;

  for( i = 0; i < l ; i++ )
  {
    if( sel.options[i].text == opt )
    {
      sel.selectedIndex = i;
      return(true);
    }
  }
  return(false);
}
// termino.mcoronae.04feb2003

// inicio.mcoronae.11feb03
function getTextSelect(obj_select)
{
	i = obj_select.selectedIndex;

	if( i == (-1) )
		str = "-1"; //No existe índice seleccionado
	else
		str = obj_select.options[i].text;

	return(str);
}
// fin.mcoronae.11feb03

function getFechaActual_sinDocumentWrite(){
	var diaSemana = new Array('Domingo', 'Lunes', 'Martes','Miércoles', 'Jueves', 'Viernes','Sábado');
	var mesName = new Array('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre');
	var fecha = new Date();
	var dia = fecha.getDay(); 
	var mes = fecha.getMonth();
	var ano = fecha.getYear();
	var numero = fecha.getDate();
		
	FechaActual = diaSemana[dia] + " " + numero + " de " + mesName[mes] + " de " + ano;
	return( FechaActual );
}
function validarObjText(salida,obj_txt,mensaje)
{
	var valor = "";

	if( obj_txt.disabled == false )
	{
		valor = espacios(obj_txt.value);
		if(  valor == "" ){
			obj_txt.value = "";
			if( salida == "BARRA_ESTADO" ){
				window.status = mensaje;
			}else if( salida == "ALERT" ){
				alert(mensaje);
				obj_txt.focus();
			}
			return(false);
		}else{
			obj_txt.value = mc_trim(obj_txt.value);
			return(true);
		}
	}
	return( true );
}
function goWindowPopup(URL,val_toolbar,val_location,val_directories,val_status,val_menubar,val_scrollbars,val_resizable,val_width,val_height,val_top,val_left){
	/*
	EJEMPLO:
	URL = "informacion.jsp";
	val_toolbar     = "no";
	val_location    = "0";
	val_directories = "no";
	val_status      = "no";
	val_menubar     = "no";
	val_scrollbars  = "no";
	val_resizable   = "no";
	val_width       = "100";
	val_height      = "200";
	val_top         = "10";
	val_left        = "10";
	*/

	var wurl      = URL;
	var wname     = "WindowPoPup";	
    var wtoolbar  = "toolbar="     + val_toolbar;
    var wlocation = "location="    + val_location;
    var wdir      = "directories=" + val_directories;
    var wstatus   = "status="      + val_status;
    var wmenubar  = "menubar="     + val_menubar;
    var wscroll   = "scrollbars="  + val_scrollbars;
    var wresize   = "resizable="   + val_resizable;
    var wwidth    = "width="       + val_width;
    var wheight   = "height="      + val_height;
	var wtop      = "top="         + val_top;
	var wleft     = "left="        + val_left;

	var wmodo       = wtoolbar + "," + wlocation + "," + wdir + "," + wstatus + "," + wmenubar + "," + wscroll + "," + wresize + "," + wwidth + "," + wheight  + "," + wtop + "," + wleft;
	window.open(wurl, wname, wmodo);

}
function get_Variable_Global_Servidor()
{
	//servidor = "s-shesmu";	
	//servidor = "p-mcoronae";	
	//servidor = "p-manuelmoya";	
	//servidor = "gqlweb";	
	//servidor = "l-emedrano";	
	servidor = "s-eros";	
	return( servidor );
}
function set_Menu_Titulo(nom,codigo)
{
	// Parámetros
	this.nombreOpcion       = nom;
	
	// Variables Locales. Atributos
	var bgColor             = verde;
	var bordercolor         = rojo; 
	var borderColorLight    = negro;
	var borderColorDark     = negro;
	var bgColor_onMouseOver = verde;
			
	switch( codigo )
	{
	case "TAB_ACCESO_DIRECTO":
		bgColor             = COLOR_TAB_ACCESO_DIRECTO;
		bgColor_onMouseOver = COLOR_TAB_ACCESO_DIRECTO;		
		break;		
	case "TAB_APOYO":
		bgColor             = COLOR_TAB_APOYO;
		bgColor_onMouseOver = COLOR_TAB_APOYO;		
		break;		
	case "TAB_GESTION":
		bgColor             = COLOR_TAB_GESTION;
		bgColor_onMouseOver = COLOR_TAB_GESTION;		
		break;		
	case "TAB_OPERACIONES":
		bgColor             = COLOR_TAB_OPERACIONES;
		bgColor_onMouseOver = COLOR_TAB_OPERACIONES;		
		break;		
	}
	// Crea un objeto fila con una celda: objeto opcion			
	document.write('<tr height="30">  ');
		document.write('  <td class="clt_menuizquierdo_objTitulo_align" ');
		document.write('	bgColor="#'+ bgColor + '" ');
		document.write('	bordercolor="#'+ bordercolor + '" ');
		document.write('    borderColorLight="#'+ borderColorLight + '" ');
		document.write('	borderColorDark="#' + borderColorDark + '" ');
		document.write('    onMouseOver=this.bgColor="#' + bgColor_onMouseOver + '" '); 
		document.write('    onMouseOut =this.bgColor="#' + bgColor + '" '); 			
		document.write(' > ');
		document.write('<B class="clt_menuizquierdo_objTitulo">&nbsp;' + this.nombreOpcion + '</B>');

		document.write('  </td> ');
	document.write('</tr> ');

	return(this);
}
// ----------------------------------------------------------------------------------------------
// INICIO MODULO DE FUNCIONES QUE CONTROLAN LOS EVENTOS DE LOS OBJETOS CELDA Y LETRA DE UNA TABLA
// ----------------------------------------------------------------------------------------------
COLOR_BURDEO = "#990000";
COLOR_NEGRO  = "#000000";
COLOR_BLANCO = "#FFFFFF";
COLOR_AZUL = "#0000FF";
COLOR_AMARILLO_CREMA = "#FFFFDE";

// *** OBJETO LETRA ***
function set_color_opcion( myElement , color )
{
	myElement.color = color;
}
function opcion_onMouseOver( myElement )
{
	set_color_opcion( myElement , COLOR_BURDEO );
}
function opcion_onMouseOut( myElement )
{
	set_color_opcion( myElement , COLOR_BLANCO );
}

// *** OBJETO CELDA ***
function celda_onMouseOut( myElement )
{
	set_color_celda( myElement , COLOR_NEGRO );

	for (var i in myElement.children) 
	{
		if (myElement.children[i].id == "objeto_letra") 
		{
			myElement.children[i].color = COLOR_BLANCO;
		}
	}
}
function celda_onMouseOver( myElement )
{
	set_color_celda( myElement , COLOR_AMARILLO_CREMA );

	for (var i in myElement.children) 
	{
		if (myElement.children[i].id == "objeto_letra") 
		{
			myElement.children[i].color = COLOR_BURDEO;
		}
	}
}
function set_color_celda( myElement , color )
{
	myElement.bgColor = color
}
// -------------------------------------------------------------------------------------------
// FIN MODULO DE FUNCIONES QUE CONTROLAN LOS EVENTOS DE LOS OBJETOS CELDA Y LETRA DE UNA TABLA
// -------------------------------------------------------------------------------------------


function creaObjetoOpcionMenu_conParametros(nro,nom,tab,rut,suc)
{
	if( tab == null ){
		tab = "TAB_APOYO";		
	}

	// Parámetros 
	this.numeroOpcion = nro;
	this.nombreOpcion = nom;
	
	valor_font_size   = "12";
	valor_font_weight = "bold";
		
	// Variables Locales. Atributos del objeto
	var bgColor             = negro; // color fondo de la celda
	var bordercolor         = rojo ; // no considerado
	var borderColorLight    = negro; // borde inferior
	var borderColorDark     = negro; // borde superior
	var bgColor_onMouseOver = rojo; // color fondo de la celda al pasar el mouse

	// Crea un objeto fila con una celda: objeto opcion			
	document.write('<tr height="30">  ');
		document.write('  <td id=calCell ');
		document.write('	bgColor="#'+ bgColor + '" ');
		document.write('	bordercolor="#'+ bordercolor + '" ');
		document.write('    borderColorLight="#'+ borderColorLight + '" ');
		document.write('	borderColorDark="#' + borderColorDark + '" ');
		document.write('    onMouseOver=celda_onMouseOver(this) ' ); 
		document.write('    onMouseOut =celda_onMouseOut(this) '); 
			
		document.write('style="cursor:hand" ');
		document.write(' onClick=doOption_conParametros('+ this.numeroOpcion +','+rut+','+suc+')');
		document.write(' > ');
		// OBJETO LETRA
		document.write("<font id=objeto_letra color='#ffffff' onMouseOver='opcion_onMouseOver(this)' style='FONT-FAMILY:Arial;FONT-SIZE:" + valor_font_size + ";FONT-WEIGHT:" + valor_font_weight + "' onMouseOut='opcion_onMouseOut(this)' ><img src='"+getBulet(tab)+"' width=4 height=6 >&nbsp;" + this.nombreOpcion + "</font>");
		document.write('  </td> ');
	document.write('</tr> ');
	//document.write('<tr><td><img src="images/menu_linea.gif" width="105" height="2" alt=""></td></tr>');
	// Retorna el objeto creado
	return(this);
}

function creaObjetoOpcionMenu(nro,nom,tab)
{
	if( tab == null ){
		tab = "TAB_APOYO";		
	}

	// Parámetros 
	this.numeroOpcion = nro;
	this.nombreOpcion = nom;
	
	valor_font_size   = "12";
	valor_font_weight = "bold";
		
	// Variables Locales. Atributos del objeto
	var bgColor             = negro; // color fondo de la celda
	var bordercolor         = rojo ; // no considerado
	var borderColorLight    = negro; // borde inferior
	var borderColorDark     = negro; // borde superior
	var bgColor_onMouseOver = rojo; // color fondo de la celda al pasar el mouse

	// Crea un objeto fila con una celda: objeto opcion			
	document.write('<tr height="30">  ');
		document.write('  <td id=calCell ');
		document.write('	bgColor="#'+ bgColor + '" ');
		document.write('	bordercolor="#'+ bordercolor + '" ');
		document.write('    borderColorLight="#'+ borderColorLight + '" ');
		document.write('	borderColorDark="#' + borderColorDark + '" ');
		document.write('    onMouseOver=celda_onMouseOver(this) ' ); 
		document.write('    onMouseOut =celda_onMouseOut(this) '); 
			
		document.write('style="cursor:hand" ');
		document.write(' onClick=doOption('+ this.numeroOpcion +')');
		document.write(' > ');
		// OBJETO LETRA
		document.write("<font id=objeto_letra color='#ffffff' onMouseOver='opcion_onMouseOver(this)' style='FONT-FAMILY:Arial;FONT-SIZE:" + valor_font_size + ";FONT-WEIGHT:" + valor_font_weight + "' onMouseOut='opcion_onMouseOut(this)' ><img src='"+getBulet(tab)+"' width=4 height=6 >&nbsp;" + this.nombreOpcion + "</font>");
		document.write('  </td> ');
	document.write('</tr> ');
	//document.write('<tr><td><img src="images/menu_linea.gif" width="105" height="2" alt=""></td></tr>');
	// Retorna el objeto creado
	return(this);
}
function getBulet(codigo)
{
	// PORTAL SISTEMAS
	servidor = get_Variable_Global_Servidor();	
	path_base_image = "http://"+servidor+":8080/PortalSistemas/pages/images/";

	if( codigo == null ){
		codigo = "TAB_APOYO";		
	}
	
	switch( codigo )
	{
	case "TAB_ACCESO_DIRECTO":
		path_image = path_base_image + "bulet_AD.gif";
		return(path_image);
		break;		
	case "TAB_APOYO":
		path_image = path_base_image + "bulet_A.gif";
		return(path_image);
		break;		
	case "TAB_GESTION":
		path_image = path_base_image + "bulet_G.gif";
		return(path_image);
		break;		
	case "TAB_OPERACIONES":
		path_image = path_base_image + "bulet_O.gif";
		return(path_image);
		break;		
	default:
		path_image = path_base_image + "bulet_A.gif";
		return(path_image);
	}

}
function logo_sistema()
{
//alert("function logo_sistema()");
document.write('<table width="100%" border="0">');
document.write('<tr>');
document.write('<td valign="top"><b style="color:#000000">Perfiles de Usuarios</b></td>');
document.write('</tr><tr> ');
document.write('<td width="85"><img src="pages/images/ic_perfiles.gif" width="85" height="80" alt="Perfiles de Usuarios" border=0></td>');
document.write('</tr>');
document.write('</table>');
}
function doOption( opt )
{	
	servidor = get_Variable_Global_Servidor();

	switch( opt )
	{
	case JS_COD_INTRANET_DESA: 
			url="http://spos/intranet/index.htm";
			llamar_window_popup(url);
			break;
	case JS_COD_INTRANET_INFORMATICA: 
			url="http://servicios.ripley.local/SERVICIOS";
			llamar_window_popup(url);
			break;
	case JS_COD_MANTENEDOR_PORTAL: 
			pagina = "http://"+ servidor + ":8080/MantenedorPortal/pages/mantenedorPortal_index.jsp";
			top.portal_centro.location.href=pagina;				
			break;
	case JS_COD_INCENTIVO_VENDEDORES:
			pagina = "http://"+ servidor + ":8080/Mantenedor_Criterios_Premiacion/pages/incentivo_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_MANTENEDOR_PORTAL:
			pagina = "http://"+ servidor + ":8080/MantenedorPortal/pages/mantenedorPortal_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_RCWEB_PRODUCCION:
			url = "http://10.0.159.20/";
			llamar_window_popup(url);
			break; 
	case JS_COD_RCWEB_DESARROLLO:
			url = "http://145.2.0.10:7777/login1.html";
			llamar_window_popup(url);
			break; 

	case JS_COD_MARKETING:
			pagina = "portal_marketing_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
			
	case JS_COD_RRHH_INFOPER:
			url = "http://s-mercurio:7778/servlet/page?_pageid=487&_dad=portal30&_schema=PORTAL30";
			llamar_window_popup(url);
			break; 

	case JS_COD_INTRANET_DESARROLLO:
			url = "http://spos/intranet/index.htm";
			llamar_window_popup(url);
			break; 
	case JS_COD_INTRANET_INFORMATICA:
			url="http://servicios.ripley.local/SERVICIOS";
			llamar_window_popup(url);
			break;
	case JS_COD_PORTAL_PROVEEDORES_DESARROLLO:    
			url="https://145.2.0.10:8443/CGI/hsrun/Distributed/jda/portalripley/portalripley.hjx;start=portalripley.HsIdentificacion.run";
			llamar_window_popup(url);
			break;
	case JS_COD_PORTAL_PROVEEDORES_PRODUCCION: 
			url="https://www.ripleyb2b.com/CGI/hsrun/PortalPrv/portalripleyPrv/portalripley.hjx;start=portalripley.HsIdentificacion.run";
			llamar_window_popup(url);
			break;
	case JS_COD_COMPOSTURA_Y_CORTINAJE: 
			alert("Proyecto en Construcción");
			break;
	case JS_COD_INTRANET_RIPLEY:
			url = "http://intranet/portal.asp";
			llamar_window_popup(url);
			break; 
	case JS_COD_COMPRAS:
			pagina = "portal_compras_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_CREDITO:
			pagina = "portal_credito_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_SUCURSALES: 
			pagina = "portal_sucursales_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_RRHH: 
			pagina = "portal_rrhh_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_INFORMATICA: 
			pagina = "portal_informatica_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_ADM_Y_FINANZAS: 
			pagina = "portal_adm_y_finanzas_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_ALMACENAJE: 
			pagina = "portal_almacenaje_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_GESFIN: 
			pagina = "portal_gesfin_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_GESCOM: 
			pagina = "portal_gescom_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	case JS_COD_GESPER: 
			pagina = "portal_gesper_index.jsp";
			top.portal_centro.location.href=pagina;				
			break; 
	}
}
function doOption_conParametros( nroAplicacion , rut , suc )
{
	servidor = get_Variable_Global_Servidor();	
		
	switch( nroAplicacion ){
		case JS_COD_INCENTIVO_VENDEDORES:
			pagina = "http://"+ servidor + ":8080/Mantenedor_Criterios_Premiacion/pages/incentivo_index.jsp?rut=" + rut + "&suc=" + suc;
			top.portal_centro.location.href=pagina;				
			break;
		case JS_COD_PRE_EMISION_TARJETA:
			pagina = "http://"+ servidor + ":8080/Preemision_Tarjetas/pages/pre_index.jsp?rut=" + rut + "&suc=" + suc;
			top.portal_centro.location.href=pagina;				
			break;
		case JS_COD_RECEPCION_BIGTICKET:
			pagina = "http://"+ servidor + ":8080/Big_Ticket/pages/pre_index.jsp?rut=" + rut + "&suc=" + suc;
			top.portal_centro.location.href=pagina;				
			break;
		case JS_COD_CUBICACION: 	
			pagina = "http://"+servidor+":8080/appCubicacion/pages/cubicacion_index.jsp?rut=" + rut ;
			top.portal_centro.location.href=pagina;				
			break; 

		case JS_COD_AUDITORIA: 	
			pagina = "http://"+servidor+":8080/Auditoria_cta_cte/pages/auditoria_index.jsp?rut=" + rut ;
			top.portal_centro.location.href=pagina;				
			break; 

		case JS_COD_LANPASS: 	// ***hoy
		    pagina = "http://"+servidor+":8080/LanPass/pages/pre_index.jsp?rut=" + rut ;
			top.portal_centro.location.href=pagina;				
			break; 

		case JS_COD_COMPOSTURA_Y_CORTINAJE: 
			pagina = "http://"+ servidor + ":8080/Compostura/index.jsp?rut=" + rut + "&suc=" + suc;
			top.portal_centro.location.href=pagina;				
			break; 
	}
}
function llamar_window_popup(url)
{	
	if( isRESOLUCION_800x600() ){
		val_width       = "700";
		val_height      = "400";
		val_left        = "50";
	}else{
		val_width       = "800";
		val_height      = "500";
		val_left        = "100";
	}

	URL = url;
	val_toolbar     = "yes";
	val_location    = "0";
	val_directories = "yes";
	val_status      = "yes";
	val_menubar     = "yes";
	val_scrollbars  = "yes";
	val_resizable   = "yes";
	val_top         = "50";
	
	goWindowPopup(URL,val_toolbar,val_location,val_directories,val_status,val_menubar,val_scrollbars,val_resizable,val_width,val_height,val_top,val_left);
}
function openWindowPopUp(URL){
	var wurl       = URL;
	var wname      = "PROCEDIMIENTOS";	
	var wtoolbar   = "toolbar=no";
	var wlocation  = "location=0";
	var wdir       = "directories=no";
	var wstatus    = "status=no";
	var wmenubar   = "menubar=no"; // BARRA ESTANDAR: ARCHIV0 EDICION VER .. 
	var wscroll    = "scrollbars=no";
	var wresize    = "resizable=no";
	var wwidth     = "width=700";
	var wheight    = "height=550";
	var wtop       = "top=" + parseInt(((screen.height - 550) / 2) - 0);
	var wleft      = "left=" + parseInt(((screen.width - 700) / 2) - 0);

	var wmodo       = wtoolbar + "," + wlocation + "," + wdir + "," + wstatus + "," + wmenubar + "," + wscroll + "," + wresize + "," + wwidth + "," + wheight  + "," + wtop + "," + wleft;
	window.open(wurl, wname, wmodo);
}
function winPopUp_informacion(){

	URL = "informacion.jsp";
	val_toolbar     = "no";
	val_location    = "0";
	val_directories = "no";
	val_status      = "no";
	val_menubar     = "no";
	val_scrollbars  = "no";
	val_resizable   = "no";
	val_width       = "450";
	val_height      = "175";
	val_top         = "250";
	val_left        = "150";

	goWindowPopup(URL,val_toolbar,val_location,val_directories,val_status,val_menubar,val_scrollbars,val_resizable,val_width,val_height,val_top,val_left);
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
//
function ver_calendario()
{
	var wurl      = "Calendario.html";	
	var wleft     = "left=350";
    var wtop      = "top=300";
    var wname     = "Autorización";
    var wtoolbar  = "toolbar=no";
    var wlocation = "location=0";
    var wdir      = "directories=no";
    var wstatus   = "status=no";
    var wmenubar  = "menubar=0";
    var wscroll   = "scrollbars=no";
    var wresize   = "resizable=no";
    var wwidth    = "width=270";
    var wheight   = "height=270";

    window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 FIN MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------

/*
* COMPOSTURA Y CORTINAJE
*/

COLOR_OPCIONAL    = "#006666";
COLOR_OBLIGATORIO = "#FFFFFF";
COLOR_DESPLIEGUE  = "#CCCCCC";

function setButton()
{
	tp = document.forms[0].totalPaginas.value;
	//alert(tp);
	
	if( tp != 0 )
	{		
		p = obj.nroBloque.value;
		p = parseInt(p,10) - 1;
		nameButton = "btnPage_" + p;
		document.forms[0].elements[nameButton].disabled = true;		
	}
}
function setLineaTotalPagina()
{
	// SET VALUES
	hidLabelTotalPagina    = document.forms[0].hidLabelTotalPagina.value;
	hidValorTotalPagina    = document.forms[0].hidValorTotalPagina.value;
	hidLabelPagina         = document.forms[0].hidLabelPagina.value;
	hidValorPaginaActual   = document.forms[0].nroBloque.value;
	hidValorPaginaTotal    = document.forms[0].totalPaginas.value;
	hidLabelTotal          = document.forms[0].hidLabelTotal.value;
	hidValorTotalRegistros = document.forms[0].totalRegistros.value;

	if( hidValorPaginaTotal == 0 ){
		hidValorPaginaTotal = 1;
	}

	// MOSTRAR LINEA TOTAL PAGINA
	document.write('<table width="100%" border="0" align="center">');
	document.write('  <tr><td class="StylePie">'+hidLabelTotalPagina+'&nbsp;'+hidValorTotalPagina+'</td>');
	document.write('  <td class="StylePie_center">'+hidLabelPagina+'&nbsp'+hidValorPaginaActual+'&nbspde&nbsp'+hidValorPaginaTotal+'</td>');
	document.write('  <td class="StyleTotalItem">'+hidLabelTotal+'&nbsp;'+hidValorTotalRegistros+'</td></tr>');
	document.write('</table>');
}
function getTablaOpciones()
{
	document.write('	<table width="100%" border="1" cellspacing="10" bgcolor="#CCCCCC"> ');
	document.write('	  <tr>  ');
	document.write('	    <td><table width="100%" border="1" class="StyleTabla_CamposObligatorios"> ');
	document.write('	        <tr> ');
	document.write('	          <td>Campo Obligatorio  ');
	document.write('	            <input type="text" name="textfield2" size="5" readonly="true"></td> ');
	document.write('	          <td>Campo Optativo <input type="text" name="textfield22" size="5" readonly="true" style="background:#006666"></td> ');
	document.write('	          <td>Campo Despliegue  ');
	document.write('	            <input type="text" name="textfield23" size="5" readonly="true" style="background:#CCCCCC"></td> ');
	document.write('	        </tr> ');
	document.write('	      </table></td> ');
	document.write('	  </tr> ');
	document.write('	</table> ');
}
function selectItemsPorPagina_onchange(objSelect,accion)
{
	idx = objSelect.selectedIndex;
	val = objSelect[idx].text;
	obj.registrosPorBloque.value = val;
	
	regPorBloque = parseInt(obj.registrosPorBloque.value,10);
	obj.indice.value = 0;
	
	obj.accion.value = accion;	
	setDisabled(true);
	obj.submit();			
}
function setVisor( mensaje )
{
	obj.txtVisor.value = mensaje;
}

function DiferenciaFechas (fechaIn1, fechaIn2) {  
  
   //Obtiene los datos del formulario  
   CadenaFecha1 = fechaIn1.value  
   CadenaFecha2 = fechaIn2.value  
      
   //Obtiene objetos Date  
   var miFecha1 = new Date( CadenaFecha1.substring(6,11), CadenaFecha1.substring(3,5), CadenaFecha1.substring(0,2) ); 
   var miFecha2 = new Date( CadenaFecha2.substring(6,11), CadenaFecha2.substring(3,5), CadenaFecha2.substring(0,2) );  
       
   //Resta fechas y redondea  
   var diferencia = miFecha2.getTime() - miFecha1.getTime()  
   var dias = Math.floor(diferencia / (1000 * 60 * 60 * 24))  
   
   return dias  
}  
