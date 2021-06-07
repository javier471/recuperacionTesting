package periodoRecuperacionJUnit;

public class EnfermoVirus{
	
	private String nombre;
	private String apellidos;
	private int edad;
	
	
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 */
	public EnfermoVirus(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
		
	public String getNombre() {
		
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
	public String getApellido() {
		// TODO Auto-generated method stub
		return this.apellidos;
	}
	
	public int getEdad() {
		// TODO Auto-generated method stub
		return this.edad;
	}
	
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
		
	}
	
	public void setApellido(String apellido) {
		this.apellidos = apellido;
		// TODO Auto-generated method stub
		
	}
	
	public void setEdad(int edad) {
		// TODO Auto-generated method stub
		this.edad = edad;
		
	}
	
	
	public String rangoEdad() {
	
		if (edad <=12)
			return "niño";
		else if (edad<=17) {
			return "adolescente";
		}
		else {
			return "adulto";
		}
	}
	
	public String toString() {
		return "EnfermoVirusImpl [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}


	
}
