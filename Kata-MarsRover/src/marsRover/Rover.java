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

	public void move(String c) {
			this.direction = "E";
	}

}
