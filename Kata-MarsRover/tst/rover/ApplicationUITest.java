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
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);

		OutputStream outputStream = new ByteArrayOutputStream();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		BufferedWriter writer = new BufferedWriter(outputStreamWriter);

		ApplicationUI ui = new ApplicationUI(reader, writer);
		ui.run();

		assertEquals(expectedOutput.toString(), outputStream.toString());

	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(ApplicationUI.MENU);
		input.append(line(ApplicationUI.START_OPTION));
		expectedOutput.append(status1(ApplicationUI.STATUS));
		input.append(line("F"));	
		expectedOutput.append(status2(ApplicationUI.STATUS));
		input.append(line(ApplicationUI.QUIT_OPTION));
		expectedOutput.append(status3(ApplicationUI.STATUS));
	}

	private String status1(String status) {
		return String.format(status, "N", 0, 0, 0);
	}

	private String status2(String status) {
		return String.format(status, "N", 0, 1, 0);
	}

	private String status3(String status) {
		return String.format(status, "N", 0, 2, 0);
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}
}
