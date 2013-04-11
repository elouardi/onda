package org.hibernate.tutorial.hbm;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FournisseurTest extends TestCase {
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
			Fournisseur f = new Fournisseur();
	        Facture f1 = new Facture();
	        Facture f2 = new Facture();
	        Collection<Facture> col = new HashSet<Facture>();
	        col.add(f1);
	        col.add(f2);
			f.setNom_Frs("Telepac");
			f.setFactures(col);
			session.save(f);
			session.getTransaction().commit();
			session.close();

			session = sessionFactory.openSession();
	        session.beginTransaction();
	        @SuppressWarnings("unchecked")
			List<Fournisseur> result = session.createQuery( "from Rejet" ).list();
	        for (Fournisseur fournisseur : result) {
				System.out.println(fournisseur.getNom_Frs());
				System.out.println(fournisseur.getFactures());
			}
}
}