package rover;

import java.io.IOException;

public class GameController {
	private Rover model;
	private GameView view;

	public GameController(Rover rover, GameView gameView) {
		this.model = rover;
		this.view = gameView;
	}

	public void updateView() throws IOException {
		view.displayOnScreen("Test ViewController Message");
	}
}
