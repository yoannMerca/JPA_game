package bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Partie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_partie;
	
	@ManyToMany(mappedBy="parties")
	private List<Joueur> joueurs;
	
	
	
	@Column(length = 30)
	private int niveau;
	
	@Column(length = 30)
	private int score;
	
	@Column
	private LocalDate date_;
	
	public Partie(){}

	public Integer getId_partie() {
		return id_partie;
	}

	public void setId_partie(Integer id_partie) {
		this.id_partie = id_partie;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDate getDate_() {
		return date_;
	}

	public void setDate_(LocalDate date_) {
		this.date_ = date_;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	
	
	

	@Override
	public String toString() {
		return "Partie [id_partie=" + id_partie + ", niveau=" + niveau + ", joueur=" + joueurs
				+ ", date_=" + date_ + "]";
	}

	
	
	
	
}
