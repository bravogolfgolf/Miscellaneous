package marsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {

	@Test
	public void testInitialPostion() {
		Point postion = new Point(21,20);
		Rover rover = new Rover(postion);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
	
	@Test
	public void test5DifferentInitialPostion() {
		Point postion = new Point(45,20);
		Rover rover = new Rover(postion);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
}
