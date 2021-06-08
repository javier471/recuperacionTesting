package empleado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestParametrizadoEmpleado {

	
	static Stream <Arguments> plus(){
		return Stream.of(
				Arguments.of(38,false,1000),
				Arguments.of(40,false,1000),
				Arguments.of(42,true,1500)			
				);
	}
	
	@ParameterizedTest
	@MethodSource("plus")
	void TestPlus(int edad,boolean resul,int cantidad) {
		Empleado e1=new Empleado("Paco","Lopez",edad,1000);
		assertEquals(e1.plus(500),resul);
		assertEquals(e1.plus(500),cantidad);
	}
	
	static Stream <Arguments> equals(){
		return Stream.of(
				Arguments.of("Pepe","Garcia",true),
				Arguments.of("Pepe","Perez",false),
				Arguments.of("Paco","Garcia",false),
				Arguments.of("Paco","Lopez",false)				
				);
		}

	@ParameterizedTest
	@MethodSource("equals")
	void TestEquals(String nombre,String apellido,boolean resul) {
		Empleado e1=new Empleado(nombre,apellido);
		Empleado e2=new Empleado("Pepe","Garcia");
		assertEquals(e1.equals(e2),resul);
	}
	

	static Stream <Arguments> compareTo(){
		return Stream.of(
				Arguments.of(23,1),
				Arguments.of(22,0),
				Arguments.of(20,-1)		
				);
		}
	
	@ParameterizedTest
	@MethodSource("compareTo")
	void TestCompareTo(int edad,int resul) {
		Empleado e1=new Empleado("Paco","Perez",edad);
		Empleado e2=new Empleado("Pepe","Garcia",22);
		assertEquals(e1.compareTo(e2),resul);
	}
}
