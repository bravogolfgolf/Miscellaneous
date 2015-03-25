package rover;

public class Point {
	public int x;
	private int y;
	private int z;


	public Point(int x, int y, int z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);

	}

	public void setY(int y) {
		this.y =  y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;	
	}

	public int getZ() {
		return z;
	}

	private void setZ(int z) {
		this.z = z;	
	}

}

