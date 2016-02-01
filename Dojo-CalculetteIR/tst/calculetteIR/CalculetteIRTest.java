package calculetteIR;

import static org.junit.Assert.*;
import org.junit.Test;


public class CalculetteIRTest {

	@Test
	public void testLevelLessThan9690() {
		CalculetteIR calculater = new CalculetteIR();
		int result = calculater.calculate(1000);
		assertEquals(0, result);

	}


}
