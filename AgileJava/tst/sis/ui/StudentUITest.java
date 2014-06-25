package sis.ui;

import java.io.*;

import junit.framework.*;

public class StudentUITest extends TestCase {
	static private final String name = "Leo Xerces Schmoo";
	
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
		System.out.println(expectedOutput.toString());
		System.out.println(outputStream.toString());
	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));
		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name));
		expectedOutput.append(StudentUI.ADDED_MESSAGE);
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.QUIT_OPTION));
		System.out.println("- Start Setup -");
		System.out.println(expectedOutput.toString());
		System.out.println("---");
		System.out.println(input.toString());
		System.out.println("- End Setup -");
	}

	private String line(String input) {
		return String.format("%s%n", input);
	}
}
