/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.upload.FormFile;
/*     */ 
/*     */ public class BorradoPromocionesForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  22 */   private int contador = 0;
/*  23 */   private String flagDatosBD = "si";
/*  24 */   private String actualiza = "no";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int total_registros;
/*     */   private String mensaje;
/*     */   private String tipoBorrado;
/*     */   private Vector preview;
/*     */   private Vector sql_delete;
/*     */   private FormFile theFile;
/*     */ 
/*     */   public FormFile getTheFile()
/*     */   {
/*  41 */     return this.theFile;
/*     */   }
/*     */ 
/*     */   public void setTheFile(FormFile theFile)
/*     */   {
/*  47 */     this.theFile = theFile;
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  59 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  71 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/*  83 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  92 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 101 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getTotal_registros()
/*     */   {
/* 110 */     return this.total_registros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 121 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 130 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 139 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setTotal_registros(int i)
/*     */   {
/* 148 */     this.total_registros = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 158 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 167 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 175 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 182 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getActualiza()
/*     */   {
/* 192 */     return this.actualiza;
/*     */   }
/*     */ 
/*     */   public void setActualiza(String actualiza) {
/* 196 */     this.actualiza = actualiza;
/*     */   }
/*     */   public String getMensaje() {
/* 199 */     return this.mensaje;
/*     */   }
/*     */   public void setMensaje(String mensaje) {
/* 202 */     this.mensaje = mensaje;
/*     */   }
/*     */   public String getTipoBorrado() {
/* 205 */     return this.tipoBorrado;
/*     */   }
/*     */   public void setTipoBorrado(String tipoBorrado) {
/* 208 */     this.tipoBorrado = tipoBorrado;
/*     */   }
/*     */   public Vector getPreview() {
/* 211 */     return this.preview;
/*     */   }
/*     */   public void setPreview(Vector preview) {
/* 214 */     this.preview = preview;
/*     */   }
/*     */   public Vector getSql_delete() {
/* 217 */     return this.sql_delete;
/*     */   }
/*     */   public void setSql_delete(Vector sql_delete) {
/* 220 */     this.sql_delete = sql_delete;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.BorradoPromocionesForm
 * JD-Core Version:    0.6.2
 */