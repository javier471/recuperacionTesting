package empleado;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEmpleado {
	
	private Empleado e1;
	
	@BeforeEach
	public void init() {
		e1=new Empleado("Paco","Perez",45,1000);
	}
	@AfterEach
	public void finish() {
		e1=null;
	}

	@Test
	void testPlus() {
		e1.plus(500);
		assertEquals(1500,e1.getSalario());
		
	}

}
