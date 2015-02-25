package marsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {

	@Test
	public void testInitialPostion() {
		Point postion = new Point(21,20);
		Rover rover = new Rover(21,20, 'N');
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
	
	@Test
	public void testDifferentInitialPostion() {
		Point postion = new Point(45,20);
		Rover rover = new Rover(45,20, 'W');
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
	
	@Test
	public void testInitialDirection() {
		Rover rover = new Rover(45,20, 'N');
		assertEquals('N',rover.getDirection());
	}
}
