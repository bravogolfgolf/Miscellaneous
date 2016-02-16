package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    public static final int LAND_ON_GO_COLLECT_200 = 200;

    @Test
    public void testSpaceCreated() {
        Space space = new Space(0,"Go");
        assertEquals(0, space.getID());
        assertEquals("Go", space.getDescription());
    }

    @Test
    public void testLandOnGo_Action() {
        Player player = new Player(new Token("Boot"));
        Space go = new Space(0,"Go");
        int expectedEndingBalance = player.getCashBalance() + LAND_ON_GO_COLLECT_200;
        go.action(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testEqualityAndHashcode(){
        Space space1 = new Space(0,"Go");
        Space space2 = new Space(0,"Go");
        assertTrue(space1.equals(space2));
        assertTrue(space1.hashCode() == space2.hashCode());
    }
}
