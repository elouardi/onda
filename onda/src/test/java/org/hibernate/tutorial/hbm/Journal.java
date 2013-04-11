package org.hibernate.tutorial.hbm;

import java.sql.Date;

public class Journal {
	private int id_Journal;
	private Date date_Fct;
	private String libelle;
	private Facture facture;
	
public Journal(){
	 super();
	// TODO Auto-generated constructor stub
}

    public int getId_Journal() {
	return id_Journal;
    }

    public void setId_Journal(int id_Journal) {
	this.id_Journal = id_Journal;
    }
	
	public Date getDate_Fct() {
		return date_Fct;
	}

	public void setDate_Fct(Date date_Fct) {
		this.date_Fct = date_Fct;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

}