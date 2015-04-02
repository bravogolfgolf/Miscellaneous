/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int input;
		int counter = 0;
		print("Enter a number: ");
		input = readInt();
		if (input != 1) {
			while (input != 1) {
				if(input % 2 == 0)
					println(String.format("%d is even, so I take half: %d", input, input/=2));
				else {
					println(String.format("%d is odd, so I make it 3n+1: %d", input, 3 * input + 1));
					input = 3 * input + 1;					
				}
				counter++;							
			}
		}
		println(String.format("The process took %d step(s) to reach 1.", counter));
	}
}