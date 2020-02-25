package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Automate;
import models.Machine;
import utl.HibernateUtil;

public class MachineDAO {
	    @SuppressWarnings("unchecked")
	    public static List <Machine> getAllMachines() {

	        Transaction transaction = null;
	        List <Machine> listofMachines = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            listofMachines = session.createQuery("from Machine").getResultList();
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listofMachines;
	    }
}
