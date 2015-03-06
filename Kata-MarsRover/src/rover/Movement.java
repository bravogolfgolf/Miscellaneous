package rover;

public class Movement {

	public static Compass turnRight(Compass direction){
		switch (direction){
		case N: return Compass.E;
		case S: return Compass.W;
		case E: return Compass.S;
		case W: return Compass.N;
		default: return direction;
		}
	}

	public static Compass turnLeft(Compass direction) {
		switch (direction){
		case N: return Compass.W;
		case S: return Compass.E;
		case E: return Compass.N;
		case W: return Compass.S;
		default: return direction;
		}
	}
}
