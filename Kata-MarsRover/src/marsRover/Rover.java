package marsRover;

public class Rover {
	private Point postion;
	private char direction;

	public Rover(int x, int y, char direction) {
		Point point = new Point(x,y);
		this.postion = point;
		this.direction = direction;
	}

	public Point getPostion() {
		return postion;
	}

	public char getDirection() {
		return direction;
	}

	public void move(char c) {
		this.direction = 'E';
		
	}

}
