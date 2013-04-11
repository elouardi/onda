package org.hibernate.tutorial.hbm;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UserTest extends TestCase {
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
		User u1 = new User();
		Profil p1 = new Profil();
		Service s1 = new Service();
		u1.setLogin(9031);
		u1.setPass("Admin");
		u1.setNomUser("ADNAN");
		u1.setPrenomUser("NADIM");
		u1.setProfil(p1);
		u1.setService(s1);
		User u2 = new User();
		Profil p2 = new Profil();
		Service s2 = new Service();
		u2.setLogin(8012);
		u2.setPass("hier");
		u2.setNomUser("FAHIM");
		u2.setPrenomUser("HALIMA");
		u2.setProfil(p2);
		u2.setService(s2);
		session.save(u1);
		session.save(u2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<User> result = session.createQuery( "from Fournisseur" ).list();
        for (User user : result) {
			System.out.println(user.getLogin());
			System.out.println(user.getPass());
			System.out.println(user.getNomUser());
			System.out.println(user.getPrenomUser());
			System.out.println(user.getProfil());
			System.out.println(user.getService());
			
		}
        session.getTransaction().commit();
        session.close();
	}
}
