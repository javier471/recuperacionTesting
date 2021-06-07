package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BarcoTest {
	
	private Barco b1;
	
	@BeforeEach
	public void init() {
		b1=new Barco("78","Seat","Barco3","Paco", 4);
	}
	
	@AfterEach
	public void finish() {
		b1=null;
	}
	
	@Test
	void testEstaACero() {
		assertEquals(0,b1.getCargaActual());
	}
	@Test
	void testCargaContenedorTrue() {
		try {
			Contenedor c1=new Contenedor("Sevilla","Madrid",440,"DHL");
			assertTrue(b1.cargaContenedor(c1));
		}catch(Exception e) {
			fail("No deberia lanzar exception");
		}
	}
	
	@Test
	void testCargaContenedorFalse() {
		try {
			Contenedor c1=new Contenedor("Sevilla","Madrid",440,"DHL");
			Contenedor c2=new Contenedor("Sevilla","Madrid",440,"DHL");

			Barco b2=new Barco("87","BMW","Barco32","Pepe",1);
			b2.cargaContenedor(c1);
			b2.cargaContenedor(c2);
			fail("Deberia haber lanzado exception");
		}catch(Exception e) {
			assertEquals("No caben más contenedores",e.getMessage());
		}
	}

}
