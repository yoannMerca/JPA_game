package main.java.com.game.jpa;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;




import bean.Joueur;
import bean.Partie;
import main.java.com.example.jpa.database.DatabaseHandle;
import repository.JoueurRepository;

public class Main {
	
	public static void main(String[] args) {

		EntityManager em = DatabaseHandle.getEntityManagerFactory();
		EntityTransaction transaction = em.getTransaction();
		
		// Begin the transaction
		transaction.begin();
		
		// the record is read and the object is now managed by Hibernate in memory
		Joueur p = em.find(Joueur.class, 1);
		//System.out.println(p.toString());
		
		// the persistent object is modified
		p.setNom("Peter");
		
		// the new objet is transient
		Joueur p2 = new Joueur();
		
		p2.setNom("BOND");
		p2.setPseudo("James");
		
		// this object become a persistent object
		em.persist(p2);
	
		
		// all the objects will be detached
		
		TypedQuery<Joueur> q = em.createQuery("select h from Joueur h ", Joueur.class);
		//System.out.println(q.getResultList().size());
		
		q.getResultList().stream().forEach(System.out::println);
		
		TypedQuery<Partie> qParties = em.createQuery("from Partie ", Partie.class);
	
		
		//qParties.getResultList().stream().forEach(System.out::println);
		Partie p1 = new Partie();
		p1.setNiveau(2);
		p1.setScore(1500);
		p1.setDate_(LocalDate.now());
		em.persist(p1);
		
		Partie p3 = new Partie();
		p3.setNiveau(5);
		p3.setScore(13435);
		p3.setDate_(LocalDate.of(2018,03,02));
		em.persist(p3);
		
		
		TypedQuery<Partie> q2 = em.createQuery("from Partie", Partie.class);
				
		try {
			 q2.getResultList().forEach(e -> e.setNiveau(e.getNiveau()+1));
			
		} catch (Exception e) {
			System.out.println("plop ca n'a pas fonctione");
		}
		
		
		System.out.println("//////////////////////////////////////");
		JoueurRepository.getJoueurByName("youcef");
		transaction.commit();
		JoueurRepository.getPseudoPlayerSorted();
		em.close();
		System.exit(0);
	}

	
}
