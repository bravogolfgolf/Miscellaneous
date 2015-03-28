package rover;

import java.io.IOException;

public class GameController {
	private Model model;
	private View view;

	public GameController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void updateView(String s) throws IOException {
		view.displayOnScreen(s);
	}

	public void move(String instruction) {
		model.move(instruction);
	}

	public String getHeading() {
		return model.getHeading();
	}

	public Point getPosition() {
		return model.getPosition();
	}
}
