package rover;

public class Rover implements Model {
	private Point position;
	private Direction direction;
	private Grid planet;

	public Rover(int x, int y, int z, String direction) {
		setPosition(x, y, z);
		setDirection(Direction.create(direction));
	}

	private void setPosition(int x, int y, int z) {
		setPosition(new Point(x , y, z));
	}

	private void setPosition(Point position) {
		this.position = position;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	private void setDirection(Direction direction){
		this.direction = direction;
	}

	private Direction getDirection() {
		return direction;
	}

	@Override
	public String getHeading() {
		return getDirection().getCompassPoint();
	}

	@Override
	public void landOnPlanet(Grid planet) {	
		this.planet = planet;
	}

	private Grid getPlanetGrid() {
		return planet;
	}

	@Override
	public void move(String instruction) {
		if (instruction.equals("R")) turnRight();
		if (instruction.equals("L")) turnLeft();
		if (instruction.equals("F")) goForward();
		if (instruction.equals("B")) goBackward();
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
}