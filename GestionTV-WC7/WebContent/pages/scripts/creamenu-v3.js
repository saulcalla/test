/**********************************************************************************
*Script date: 06/08/2004 (keep this date to check versions)
*Crea menú dinamico
*********************************************************************************/

opciones=new Array();
opciones=cadenaString.split("],");
	//Creating the menu object -- You can call it whatever you want - just remember to
	//have the same name as the argument.
	slideMenu = new createSlideMenu("slideMenu")

	//Variables to set:
	slideMenu.menuy=10 //The top placement of the menu.
	slideMenu.menux=0 //The left placement of the menu
	slideMenu.useImages = 1 //Are you using images or not?
	slideMenu.pxspeed=20 //The pixel speed of the animation
	slideMenu.timspeed=25 //The timer speed of the animation
	slideMenu.inset = 0 //How much the selected items should pop to the left
	slideMenu.arrow = 0 //Set this to className that has font-family:webdings
										//if you want to use the arrow feature. Note:
										//This ONLY works on DOM capable browsers, and with
										//useImages set to 0 - It's basically just a test I did.
										//I hope to improve it later on.

	//Needed dummy classes - leave in the stylesheet!
	slideMenu.bgClass =	"slideMenuBG"
	slideMenu.txtClass = "slideMenuText"

	slideMenu.level[0] = new slideMenu_makeLevel(
	left = 0,
	width = 240,
	height = 21,
	between = 4,
	className = "clSlideMenu",
	classNameA = "clA0",
	regImage = "images/level0_regular.gif",
	roundImg = "images/level0_regular.gif",
	roundImg2 = "",
	subImg = "",
	subRound= "")
	
	slideMenu.level[1] = new slideMenu_makeLevel(10,127,26,2,"clSlideMenu","clA1","images/level1_regular.gif","images/level1_round2.gif","images/level1_round.gif","images/level1_sub.gif", "images/level1_sub.gif")
	slideMenu.level[2] = new slideMenu_makeLevel(21,118,18,2,"clSlideMenu","clA2","images/level2_regular.gif","images/level2_round2.gif","images/level2_round.gif", "images/level2_sub.gif", "images/level2_sub_round.gif")
	slideMenu.level[3] = new slideMenu_makeLevel(33,108,20,2,"clSlideMenu","clA3","images/level3_regular.gif","images/level3_round2.gif","images/level3_round.gif","images/level3_sub.gif","images/level3_sub_round.gif")
	slideMenu.level[4] = new slideMenu_makeLevel(40,107,19,2,"clSlideMenu","clA4","images/level4_regular.gif", "images/level4_round2.gif","images/level4_round.gif","images/level4_sub.gif", "images/level4_sub_round.gif")

	//Image preload --- leave this

	for(var i=0;i<slideMenu.level;i++){
		var l = slideMenu.level[i]
		new preLoadBackgrounds(l.regImage,l.roundImg,l.roundImg2,l.subImg,l.subRound)
	}

	//Menu 2 -----------------------

	var ind=0;
	var cadena="";
	var indSub=0;
	while (ind<opciones.length)
	{	
		var posicion=1;
	    cadena=opciones[ind];
       	cadena = cadena.substr(posicion);
		var inicio = posicion;
		var fin = cadena.indexOf(',');
		codigoFuncion = trim(cadena.substring(inicio,fin));
		cadena = cadena.substr(fin+1);
		inicio = 0;
		fin = cadena.indexOf(',');
		opcionMenu = trim(cadena.substr(inicio,fin));
		cadena = cadena.substr(fin+1);
		inicio = 0;
		fin = cadena.indexOf(',');
		padre = trim(cadena.substr(inicio,fin));
		cadena = cadena.substr(fin+1);
		inicio = 0;
		fin = cadena.indexOf(',');
		nivel = trim(cadena.substr(inicio,fin));
		cadena = cadena.substr(fin);
		if (ind==opciones.length-1)
		{
			linkOpcion= trim(cadena.substr(inicio+1,cadena.length-3));
		}
		else
			linkOpcion= trim(cadena.substr(inicio+1));
	
		//ciclo generación menú
		if ((nivel==1)||(nivel=="null"))
		{
			slideMenu.makeMenu('top',opcionMenu,linkOpcion,'centro');
			codigoOpcion=codigoFuncion;
			indSub=0;
			while (indSub<opciones.length)
			{
				var posicion=1;
        		cadena=opciones[indSub];
       			cadena = cadena.substr(posicion);
				var inicio = posicion;
				var fin = cadena.indexOf(',');
				codigoFuncion = trim(cadena.substring(inicio,fin));
				cadena = cadena.substr(fin+1);
				inicio = 0;
				fin = cadena.indexOf(',');
				opcionMenu = trim(cadena.substr(inicio,fin));
				cadena = cadena.substr(fin+1);
				inicio = 0;
				fin = cadena.indexOf(',');
				padre = trim(cadena.substr(inicio,fin));
				cadena = cadena.substr(fin+1);
				inicio = 0;
				fin = cadena.indexOf(',');
				nivel = trim(cadena.substr(inicio,fin));
				cadena = cadena.substr(fin);
				if (indSub==opciones.length-1)
				{
					linkOpcion= trim(cadena.substr(inicio+1,cadena.length-3));
				}
				else {
					linkOpcion= trim(cadena.substr(inicio+1,cadena.length-1));
				}
				if (padre==codigoOpcion)
				{
					if (nivel==2)
					{
						if (linkOpcion=="null")
						{
							slideMenu.makeMenu('sub',opcionMenu); 							
						}
						else
						{
						   if (indSub==opciones.length-1) 
                           		linkOpcion= trim(cadena.substr(inicio+1,cadena.length-3));
						   slideMenu.makeMenu('sub',opcionMenu,linkOpcion,'centro');
						}
					}
				}
			indSub++;	
			}	
		}
		
		
	ind++;
	}


	//Initiating the menu !! 

	slideMenu.init()		

