package rover;

import java.io.IOException;

public class GameController {
	private Rover model;
	private View view;

	public GameController(Rover rover, View view) {
		this.model = rover;
		this.view = view;
	}

	public void updateView(String s) throws IOException {
		view.displayOnScreen(s);
	}

	public void moveRover(String instruction) {
		model.move(instruction);
	}

	public String getHeading() {
		return model.getHeading();
	}

	public Point getPosition() {
		return model.getPosition();
	}
}
