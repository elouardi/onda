package org.hibernate.tutorial.hbm;

public class Motif {
   private int idMotif;
   private String nom_Motif;
   private Rejet rejet;

   
public Motif() {
	   super();
	   // TODO Auto-generated constructor stub
      }
public int getIdMotif() {
	return idMotif;
}
public void setIdMotif(int idMotif) {
	this.idMotif = idMotif;
}
public String getNom_Motif() {
	return nom_Motif;
}
public void setNom_Motif(String nom_Motif) {
	this.nom_Motif = nom_Motif;
}
public Rejet getRejet() {
	return rejet;
}
public void setRejet(Rejet rejet) {
	this.rejet = rejet;
}

}