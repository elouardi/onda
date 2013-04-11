package org.hibernate.tutorial.hbm;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FonctionTest extends TestCase {
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

	public void testBasicUsage() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Fonction f1 = new Fonction();
		Profil pr1 = new Profil();
		f1.setNomFonction("Ajouter");
		f1.setProfil(pr1);
		Fonction f2 = new Fonction();
		Profil pr2 = new Profil();
		f2.setNomFonction("Certifier");
		f2.setProfil(pr2);
		session.save(f1);
		session.save(f2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Fonction> result = session.createQuery( "from Fonction" ).list();
        for (Fonction fonction : result) {
			System.out.println(fonction.getNomFonction());
			System.out.println(fonction.getProfil());
		}
        session.getTransaction().commit();
        session.close();
	}
}
