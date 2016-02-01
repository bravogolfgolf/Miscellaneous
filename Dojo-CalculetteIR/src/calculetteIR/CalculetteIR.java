package calculetteIR;

public class CalculetteIR {

	private static final double LEVEL_1_RATE = 0.0;
	private static final int LEVEL_1_MINIMUM_AMOUNT = 0;

	private static final double LEVEL_2_RATE = .14;
	private static final int LEVEL_2_MINIMUM_AMOUNT = 9690;

	private static final double LEVEL_3_RATE = .30;
	private static final int LEVEL_3_MINIMUM_AMOUNT = 26764;


	public double calculate(int income) {
		double tax = 0.0;
		
		if (income > LEVEL_3_MINIMUM_AMOUNT){
			tax +=  (income - LEVEL_3_MINIMUM_AMOUNT) * LEVEL_3_RATE;
			income -= income - LEVEL_3_MINIMUM_AMOUNT;
		}
		
		if (income > LEVEL_2_MINIMUM_AMOUNT){
			tax +=  (income - LEVEL_2_MINIMUM_AMOUNT) * LEVEL_2_RATE;
			income -= income - LEVEL_2_MINIMUM_AMOUNT;
		}
		
		if (income > LEVEL_1_MINIMUM_AMOUNT){
			tax +=  (income - LEVEL_1_MINIMUM_AMOUNT) * LEVEL_1_RATE;
			income -= income - LEVEL_1_MINIMUM_AMOUNT;
		}
		
		return tax;
	}

}
