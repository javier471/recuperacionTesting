package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Cuenta;

class CuentaTest {
	
	private Cuenta c1;
	@BeforeEach
	public void init() {
		Cuenta c1=new Cuenta("21211","Paco");
	}
	@AfterEach
	public void finish() {
		 c1 = null;
	}

	@Test
	void testIngresarDouble() throws Exception {
		try {
		c1.ingresar("concept", 100);
		assertEquals(100,c1.getSaldo());
		}
		catch(Exception e) {
			
		}
	}

	@Test
	void testRetirarDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testIngresarStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testRetirarStringDouble() {
		fail("Not yet implemented");
	}

}
