package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Credito;

class CreditoTest {
	private Credito c;
	
	@BeforeEach
	public void init(){
		Credito c=new Credito("2313","Paco",null,1000);
	}
	@AfterEach
	public void finish(){
		c=null;
	}

	@Test
	void testRetirar() throws Exception {
		c.retirar(100);
		assertEquals(900, c.getCreditoDisponible());
	}

	@Test
	void testIngresar() {
		try {
			c.ingresar(100);
			assertEquals(1100,c.getCreditoDisponible());
		}catch(Exception e) {
			
		}
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			c.pagoEnEstablecimiento("datos", 100);
			assertEquals(900,c.getCreditoDisponible());
		}catch(Exception e) {
			
		}
	}

	@Test
	void testGetCreditoDisponible() {

		assertEquals(1000, c.getSaldo());
	}

	@Test
	void testLiquidar() {
		fail("Not yet implemented");
	}

}
