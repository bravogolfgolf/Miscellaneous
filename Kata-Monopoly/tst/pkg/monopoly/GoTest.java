package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoTest {

    public static final int LAND_ON_GO_COLLECT_200 = 200;

    @Test
    public void testGoCreated(){
        Space go = new Go(0,"Go");
        assertEquals(0,go.getID());
        assertEquals("Go",go.getDescription());
    }

    @Test
    public void testLandOn() {
        Player player = new Player(new Token("Boot"));
        Space go = new Go(0,"Go");
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        Player player = new Player(new Token("Boot"));
        Space go = new Go(0,"Go");
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
