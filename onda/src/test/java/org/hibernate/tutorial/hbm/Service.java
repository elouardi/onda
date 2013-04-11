package org.hibernate.tutorial.hbm;
import java.util.Collection;

public class Service {
   private int id_Serv;
   private String libelle;
   private Collection<User> users;
   private Facture facture;
   
   

public Service() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_Serv() {
	return id_Serv;
}
public void setId_Serv(int id_Serv) {
	this.id_Serv = id_Serv;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Collection<User> getUsers() {
	return users;
}
public void setUsers(Collection<User> users) {
	this.users = users;
}
public Facture getFacture() {
	return facture;
}
public void setFacture(Facture facture) {
	this.facture = facture;
}
   
}