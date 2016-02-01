package calculetteIR;

import static org.junit.Assert.*;
import org.junit.Test;


public class CalculetteIRTest {

	@Test
	public void testLevelLessThan9690() {
		CalculetteIR calculater = new CalculetteIR();
		double result = calculater.calculate(1000);
		assertEquals(0.0, result,0);
	}

	@Test
	public void testLevelLessThan26764() {
		CalculetteIR calculater = new CalculetteIR();
		double result = calculater.calculate(25000);
		assertEquals(2143.40, result,0);
	}
	
	@Test
	public void testLevelLessThan71754() {
		CalculetteIR calculater = new CalculetteIR();
		double result = calculater.calculate(50000);
		assertEquals(9361.16, result,0);
	}
}
