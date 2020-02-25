package database_builders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Address;
import models.CarteSansContact;
import models.Machine;
import models.MachineErr;
import models.PaymentSystem;
import models.StateMachine;
import utl.HibernateUtil;

public class Build {

	public static void main(String[] args) {
		Address ad = new Address(2, "a", "sarra", 2097);
		CarteSansContact cc = new CarteSansContact("normal");
		Set<PaymentSystem> pp = new HashSet<>();
		Set<MachineErr> ll = new HashSet<>();
		MachineErr err = new MachineErr();
		err.setMessage("aze");
		CarteSansContact c = new CarteSansContact();
		Machine machine = new Machine(StateMachine.OK,23.4f,pp,ll);
		machine.addErrors(err);
		machine.addPaymentSystem(c);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
        	// start a transaction
            transaction = session.beginTransaction();
           /*
            session.save(p);
            session.save(err);
           */
            // save the student object
            session.save(machine);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
}
