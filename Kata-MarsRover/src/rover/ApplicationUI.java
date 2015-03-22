package rover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.OutputStreamWriter;


public class ApplicationUI {
	static final String QUIT_OPTION = "Q";
	static final String FORWARD_OPTION = "F";
	static final String INSTRUCTION_PROMPT = "Use (L)eft, (R)ight (F)orward and (B)ackwards to move rover. Use to (Q)uit.";
	static final String STATUS = "Heading: %s; Position x = %d, y = %d, z = %d";

	private Rover rover;
	private Grid grid;

	private BufferedReader reader;
	private BufferedWriter writer;	

	public ApplicationUI() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		rover = new Rover(0, 0, 0, "N");
		grid = new Grid(9, 9);
		rover.landOnPlanet(grid);
	}

	public static final void main(String[] args) throws IOException {
		new ApplicationUI().run();
	}	

	public void run() throws IOException {
		String line = "";
		writeln(STATUS);
		writeln(INSTRUCTION_PROMPT);
		line = reader.readLine();
		while (!line.equals(QUIT_OPTION)) {
			rover.move(line);
			writeln(STATUS);
			writeln(INSTRUCTION_PROMPT);
			line = reader.readLine();
		}
	}

	private void writeln(String line) throws IOException {
		write(line);
		writer.newLine();
		writer.flush();
	}

	private void write(String str) throws IOException {
		String s = String.format(str, rover.getHeading(), rover.getPosition().getX(), rover.getPosition().getY(), rover.getPosition().getZ());
		writer.write(s, 0, s.length());
		writer.flush();
	}
}
