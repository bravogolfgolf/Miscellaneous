package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp()  {
        game = new Game();
    }

    private void addThisManyPlayers(int number) {
        for (int i = 0; i < number; i++) {
            Token token = new Token("");
            Player player = new Player(token);
            game.addPlayer(player);
        }
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenFewerThanTwoPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(1);
        game.play();
    }

    @Test
    public void testGameWithTwoPlayers() throws Game.InvalidPlayerCount {
        final int EXPECTED_NUMBER_OF_PLAYERS = 2;
        addThisManyPlayers(2);
        game.play();
        assertEquals(EXPECTED_NUMBER_OF_PLAYERS, game.getNumberOfPlayers());
    }

    @Test(expected = Game.InvalidPlayerCount.class)
    public void testGameThrowsExceptionWhenMoreThanEightPlayers() throws Game.InvalidPlayerCount {
        addThisManyPlayers(9);
        game.play();
    }

    @Test
    public void testPlayersAreNotAlwaysInSameOrder() {

    }

    @Test
    public void testGameOfTwentyRounds()  {
    }
}
