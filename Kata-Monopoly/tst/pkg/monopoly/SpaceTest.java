package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {


    @Test
    public void testSpaceCreated() {
        Space space = new Space(0,"Go");
        assertEquals(0, space.getID());
        assertEquals("Go", space.getDescription());
    }

    @Test
    public void testLandOn() {
        Player player = new Player(new Token("Boot"));
        Space space = new Space(1,"Not Go");
        int expectedEndingBalance = player.getCashBalance();
        space.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        Player player = new Player(new Token("Boot"));
        Space space = new Space(0,"Go");
        int expectedEndingBalance = player.getCashBalance();
        space.passBy(player);
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
