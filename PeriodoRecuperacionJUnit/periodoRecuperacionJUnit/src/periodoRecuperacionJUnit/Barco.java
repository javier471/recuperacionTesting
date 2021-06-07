package periodoRecuperacionJUnit;


public class Barco {
    String eslora;
    String marca;
    String modelo;
    Contenedor carga[];
    String capitan;
    private int capacidad; //número de contenedores que caben en el barco
    private int cargaActual; //número de contenedores cargados actualmente
    
    public Barco(String eslora, String marca, String modelo, String capitan, int capacidad) {
        this.eslora = eslora;
    	this.marca = marca;
        this.modelo = modelo;
        this.capitan = capitan;
        this.capacidad = capacidad;
        //Creamos el array de contenedores con la capacidad que nos indican
        carga = new Contenedor[capacidad]; 
        cargaActual = 0; //por ahora no hay contenedores en el barco
    }
    
    public boolean cargaContenedor(Contenedor contenedor) throws CapacidadExcedidaException {
    	boolean cargado;
        if (cargaActual >= capacidad) {
            throw new CapacidadExcedidaException("No caben más contenedores");
        } else {
            carga[cargaActual] = contenedor; //el vagón pasado ocupa el último lugar
            cargaActual ++; //ahora tenemos un vagón más enganchado al tren
            cargado=true;
        }
        return cargado;
    }   
    
    
    public int getCargaActual() {
    	return cargaActual;
    }
}