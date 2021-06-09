package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RobotTest {
	
	private Robot r1;
	
	@BeforeEach
	public void init() {
		r1=new Robot("Robot1",1000,150);
	}
	
	@AfterEach
	public void finish() {
		r1=null;
	}

	@Test
	void testToString() {
		String var="ID: " + r1.getID() + " Porcentaje de vida: " + r1.getVida();
		assertEquals(var,r1.toString());
	}

	static Stream <Arguments> Compare(){
		return Stream.of(
				Arguments.of(100,50),
				Arguments.of(50,0),
				Arguments.of(-30,-80),
				Arguments.of(0,-50)							
				);
	}
	
		
	@ParameterizedTest
	@MethodSource("Compare")
	void testCompareTo(int vida,int resul) {
		Robot ro1=new Robot("ID1",vida,30);
		Robot ro2=new Robot("ID2",50,30);
		assertEquals(ro1.compareTo(ro2),resul);
		
	}

}
