package bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Avatar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy="avatar")
	private Set<Engin> engins ;
	
	@OneToOne(mappedBy="avatar")
	private Joueur joueur;
	
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

	public Joueur getJoueur() {
		return joueur;
	}

	public void setParties(Joueur J) {
		this.joueur = J;
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

	@Override
	public String toString() {
		return "Avatar [id=" + id + ", engins=" + engins + ", puissance="
				+ puissance + "]";
	}
	
	
}
