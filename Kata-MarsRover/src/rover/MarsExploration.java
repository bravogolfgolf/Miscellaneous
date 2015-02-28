package rover;
import java.io.*;

public class MarsExploration {
	private static PrintStream output = System.out;
	
	public static void main(String[] args) {
		Grid mars = new Grid(100,100);
		mars.addObstacleAt(1, 2);

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		String direction = args[2];
		Rover rover = new Rover(x, y, direction);
		rover.placeOnGrid(mars);

		output.format("Grid Size: H:%d by W:%d%n", mars.getHeight(), mars.getWidth());
		output.format("Instruction: %s%n", args[3]);

		String[] instruction = args[3].split("");

		for (int i = 1 ; i < instruction.length; i++){
			output.format("Rover: Point:%d,%d Direction:%s%n", rover.getPosition().getX(), rover.getPosition().getY(), rover.getDirection());
			output.format("Move: %s%n", instruction[i]);
			i = tryToMove(rover, instruction, i);
		}
		output.format("Final: Point:%d,%d Direction:%s%n%n", rover.getPosition().getX(), rover.getPosition().getY(), rover.getDirection());
	}

	private static int tryToMove(Rover rover, String[] instruction, int i) {
		try {rover.move(instruction[i]);
		return i;}
		catch (UnsupportedOperationException e) {
			e.getMessage();
			output.format("Movement Stopped...%s%n", e.getMessage());
			return i = instruction.length;
		}
	}
}
