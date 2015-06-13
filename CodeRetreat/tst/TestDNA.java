import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class TestDNA {

	@Test
	public void testReverse() throws IOException {
		DNA dna = new DNA();
		dna.process("inputfile.txt", "outputfile.txt");
		String outputContent = readFileToString("outputfile.txt");
		String expectedContent = readFileToString("expectedfile.txt");	
		assertTrue(outputContent.equals(expectedContent));
	}


	private String readFileToString(String inputFilePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(inputFilePath));

		try {

			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}

		} catch (Exception e) {

		} finally {
			br.close();
		}
		return sb.toString();
	}

}


