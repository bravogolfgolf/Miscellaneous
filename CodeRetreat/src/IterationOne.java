import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IterationOne {

	public static final void main(String[] args) throws IOException {
		String input;
		String output;
		int count;
		String[] tokens;

		FileInputStream inputFile = new FileInputStream(new File("inputfile.txt"));
		FileOutputStream outputFile = new FileOutputStream(new File("outputfile.txt"));

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputFile));

		input = reader.readLine();

		tokens = input.split("[ ]");

		if (tokens[0].equals("reverse")){
			input = reader.readLine();
			output = removeLetters(input);
			output = reverseLetters(output);
			writer.write(output);
			writer.flush();
		}

		else if(tokens[0].equals("count")){
			String sequence = tokens[1];
			input = reader.readLine();
			output = removeLetters(input);
			count = countLetters(output, sequence);
			writer.write(count);
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

	private static int countLetters(String input, String sequence) {
		// not finished
		int count = 0;
		return count;
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

