package pruebaJUnit5;

public class LuchaRobots {
	private String estadio;
	private Robot luchadores[];
	private String arbitro;
	
	public LuchaRobots(String estadio, String arbitro) {
		try {
			this.setEstadio(estadio);
			this.setArbitro(arbitro);
			luchadores = new Robot[2];
		}
		catch(Exception e) {
			
		}
	}
	
	public int añadeRobot(String ID, float vida, float fuerza ) { 
		if (luchadores.length < 2) {
			Robot robot = new Robot(ID, vida, fuerza);
			luchadores[luchadores.length]= robot;
			
		}
		
		return luchadores.length;
	}
	
	public int getNumLuchadores() {
		return luchadores.length;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) throws NotAllowedChangeException{
		if (luchadores.length == 0) {
			this.estadio = estadio;
		}
		else {
			throw new NotAllowedChangeException("Ya se han añadido luchadores");
		}
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	
	
	
	

}
