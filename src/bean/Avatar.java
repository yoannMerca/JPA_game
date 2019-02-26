package bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Avatar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy="avatar")
	private Set<Engin> engins ;
	
	@OneToMany(mappedBy="avatar")
	private Set<Joueur> joueurs;
	
	@Column(length = 30)
	private String nom;
	
	@Column(length = 30)
	private int puissance;	
	
	public Avatar(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Engin> getEngins() {
		return engins;
	}

	public void setEngins(Set<Engin> engins) {
		this.engins = engins;
	}

	public Set<Joueur> getJoueur() {
		return joueurs;
	}

	public void setParties(Set<Joueur> J) {
		this.joueurs = J;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
	
}
