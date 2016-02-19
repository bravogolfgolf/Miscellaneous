package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GoToJailTest {

    private Space goToJail;
    private Space jail;
    private Player player;
    private Space space;
    private int startingBalance;
    private int endingBalance;

    @Before
    public void setUp() throws Exception {
        goToJail = Space.create("GoToJail","Go to Jail");
        jail = Space.create("Other","Jail");
        player = new Player();
        startingBalance = player.getCashBalance();
    }

    @After
    public void tearDown() throws Exception {
        goToJail = null;
        jail = null;
        player = null;
    }

    @Test
    public void testLandOnGoToJailAndPlayerDoesGoToJailWithNoChangeInCash() {
        goToJail.landOn(player);
        space = player.getSpace();
        endingBalance = player.getCashBalance();
        assertTrue(space.equals(jail));
        assertEquals(startingBalance,endingBalance);
    }

    @Test
    public void testPassByGoToJailAndPlayerDoesNotGoToJailWithNoChangeInCash() {
        goToJail.passBy(player);
        space = player.getSpace();
        endingBalance = player.getCashBalance();
        assertFalse(space.equals(jail));
        assertEquals(startingBalance,endingBalance);
    }
}
