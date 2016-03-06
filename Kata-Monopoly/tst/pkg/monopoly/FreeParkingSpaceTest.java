package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreeParkingSpaceTest {

    private Player player;
    private FreeParking freeParking;

    @Before
    public void setUp() {
        player = new Player("Cat");
        freeParking = (FreeParking) Space.create("FreeParking","FreeParking");
    }

    @After
    public void teardown() {
        player = null;
        freeParking = null;
    }

    @Test
    public void testLandOn()  {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.landOn(player, "Roll");
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        freeParking.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
