package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactureTest extends TestCase {
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings("deprecation")
	public void testBasicUsage() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Facture fac = new Facture();
		Service s1 = new Service();
		Service s2 = new Service();
		Service s3 = new Service();
		HistoriqueFacture hj1 = new HistoriqueFacture();
		HistoriqueFacture hj2 = new HistoriqueFacture();
		Journal j1 = new Journal();
		Journal j2 = new Journal();
		Fournisseur f = new Fournisseur();
		OrdrePaiement op = new OrdrePaiement();
		Collection<Service> col1 = new HashSet<Service>();
        col1.add(s1);
        col1.add(s2);
        col1.add(s3);
        Collection<HistoriqueFacture> col2 = new HashSet<HistoriqueFacture>();
        col2.add(hj1);
        col2.add(hj2);
        Collection<Journal> col3 = new HashSet<Journal>();
        col3.add(j1);
        col3.add(j2);
		fac.setId_Fac(71);
		fac.setDoceng("MA25/11");
		fac.setDate_Fac(new Date(11, 10, 2013));
		fac.setMt_Fac(112514.00);
		fac.setStatu_Fac(Statut.ADispatcher);
		fac.setDevise_Fac(Devise.MAD);
		fac.setDelai_Fac(60);
		fac.setServices(col1);
		fac.setHistoriques(col2);
		fac.setJournals(col3);
		fac.setOp(op);
		fac.setFournisseur(f);
		session.save(fac);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Facture> result = session.createQuery( "from Facture" ).list();
        for (Facture facture : result) {
			System.out.println(facture.getId_Fac());
			System.out.println(facture.getDoceng());
			System.out.println(facture.getDate_Fac());
			System.out.println(facture.getMt_Fac());
			System.out.println(facture.getDevise_Fac());
			System.out.println(facture.getDelai_Fac());
			System.out.println(facture.getServices());
            System.out.println(facture.getHistoriques());
			System.out.println(facture.getJournals());
			System.out.println(facture.getOp());
			System.out.println(facture.getFournisseur());
		
		}
        session.getTransaction().commit();
        session.close();
	}
}
