package ma.onda.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class DataService {
	private static SessionFactory sessionFactory;
	private Session session;
	
	public Session getSession() {
		if(session== null)
			session = sessionFactory.getCurrentSession();
		return session;
	}

	static{
		sessionFactory = new Configuration()
        .configure() // configures settings from hibernate.cfg.xml
        .buildSessionFactory();
	}




	public void delete(Object arg0) {
		try {
			session.beginTransaction();
			session.delete(arg0);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz,Serializable arg1) {
		try {
			return (T)session.get(clazz, arg1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public <T> T load(Class<T> clazz,Serializable arg1) {
		try {
			return (T)session.load(clazz, arg1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Object merge(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	public void persist(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public Serializable save(Object arg0) {
		try {
			session.beginTransaction();
			session.save(arg0);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}

	public void saveOrUpdate(Object arg0) {
		try {
			session.beginTransaction();
			session.saveOrUpdate(arg0);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void update(Object arg0) {
		try {
			session.beginTransaction();
			session.update(arg0);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
