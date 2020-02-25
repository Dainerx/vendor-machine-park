package database_builders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.MachineDAO;
import models.Address;
import models.CarteSansContact;
import models.Machine;
import models.MachineErr;
import models.PaymentSystem;
import models.StateMachine;
import utl.HibernateUtil;

public class Fetch {

	public static void main(String[] args) {
		System.out.println(MachineDAO.getAllMachines());
	}
}
