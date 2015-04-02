/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;

	int rowWidthOffset;
	int rowHeightOffset;
	
	public void run() {
		setReferenceWidthAndHeghtToCenterPyramid();
		createRowOf(BRICKS_IN_BASE, rowWidthOffset, rowHeightOffset);
	}

	private void setReferenceWidthAndHeghtToCenterPyramid() {
		setRowWidthOffset();
		setRowHeightOffset();	
	}

	private void setRowWidthOffset() {
		int CENTER_OF_CANVAS = getWidth() / 2;
		int HALF_THE_LENGTH_OF_PYRAMID_BASE = (BRICKS_IN_BASE * BRICK_WIDTH) / 2;
		rowWidthOffset =  CENTER_OF_CANVAS - HALF_THE_LENGTH_OF_PYRAMID_BASE;
	}
	
	private void setRowHeightOffset() {
		rowHeightOffset =  getHeight() - BRICK_HEIGHT;
	}

	private void createRowOf(int brickCount, int rowWidthOffset, int rowHeightOffset) {
		int pyramidOffset = rowWidthOffset + BRICK_WIDTH / 2;
		if(brickCount > 0) {
			for(int index = 0; index < brickCount; index++, rowWidthOffset+=BRICK_WIDTH)
				add(new GRect(BRICK_WIDTH, BRICK_HEIGHT), rowWidthOffset, rowHeightOffset);
			createRowOf(--brickCount, pyramidOffset, rowHeightOffset - BRICK_HEIGHT);
		}
	}
}

