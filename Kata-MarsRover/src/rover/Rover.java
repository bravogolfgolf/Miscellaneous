package rover;

public class Rover {
	private Point position;
	private Direction direction;
	private Grid planet;

	public Rover(int x, int y, String direction) {
		setPosition(x, y);
		setDirection(direction);
	}

	private void setPosition(int x, int y) {
		setPosition(new Point(x , y));
	}

	private void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	private void setDirection(String direction) {
		if(direction == "N") setDirection(new North());
		if(direction == "S") setDirection(new South());
		if(direction == "E") setDirection(new East());
		if(direction == "W") setDirection(new West());
	}

	private void setDirection(Direction direction){
		this.direction = direction;
	}

	private Direction getDirection() {
		return direction;
	}

	public String getHeading() {
		return getDirection().getCompassPoint();
	}

	public void landOnPlanet(Grid planet) {	
		this.planet = planet;
	}

	public Grid getPlanetGrid() {
		return planet;
	}

	public void move(String instruction) {
		Point preservedPosition = getPosition();

		if (instruction == "R") turnRight();
		if (instruction == "L") turnLeft();
		if (instruction == "F") goForward();
		if (instruction == "B") goBackward();

		checkForObstacle(preservedPosition);
	}

	private void turnRight(){
		setDirection(getDirection().turnRight());
	}

	private void turnLeft() {
		setDirection(getDirection().turnLeft());
	}

	private void goForward() {
		setPosition(getDirection().goForward(getPosition(), getPlanetGrid()));
	}

	private void goBackward() {
		setPosition(getDirection().goBackward(getPosition(), getPlanetGrid()));
	}

	private void checkForObstacle(Point preservedPosition) {
		try {if(getPlanetGrid().hasObstacleAt(getPosition()))
			throw new UnsupportedOperationException();
		}
		catch (UnsupportedOperationException e) {
			doNotMove(preservedPosition);
			throw new UnsupportedOperationException("Obstacle Encoutered");
		}
	}

	private void doNotMove(Point preservedPosition) {
		setPosition(preservedPosition);
	}
}