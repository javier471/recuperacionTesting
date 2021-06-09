package numeros;

public class Numeros {
	private int x;
	private int y;
	
	/**
	 * 
	 */
	public Numeros(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Función que devuelve true si los dos números que componen
	 * la clase son primos.
	 * False en caso contrario
	 * @return boolean
	 */
	public boolean primos() {
		boolean resul = true;
		if (!numPrimo(this.x) || !numPrimo(this.y) )
			resul = false;
		return resul;
	}
	
	

	private boolean numPrimo(int aux) {
		boolean resul = true;
		for (int i = 2; i< aux && resul; i++) {
			if (aux%i == 0)
				resul = false;
		}
		return resul;
	}
	/**
	 * Función que devuelve true si los dos valores entán incluido
	 * dentro del intervalo sin que sean iguales a los bordes
	 * @param inf
	 * @param sup
	 * @return
	 */
	public boolean intervaloAbierto(int inf, int sup) {
		boolean resul = true;
		if (this.x < inf || this.x > sup)
			resul = false;
		if (this.y < inf || this.y > sup)
			resul = false;
		
		return resul;
	}
	
	
	/**
	 * Función que devuelve true si los dos valores entán incluido
	 * dentro del intervalo incluyendo los bordes
	 * @param inf
	 * @param sup
	 * @return
	 */
	public boolean intervaloCerrado(int inf, int sup) {
		boolean resul = true;
		if (this.x <= inf || this.x >= sup)
			resul = false;
		if (this.y <= inf || this.y >= sup)
			resul = false;
		
		return resul;
	}
	
	/**
	 * Función que devuelve la suma de los dos valores que 
	 * componen la clase
	 * @return int
	 */
	public int suma() {
		return this.x + this.y;
	}
}
