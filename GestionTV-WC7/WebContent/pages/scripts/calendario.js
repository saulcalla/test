// JavaScript Document

// --------------------------------------------------------------------------------------------------------------------
//                                                 MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------
//
function goWindowPopupCalendario( nameFormulario , nameObjetoText)
{
	document.formularioPadre.txtNameFormulario.value = nameFormulario;
	document.formularioPadre.txtNameObjetoText.value = nameObjetoText;

	var wurl      = "Calendario.html";	
	var wleft     = "left=350";
    var wtop      = "top=300";
    var wname     = "Autorización";
    var wtoolbar  = "toolbar=no";
    var wlocation = "location=0";
    var wdir      = "directories=no";
    var wstatus   = "status=no";//
    var wmenubar  = "menubar=0";
    var wscroll   = "scrollbars=no";//
    var wresize   = "resizable=no";//
    var wwidth    = "width=270";
    var wheight   = "height=270";

    window.open(wurl, wname, wtop+","+wleft+","+wtoolbar+","+wlocation+","+wdir+","+wstatus+","+wmenubar+","+wscroll+","+wresize+","+wwidth+","+wheight);
}
// --------------------------------------------------------------------------------------------------------------------
//                                                 FIN MODULO: CALENDARIO 
// --------------------------------------------------------------------------------------------------------------------


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

