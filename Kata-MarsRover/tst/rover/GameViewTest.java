package rover;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameViewTest {
	static final String TEST_MESSAGE = "Test Message";

	
	@Test
	public void testPrintMessageToScreen() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		setup(expectedOutput);

		OutputStream outputStream = new ByteArrayOutputStream();

		PrintStream consoleOut = System.out;

		System.setOut(new PrintStream(outputStream));

		try{
			GameView g = new GameView();
			g.displayOnScreen("Test Message");

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

