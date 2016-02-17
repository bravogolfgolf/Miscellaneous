package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoTest {

    public static final int LAND_ON_GO_COLLECT_200 = 200;

    @Test
    public void testLandOnIncreaseBalance() {
        Player player = new Player();
        Space go = new Go("Go");
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassByIncreaseBalance() {
        Player player = new Player();
        Space go = new Go("Go");
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
