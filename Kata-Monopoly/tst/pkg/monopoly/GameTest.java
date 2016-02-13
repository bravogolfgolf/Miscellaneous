package pkg.monopoly;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    public static final int EXPECTED_NUMBER_OF_PLAYERS = 2;


    @Test
    public void testCreatePlayersUI() throws IOException {
        StringBuffer expectedOutput = new StringBuffer();
        StringBuffer input = new StringBuffer();
        setupUserTestScript(expectedOutput, input);

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

    private void setupUserTestScript(StringBuffer expectedOutput, StringBuffer input) {

        final String TRY_TO_ADD_ONE_PLAYER = "1";
        final String TRY_TO_ADD_NINE_PLAYERS = "9";
        final String TRY_TO_ADD_TWO_PLAYERS = "2";
        final int FIRST_PLAYER = 1;
        final int SECOND_PLAYER = 2;

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
        input.append(line("h"));

    }

    private String line(String input) {
        return String.format("%s%n", input);
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {
        int playersMatch = 0;

        for (int counter = 0; counter < 100; counter++) {
            StringBuffer expectedOutput = new StringBuffer();
            StringBuffer input = new StringBuffer();
            setupUserAreNotInSameOrderScript(expectedOutput, input);

            byte[] buffer = input.toString().getBytes();
            InputStream inputStream = new ByteArrayInputStream(buffer);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);

            Game game = new Game(reader, writer);
            game.run();

            if (playersMatch(game)) {
                playersMatch++;
            }

        }
        assertTrue(playersMatch >= 1 && playersMatch <= 99);
        System.out.println(String.format("Number of matches: %d", playersMatch));

    }

    private void setupUserAreNotInSameOrderScript(StringBuffer expectedOutput, StringBuffer input) {
        final String ADD_TWO_PLAYERS = "2";

        input.append(line(ADD_TWO_PLAYERS));
        input.append(line("B"));
        input.append(line("h"));
    }

    private boolean playersMatch(Game game) {
        Player player1 = new Player("Boot");
        Player player2 = new Player("Top hat");
        final int FIRST_PLAYER = 0;
        final int SECOND_PLAYER = 1;
        return (player1.equals(game.getPlayer(FIRST_PLAYER)) && player2.equals(game.getPlayer(SECOND_PLAYER)));
    }

}
