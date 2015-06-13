import static org.junit.Assert.*;

import org.junit.Test;

public class TestDNA {

	@Test
	public void testClean() {
		DNA dna = new DNA("ATUGACRE");
		dna.clean();
		assertEquals("ATGAC", dna.getValue());
	}

	@Test
	public void testReverse() {
		DNA dna = new DNA("ATUGACRE");
		dna.reverse();
		assertEquals("ERCAGUTA", dna.getValue());
	}


}