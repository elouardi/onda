package ma.onda.domaine;
import java.util.Date;
import java.util.Collection;


public class OrdrePaiement {
   private int id_Op;
   private String obj;
   private Date date_Op;
   private Date date_Bc;
   private Date date_SignT;
   private Date date_Dg;
   private int num_Paie;
   private String nom_benf;
   private double deduc;
   private double mt_Total;
   private double mt_Op;
   private Rejet rejet;
   private Collection<Facture> factures;
 
   
public OrdrePaiement() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_Op() {
	return id_Op;
}
public void setId_Op(int id_Op) {
	this.id_Op = id_Op;
}
public String getObj() {
	return obj;
}
public void setObj(String obj) {
	this.obj = obj;
}
public Date getDate_Op() {
	return date_Op;
}
public void setDate_Op(Date date_Op) {
	this.date_Op = date_Op;
}
public Date getDate_Bc() {
	return date_Bc;
}
public void setDate_Bc(Date date_Bc) {
	this.date_Bc = date_Bc;
}
public Date getDate_SignT() {
	return date_SignT;
}
public void setDate_SignT(Date date_SignT) {
	this.date_SignT = date_SignT;
}
public Date getDate_Dg() {
	return date_Dg;
}
public void setDate_Dg(Date date_Dg) {
	this.date_Dg = date_Dg;
}
public int getNum_Paie() {
	return num_Paie;
}
public void setNum_Paie(int num_Paie) {
	this.num_Paie = num_Paie;
}
public String getNom_benf() {
	return nom_benf;
}
public void setNom_benf(String nom_benf) {
	this.nom_benf = nom_benf;
}
public double getDeduc() {
	return deduc;
}
public void setDeduc(double deduc) {
	this.deduc = deduc;
}
public double getMt_Total() {
	return mt_Total;
}
public void setMt_Total(double mt_Total) {
	this.mt_Total = mt_Total;
}
public double getMt_Op() {
	return mt_Op;
}
public void setMt_Op(double mt_Op) {
	this.mt_Op = mt_Op;
}
public Rejet getRejet() {
	return rejet;
}
public void setRejet(Rejet rejet) {
	this.rejet = rejet;
}
public Collection<Facture> getFactures() {
	return factures;
}
public void setFactures(Collection<Facture> factures) {
	this.factures = factures;
} 
}