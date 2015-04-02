/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import java.util.*;

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL = 17;
	public void run() {
		int input;
		int smallest = 0;
		int largeest = 0;
		List<Integer> numbers = new ArrayList<Integer>();

		println("This program finds the largest and smallest numbers.");

		do{
			print("? ");
			input = readInt();
			if (input != SENTINEL) {
				smallest = input;
				largeest = input;
				numbers.add(input);
			}
		}
		while(input != SENTINEL);

		if (numbers.size() > 0) {
			for(int number : numbers){
				if (number < smallest)
					smallest = number;
				else if (number > largeest)
					largeest = number;
			}
			print("Smallest: ");
			println(smallest);
			print("Largest: ");
			println(largeest);
		}
		else {
			println("Sentinel was only input.");
		}
	}

}


