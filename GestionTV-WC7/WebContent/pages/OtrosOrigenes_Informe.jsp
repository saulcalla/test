<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<% String vFormulario = new String("otrosOrigenesForm");%>
<% String vForm = new String("document.otrosOrigenesForm");%>
<% String vaccion = new String("/otrosOrigenes");%>
<% String vcolumna = new String("otrosOrigenes.col");%>
<% int numcol = 21;%>

  <html>
    <head>
      <title>Gestion TV - Ventas Otros Origenes</title>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <meta name="pagina" content="OtrosOrigenes_informe.jsp">
      <meta name="author" content="RCid">
      <meta name="date" content="01012005">
      <link rel="stylesheet" type="text/css" href="pages/styles/estylemante.css">
	  <link rel="stylesheet" type="text/css" href="styles/estylemante.css">
	  
      <script language="Javascript" src="scripts/funciones.js"></script>
      <script language="JavaScript">
        var fechaActual = getFechaActualdelPC();

         function getFechaActualdelPC() {
          // Formato dd-mm-yyyy
          var fecha = new Date();
          var dia   = fecha.getDate();
          var mes   = fecha.getMonth() + 1;
          var ano   = fecha.getYear();

          if (dia < 10) {
            dia = "0" + dia;
          }

          if (mes < 10) {
            mes = "0" + mes;
          }

          var strFecha = dia + "-" + mes + "-" + ano;

          return (strFecha);
        }
      </script>
    </head>
    <body class="Stylebody">
    <font class="StylePrint_left_Medium">Fecha:<script>document.write(' ' + fechaActual);</script></font>
      <html:form action="<%=vaccion%>">
        <p align="center">Ventas Otros Origenes</font></p>
       
        <div align="center">
        <br>
        <p>
       
          <table cellspacing="0" cellpadding="0" align="center" width="100%" border="1">
            <!-- Fila Encabezado -->
            <tr>
<%
              for (int i = 1; i <= numcol; i++) {
                String temp = new String(vcolumna + i);
%>
                <td class="StylePrint_center_Small">
                  <bean:message key="<%=temp%>"/>
                </td>
<%
              }
%>
            </tr>
            <!-- Fila Detalle -->
            <logic:iterate id="campos" name="<%=vFormulario%>" property="vctDetalles">
              <tr>
                <logic:iterate id="elemento" name="campos" indexId="index">
               		<logic:equal name="index" value="0">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="1">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="2">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="3">
						<td class="StylePrint_left_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="4">
						<td class="StylePrint_left_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="5">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="6">
						<td class="StylePrint_left_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="7">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="8">
						<td class="StylePrint_left_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="9">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="10">
						<td class="StylePrint_left_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="11">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="12">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="13">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="14">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="15">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="16">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="17">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="18">
						<td class="StylePrint_right_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="19">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
					<logic:equal name="index" value="20">
						<td class="StylePrint_center_Small"><bean:write name="elemento"/></td>
					</logic:equal>
                </logic:iterate>
              </tr>
            </logic:iterate>
          </table>
       
        <p>
        </div>
      </html:form>
    </body>
  </html>
