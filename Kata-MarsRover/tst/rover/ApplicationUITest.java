package rover;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class ApplicationUITest {

	@Test
	public void testViewPrintHeading() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		StringBuffer input = new StringBuffer();
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();

		InputStream inputStream = new ByteArrayInputStream(buffer);
//		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//		BufferedReader reader = new BufferedReader(inputStreamReader);

		OutputStream outputStream = new ByteArrayOutputStream();
//		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//		BufferedWriter writer = new BufferedWriter(outputStreamWriter);

		InputStream consoleIn = System.in;
		PrintStream consoleOut = System.out;
		
		System.setIn(inputStream);
		System.setOut(new PrintStream(outputStream));
		
		try{

//			ApplicationUI ui = new ApplicationUI(reader , writer);
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
		expectedOutput.append(ApplicationUI.MENU);
		expectedOutput.append(status1(ApplicationUI.STATUS));
		expectedOutput.append(status1(ApplicationUI.INSTRUCTION_PROMPT));
		input.append(line(ApplicationUI.FORWARD_OPTION));
		expectedOutput.append(status2(ApplicationUI.STATUS));
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
