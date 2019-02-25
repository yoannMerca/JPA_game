package bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Partie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_partie;
	
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

	@Override
	public String toString() {
		return "Partie [id_partie=" + id_partie + ", niveau=" + niveau + ", score=" + score + ", date_=" + date_ + "]";
	};
	
	
	
}
