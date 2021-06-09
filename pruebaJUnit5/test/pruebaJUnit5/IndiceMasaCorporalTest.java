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
				Arguments.of("17","Tienes que engordar"),
				Arguments.of("18","Muy bien"),
				Arguments.of("25","Sobrepeso"),
				Arguments.of("27","Sobrepeso")			
				);
	}
	
	@ParameterizedTest
	@MethodSource("imc")
	void TestIndiceMasaCorporal(String peso,String resul) {
		try {
		IndiceMasaCorporal i1=new IndiceMasaCorporal(80,175);
		assertEquals(i1.diagnostico(),resul);
		}catch(Exception e) {
			
		}
	}
	
	
	
	

}
