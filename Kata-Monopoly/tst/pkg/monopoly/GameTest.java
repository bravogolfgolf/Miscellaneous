package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        Token boot = new Token("Boot");
        Token cat = new Token("Cat");
        Player player1 = new Player(boot);
        Player player2 = new Player(cat);
        game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

    }

    @Test
    public void testGameWithTwoPlayers() throws IOException {
        final int EXPECTED_NUMBER_OF_PLAYERS = 2;
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws IOException {

    }

    @Test
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws IOException {
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() throws IOException {

    }

    @Test
    public void testGameOfTwentyRounds() throws IOException {
    }
}
