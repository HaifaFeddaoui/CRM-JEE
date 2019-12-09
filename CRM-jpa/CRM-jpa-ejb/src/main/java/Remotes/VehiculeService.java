package Remotes;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Vehicule;

//import tn.esprit.PiDev.Remotes.employeeServiceRemote;
//import tn.esprit.PiDev.entities.Employe;



	@Stateless
	@LocalBean
	public class VehiculeService implements VehiculeServiceRemote {

		@PersistenceContext(unitName="CRM-jpa-ejb")
		EntityManager em;
		
		
		
		@Override
		public void addVehicule(Vehicule Vehicule) {
		
			em.persist(Vehicule);
			
		}

		@Override
		public void updateVehicule(Vehicule Vehicule) {
			em.merge(Vehicule);
			
		}

		@Override
		public Vehicule getVehiculeById(int id) {
	       return em.find(Vehicule.class, id);
	}

		@Override
		public void deleteVehicule(int id) {
			em.remove(em.find(Vehicule.class, id));
			
		}

		@Override
		public List<Vehicule> getall() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f", Vehicule.class);
			 return query.getResultList();

	}
		
		public List<Vehicule> getall1() {
			//Date date = new Date();
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where year(dateCirc)>=2017 and year(dateCirc)<=2019", Vehicule.class);
			 return query.getResultList();

	}
		
		public List<Vehicule> getall2() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where year(dateCirc)>=2015 and year(dateCirc)<2017", Vehicule.class);
			 return query.getResultList();

	}
		
		public List<Vehicule> getall3() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where year(dateCirc)<2015", Vehicule.class);
			 return query.getResultList();

	}

		@Override
		public List<Vehicule> getallTruc() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where typeVh='Truc' ", Vehicule.class);
			 return query.getResultList();

		}
		@Override
		public List<Vehicule> getallCar() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where typeVh='Car' ", Vehicule.class);
			 return query.getResultList();

		}
		@Override
		public List<Vehicule> getallSuv() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where typeVh='SUV' ", Vehicule.class);
			 return query.getResultList();

		}
		@Override
		public List<Vehicule> getallBer() {
			TypedQuery<Vehicule> query = em.createQuery("SELECT f FROM Vehicule f where typeVh='Berlin' ", Vehicule.class);
			 return query.getResultList();

		}
		
	}
	
	

