package calculetteIR;

public class CalculetteIR {

	private static final double LEVEL_2_RATE = .14;
	private static final int LEVEL_2_MINIMUM_AMOUNT = 9690;

	public double calculate(int income) {
		if (income > LEVEL_2_MINIMUM_AMOUNT){
			return (income - LEVEL_2_MINIMUM_AMOUNT) * LEVEL_2_RATE;
		}
		return 0;
	}

}
