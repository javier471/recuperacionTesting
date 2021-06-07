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
				Arguments.of(4),
				Arguments.of(0),
				Arguments.of(-1),
				Arguments.of(12),
				Arguments.of(14),
				Arguments.of(17),
				Arguments.of(18)
				);				
				
	}
	
	@ParameterizedTest
	@MethodSource("edad")
	void TestEdad(int anno) {
		EnfermoVirus e1=new EnfermoVirus("Pepe","Perez",20);
		assertEquals(e1.rangoEdad(),edad());
	}
	
}
