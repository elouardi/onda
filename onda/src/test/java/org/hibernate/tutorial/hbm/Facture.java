package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.Collection;

public class Facture {
	private int id_Fac;
	private String doceng;
	private Date date_Fac;
	private double mt_Fac;
	private Statut statu_Fac;
	private Devise devise_Fac;
	private int delai_Fac;
	private Collection<Journal> journals;
	private Collection<HistoriqueFacture> historiques;
	private Collection<Service> services;
	private Fournisseur fournisseur;
	private OrdrePaiement op;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_Fac() {
		return id_Fac;
	}

	public void setId_Fac(int id_Fac) {
		this.id_Fac = id_Fac;
	}

	public String getDoceng() {
		return doceng;
	}

	public void setDoceng(String doceng) {
		this.doceng = doceng;
	}

	public Date getDate_Fac() {
		return date_Fac;
	}

	public void setDate_Fac(Date date_Fac) {
		this.date_Fac = date_Fac;
	}

	public double getMt_Fac() {
		return mt_Fac;
	}

	public void setMt_Fac(double mt_fac) {
		this.mt_Fac = mt_fac;
	}

	public Statut getStatu_Fac() {
		return statu_Fac;
	}

	public void setStatu_Fac(Statut statu_Fac) {
		this.statu_Fac = statu_Fac;
	}

	public Devise getDevise_Fac() {
		return devise_Fac;
	}

	public void setDevise_Fac(Devise devise_Fac) {
		this.devise_Fac = devise_Fac;
	}
	public int getDelai_Fac() {
		return delai_Fac;
	}

	public void setDelai_Fac(int delai_Fac) {
		this.delai_Fac = delai_Fac;
	}
	
	public Collection<Journal> getJournals() {
		return journals;
	}

	public void setJournals(Collection<Journal> journals) {
		this.journals = journals;
	}

	public Collection<HistoriqueFacture> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Collection<HistoriqueFacture> historiques) {
		this.historiques = historiques;
	}

	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public OrdrePaiement getOp() {
		return op;
	}

	public void setOp(OrdrePaiement op) {
		this.op = op;
	}

}