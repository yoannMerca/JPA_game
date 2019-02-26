package bean;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Table;

	@Table
	@Entity
	public class Aeronef extends Engin {
		
		@Column(length = 30)
		private String type;
		
		@Column(length = 30)
		private int autonomieKM;

		
		public Aeronef() {
			super();
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getAutonomieKM() {
			return autonomieKM;
		}

		public void setAutonomieKM(int autonomieKM) {
			this.autonomieKM = autonomieKM;
		}
			
	}

