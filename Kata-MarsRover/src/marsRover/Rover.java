package marsRover;

public class Rover {
	private Point postion = new Point(21,20);

	public Rover(Point postion) {
		this.postion = postion;
		// TODO Auto-generated constructor stub
	}

	public Rover(int i, int j) {
		Point point = new Point(i,j);
		this.postion = point;
	}

	public Point getPostion() {
		// TODO Auto-generated method stub
		return postion;
	}

}
