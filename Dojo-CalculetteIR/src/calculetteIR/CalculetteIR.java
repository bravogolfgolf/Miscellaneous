package calculetteIR;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculetteIR {

	private static final Double LEVEL_1_RATE = 0.0;
	private static final Double LEVEL_1_MINIMUM_AMOUNT = 0.0;
	private static final Double LEVEL_2_RATE = .14;
	private static final Double LEVEL_2_MINIMUM_AMOUNT = 9690.0;
	private static final Double LEVEL_3_RATE = .30;
	private static final Double LEVEL_3_MINIMUM_AMOUNT = 26764.0;
	private static final Double LEVEL_4_RATE = .41;
	private static final Double LEVEL_4_MINIMUM_AMOUNT = 71754.0;
	private static final Double LEVEL_5_RATE = .45;
	private static final Double LEVEL_5_MINIMUM_AMOUNT = 151956.0;

	Map<Double, Double> taxTable = new LinkedHashMap<Double, Double>();

	public double calculate(int income) {
		double tax = 0.0;
		
		createTaxTable();
		
		for(Map.Entry<Double, Double> entry : taxTable.entrySet()) {
			Double levelRate = 0.0;
			Double levelMinimumAmount = 0.0;

			levelRate = entry.getKey();
			levelMinimumAmount = entry.getValue();

			if (income > levelMinimumAmount){
				tax +=  (income - levelMinimumAmount) * levelRate;
				income -= income - levelMinimumAmount;
			}
		}
		return tax;
	}

	private void createTaxTable() {
		taxTable.put(LEVEL_5_RATE, LEVEL_5_MINIMUM_AMOUNT);
		taxTable.put(LEVEL_4_RATE, LEVEL_4_MINIMUM_AMOUNT);
		taxTable.put(LEVEL_3_RATE, LEVEL_3_MINIMUM_AMOUNT);
		taxTable.put(LEVEL_2_RATE, LEVEL_2_MINIMUM_AMOUNT);
		taxTable.put(LEVEL_1_RATE, LEVEL_1_MINIMUM_AMOUNT);
	}
}
