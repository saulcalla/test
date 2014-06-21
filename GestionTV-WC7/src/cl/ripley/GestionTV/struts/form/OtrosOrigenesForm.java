/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ 
/*     */ public class OtrosOrigenesForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  16 */   private Vector vctDetalles = new Vector();
/*     */   private String hayDatos;
/*     */   private String mensaje;
/*     */   private String vctExpHead;
/*     */   private String exportFile;
/*     */   private String hayDatosExportar;
/*  26 */   private String fec_inicio = "";
/*  27 */   private String fec_final = "";
/*     */   private String accesoRangos;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  33 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  40 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  47 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/*  56 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/*  64 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/*  72 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  80 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/*  87 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/*  94 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 102 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 109 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 116 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public String getFec_final()
/*     */   {
/* 127 */     return this.fec_final;
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 138 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_final(String string)
/*     */   {
/* 149 */     this.fec_final = string;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 160 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public String getAccesoRangos()
/*     */   {
/* 171 */     return this.accesoRangos;
/*     */   }
/*     */ 
/*     */   public void setAccesoRangos(String string)
/*     */   {
/* 182 */     this.accesoRangos = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 193 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 204 */     this.hayDatosExportar = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.OtrosOrigenesForm
 * JD-Core Version:    0.6.2
 */