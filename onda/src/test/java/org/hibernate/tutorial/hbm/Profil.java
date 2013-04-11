package org.hibernate.tutorial.hbm;
import java.util.Collection;

public class Profil {
   private int id_Profil;
   private ProfilType nom_Profil;
   private Collection<Fonction> fonctions;
   private User user;
  
public Profil() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_Profil() {
	return id_Profil;
}
public void setId_Profil(int id_Profil) {
	this.id_Profil = id_Profil;
}
public ProfilType getNom_Profil() {
	return nom_Profil;
}
public void setNom_Profil(ProfilType nom_Profil) {
	this.nom_Profil = nom_Profil;
}
public Collection<Fonction> getFonctions() {
	return fonctions;
}
public void setFonctions(Collection<Fonction> fonctions) {
	this.fonctions = fonctions;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}