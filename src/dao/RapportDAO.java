package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.*;
import utl.HibernateUtil;

public class RapportDAO {

	@SuppressWarnings("unchecked")
	public List<Automate> getAllRapports() {
		Transaction transaction = null;
		List<Automate> listOfAutomate = null;
		try (Session session = HibernateUtil.getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfAutomate = session.createQuery("from Rapport").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfAutomate;
    }

}
