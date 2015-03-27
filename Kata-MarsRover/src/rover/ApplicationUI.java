package rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rover.Grid.ObstacleEncoutered;


public class ApplicationUI {
	static final String QUIT_OPTION = "Q";
	static final String INSTRUCTION_PROMPT = "Use (L)eft, (R)ight (F)orward and (B)ackwards to move rover. Use to (Q)uit.";
	static final String STATUS = "Heading: %s; Position x = %d, y = %d, z = %d";
	static final String OBSTACLE_MESSAGE = "Obstacle Encoutered";

	private Rover model;
	private Grid grid;

	private View view;
	private GameController gc;
	private BufferedReader reader;

	public ApplicationUI() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		createModel();
		view = new GameView();
		gc = new GameController(model, view);

	}

	private void createModel() {
		model = new Rover(0, 0, 0, "N");
		grid = new Grid(9, 9);
		grid.addObstacleAt(0, 2, 0);
		model.landOnPlanet(grid);
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
			tryToMove(line);
			writeln(STATUS);
			writeln(INSTRUCTION_PROMPT);
			line = reader.readLine();
		}
	}

	private void tryToMove(String line) throws IOException {
		try {
			gc.moveRover(line);			
		} catch (ObstacleEncoutered e) {
			writeln(e.getMessage());
		}
	}

	private void writeln(String line) throws IOException {
		String s = String.format(line, gc.getHeading(), gc.getPosition().x, gc.getPosition().y, gc.getPosition().z);
		gc.updateView(s);
	}
}