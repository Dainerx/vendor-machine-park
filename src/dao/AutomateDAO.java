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

public class AutomateDAO {
	
		private List <Machine> feedMachines()
		{
			Set<PaymentSystem> ps = new HashSet<>();
			CarteSansContact cc = new CarteSansContact("normal");
			CarteAPuce cp = new CarteAPuce("normal");
			MonnayeurPieces mp = new MonnayeurPieces("plein");
			ps.add(cc);
			ps.add(cp);
			ps.add(mp);
			Set<MachineErr> merr = new HashSet<>();
			Machine machine1 = new Machine(StateMachine.OK,30.4f,ps,merr);
			Machine machine2 = new Machine(StateMachine.OK,30.4f,ps,merr);
			Machine machine3 = new Machine(StateMachine.OK,30.4f,ps,merr);
			
			// feed machines
			List<Machine> listMachines = new ArrayList<Machine>();
			listMachines.add(machine1);
			listMachines.add(machine2);			
			listMachines.add(machine3);
			return listMachines;
			// Machine creation	
		}
		
		public List <Automate> feedAutomates()
		{
			Address address = new Address(99, "Avenue Jean Baptiste Clement", "Villetaneuse", 93430);
			Gps gps = new Gps(48.954230f,2.337950f);
			
			/*
			Article chips = new Article("chips",10,1.5f);
			Article madlene = new Article("madlene",20,1.2f);
			Article biscuits = new Article("biscuits",5,1f);
	        Article coke = new Article("coffee",30,1.2f);
			Article fanta = new Article("fanta",30,1.2f);
			Article pepsi = new Article("pepsi",30,1.2f);
	        Article coffee = new Article("coffee",20,0.5f);
			Article tea = new Article("tea",20,0.5f);
			Article hotChocolate = new Article("hot chocolate",15,1f);
	        */
	        Automate automate1 = new Automate();
	        String serialNumber1 = "1000";
	        automate1.setSerialNumber(serialNumber1);
	        automate1.setAddress(address);
	        automate1.setGpsCoordinates(gps);
	        automate1.setStateAutomate(StateAutomate.UP);
	        automate1.setArea("Forum");
	        automate1.setArticlesType(ArticlesType.Snacks);
	        //automate1.addArticle(chips);
	        //automate1.addArticle(madlene);
	        //automate1.addArticle(biscuits);
	        
			Automate automate2 = new Automate();
	        String serialNumber2 = "1001";
	        automate2.setSerialNumber(serialNumber2);
	        automate2.setAddress(address);
	        automate2.setGpsCoordinates(gps);
	        automate2.setStateAutomate(StateAutomate.UP);
	        automate2.setArea("Engineering school");
	        automate2.setArticlesType(ArticlesType.HotDrinks);
	        //automate2.addArticle(coffee);
	        //automate2.addArticle(tea);
	        //automate2.addArticle(hotChocolate);
	        
			 Automate automate3 = new Automate();
	        String serialNumber3 = "1002";
	        automate3.setSerialNumber(serialNumber3);
	        automate3.setAddress(address);
	        automate3.setGpsCoordinates(gps);
	        automate3.setStateAutomate(StateAutomate.UP);
	        automate3.setArea("DUT");
	        automate3.setArticlesType(ArticlesType.ColdDrinks);
	        //automate3.addArticle(coke);
	        //automate3.addArticle(fanta);
	        //automate3.addArticle(pepsi);
	        
	        List<Automate> listAutomates = new ArrayList<>();
	        listAutomates.add(automate1);
	        listAutomates.add(automate2);
	        listAutomates.add(automate3);
			
	        List<Machine> listMachines = feedMachines();
			Iterator<Automate> it1 = listAutomates.iterator();
			Iterator<Machine> it2 = listMachines.iterator();
		    while (it1.hasNext() && it2.hasNext()) {
		        it1.next().setMachine(it2.next());
		    }

		    return listAutomates;
		}

	    public void saveAutomate(Automate automate) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(automate);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public void updateAutomate(Automate automate) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(automate);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public void deleteAutomate(String serialNumber) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a Automate object
	            Automate automate = session.get(Automate.class, serialNumber);
	            if (automate != null) {
	                session.delete(automate);
	                System.out.println("automate is deleted");
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public Automate getAutomate(String serialNumber) {
	        Transaction transaction = null;
	        Automate automate = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an automate object
	            automate = session.get(Automate.class, serialNumber);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return automate;
	    }

	    @SuppressWarnings("unchecked")
	    public List <Automate> getAllAutomates() {

	        Transaction transaction = null;
	        List <Automate> listOfUser = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfUser = session.createQuery("from Automate").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfUser;
	    }
}
