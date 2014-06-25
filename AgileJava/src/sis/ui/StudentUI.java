package sis.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class StudentUI {
	BufferedReader reader;
	BufferedWriter writer;
	public static final String MENU = "(A)dd or (Q)uit";
	public static final String ADD_OPTION = "A";
	public static final String QUIT_OPTION = "Q";

	public StudentUI(BufferedReader reader, BufferedWriter writer) {
		this.reader = reader;
		this.writer = writer;}

	public void run() throws IOException {
		String line;
		do{
			write(MENU);
			line = reader.readLine();
			if (line.equals(ADD_OPTION)){
				// TODO: first figure out how to get this file and assoc testfile up to github;
			}
		}while (!line.equals(QUIT_OPTION));
	}

	private void write(String line) throws IOException {
		writer.write(line,0,line.length());
		writer.flush();
	}
}