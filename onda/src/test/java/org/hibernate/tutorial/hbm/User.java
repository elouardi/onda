package org.hibernate.tutorial.hbm;

public class User {
   
private int id_User;
   private int login;
   private String pass;
   private String nomUser;
   private String prenomUser;
   private Profil profil;
   private Service Service;

   
 public User() {
		super();
		// TODO Auto-generated constructor stub
	}
   
public int getId_User() {
	return id_User;
}
public void setId_User(int id_User) {
	this.id_User = id_User;
}
public int getLogin() {
	return login;
}
public void setLogin(int login) {
	this.login = login;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getNomUser() {
	return nomUser;
}
public void setNomUser(String nomUser) {
	this.nomUser = nomUser;
}
public String getPrenomUser() {
	return prenomUser;
}
public void setPrenomUser(String prenomUser) {
	this.prenomUser = prenomUser;
}
public Profil getProfil() {
	return profil;
}
public void setProfil(Profil profil) {
	this.profil = profil;
}
public Service getService() {
	return Service;
}
public void setService(Service service) {
	Service = service;
}
}