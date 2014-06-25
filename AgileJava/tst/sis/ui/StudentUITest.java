package sis.ui;

import java.io.*;
import java.util.*;
import sis.studentinfo.*;

import junit.framework.*;

public class StudentUITest extends TestCase {
	static private final String name1 = "Leo Xerces Schmoo";
	static private final String name2 = "Brian Glenn Gibson";

	public void testCreateStudent() throws IOException {
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
			StudentUI ui = new StudentUI();
			ui.run();
			assertEquals(expectedOutput.toString(),outputStream.toString());

			List<Student> students = ui.getAddedStudents();
			assertEquals(2,students.size());
			assertEquals(name1,students.get(0).getName());
			assertEquals(name2,students.get(1).getName());

		}
		finally{
			System.setIn(consoleIn);
			System.setOut(consoleOut);
		}
	}

	private void setup(StringBuffer expectedOutput, StringBuffer input) {
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));

		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name1));
		expectedOutput.append(line(StudentUI.ADDED_MESSAGE));

		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));
		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name2));
		expectedOutput.append(line(StudentUI.ADDED_MESSAGE));

		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.QUIT_OPTION));
		expectedOutput.append(line(StudentUI.QUIT_MESSAGE));
	}

	private String line(String input) {
		return String.format("%s%n", input);
	}
}
