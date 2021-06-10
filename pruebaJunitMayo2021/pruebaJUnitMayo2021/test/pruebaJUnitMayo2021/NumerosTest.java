package pruebaJUnitMayo2021;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import numeros.Numeros;

class NumerosTest {

	
	static Stream <Arguments> primos(){
		return Stream.of(
				Arguments.of(1,2,true),
				Arguments.of(1,4,false),
				Arguments.of(4,8,false)
				);
		}	
	
	@ParameterizedTest
	@MethodSource("primos")
	void testPrimos(int num1,int num2,boolean resul) {
		Numeros n1=new Numeros(num1,num2);
		assertEquals(n1.primos(),resul);
	}
	
	static Stream <Arguments> intervaloCerrado(){
		return Stream.of(
				Arguments.of(1,10,true),
				Arguments.of(1,7,true),
				Arguments.of(3,10,true),
				Arguments.of(3,18,false)
				);
		}	

	@ParameterizedTest
	@MethodSource("intervaloCerrado")
	void testIntervaloCerrado(int num1,int num2,boolean resul) {
		Numeros n1=new Numeros(1,10);
		assertEquals(n1.intervaloCerrado(num1, num2),resul);
	}
	static Stream <Arguments> intervaloAbierto(){
		return Stream.of(
				Arguments.of(1,10,false),
				Arguments.of(1,7,false),
				Arguments.of(3,10,false),
				Arguments.of(3,7,true)
				);
		}	

	@ParameterizedTest
	@MethodSource("intervaloAbierto")
	void testIntervaloAbierto(int num1,int num2,boolean resul) {
		Numeros n1=new Numeros(2,8);
		assertEquals(n1.intervaloAbierto(num1, num2),resul);
	}
	
	static Stream <Arguments> Suma(){
		return Stream.of(
				Arguments.of(1,10,11),
				Arguments.of(1,7,8),
				Arguments.of(0,10,10),
				Arguments.of(3,-7,-4)
				);
		}	

	@ParameterizedTest
	@MethodSource("Suma")
	void testSuma(int num1,int num2,int resul) {
		Numeros n1=new Numeros(num1,num2);
		assertEquals(n1.suma(),resul);
	}

}
