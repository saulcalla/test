package cl.ripley.GestionTV.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.ripley.GestionTV.struts.bean.VentaActualBean;
import cl.ripley.GestionTV.struts.form.VentaActualForm;

public class VentaActualAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
//		String Conectado = (String)request.getSession().getAttribute("Conectado");
//	    if (Conectado == null) {
//	    	return mapping.findForward("timeOut");
//	    }
		VentaActualForm objetoForm = (VentaActualForm)form;
	    VentaActualBean ventaActualBean = new VentaActualBean();
	    String ventaActual = ventaActualBean.getVentaActual(getDataSource(request, "Db2"));
	    objetoForm.setVentaTotal(ventaActual);
		
		return mapping.findForward("ventaActual");
	}
}
