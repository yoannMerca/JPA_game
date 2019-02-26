package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
		p.toString();
	}
	public static void getPseudoPlayerSorted() {
		TypedQuery<Joueur> q = em.createQuery("from Joueur", Joueur.class);
		
		q.getResultList().stream().map(e -> e.getPseudo()).sorted((o1,o2)->{
			return  (o1.equals(o2)) ? 1: (o2.equals(o1)? -1 :0) ;
		}).forEach(System.out::println);

		
	}
}
