package sis.studentinfo;

import java.util.*;

public class Performance {
	private List<Double> scores;

	public void setNumberOfTest(int numberOfTest) {
		this.scores = new ArrayList<Double>(numberOfTest);
	}

	public void set(int index, double score) {
		this.scores.add(index, score);
	}

	public double get(int index) {
		return this.scores.get(index);
	}

	public double average() {
		double total = 0.0;
		if (scores == null) return 0.0;
		for (Double dbl : scores)
			total += dbl;
		return total / scores.size();
	}

}
