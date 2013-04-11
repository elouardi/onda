package ma.onda.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.tutorial.hbm.Fournisseur;

import ma.onda.util.DataService;

@ManagedBean
@SessionScoped
public class SessionBean {
	private DataService dataService = new DataService();

	public DataService getDataService() {
		return dataService;
	}

	private void test() {
		// TODO Auto-generated method stub

		Fournisseur f1 = new Fournisseur();
		f1.setNom_Frs("test");
		dataService.save(f1);
	}

}
