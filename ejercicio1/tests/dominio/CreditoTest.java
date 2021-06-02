package dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Credito;

class CreditoTest {
	private Credito c;
	private Cuenta c1;
	
	@BeforeEach
	public void init(){
		c1=new Cuenta("21211","Paco");
		c=new Credito("2313","Paco",null,1000);
		c.setCuenta(c1);
	}
	@AfterEach
	public void finish(){
		c=null;
	}

	@Test
	void testRetirar()  {
		try {
		c.retirar(100);
		assertEquals(895, c.getCreditoDisponible());
		}catch(Exception e) {
			fail("Metodo debe restar tambien cantidad que se le pasa");
		}
	}

	
	@Test
	void testRetirarCantidadMayor()  {
		try {
		c.retirar(10000);
		fail("Se debe lanzar exception");
		}catch(Exception e) {
			assertEquals("Crédito insuficiente",e.getMessage());
		}
	}
	@Test
	void testIngresar() {
		try {
			c.ingresar(100);
			assertEquals(1100,c.getSaldo());
		}catch(Exception e) {
			fail("El metodo debería sumar lo que se le pasa y no settear esa cantidad como saldo");
		}
	}
	
	@Test
	void testIngresarNegativo() {
		try {
			c.ingresar(-100);
			fail("Se deberia haber lanzado exception");
		}catch(Exception e) {
			
		}
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			c.pagoEnEstablecimiento("datos", 100);
			assertEquals(900,c.getCreditoDisponible());
		}catch(Exception e) {
			fail("No debe lanzar exception");
		}
	}

	@Test
	void testGetCreditoDisponible() {
		assertEquals(1000, c.getCreditoDisponible());
	}

	@Test
	void testLiquidar() {
		fail("Not yet implemented");
	}

}
