package pruebaJUnit5;

class Robot {
	private String ID;
	private float vida;
	private float fuerza;
	
	public Robot(String ID, float vida, float fuerza) {
		this.ID = ID;
		this.vida = vida;
		this.setFuerza(fuerza);
	}
	
	public String getID() {
		return ID;
	}
	
	public float getVida() {
		return vida;
	}
	
	public String toString() {
		return "ID: " + this.ID + " Porcentaje de vida: " + this.vida;
	}
	
	public int compareTo(Object o) {
		Robot ro = (Robot) o;
		return (int)(this.vida -ro.vida);
	}

	public float getFuerza() {
		return fuerza;
	}

	public void setFuerza(float fuerza) {
		this.fuerza = fuerza;
	}

}
