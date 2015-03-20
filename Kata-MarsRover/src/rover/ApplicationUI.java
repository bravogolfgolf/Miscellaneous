package rover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class ApplicationUI {
	static final String MENU = "(S)tart or (Q)uit?";
	static final String START_OPTION = "S";
	static final String QUIT_OPTION = "Q";
	static final String INSTRUCTION_PROMPT = "Use (L)eft, (R)ight (F)orward and (B)ackwards to move rover.";
	static final String STATUS = "Heading: %s; Position x = %d, y = %d, z = %d";

	private Rover rover = new Rover(0, 0, 0, "N");
	private Grid grid = new Grid(9, 9);

	private BufferedReader reader;
	private BufferedWriter writer;	

	public ApplicationUI(BufferedReader reader, BufferedWriter writer) {
		this.reader = reader;
		this.writer = writer;
		rover.landOnPlanet(grid);
	}

	public void run() throws IOException {
		String line;
		write(MENU);
		line = reader.readLine();

		if(line.equals(START_OPTION)) {
			write(STATUS);
			do {
				line = reader.readLine();
				rover.move("F");
				write(STATUS);
			}
			while (!line.equals("Q"));
		}
	}

	private void write(String str) throws IOException {
		String s = String.format(str, rover.getHeading(), rover.getPosition().getX(), rover.getPosition().getY(), rover.getPosition().getZ());
		writer.write(s, 0, s.length());
		writer.flush();
	}
}
