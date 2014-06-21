/**********************************************************************************
*Creado por mcoronae
*Modificado por mmoyan
*Script date: 10/08/2004 (keep this date to check versions)
*Componentes para paginación de consultas a BD
*********************************************************************************/


	function body_onload( obj )	{
		setItemSelect(obj);
		setDisabled_btnPage(true , obj);
		if (RegporBloq=="10") {
			obj.SelectItemsPorPagina.options[0].selected=true;
		} else {
			for (var i=0;i<obj.SelectItemsPorPagina.length;i++) {
 				if (obj.SelectItemsPorPagina.options[i].value==RegporBloq) {
					obj.SelectItemsPorPagina.options[i].selected=true;			      		
					break;
  				}
			}
		}
	}

	function setItemSelect( obj )	{		
		SetOptionValue( obj.SelectItemsPorPagina, obj.registrosPorBloque.value );
	}

	function btnSiguiente_onclick( obj , sendAccion )	{
		// Objeto Select
		objSelect = obj.SelectItemsPorPagina;
		idx = objSelect.selectedIndex;
		val = objSelect[idx].text;
	
		// Registros por Bloque
		obj.registrosPorBloque.value = val;
		regPorBloque = parseInt(obj.registrosPorBloque.value,10);
		
		// Indice de la Paginación
		obj.indice.value = parseInt(obj.indice.value,10) + regPorBloque;
	
		// Ejecutar Acción
		obj.accion.value = sendAccion;
		setDisabled( true , obj );
		obj.submit();
	}

	function btnAnterior_onclick( obj , sendAccion )	{
		regPorBloque = parseInt(obj.registrosPorBloque.value,10);
		val = parseInt(obj.indice.value,10) - regPorBloque;
		if( val < 0 )
			obj.indice.value = 0;
		else
			obj.indice.value = val;
		
		obj.accion.value = sendAccion;
		setDisabled( true , obj );
		obj.submit();
	}
	
	function selectItemsPorPagina_onchange( obj , sendAccion)	{
	
		// Objeto Select
		objSelect = obj.SelectItemsPorPagina;

		idx = objSelect.selectedIndex;
		val = objSelect[idx].text;
		obj.registrosPorBloque.value = val;
		
		regPorBloque = parseInt(obj.registrosPorBloque.value,10);
		//alert(val);
		//obj.indice.value = parseInt(obj.indice.value,10);
		obj.indice.value = 0;
		
		obj.accion.value = sendAccion;	
		setDisabled(true , obj );
		obj.submit();			
	}
	
	
	function a_onclick( p , obj , sendAccion) {		
		// Objeto Select
		objSelect = obj.SelectItemsPorPagina;
		idx = objSelect.selectedIndex;
		val = objSelect[idx].text;
		
		// Registros por Bloque
		obj.registrosPorBloque.value = val;
		regPorBloque = parseInt(obj.registrosPorBloque.value,10);
			
		// Indice de la Paginación en función de la página
		p = parseInt(p,10) - 1;
		obj.indice.value = regPorBloque * p ;
		
		// Ejecutar Acción
		obj.accion.value = sendAccion;
		setDisabled(true , obj );
		obj.submit();
	}
	
	function setDisabled( valorBoolean , obj ) {
		setDisabled_ItemsPorPagina(valorBoolean , obj);
		setDisabled_btnAnterior(valorBoolean , obj);
		setDisabled_btnSiguiente(valorBoolean , obj);
		setDisabled_btnPage(valorBoolean , obj);
	}
	
	function setDisabled_ItemsPorPagina( valorBoolean , obj ) {
		objSelect = obj.SelectItemsPorPagina;
		objSelect.disabled=valorBoolean;
	}
	
	function setDisabled_btnAnterior( valorBoolean  , obj ) {
		obj.btnAnterior.disabled = valorBoolean;
	}
	
	function setDisabled_btnSiguiente( valorBoolean , obj )	{
		obj.btnSiguiente.disabled = valorBoolean;
	}
	
	function setDisabled_btnPage(valorBoolean , obj ) {	
		n = parseInt(obj.hiddenTotalPaginas.value,10);	
		for( i = 0 ; i < n ; i++ ) {
			nameTxt = "btnPage_" + i;
			if (parseInt(NumBolq,10)==(i+1)) {
		   		document.forms[0].elements[nameTxt].disabled =	valorBoolean;	
			} else {
		        document.forms[0].elements[nameTxt].disabled = (! valorBoolean);
		    }
		}	
	}
