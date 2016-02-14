package pkg.monopoly;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    public static final int EXPECTED_NUMBER_OF_PLAYERS = 2;
    private final StringBuffer expectedOutput = new StringBuffer();
    private final StringBuffer input = new StringBuffer();
    private final OutputStream outputStream = new ByteArrayOutputStream();

    private BufferedReader getBufferedReader() {
        byte[] buffer = input.toString().getBytes();
        InputStream inputStream = new ByteArrayInputStream(buffer);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }

    private BufferedWriter getBufferedWriter() {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        return new BufferedWriter(outputStreamWriter);
    }

    private Game getGame(BufferedReader reader, BufferedWriter writer) throws IOException {
        Game game = new Game(reader, writer);
        game.run();
        return game;
    }

    private String line(String input) {
        return String.format("%s%n", input);
    }

    @Test
    public void testCreatePlayersUI() throws IOException {
        setupUserTestScript(expectedOutput, input);
        BufferedReader reader = getBufferedReader();
        BufferedWriter writer = getBufferedWriter();
        Game game = getGame(reader, writer);

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

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {
        int playersMatch = 0;

        for (int counter = 0; counter < 100; counter++) {
            setupUserAreNotInSameOrderScript(expectedOutput, input);
            BufferedReader reader =  getBufferedReader();
            BufferedWriter writer = getBufferedWriter();
            Game game = getGame(reader, writer);

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
