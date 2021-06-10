package pruebaJUnitMayo2021;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proyectos.Proyecto;

class ProyectoTest {
	
	private Proyecto p1;
	
	@BeforeEach
	public void init() {
		try {
		p1=new Proyecto("Proyect",LocalDate.of(2020,11,21),LocalDate.of(2020, 12, 14));
		}catch(Exception e) {
			fail("No deberia lanzar exception");
		}
	}

	@AfterEach
	public void finish() {
		p1=null;
	}
	
	@Test
	void testAddTareaTrue() {
		try {
			p1.addTarea("Concept", LocalDate.of(2020, 11, 22), 4);
			assertEquals("Task " + "Concept" + ", Fecha inicio=" + LocalDate.of(2020, 11, 22)
					+ ", duración=" + 4 + ".En proceso",p1.toString());
		}catch(Exception e) {
			fail("No se deberia haber lanzado exception");
		}
	}
	
	@Test
	void testAddTareaFechaAntes() {
		try {
			p1.addTarea("Concept", LocalDate.of(2019,2,11), 3);
			fail("Se deberia haber lanzado exception");
		}catch(Exception e) {
			assertEquals("No se puede añadir una tarea fuera de los límites del proyecto",e.getMessage());
		}
	}

	@Test
	void testAddTarea0() {
		try {
			p1.addTarea("Concept", LocalDate.of(2020,11,22),-4);
			fail("Se deberia haber lanzado exception");
		}catch(Exception e) {
			assertEquals("No se puede añadir una tarea con tiempo negativo",e.getMessage());
		}
	}
	
	@Test
	void testDelTask() {
		fail("Not yet implemented");
	}

	@Test
	void testEndTask() {
		fail("Not yet implemented");
	}

}
