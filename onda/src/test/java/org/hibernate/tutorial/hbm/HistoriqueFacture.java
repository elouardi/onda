package org.hibernate.tutorial.hbm;

import java.sql.Date;

public class HistoriqueFacture {
	private int idHistorique;
	private Statut action;
	private Date dateRecp;
	private String entite;
	private Date dateEnvoi;
	private Facture facture;
	
	
    public HistoriqueFacture() {
    	super();
		// TODO Auto-generated constructor stub
	}

	public int getIdHistorique() {
		return idHistorique;
	}

	public void setIdHistorique(int idHistorique) {
		this.idHistorique = idHistorique;
	}

	public Statut getAction() {
		return action;
	}

	public void setAction(Statut action) {
		this.action = action;
	}

	public java.util.Date getDateRecp() {
		return dateRecp;
	}

	public void setDateRecp(Date dateRecp) {
		this.dateRecp = dateRecp;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	

}