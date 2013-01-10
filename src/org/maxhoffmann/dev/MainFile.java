package org.maxhoffmann.dev;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainFile
{
	private SessionFactory sessionFactory;
	
	public MainFile() {
		try {
			System.out.println( "------------------------------------------------------" );
		    System.out.println( "Initializing Hibernate" );
		    sessionFactory = new Configuration().configure().buildSessionFactory();
		    System.out.println( "Finished Initializing Hibernate" );
		    System.out.println( "------------------------------------------------------" );
		} catch ( HibernateException ex) {
			ex.printStackTrace();
			System.exit(5);
		}
	}
	
	public static void main( String[] args ) {
		MainFile DieIds = new MainFile();
		DieIds.getTheIds();
	};
	
	private void getTheIds() {
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessionFactory.openSession();
			trx = sess.beginTransaction();
			System.out.println("Kunden:\n");
			List<?> Resources = sess.createQuery( "from resource" ).list();
			for ( int i=0; i<Resources.size(); i++) {
				Resource resource = (Resource)Resources.get(i);
				System.out.println("Die Id ist: " + resource.getId());
			}
			trx.commit();
			} catch( HibernateException ex ) {
				if ( trx != null )
					try { trx.rollback(); } catch( HibernateException exRb ) {}
			    throw new RuntimeException( ex.getMessage() );
			} finally {
				try { if(sess != null ) sess.close(); } catch( Exception exCl ) {}
			}
	}
}