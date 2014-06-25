package sis.ui;

import java.io.*;
import java.util.*;
import sis.studentinfo.*;

public class StudentUI {
	public static final String MENU = "(A)dd or (Q)uit";
	public static final String ADD_OPTION = "A";
	public static final String QUIT_OPTION = "Q";
	public static final String NAME_PROMPT = "Name:";
	public static final String ADDED_MESSAGE = "Added";
	public static final String QUIT_MESSAGE = "Quit";

	private BufferedReader reader;
	private BufferedWriter writer;
	private List<Student> students = new ArrayList<Student>();

	public static final void main(String[] args) throws IOException{
		new StudentUI().run();
	}
	
	public StudentUI() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));;
		this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public void run() throws IOException {
		String line;
		do{
			write(MENU);
			line = reader.readLine();
			if (line.equals(ADD_OPTION)){
				addStudent();
			}
		}while (!line.equals(QUIT_OPTION));
		writeln(QUIT_MESSAGE);
	}

	List<Student> getAddedStudents() {
		return students;
	}

	private void addStudent() throws IOException {
		String name;
		write(NAME_PROMPT);
		name = reader.readLine();
		students.add(new Student(name));
		writeln(ADDED_MESSAGE);
	}

	private void write(String line) throws IOException {
		writer.write(line,0,line.length());
		writer.flush();
	}

	private void writeln(String line) throws IOException {
		writer.write(line,0,line.length());
		writer.newLine();
		writer.flush();
	}
}