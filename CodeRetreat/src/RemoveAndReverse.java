import java.util.List;


public class RemoveAndReverse {
	
	public String DoIt(List<String> inputList){
		String input, output;
		
		if (inputList.get(0).equals("reverse")){
			input = inputList.get(1);
			output = removeLetters(input);
			output = reverseLetters(output);
		}

		else {
			output = removeLetters(inputList.get(0));
		}
		
		return output;
	}

	private static String removeLetters(String input) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < input.length(); i++){
			if(input.charAt(i) == 'A') {
				sb.append(input.charAt(i));
			}

			if(input.charAt(i) == 'T') {
				sb.append(input.charAt(i));
			}

			if(input.charAt(i) == 'C') {
				sb.append(input.charAt(i));
			}

			if(input.charAt(i) == 'G') {
				sb.append(input.charAt(i));
			}
		}

		return sb.toString();
	}

	private static String reverseLetters(String input) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < input.length(); i++){
			sb.append(input.charAt(input.length() - (i+1)));
		}

		return sb.toString();
	}
}
