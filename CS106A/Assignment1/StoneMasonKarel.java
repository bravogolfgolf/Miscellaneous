/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	private static final long serialVersionUID = 2939555847386063860L;

	public void run() {
		repairColumn();
		while(frontIsClear()){
			move();
			if(isColumn())
				repairColumn();
		}

	}

	private boolean isColumn() {
		return (getLocation().x - 1) % 4 == 0;
	}

	private void repairColumn() {
		repairBottomBlock();
		repairUpperBlocks();
		returnToBottomOfColumn();
	}

	private void repairBottomBlock() {
		turnLeft();
		if(noBeepersPresent())
			putBeeper();
	}

	private void repairUpperBlocks() {
		while(frontIsClear()) {
			move();
			if(noBeepersPresent())
				putBeeper();
		}
	}

	private void returnToBottomOfColumn() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
}