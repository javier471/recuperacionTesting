package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EnfermoVirusParametrizadoTests {

	static Stream <Arguments> edad(){
		return Stream.of(
				Arguments.of(4,"niño"),
				Arguments.of(0,"niño"),
				Arguments.of(-1,"niño"),
				Arguments.of(12,"niño"),
				Arguments.of(14,"adolescente"),
				Arguments.of(17,"adolescente"),
				Arguments.of(18,"adulto")
				);				
				
	}
	
	@ParameterizedTest
	@MethodSource("edad")
	void TestEdad(int anno,String resul) {
		EnfermoVirus e1=new EnfermoVirus("Pepe","Perez",anno);
		assertEquals(e1.rangoEdad(),resul);
	}
	
}
