package proyectos;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws FechaInicialFinalNoValidaException, FechaInicialProyectoNoValidaException, FechaInicialTareaNoValidaException, DuracionTareaNoValidoException {
		// TODO Auto-generated method stub
		Proyecto p1=new Proyecto("Proyect",LocalDate.of(2020,11,21),LocalDate.of(2020, 12, 14));
		p1.addTarea("Concept", LocalDate.of(2019,2,11), 3);

	}

}
