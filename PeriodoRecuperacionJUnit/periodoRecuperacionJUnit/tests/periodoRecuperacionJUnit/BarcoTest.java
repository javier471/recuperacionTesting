package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BarcoTest {
	
	private Barco b1;
	
	@BeforeEach
	public void init() {
		b1=new Barco("78","Seat","Barco3","Paco", 10);
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
	void testCargaContenedor() {
		fail("Not yet implemented");
	}

}
