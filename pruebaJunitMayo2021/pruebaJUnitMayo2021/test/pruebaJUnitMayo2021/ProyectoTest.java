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
		p1=new Proyecto("Proyect",LocalDate.now(),LocalDate.now().plusMonths(2));
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
			p1.addTarea("Concept", LocalDate.now().plusDays(10), 4);
			assertEquals("Proyecto Proyect con código 0. Fecha de comienzo "+LocalDate.now()+". Fecha final:"+LocalDate.now().plusMonths(2)+"\n" + 
					"Task Concept, Fecha inicio="+LocalDate.now().plusDays(10)+", duración=4.En proceso\n",p1.toString());
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
	void testDelTaskTrue() {
		try {
			p1.addTarea("Concept", LocalDate.now().plusDays(10),4);
			p1.delTask("Concept");
			assertEquals("Proyecto Proyect con código 0. Fecha de comienzo 2021-06-11. Fecha final:2021-08-11\n" + 
					"Task Concept, Fecha inicio=2021-06-21, duración=4.En proceso\n"
					,p1.toString());
			
		}catch(Exception e) {
			fail("No se deberia haber lanzado exception");
		}
	}
	
	@Test
	void testEndTask() {
		try {
			p1.addTarea("Concept", LocalDate.of(2021, 11, 22), 4);
			p1.endTask("Concept");
			//assertEquals();
		}catch(Exception e) {
			
		}
	}

}
