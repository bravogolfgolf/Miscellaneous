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

	public Object getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}

}
