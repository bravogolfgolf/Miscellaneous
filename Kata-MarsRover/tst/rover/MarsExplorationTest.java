package rover;

import org.junit.Test;

public class MarsExplorationTest {

	@Test
	public void testNoObstacle() {
		String x = "0";
		String y = "0";
		String direction = "N";
		String instruction = "FFFBLFRBFFL";
		String[] string = {x, y, direction, instruction};
		MarsExploration.main(string);
	}
	
	@Test
	public void testObstacle() {
		String x = "0";
		String y = "0";
		String direction = "N";
		String instruction = "FFLB";
		String[] string = {x, y, direction, instruction};	
		MarsExploration.main(string);
	}
}
