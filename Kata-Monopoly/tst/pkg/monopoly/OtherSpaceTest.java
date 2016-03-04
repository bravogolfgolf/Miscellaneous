package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OtherSpaceTest {

    private Player player;
    private Other other;

    @Before
    public void setUp() {
        player = new Player("Cat");
        other = (Other) Space.create("Other","Other");
    }

    @After
    public void teardown() {
        player = null;
        other = null;
    }

    @Test
    public void testLandOn() throws GoToJail.GoToJailException {
        int expectedEndingBalance = player.getCashBalance();
        other.landOn(player, "Roll");
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        other.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
