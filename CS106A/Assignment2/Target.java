/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Target extends GraphicsProgram {	
	private final double LARGE = 72;
	private final double MEDIUM = LARGE * .65;
	private final double SMALL = LARGE * .3;
	
	public void run() {
		/*
		 * This figure is simply three GOval objects,
		 * two red and one white, drawn in the correct order.
		 * The outer circle should have a radius of one inch (72 pixels),
		 * the white circle has a radius of 0.65 inches,
		 * and the inner red circle has a radius of 0.3 inches.
		 * The figure should be centered in the window of a GraphicsProgram subclass.
		 * */

		double circleDiameters[] = {LARGE, MEDIUM, SMALL};
		boolean flag = true;

		for(double diameter : circleDiameters) {
			GOval oval = new GOval(diameter, diameter);
			double centerHeight = (getHeight() / 2) - (oval.getHeight() / 2);		
			double centerWidth = (getWidth() / 2) - oval.getWidth() / 2;
			oval.setLocation(centerWidth, centerHeight);

			if(flag){
				oval.setColor(Color.RED);
				oval.setFilled(true);
				oval.setFillColor(Color.RED);
			}else{
				oval.setColor(Color.WHITE);
				oval.setFilled(true);
				oval.setFillColor(Color.WHITE);
			}
			flag = !flag;
			add(oval);			
		}
	}
}