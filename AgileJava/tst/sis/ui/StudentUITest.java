package sis.ui;

import java.io.*;

import junit.framework.*;

public class StudentUITest extends TestCase {

	public void testCreateStudent() throws IOException {
		StringBuffer expectedOutput = new StringBuffer();
		StringBuffer input = new StringBuffer();
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();

		InputStream inputStream = new ByteArrayInputStream(buffer);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		OutputStream outputStream = new ByteArrayOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

		StudentUI ui = new StudentUI(reader,writer);
		ui.run();
		assertEquals(expectedOutput.toString(),outputStream.toString());
	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(StudentUI.MENU);
		input.append(StudentUI.QUIT_OPTION);
	}
}
