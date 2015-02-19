package sort;
import java.util.ArrayList;
import java.util.List;

public class Sorter {

	private ArrayList<Integer> result = new ArrayList<Integer>();

	public List<Integer> sort(Integer...ints) {
		if (ints.length > 0){
			createInputArray(ints);
			sortArray();
		}
		return result;
	}

	private void sortArray() {
		if (result.size() > 1)
			for (int i = 0; i < result.size() - 1; i++) {
				if(result.get(i) > result.get(i+1)){
					Integer high = result.get(i+1);
					Integer low = result.get(i);						
					result.set(i, high);
					result.set(i+1, low);
				}
				i = 0;
			}
	}

	private void createInputArray(Integer... ints) {
		for (Integer j : ints){
			result.add(j);
		}
	}
}
