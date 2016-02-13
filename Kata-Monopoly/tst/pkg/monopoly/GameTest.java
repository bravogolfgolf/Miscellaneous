package pkg.monopoly;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testRequestAProperNumberOfPlayersForGame() throws IOException {
        StringBuffer expectedOutput = new StringBuffer();
        StringBuffer input = new StringBuffer();
        setup(expectedOutput, input);

        byte[] buffer = input.toString().getBytes();
        InputStream inputStream = new ByteArrayInputStream(buffer);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        Game game = new Game(reader,writer);
        game.run();

        assertEquals(expectedOutput.toString(),outputStream.toString());

    }

    private void setup(StringBuffer expectedOutput, StringBuffer input) {
        expectedOutput.append(Game.HOW_MANY_PLAYERS);
    }

}
