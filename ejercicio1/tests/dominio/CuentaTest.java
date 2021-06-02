package dominio;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Cuenta;

class CuentaTest {
	
	private Cuenta c1;
	@BeforeEach
	public void init() {
		c1=new Cuenta("21211","Paco");
	}
	@AfterEach
	public void finish() {
		 c1 = null;
	}

	@Test
	void TestEstaACero() {
		assertEquals(0,c1.getSaldo());
	}
	
	@Test
	void testIngresarDouble()  {
		try {
		c1.ingresar(100);
		assertEquals(100,c1.getSaldo());
		}
		catch(Exception e) {
			fail("No debería haber lanzado exception");
		}
	}
	
	@Test
	void testIngresarDoubleNegativo()  {
		try {
		c1.ingresar(-15);
		fail("Debería haber lanzado exception");
		}
		catch(Exception e) {
			assertEquals("No se puede ingresar una cantidad negativa",e.getMessage());
		}
	}
	

	@Test
	void testRetirarDouble() {
		try {
			c1.ingresar(100);
			c1.retirar(50);
			assertEquals(50,c1.getSaldo());
		}
		catch(Exception e) {
			fail("No debería haber lanzado exception");
		}
	}
	@Test
	void testRetirarDoubleSiNoHay() {
		try {
			c1.retirar(50);
			fail("Se deberia lanzar exception");
		}
		catch(Exception e) {
			assertEquals("Saldo insuficiente",e.getMessage());
		}
	}
	
	@Test
	void testRetirarDoubleNegativo() {
		try {
			c1.retirar(-50);
			fail("Se deberia lanzar exception");
		}
		catch(Exception e) {
			assertEquals("No se puede retirar una cantidad negativa",e.getMessage());
		}
	}

	@Test
	void testIngresarStringDouble() {
		try {
			c1.ingresar("concept", 100);
			assertEquals(100,c1.getSaldo());
		}
		catch(Exception e) {
			fail("No deberia haber lanzado exception");
		}
	}
	@Test
	void testIngresarStringDoubleNegativo() {
		try {
			c1.ingresar("concept", -100);
			fail("Debe saltar exception");
		}
		catch(Exception e) {
			assertEquals("No se puede ingresar una cantidad negativa",e.getMessage());
		}
	}

	@Test
	void testRetirarStringDouble() {
		try {
			c1.ingresar(100);
			c1.retirar("concept",50);
		}catch(Exception e) {
			fail("No se deberia haber lanzado exception");
		}
	}
	
	@Test
	void testRetirarStringDoubleNegativo() {
		try {
			c1.retirar("concept",-50);
			fail("Deberia lanzar exception");
		}catch(Exception e) {
			assertEquals("No se puede retirar una cantidad negativa",e.getMessage());
		}
	}
	
	@Test
	void testRetirarStringDoubleSiNoHay() {
		try {
			c1.retirar("concept",50);
			fail("Deberia lanzar exception");
		}catch(Exception e) {
			assertEquals("Saldo insuficiente",e.getMessage());
		}
	}
	
}
