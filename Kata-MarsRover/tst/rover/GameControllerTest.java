package rover;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameControllerTest {
	static final String TEST_MESSAGE = "Test ViewController Message";
	private Rover rover = new Rover(0, 0, 0, "N");
	private Grid grid = new Grid(9, 9);
	private GameView gameView = new GameView();		
	private GameController gc;
	
	@Test
	public void testUpdateGameView() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		setup(expectedOutput);

		OutputStream outputStream = new ByteArrayOutputStream();

		PrintStream consoleOut = System.out;

		System.setOut(new PrintStream(outputStream));

		try{
			rover.landOnPlanet(grid);
			GameController gc = new GameController(rover, gameView);
			gc.updateView();
			assertEquals(expectedOutput.toString(), outputStream.toString());
		}
		finally{
			System.setOut(consoleOut);		
		}
	}

	private void setup(StringBuffer expectedOutput) {
		expectedOutput.append(line(TEST_MESSAGE));
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}
}
