package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JailTest {

    private Player player;
    private Jail jail;

    @Before
    public void setUp() {
        player = new Player("Cat");
        jail = (Jail) Space.create("Jail","Other");
    }

    @After
    public void teardown() {
        player = null;
        jail = null;
    }

    @Test
    public void testLandOn() throws GoToJail.GoToJailException {
        int expectedEndingBalance = player.getCashBalance();
        jail.landOn(player, "Roll");
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        jail.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
