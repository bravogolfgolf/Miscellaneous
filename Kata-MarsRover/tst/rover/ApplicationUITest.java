package rover;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class ApplicationUITest {
	static final String FORWARD_OPTION = "F";

	
	@Test
	public void testViewPrintHeading() throws IOException {
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
			ApplicationUI ui = new ApplicationUI();
			ui.run();

			assertEquals(expectedOutput.toString(), outputStream.toString());
		}
		finally{
			System.setIn(consoleIn);
			System.setOut(consoleOut);		
		}
	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(status1(ApplicationUI.STATUS));
		expectedOutput.append(line(ApplicationUI.INSTRUCTION_PROMPT));
		input.append(line(FORWARD_OPTION));
		expectedOutput.append(status2(ApplicationUI.STATUS));
		expectedOutput.append(line(ApplicationUI.INSTRUCTION_PROMPT));
		input.append(line(FORWARD_OPTION));
		expectedOutput.append(line(ApplicationUI.OBSTACLE_MESSAGE));
		expectedOutput.append(status2(ApplicationUI.STATUS));
		expectedOutput.append(line(ApplicationUI.INSTRUCTION_PROMPT));
		input.append(line(ApplicationUI.QUIT_OPTION));
		}

	private String status1(String status) {
		return line(String.format(status, "N", 0, 0, 0));
	}

	private String status2(String status) {
		return line(String.format(status, "N", 0, 1, 0));
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}
}