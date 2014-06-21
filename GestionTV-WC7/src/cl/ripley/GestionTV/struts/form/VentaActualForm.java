package cl.ripley.GestionTV.struts.form;

import org.apache.struts.action.ActionForm;

public class VentaActualForm extends ActionForm {
	private String ventaTotal;

	public String getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(String ventaTotal) {
		this.ventaTotal = ventaTotal;
	}
}
