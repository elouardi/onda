package org.hibernate.tutorial.hbm;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OrdrePaiementTest extends TestCase {
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
		OrdrePaiement op1 = new OrdrePaiement();
		Rejet r1= new Rejet();
		Facture f1 = new Facture();
        Facture f2 = new Facture();
        Collection<Facture> col1 = new HashSet<Facture>();
        col1.add(f1);
        col1.add(f2);
		op1.setObj("Construction d'un Aerozone");
		op1.setDate_Op(new Date(11,12,2011));
		op1.setDate_Bc(new Date(10,04,2011));
		op1.setDate_Dg(new Date(8,04,2011));
		op1.setDate_SignT(new Date(9,04,2011));
	    op1.setNum_Paie(12542);
	    op1.setNom_Benf("Telepac");
	    op1.setDeduc(3000.00);
	    op1.setMt_Total(25000000.00);
	    op1.setMt_Op(124512.00);
	    op1.setFactures(col1);
	    op1.setRejet(r1);
	    OrdrePaiement op2 = new OrdrePaiement();
	    Rejet r2= new Rejet();
	    Facture f3 = new Facture();
        Facture f4 = new Facture();
        Collection<Facture> col2 = new HashSet<Facture>();
        col2.add(f3);
        col2.add(f4);
		op2.setObj("Construction d'un Aerogarde");
		op2.setDate_Op(new Date(20,10,2012));
		op2.setDate_Bc(new Date(25,10,2012));
		op2.setDate_Dg(new Date(28,10,2012));
		op2.setDate_SignT(new Date(9,04,2012));
	    op2.setNum_Paie(12500);
	    op2.setNom_Benf("iam");
	    op2.setDeduc(3000.00);
	    op2.setMt_Total(25000000.00);
	    op2.setMt_Op(124512.00);
	    op2.setFactures(col2);
	    op2.setRejet(r2);
	    session.save(op1);
		session.save(op2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<OrdrePaiement> result = session.createQuery( "from Fournisseur" ).list();
        for (OrdrePaiement ordrePaiement : result) {
			System.out.println(ordrePaiement.getDate_Op());
			System.out.println(ordrePaiement.getDate_Bc());
			System.out.println(ordrePaiement.getDate_Dg());
			System.out.println(ordrePaiement.getDate_SignT());
			System.out.println(ordrePaiement.getNum_Paie());
			System.out.println(ordrePaiement.getNom_Benf());
			System.out.println(ordrePaiement.getDeduc());
			System.out.println(ordrePaiement.getMt_Total());
			System.out.println(ordrePaiement.getMt_Op());
			System.out.println(ordrePaiement.getFactures());
			System.out.println(ordrePaiement.getRejet());
			
				}
        session.getTransaction().commit();
        session.close();
	}
}
