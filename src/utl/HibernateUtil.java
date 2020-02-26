package utl;

import java.util.Properties;
import models.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try {
			loadSessionFactory();
		} catch (Exception e) {
			System.err.println("Exception while initializing hibernate util.. ");
			e.printStackTrace();
		}
	}

	public static void loadSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("../hibernate.cfg.xml");
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Gps.class);
		configuration.addAnnotatedClass(PaymentSystem.class);
		configuration.addAnnotatedClass(MonnayeurPieces.class);
		configuration.addAnnotatedClass(CarteAPuce.class);
		configuration.addAnnotatedClass(CarteSansContact.class);
		configuration.addAnnotatedClass(MachineErr.class);
		configuration.addAnnotatedClass(Machine.class);
		configuration.addAnnotatedClass(Automate.class);
		configuration.addAnnotatedClass(Rapport.class);
		configuration.addAnnotatedClass(Article.class);

		ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		sessionFactory = configuration.buildSessionFactory(srvcReg);
	}

	public static Session getSession() throws HibernateException {
		Session retSession = null;
		try {
			retSession = sessionFactory.openSession();
		} catch (Throwable t) {
			System.err.println("Exception while getting session.. " + t.getMessage());
			t.printStackTrace();
		}
		if (retSession == null) {
			System.err.println("session is discovered null");
		}
		return retSession;
	}
}