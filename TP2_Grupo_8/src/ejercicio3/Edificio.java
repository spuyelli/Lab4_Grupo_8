package ejercicio3;

public class Edificio {
	
		private double superficieEdificio;

		//CONSTRUCTORES
		public Edificio(double superficieEdificio) {
			this.superficieEdificio = superficieEdificio;
		}
		
		public Edificio () {
			this.superficieEdificio=0;
		}
		
		//GETERS SETERS
		public double getSuperficieEdificio() {
			return superficieEdificio;
		}

		public void setSuperficieEdificio(double superficieEdificio) {
			this.superficieEdificio = superficieEdificio;
		}

		@Override
		public String toString() {
			return "Edificio: superficieEdificio= " + superficieEdificio ;
		}

		
		
}		
