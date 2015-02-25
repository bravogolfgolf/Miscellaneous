package marsRover;

public class Rover {
	private Point postion;
	private String direction;

	public Rover(int x, int y, String direction) {
		Point point = new Point(x,y);
		this.postion = point;
		this.direction = direction;
	}

	public Point getPostion() {
		return postion;
	}

	public String getDirection() {
		return direction;
	}

	public void move(String instruction) {
		switch (Instruction.valueOf(instruction)) {
		case R:
			turnRightFrom(direction);
			break;
		case L:
			turnLeftFrom(direction);
			break;
		case F:
			forwardInThis(direction);
			break;
		}
	}

	private void forwardInThis(String direction2) {
		switch (Compass.valueOf(direction)){
		case N: postion.setY((postion.getY() + 1)); break;
		case E: postion.setX((postion.getX() - 1)); break;
		case S: postion.setY((postion.getY() - 1)); break;
		case W: postion.setX((postion.getX() + 1));
		}
	}

	private void turnRightFrom(String direction2){
		switch (Compass.valueOf(direction)){
		case N: direction = "E"; break;
		case E: direction = "S"; break;
		case S: direction = "W"; break;
		case W: direction = "N"; break;
		}
	}

	private void turnLeftFrom(String direction2) {
		switch (Compass.valueOf(direction)){
		case N: direction = "W"; break;
		case W: direction = "S"; break;		
		case S: direction = "E"; break;
		case E: direction = "N"; break;
		}
	}
}