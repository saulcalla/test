/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class CargasForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  19 */   private Vector vctDetalles = new Vector();
/*     */   private String estado1;
/*     */   private String estado2;
/*     */   private String estado3;
/*     */   private String estado4;
/*     */   private String estado5;
/*     */   private String estado6;
/*     */   private String estado7;
/*     */   private String estado8;
/*     */   private String fec1;
/*     */   private String fec2;
/*     */   private String fec3;
/*     */   private String fec4;
/*     */   private String fec5;
/*     */   private String fec6;
/*     */   private String fec7;
/*     */   private String fec8;
/*     */   private Vector vctExpHead;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  40 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string) {
/*  44 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles() {
/*  48 */     return this.vctDetalles;
/*     */   }
/*     */   public void setVctDetalles(Vector vVector) {
/*  51 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getestado1()
/*     */   {
/*  64 */     return this.estado1;
/*     */   }
/*     */ 
/*     */   public String getestado2()
/*     */   {
/*  71 */     return this.estado2;
/*     */   }
/*     */ 
/*     */   public String getestado3()
/*     */   {
/*  78 */     return this.estado3;
/*     */   }
/*     */ 
/*     */   public String getfec1()
/*     */   {
/*  85 */     return this.fec1;
/*     */   }
/*     */ 
/*     */   public String getfec2()
/*     */   {
/*  92 */     return this.fec2;
/*     */   }
/*     */ 
/*     */   public String getfec3()
/*     */   {
/*  99 */     return this.fec3;
/*     */   }
/*     */ 
/*     */   public void setestado1(String string)
/*     */   {
/* 106 */     this.estado1 = string;
/*     */   }
/*     */ 
/*     */   public void setestado2(String string)
/*     */   {
/* 113 */     this.estado2 = string;
/*     */   }
/*     */ 
/*     */   public void setestado3(String string)
/*     */   {
/* 120 */     this.estado3 = string;
/*     */   }
/*     */ 
/*     */   public void setfec1(String string)
/*     */   {
/* 127 */     this.fec1 = string;
/*     */   }
/*     */ 
/*     */   public void setfec2(String string)
/*     */   {
/* 134 */     this.fec2 = string;
/*     */   }
/*     */ 
/*     */   public void setfec3(String string)
/*     */   {
/* 141 */     this.fec3 = string;
/*     */   }
/*     */ 
/*     */   public String getestado4()
/*     */   {
/* 148 */     return this.estado4;
/*     */   }
/*     */ 
/*     */   public String getestado5()
/*     */   {
/* 155 */     return this.estado5;
/*     */   }
/*     */ 
/*     */   public String getestado6()
/*     */   {
/* 162 */     return this.estado6;
/*     */   }
/*     */ 
/*     */   public void setestado4(String string)
/*     */   {
/* 169 */     this.estado4 = string;
/*     */   }
/*     */ 
/*     */   public void setestado5(String string)
/*     */   {
/* 176 */     this.estado5 = string;
/*     */   }
/*     */ 
/*     */   public void setestado6(String string)
/*     */   {
/* 183 */     this.estado6 = string;
/*     */   }
/*     */ 
/*     */   public String getfec4()
/*     */   {
/* 190 */     return this.fec4;
/*     */   }
/*     */ 
/*     */   public String getfec5()
/*     */   {
/* 197 */     return this.fec5;
/*     */   }
/*     */ 
/*     */   public String getfec6()
/*     */   {
/* 204 */     return this.fec6;
/*     */   }
/*     */ 
/*     */   public void setfec4(String string)
/*     */   {
/* 211 */     this.fec4 = string;
/*     */   }
/*     */ 
/*     */   public void setfec5(String string)
/*     */   {
/* 218 */     this.fec5 = string;
/*     */   }
/*     */ 
/*     */   public void setfec6(String string)
/*     */   {
/* 225 */     this.fec6 = string;
/*     */   }
/*     */ 
/*     */   public void setfec7(String string)
/*     */   {
/* 235 */     this.fec7 = string;
/*     */   }
/*     */ 
/*     */   public void setfec8(String string)
/*     */   {
/* 242 */     this.fec8 = string;
/*     */   }
/*     */ 
/*     */   public void setvctExpHead(Vector vector)
/*     */   {
/* 249 */     this.vctExpHead = vector;
/*     */   }
/*     */ 
/*     */   public String getfec7()
/*     */   {
/* 256 */     return this.fec7;
/*     */   }
/*     */ 
/*     */   public String getfec8()
/*     */   {
/* 262 */     return this.fec8;
/*     */   }
/*     */ 
/*     */   public void setestado7(String string) {
/* 266 */     this.estado7 = string;
/*     */   }
/*     */   public void setestado8(String string) {
/* 269 */     this.estado8 = string;
/*     */   }
/*     */ 
/*     */   public String getestado7()
/*     */   {
/* 276 */     return this.fec7;
/*     */   }
/*     */   public String getestado8() {
/* 279 */     return this.fec8;
/*     */   }
/*     */ 
/*     */   public Vector getvctExpHead() {
/* 283 */     return this.vctExpHead;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.CargasForm
 * JD-Core Version:    0.6.2
 */