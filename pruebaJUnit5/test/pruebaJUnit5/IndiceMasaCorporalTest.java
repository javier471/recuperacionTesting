package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IndiceMasaCorporalTest {

	static Stream <Arguments> imc(){
		return Stream.of(
				Arguments.of(80,175,"Sobrepeso"),
				Arguments.of(90,170,"Sobrepeso"),
				Arguments.of(40,180,"Tienes que engordar"),
				Arguments.of(70,180,"Muy bien")			
				);
	}
	
	@ParameterizedTest
	@MethodSource("imc")
	void TestIndiceMasaCorporal(float peso,float altura,String resul) {
		try {
		IndiceMasaCorporal i1=new IndiceMasaCorporal(peso,altura);
		assertEquals(i1.diagnostico(),resul);
		}catch(Exception e) {
			fail("No deberia lanzar exception");
		}
	}
	
	
	
	

}
