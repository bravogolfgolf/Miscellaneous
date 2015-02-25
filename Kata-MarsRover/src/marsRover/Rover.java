package marsRover;

public class Rover {
	private Point postion;

	public Rover(int x, int y, char drection) {
		Point point = new Point(x,y);
		this.postion = point;
	}

	public Point getPostion() {
		return postion;
	}

}
