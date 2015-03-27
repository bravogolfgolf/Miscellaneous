package rover;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameViewTest {
	static final String TEST_MESSAGE = "Test Message";

	
	@Test
	public void testPrintMessageToScreen() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		StringBuffer input = new StringBuffer();
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();

		InputStream inputStream = new ByteArrayInputStream(buffer);
		OutputStream outputStream = new ByteArrayOutputStream();

		InputStream consoleIn = System.in;
		PrintStream consoleOut = System.out;

		System.setIn(inputStream);
		System.setOut(new PrintStream(outputStream));

		try{
			GameView g = new GameView();
			g.displayOnScreen("Test Message");

			assertEquals(expectedOutput.toString(), outputStream.toString());
		}
		finally{
			System.setIn(consoleIn);
			System.setOut(consoleOut);		
		}
	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(line(TEST_MESSAGE));
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}
}

