package empleado;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEmpleado {
	
	private Empleado e1;
	private Empleado e2;
	private Empleado e3;
	private Empleado e4;
	
	@BeforeEach
	public void init() {
		e1=new Empleado("Paco","Perez",45,1000);
		e2=new Empleado("Paco","Perez",39,1000);
		e3=new Empleado("Pepe","Garcia",40,1000);
		e4=new Empleado("Paco","Garcia",40,1000);

	}
	@AfterEach
	public void finish() {
		e1=null;
		e2=null;
		e3=null;
		e4=null;
	}

	@Test
	void testPlusMayorDe40() {
		e1.plus(500);
		assertEquals(1500,e1.getSalario());
		
	}
	
	@Test
	void TestPlus40() {
		e2.plus(500);
		assertEquals(1000,e2.getSalario());
	}

	@Test
	void TestPlusMenorQue40() {
		e3.plus(500);
		assertEquals(1000,e3.getSalario());
	}
	
	@Test
	void TestEqualsSi() {
		assertTrue(e1.equals(e2));
	}
	
	@Test
	void TestEqualsNo() {
		assertFalse(e1.equals(e3));
	}
	
	@Test
	void TestCompareToMayor() {
		assertEquals(1,e1.compareTo(e2));
	}
	
	@Test
	void TestCompareToIgual() {
		assertEquals(0,e3.compareTo(e4));
	}
	
	@Test
	void TestCompareToMenor() {
		assertEquals(-1,e2.compareTo(e1));
	}
	
	@Test
	void TestToString() {
		String var="El empleado se llama "+e1.getNombre()+" "+e1.getApellido()+" con "+e1.getEdad()+" años " +
                "y un salario de "+e1.getSalario();
		assertEquals(var,e1.toString());
	}
	
}
