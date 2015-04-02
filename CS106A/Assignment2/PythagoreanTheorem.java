/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		int a, b;
		double c;
		println("Enter values to compute Pythagorean theorem.");
		print("a: ");
		a = readInt();
		print("b: ");
		b = readInt();
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		print("c = ");
		println(c);
	}
}
