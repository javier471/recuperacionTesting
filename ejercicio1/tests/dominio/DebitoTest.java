package dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Debito;

class DebitoTest {

	private Debito d1;
	private Cuenta c1;
	
	@BeforeEach
	public void init() {
		 c1=new Cuenta("21211","Paco");
		 d1=new Debito("2441","Paco",null);
		 d1.setCuenta(c1);
	}
	@AfterEach
	public void finish() {
		d1=null;
	}
	
	@Test
	void testRetirar() {
		try {
		c1.ingresar(100);
		d1.retirar(50);
		assertEquals(50,d1.getSaldo());
		}
		catch(Exception e) {
			fail("No deberia haber lanzado exception");
		}
	}
	@Test
	void testRetirarMayorQueSaldo() {
		try {
		d1.retirar(50);
		fail("No puedes retirar sin haber saldo");
		}
		catch(Exception e) {
			assertEquals("Saldo insuficiente",e.getMessage());
		}
	}

	@Test
	void testRetirarNegativo() {
		try {
		d1.retirar(-50);
		fail("No puedes retirar sin negativo");
		}
		catch(Exception e) {
			assertEquals("No se puede retirar una cantidad negativa",e.getMessage());
		}
	}
	@Test
	void testIngresar() {
		try {
		c1.ingresar(50);
		assertEquals(50,d1.getSaldo());
		}
		catch(Exception e) {
			fail("No deberia haber lanzado exception");
		}
	}
	
	@Test
	void testIngresarNegativo() {
		try {
		c1.ingresar(-50);
		fail("Deberia haber lanzado exception");
		}
		catch(Exception e) {
			assertEquals("No se puede ingresar una cantidad negativa",e.getMessage());
		}
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			c1.ingresar(100);
			d1.pagoEnEstablecimiento("pago",50);
			assertEquals(50,d1.getSaldo());
		}
		catch(Exception e) {
			fail("No deberia lanzar exception");
		}
	}
	
	@Test
	void testPagoEnEstablecimientoMenorQueSaldo() {
		try {
			c1.ingresar(100);
			d1.pagoEnEstablecimiento("pago",150);
			fail("Deberia lanzar exception");
		}
		catch(Exception e) {
			assertEquals("Saldo insuficiente",e.getMessage());
		}
	}

	@Test
	void testPagoEnEstablecimientoNegativo() {
		try {
			c1.ingresar(100);
			d1.pagoEnEstablecimiento("pago",-50);
			fail("Deberia lanzar exception");
		}
		catch(Exception e) {
			assertEquals("No se puede retirar una cantidad negativa",e.getMessage());
		}
	}

}
