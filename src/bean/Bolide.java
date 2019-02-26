package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Bolide extends Engin {

	
	@Column(length = 30)
	private int nbRoues;
	
	@Column(length = 30)
	private int autonomieHeure;

	public Bolide() {
		super();
	}

	
	
	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	public int getAutonomieHeure() {
		return autonomieHeure;
	}

	public void setAutonomieHeure(int autonomieHeure) {
		this.autonomieHeure = autonomieHeure;
	}
	
	
}
