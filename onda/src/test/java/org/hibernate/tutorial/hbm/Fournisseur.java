package org.hibernate.tutorial.hbm;

import java.util.Collection;

public class Fournisseur {
	private int id_Frs;
	private String nom_Frs;
	private Collection<Facture> factures;

	
public Fournisseur(){
	super();
	// TODO Auto-generated constructor stub
}
	public int getId_Frs() {
		return id_Frs;
	}

	public void setId_Frs(int id_Frs) {
		this.id_Frs = id_Frs;
	}

	public String getNom_Frs() {
		return nom_Frs;
	}

	public void setNom_Frs(String nom_Frs) {
		this.nom_Frs = nom_Frs;
	}

	public Collection<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}

}