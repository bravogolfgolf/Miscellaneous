package rover;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class RoverTest {
	private Rover rover;
	private Grid mars;
	private String direction = "N";
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private int height = 9;
	private int width = 9;

	private void createRoverOnGrid(int x, int y, String direction) {
		rover = new Rover(x, y, z, direction);
		mars = new Grid(height, width);
		rover.landOnPlanet(mars);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testPlaceRoverOnGrid() {
		createRoverOnGrid(x, y, direction);
		assertEquals(9,rover.getPlanetGrid().getHeight());
		assertEquals(9,rover.getPlanetGrid().getWidth());
	}

	@Test
	public void testGridDifferentDimensions() {
		height = 11;
		width = 12;
		mars = new Grid(height, width);
		createRoverOnGrid(x, y, direction);
		assertEquals(11,rover.getPlanetGrid().getHeight());
		assertEquals(12,rover.getPlanetGrid().getWidth());
	}

	@Test
	public void testInitialPostion() {
		createRoverOnGrid(x, y, direction);
		assertEquals(0, rover.getPosition().getX());
		assertEquals(0, rover.getPosition().getY());
	}

	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals(x, rover.getPosition().getX());
		assertEquals(y, rover.getPosition().getY());
	}

	@Test
	public void testInitialDirection() {
		createRoverOnGrid(x, y, direction);
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testDifferentDirection() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals("W",rover.getHeading());
	}


	@Test
	public void testFacingNorthThenTurnRight() {
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("E",rover.getHeading());
	}

	private void turnRight() {
		rover.move("R");
	}

	@Test
	public void testFacingEastThenTurnRight() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("S",rover.getHeading());
	}

	@Test
	public void testFacingSouthThenTurnRight() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("W",rover.getHeading());
	}

	@Test
	public void testFacingWestThenTurnRight() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testFacingNorthThenTurnLeft() {
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("W",rover.getHeading());
	}

	private void turnLeft() {
		rover.move("L");
	}

	@Test
	public void testFacingWestThenTurnLeft() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("S",rover.getHeading());
	}

	@Test
	public void testFacingSouthThenTurnLeft() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("E",rover.getHeading());
	}

	@Test
	public void testFacingEastThenTurnLeft() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testMoveForwardNorth() throws IOException {
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(1,rover.getPosition().getY());
	}

	private void goForward() throws IOException {
		StringBuffer input = new StringBuffer();
		input.append(line(ApplicationUI.FORWARD_OPTION));
		byte[] buffer = input.toString().getBytes();
		InputStream inputStream = new ByteArrayInputStream(buffer);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);	
		String line = reader.readLine();
		rover.move("F");
	}

	private String line(String str) {
		return String.format("%s%n", str);
	}

	@Test
	public void testMoveForwardWest() throws IOException {
		x = 1;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardSouth() throws IOException {
		y = 1;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardEast() throws IOException {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(1,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackNorth() {
		y = 1;
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackEast() {
		x = 1;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	private void goBackward() {
		rover.move("B");
	}

	@Test
	public void testMoveBackSouth() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(1,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackWest() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(1,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardNorthWrap() throws IOException {
		y = 9;
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardEastWrap() throws IOException {
		x = 9;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardSouthWrap() throws IOException {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(9,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardWestWrap() throws IOException {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(9,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackNorthWrap() {
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(9,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackEastWrap() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(9,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackSouthWrap() {
		y = 9;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackWestWrap() {
		x = 9;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test (expected = Grid.ObstacleEncoutered.class)
	public void testFoundObstacleForward() throws IOException {
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1, 0);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test (expected = Grid.ObstacleEncoutered.class)
	public void testFoundObstacleBack() {
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 9, 0);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void throwsExceptionEncouterObstacleBackward() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 9, 0);
		goBackward();
	}

	@Test
	public void throwsExceptionEncouterObstacleForward() throws IOException {
		thrown.expect(Grid.ObstacleEncoutered.class);
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1, 0);
		goForward();
	}

	@Test
	public void throwsExceptionEncouterObstacleBackwardSouth() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		direction = "S";
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1, 0);
		goBackward();
	}

	@Test
	public void throwsExceptionEncouterObstacleForwardSouth() throws IOException {
		thrown.expect(Grid.ObstacleEncoutered.class);
		direction = "S";
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 9, 0);
		goForward();
	}

	@Test
	public void throwsExceptionForIncorrectDirection() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Incorrect direction value");
		direction = "X";
		createRoverOnGrid(x, y, direction);
	}
}