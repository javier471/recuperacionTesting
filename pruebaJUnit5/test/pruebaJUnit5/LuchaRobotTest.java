package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuchaRobotTest {
	

	private LuchaRobots lr1;
	
	@BeforeEach
	public void init() {
		lr1=new LuchaRobots("Estadio","Perez");
	}
	@AfterEach
	public void finish() {
		lr1=null;
	}
	
	
	@Test
	void testEstaACero() {
		assertEquals(0,lr1.getNumLuchadores());
	}
	
	
	@Test
	void testSeAñadeRobot() {
		lr1.añadeRobot("4", 200, 15);
		assertEquals(1,lr1.getNumLuchadores());
	}
	
	@Test 
	void testAñadeRobot() {
		lr1.añadeRobot("ID1", 100, 40);
		lr1.añadeRobot("ID2", 150, 30);
		lr1.añadeRobot("ID3", 130, 35);
		assertEquals(2,lr1.getNumLuchadores());
		
		
	}
 
	@Test
	void testSetEstadio() {
		try {
			lr1.setEstadio("Estadio");
			fail("No se deberia haber lanzado exception");
		}catch(Exception e) {
			assertEquals("Ya se han añadido luchadores",e.getMessage());
		}
	}

}
