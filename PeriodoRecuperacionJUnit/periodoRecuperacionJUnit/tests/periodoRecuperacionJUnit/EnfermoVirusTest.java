package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnfermoVirusTest {
	
	private EnfermoVirus e1;
	@BeforeEach
	public void init () {
		e1=new EnfermoVirus("Pepe","Perez",19);
	}
	
	@AfterEach
	public void finish() {
		e1=null;
	}
	@Test
	void testRangoEdadAdulto() {
		assertEquals("adulto",e1.rangoEdad());
	}

	@Test
	void testRangoEdadAdolescente() {
		e1.setEdad(17);
		assertEquals("adolescente",e1.rangoEdad());
	}

	@Test
	void testRangoEdadNino() {
		e1.setEdad(9);
		assertEquals("niño",e1.rangoEdad());
	}


}
