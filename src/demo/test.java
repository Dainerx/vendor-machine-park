package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Address;
import models.CarteSansContact;
import models.Machine;
import models.MachineErr;
import models.PaymentSystem;
import models.StateMachine;
import utl.HibernateUtil;

public class test {

	public static void main(String[] args) {
		Address ad = new Address(2, "a", "sarra", 2097);
		CarteSansContact cc = new CarteSansContact("normal");
		PaymentSystem[] pp = new PaymentSystem[3];
		pp[0] = cc;
		List<MachineErr> ll = new ArrayList<>();
		pp[0] = cc;
		Machine machine = new Machine(StateMachine.OK,23.4f,pp,ll);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	// start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(machine);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
}
