package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Debito;

class DebitoTest {

	private Debito d1;
	
	@BeforeEach
	public void init() {
		Debito d1=new Debito("2441","Paco",null);
	}
	@AfterEach
	public void finish() {
		d1=null;
	}
	
	@Test
	void testRetirar() {
		try {
		d1.ingresar(100);
		d1.retirar(50);
		assertEquals(50,d1.getSaldo());
		}
		catch(Exception e) {
			
		}
	}

	@Test
	void testIngresar() throws Exception {
		d1.ingresar(50);
		assertEquals(50,d1.getSaldo());
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			d1.ingresar(100);
			d1.pagoEnEstablecimiento("pago",50);
			assertEquals(50,d1.getSaldo());
		}
		catch(Exception e) {
			
		}
	}

}
