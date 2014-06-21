package cl.ripley.GestionTV.struts.action;

import cl.ripley.GestionTV.struts.bean.ActualizaEstadosBean;
import cl.ripley.GestionTV.struts.form.ActualizaEstadosForm;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

public class ActualizaEstadosAction extends Action
{
  protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String Conectado = (String)request.getSession().getAttribute("Conectado");
    if (Conectado == null) {
      return mapping.findForward("timeOut");
    }
    ActualizaEstadosForm conForm = (ActualizaEstadosForm)form;
    ActualizaEstadosBean conBean = new ActualizaEstadosBean();
    if (conForm.getAccion().equals("InicioActualizaEstados")) {
      conForm.setVctDetalles(null);
      conForm.setHayDatos("no");
      conForm.setGrabado("no");
      conForm.setHayDatosExportar("no");
      conForm.setFec_inicio("");
      conForm.setFec_fin("");
      conForm.setNum_Oc("");
      conForm.setMensaje("");
      conForm.setFlagDatosBD("si");
      conForm.setEstadocorrecto("no");
      conForm.setEstado7("no");
      conForm.setEstado0("no");
      conForm.setEstado1("no");

      return mapping.findForward("iniciar");
    }
    if (conForm.getAccion().equals("actualiza"))
    {
      conBean.setEstado(conForm.getEst());
      conBean.setNum_Oc(conForm.getNum_Oc());
      boolean res = conBean.ActualizarEstado(getDataSource(request, "Db2"));
      if (res) {
        conForm.setGrabado("si");
        conForm.setMensaje("Estado Actualizado");
      } else {
        conForm.setGrabado("no");
      }

      return mapping.findForward("iniciar");
    }
    if (conForm.getAccion().equals("buscar"))
    {
      conForm.setEstadocorrecto("no");
      conForm.setEstado7("no");
      conForm.setEstado0("no");
      conForm.setEstado1("no");
      conBean.setNum_Oc(conForm.getNum_Oc());

      Vector vet = conBean.getPaginacion(getDataSource(request, "Db2"), conForm.getNum_Oc());
      if (vet.size() == 0) {
        conForm.setFlagDatosBD("no");
      }
      else {
        Vector vet2 = (Vector)vet.get(0);
        conForm.setNum_Oc2(vet2.get(0).toString());

        int valor = Integer.parseInt(vet2.get(1).toString());
        String mensaje;
        switch (valor) {
        case 0:
          mensaje = messages.getMessage("ventas.estado.0");
          conForm.setEstado0("si");
          conForm.setEstadocorrecto("si");
          break;
        case 1:
          mensaje = messages.getMessage("ventas.estado.1");
          conForm.setEstado1("si");
          conForm.setEstadocorrecto("si");
          break;
        case 2:
          mensaje = messages.getMessage("ventas.estado.2");
          break;
        case 3:
          mensaje = messages.getMessage("ventas.estado.3");
          break;
        case 4:
          mensaje = messages.getMessage("ventas.estado.4");
          break;
        case 7:
          mensaje = messages.getMessage("ventas.estado.7");
          conForm.setEstado7("si");
          conForm.setEstadocorrecto("si");
          break;
        case 8:
          mensaje = messages.getMessage("ventas.estado.8");
          break;
        case 5:
        case 6:
        default:
          mensaje = messages.getMessage("ventas.estado.default");
        }

        conForm.setEstado(mensaje);
        String check1 = conForm.getCheck_1();
        String creacion = "";
        String fecha = "";
        String year = "";
        String mes = "";
        String dia = "";
        String hora = "";
        creacion = vet2.get(2).toString();

        year = creacion.substring(0, 4);
        mes = creacion.substring(5, 7);
        dia = creacion.substring(8, 10);
        hora = creacion.substring(11, 16);
        fecha = dia + "/" + mes + "/" + year + " " + hora;
        conForm.setFecha_Cre(fecha);
      }

      conForm.setHayDatos(conBean.getHayDatos());
      conForm.setMensaje(conBean.getMensaje());

      return mapping.findForward("iniciar");
    }

    return mapping.findForward("cancelar");
  }

  protected void removeFormBean(ActionMapping mapping, HttpServletRequest request) {
    if (mapping.getAttribute() != null)
      if ("request".equals(mapping.getScope())) {
        request.removeAttribute(mapping.getAttribute());
      } else {
        HttpSession session = request.getSession();
        session.removeAttribute(mapping.getAttribute());
      }
  }
}