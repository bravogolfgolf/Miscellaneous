package calculetteIR;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculetteIR {

	private static final Double LEVEL_1_RATE = 0.0;
	private static final Integer LEVEL_1_MINIMUM_AMOUNT = 0;
	private static final Double LEVEL_2_RATE = .14;
	private static final Integer LEVEL_2_MINIMUM_AMOUNT = 9690;
	private static final Double LEVEL_3_RATE = .30;
	private static final Integer LEVEL_3_MINIMUM_AMOUNT = 26764;
	private static final Double LEVEL_4_RATE = .41;
	private static final Integer LEVEL_4_MINIMUM_AMOUNT = 71754;
	private static final Double LEVEL_5_RATE = .45;
	private static final Integer LEVEL_5_MINIMUM_AMOUNT = 151956;

	Map<Integer, Double> taxTable = new LinkedHashMap<Integer, Double>();

	public double calculate(int income) {
		double tax = 0.0;
		
		createTaxTableSortedLargestToSmallest();
		
		for(Map.Entry<Integer, Double> entry : taxTable.entrySet()) {
			Integer levelMinimumAmount = 0;
			Double levelRate = 0.0;

			levelMinimumAmount = entry.getKey();
			levelRate = entry.getValue();

			if (income > levelMinimumAmount){
				tax +=  (income - levelMinimumAmount) * levelRate;
				income -= income - levelMinimumAmount;
			}
		}
		return tax;
	}

	private void createTaxTableSortedLargestToSmallest() {
		taxTable.put(LEVEL_5_MINIMUM_AMOUNT, LEVEL_5_RATE);
		taxTable.put(LEVEL_4_MINIMUM_AMOUNT, LEVEL_4_RATE);
		taxTable.put(LEVEL_3_MINIMUM_AMOUNT, LEVEL_3_RATE);
		taxTable.put(LEVEL_2_MINIMUM_AMOUNT, LEVEL_2_RATE);
		taxTable.put(LEVEL_1_MINIMUM_AMOUNT, LEVEL_1_RATE);
	}
}
