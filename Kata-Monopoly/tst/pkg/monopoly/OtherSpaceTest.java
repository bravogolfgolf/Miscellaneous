package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OtherSpaceTest {

    private Player player;
    private Space property;

    @Before
    public void setUp() {
        player = new Player("Cat");
        property = Space.create("Other","Other");
    }

    @After
    public void teardown() {
        player = null;
        property = null;
    }

    @Test
    public void testLandOn() {
        int expectedEndingBalance = player.getCashBalance();
        property.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        property.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
