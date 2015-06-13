import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DNA {

	public void process(String inputFilePath, String outputFilePath) throws IOException {
		String input;
		String output;

		FileInputStream inputFile = new FileInputStream(new File(inputFilePath));
		FileOutputStream outputFile = new FileOutputStream(new File(outputFilePath));

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputFile));
		
		input = reader.readLine();

		if (input.equals("reverse")){
			input = reader.readLine();
			output = removeLetters(input);
			output = reverseLetters(output);
			writer.write(output);
			writer.flush();
		}

		else {
			output = removeLetters(input);
			writer.write(output);
			writer.flush();
		}
		writer.close();
		reader.close();	
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
