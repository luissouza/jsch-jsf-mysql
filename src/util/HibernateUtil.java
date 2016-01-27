package util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	public static Session session = getSessionFactory().openSession();
	
	public static Configuration getConfiguration() {
		try {
			return new Configuration().configure();	
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
		}
	}
	
	private static SessionFactory buildSessionFactory() {
        return getConfiguration().buildSessionFactory();        
    }
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }


}
