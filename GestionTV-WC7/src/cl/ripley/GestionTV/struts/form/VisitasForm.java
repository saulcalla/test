/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class VisitasForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  18 */   private Vector vctDetalles = new Vector();
/*     */   private int filasActualizadas;
/*     */   private String fec_inicio;
/*     */   private String fec_final;
/*     */   private String fechaInforme;
/*  27 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String mensaje;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  41 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  53 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  63 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  75 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public int getFilasActualizadas()
/*     */   {
/*  85 */     return this.filasActualizadas;
/*     */   }
/*     */ 
/*     */   public void setFilasActualizadas(int vFilas)
/*     */   {
/*  97 */     this.filasActualizadas = vFilas;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_final()
/*     */   {
/* 113 */     return this.fec_final;
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 120 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_final(String string)
/*     */   {
/* 127 */     this.fec_final = string;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 134 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public String getFechaInforme()
/*     */   {
/* 141 */     return this.fechaInforme;
/*     */   }
/*     */ 
/*     */   public void setFechaInforme(String string)
/*     */   {
/* 148 */     this.fechaInforme = string;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 157 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 166 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 173 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 180 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 187 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 194 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 201 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 208 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 215 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 222 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 229 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 236 */     this.hayDatosExportar = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.VisitasForm
 * JD-Core Version:    0.6.2
 */