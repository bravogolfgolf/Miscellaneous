package rover;

import java.io.IOException;

public class GameController {
	private Rover model;
	private GameView view;

	public GameController(Rover rover, GameView gameView) {
		this.model = rover;
		this.view = gameView;
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
