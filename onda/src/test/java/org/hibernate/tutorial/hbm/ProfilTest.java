package org.hibernate.tutorial.hbm;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ProfilTest extends TestCase {
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
		Profil p = new Profil();
		User u = new User();
        Fonction f1 = new Fonction();
        Fonction f2 = new Fonction();
        Collection<Fonction> col = new HashSet<Fonction>();
        col.add(f1);
        col.add(f2);
       	p.setNom_Profil(ProfilType.Admin);
       	p.setUser(u);
       	p.setFonctions(col);
		session.save(p);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Profil> result = session.createQuery( "from Rejet" ).list();
        for (Profil profil : result) {
			System.out.println(profil.getNom_Profil());
			System.out.println(profil.getFonctions());
			System.out.println(profil.getUser());
		}
        session.getTransaction().commit();
        session.close();
	}
}
