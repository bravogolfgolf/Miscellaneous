/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	private static final long serialVersionUID = 3602491207624968395L;

	public void run() {
		if(isOneAvenueWorld())
			putBeeper();
		else {
			putBeeperOnEveryCornerOfFirstStreet();
			returnToFirstAvenue();
			searchForCenterOfFirstStreet();
		}
	}

	private boolean isOneAvenueWorld() {
		return frontIsBlocked();
	}

	private void putBeeperOnEveryCornerOfFirstStreet() {
		putBeeper();
		while(frontIsClear()){
			move();
			putBeeper();
		}
	}

	private void returnToFirstAvenue() {
		turnAround();
		while(frontIsClear())
			move();
		turnAround();
	}

	private void searchForCenterOfFirstStreet() {
		clearCurrentAvenueThatIsNotCenter();
		moveToAvenueFurthestFromCurrent();
		checkIfCurrentAvenueIsCenter();
	}

	private void clearCurrentAvenueThatIsNotCenter() {
		while(beepersPresent())
			pickBeeper();
	}

	private void moveToAvenueFurthestFromCurrent() {
		while(frontIsClear())
			move();
		turnAround();
		while(!beepersPresent())
			move();
	}

	private void checkIfCurrentAvenueIsCenter() {
		if(isCenterAvenue()) {
			move();
			if(confirmedIsCenterAvenueThenMoveBackAndStop()) {
				moveBack();
			} else {
				moveBack();				
				searchForCenterOfFirstStreet();
			}
		}
	}

	private boolean isCenterAvenue() {
		return beepersPresent();
	}

	private boolean confirmedIsCenterAvenueThenMoveBackAndStop() {
		return !beepersPresent();
	}

	private void moveBack() {
		turnAround();
		move();
		turnAround();
	}
}
