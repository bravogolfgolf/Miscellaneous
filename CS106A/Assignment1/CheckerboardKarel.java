/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	private static final long serialVersionUID = -5950252669847130159L;

	public void run() {
		putBeeper();
		placeBeepersInRow();
		turnLeft();
		while(frontIsClear()){
			moveUpAndTurnLeft();
			placeBeepersInRow();
			turnRight();
			if(frontIsClear()){
				moveUpAndTurnRight();
				placeBeepersInRow();
				turnLeft();
			}
		}
	}

	private void moveUpAndTurnRight() {
		if(beepersPresent()) {
			move();
			turnRight();
			move();
			putBeeper();
		} else {
			move();
			turnRight();
			putBeeper();

		}
	}


	private void moveUpAndTurnLeft() {
		if(beepersPresent()) {
			move();
			turnLeft();
			if(frontIsClear()){					
				move();
				putBeeper();
			}
		} else {
			move();
			turnLeft();
			putBeeper();			
		}
	}

	private void placeBeepersInRow() {
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
		}
	}
}