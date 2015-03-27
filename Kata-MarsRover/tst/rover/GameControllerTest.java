package rover;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameControllerTest {
	static final String TEST_MESSAGE = "Test ViewController Message";

	StringBuffer expectedOutput = new StringBuffer();
	OutputStream outputStream = new ByteArrayOutputStream();

	private Rover rover = new Rover(0, 0, 0, "N");
	private Grid grid = new Grid(9, 9);
	private GameView gameView;		

	private GameController setupGameController() {
		rover.landOnPlanet(grid);
		gameView = new GameView();
		GameController gc = new GameController(rover, gameView);
		return gc;
	}

	private PrintStream setupPrintStream() {
		PrintStream consoleOut = System.out;
		System.setOut(new PrintStream(outputStream));
		return consoleOut;
	}

	private void setupExpectOutput(StringBuffer expectedOutput) {
		expectedOutput.append(line(TEST_MESSAGE));
		expectedOutput.append(line(TEST_MESSAGE));
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}

	@Test
	public void testUpdateGameView() throws IOException {
		setupExpectOutput(expectedOutput);
		PrintStream consoleOut = setupPrintStream();

		GameController gc = setupGameController();

		try{
			gc.updateView("Test ViewController Message");
			gc.updateView("Test ViewController Message");
			assertEquals(expectedOutput.toString(), outputStream.toString());
		}
		finally{
			System.setOut(consoleOut);		
		}
	}

	@Test
	public void testMoveRover() {
		GameController gc = setupGameController();
		gc.moveRover("R");
		assertEquals("E", this.rover.getHeading());
	}
}