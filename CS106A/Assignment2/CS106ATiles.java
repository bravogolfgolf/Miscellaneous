/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;

public class CS106ATiles extends GraphicsProgram {
	private static final int BOX_WIDTH = 200;
	private static final int BOX_HEIGHT = 40;
	private static final int TILE_SPACE = 50;

	private double tilesCenterWidth;
	private double tilesCenterHeight;
	private double boxOffset;
	private GPoint program;
	private GPoint subProgram;

	private String labels[] = {"Program","GraphicsProgram","ConsoleProgram","DialogProgram"};

	public void run() {
		calculateTilesCenterWidth();
		calculateTilesCenterHeight();

		for(String label:labels){
			GCompound allGObjects = new GCompound();
			GCompound compound = new GCompound();

			compound = createCompoundLabelRect(label);

			if(label.equals("Program")) {
				compound.setLocation(tilesCenterWidth - compound.getWidth() / 2, 0);
				program = new GPoint(tilesCenterWidth, BOX_HEIGHT);
			} else {
				compound.setLocation(boxOffset, BOX_HEIGHT + TILE_SPACE);
				subProgram = new GPoint(boxOffset + BOX_WIDTH / 2, BOX_HEIGHT + TILE_SPACE);
				boxOffset+=BOX_WIDTH + TILE_SPACE;
				allGObjects.add(new GLine(program.getX(), program.getY(), subProgram.getX(), subProgram.getY()));	
			}

			allGObjects.add(compound);
			allGObjects.setLocation((getWidth() / 2 - tilesCenterWidth)
					,getHeight() / 2 - tilesCenterHeight);	
			add(allGObjects);
		}
	}

	private void calculateTilesCenterHeight() {
		double tilesHeight = BOX_HEIGHT * 2 + TILE_SPACE;
		tilesCenterHeight = tilesHeight / 2;
	}

	private void calculateTilesCenterWidth() {
		double tilesWidth = BOX_WIDTH * 3 + TILE_SPACE * 2;
		tilesCenterWidth = tilesWidth / 2;
	}

	private GCompound createCompoundLabelRect(String label) {
		GCompound compound = new GCompound();
		GLabel labelDialog = new GLabel(label);
		GRect rectDialog = new GRect(BOX_WIDTH, BOX_HEIGHT);
		labelDialog.setLocation(rectDialog.getX() + rectDialog.getWidth() / 2 - labelDialog.getWidth() / 2,
				rectDialog.getY() + (rectDialog.getHeight() / 2 + labelDialog.getAscent() / 2));
		compound.add(labelDialog);
		compound.add(rectDialog);
		return compound;
	}
}
