package repository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import bean.Avatar;
import bean.Joueur;
import main.java.com.example.jpa.database.DatabaseHandle;

public class JoueurRepository {

	static /*
			 * TypedQuery<Person> query =
			 * em.createQuery("SELECT p FROM Person p WHERE p.id = ?", Person.class);
			 * query.setParameter(1, 12); Person person = query.getSingleResult();
			 */
	EntityManager em = DatabaseHandle.getEntityManagerFactory();
	EntityTransaction transaction = em.getTransaction();

	public static void getJoueurByName(String name) {
		TypedQuery<Joueur> q = em.createQuery("select j from Joueur j where j.nom = :name", Joueur.class);
		q.setParameter("name", name);
		Joueur p = q.getSingleResult();
		System.out.println(p.toString()); 
	}
	public static void getPseudoPlayerSorted() {
		TypedQuery<Joueur> q = em.createQuery("from Joueur", Joueur.class);
		q.getResultList().stream().sorted((e1, e2) -> e1.getPseudo().compareTo(e2.getPseudo())).forEach(e->System.out.println(e.getPseudo()));
	}
	public static void getPlayerPlayedToday(LocalDate date) {
		System.out.print("On a tous jouees en date du "+date);
		TypedQuery<Joueur> q = em.createQuery("Select j FROM Joueur j Join j.parties p Join p.joueurs Where p.date_=:date ",Joueur.class);
		q.setParameter("date", LocalDate.of(2018, 05, 11));
		
		q.getResultList().stream().forEach(e->System.out.println(e.getPseudo()));
		System.out.println("--------------------------------------------");
	}
	public static void getPlayerEngins(String pseudo) {
		//TypedQuery<Joueur> q = em.createQuery("Select j FROM Joueur j Where j.pseudo = :pseudo",Joueur.class);
		TypedQuery<Joueur> q = em.createQuery("Select j FROM Joueur j Join j.avatar a Join a.engins Where j.pseudo = :pseudo",Joueur.class);
		q.setParameter("pseudo", pseudo);
		q.setMaxResults(1);
		System.out.println(q.getResultList());
		
	}
	
	public static void getLastPartieByUser(String pseudo) {
		
		TypedQuery<Joueur> q = em.createQuery("Select j FROM Joueur j Join j.parties p Join p.joueurs Where j.pseudo=:pseudo order by p.date_ ",Joueur.class);
		q.setParameter("pseudo", pseudo);
		q.setMaxResults(1);
		Joueur j = q.getSingleResult();
		System.out.println(j.getParties());
		
	}
	
}
