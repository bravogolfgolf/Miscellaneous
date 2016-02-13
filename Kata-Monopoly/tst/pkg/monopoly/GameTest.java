package pkg.monopoly;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    public static final String TRY_TO_ADD_ONE_PLAYER = "1";
    public static final String TRY_TO_ADD_NINE_PLAYERS = "9";
    public static final String TRY_TO_ADD_TWO_PLAYERS = "2";
    public static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    public static final int FIRST_PLAYER = 1;
    public static final int SECOND_PLAYER = 2;

    @Test
    public void testCreatePlayersUI() throws IOException {
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

        Game game = new Game(reader, writer);
        game.run();

        assertEquals(expectedOutput.toString(), outputStream.toString());
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());

    }

    private void setup(StringBuffer expectedOutput, StringBuffer input) {
        expectedOutput.append(Game.HOW_MANY_PLAYERS);
        input.append(line(TRY_TO_ADD_ONE_PLAYER));
        expectedOutput.append(Game.INVALID_NUMBER_OF_PLAYERS);
        expectedOutput.append(Game.HOW_MANY_PLAYERS);
        input.append(line(TRY_TO_ADD_NINE_PLAYERS));
        expectedOutput.append(Game.INVALID_NUMBER_OF_PLAYERS);
        expectedOutput.append(Game.HOW_MANY_PLAYERS);
        input.append(line(TRY_TO_ADD_TWO_PLAYERS));
        expectedOutput.append(String.format(Game.SELECT_TOKEN, FIRST_PLAYER));
        expectedOutput.append("(B)oot, (R)ace car, (C)at, (D)og, Top (h)at, Battle(s)hip, (T)himble, (W)heelbarrow");
        input.append(line("B"));
        expectedOutput.append(String.format(Game.SELECT_TOKEN, SECOND_PLAYER));
        expectedOutput.append("(R)ace car, (C)at, (D)og, Top (h)at, Battle(s)hip, (T)himble, (W)heelbarrow");
        input.append(line("x"));
        expectedOutput.append(Game.INVALID_TOKEN_LETTER);
        expectedOutput.append(String.format(Game.SELECT_TOKEN, SECOND_PLAYER));
        expectedOutput.append("(R)ace car, (C)at, (D)og, Top (h)at, Battle(s)hip, (T)himble, (W)heelbarrow");
        input.append(line("s"));

    }

    private String line(String input) {
        return String.format("%s%n", input);
    }

}
