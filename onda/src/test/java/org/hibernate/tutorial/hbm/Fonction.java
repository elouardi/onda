package org.hibernate.tutorial.hbm;

public class Fonction {
	private int idFonction;
	private String nomFonction;
	private Profil profil;
	
	
	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(int idFonction) {
		this.idFonction = idFonction;
	}

	public String getNomFonction() {
		return nomFonction;
	}

	public void setNomFonction(String nomFonction) {
		this.nomFonction = nomFonction;
	}
	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}