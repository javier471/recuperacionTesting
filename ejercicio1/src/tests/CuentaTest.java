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
	void testIngresarDouble()  {
		try {
		c1.ingresar(100);
		assertEquals(100,c1.getSaldo());
		}
		catch(Exception e) {
			
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
			
		}
	}
	@Test
	void testRetirarDoubleSiNoHay() {
		try {
			c1.retirar(50);
			fail("Se deberia lanzar exception");
		}
		catch(Exception e) {
			
		}
	}

	@Test
	void testIngresarStringDouble() {
		try {
			c1.ingresar("concept", 100);
			assertEquals(100,c1.getSaldo());
		}
		catch(Exception e) {
			
		}
	}
	@Test
	void testIngresarStringDoubleNegativo() {
		try {
			c1.ingresar("concept", -100);
			fail("Debe saltar exception");
		}
		catch(Exception e) {
			
		}
	}

	@Test
	void testRetirarStringDouble() {
		try {
			c1.ingresar(100);
			c1.retirar("concept",50);
		}catch(Exception e) {
			
		}
	}
}
