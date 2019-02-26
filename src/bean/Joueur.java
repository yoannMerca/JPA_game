package bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "joueur")
public class Joueur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	@JoinTable(name="joueur_partie", 
		joinColumns= @JoinColumn(name="id_joueur", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_partie", referencedColumnName="id_partie")
		)
	private List<Partie> parties;
	
	@ManyToOne
	@JoinColumn(name="id_avatar")
	private Avatar avatar;
	
	@Column(name = "nom", length = 30)
	private String nom;
	
	@Column(name = "mail", length = 30)
	private String mail;
	
	@Column(name = "pseudo", length = 30)
	private String pseudo;
	
	
	public Joueur() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	
	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ",, nom=" + nom + ", mail=" + mail + ", pseudo=" + pseudo
				+ "]";
	}

	

}
