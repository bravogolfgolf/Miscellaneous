package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    @Test
    public void testCreateSpace() {
        Space space = new Space("Space");
        assertEquals("Space", space.getDescription());
    }

    @Test
    public void testSetNextSpace(){
        Space start = new Space("Start");
        Space space1 = new Space("Space1");
        start.setNextSpace(space1);
        assertTrue(start.getNextSpace().equals(space1));
    }

    @Test
    public void testLandOn() {
        Player player = new Player();
        Space space = new Space("Space");
        int expectedEndingBalance = player.getCashBalance();
        space.landOn(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        Player player = new Player();
        Space space = new Space("Space");
        int expectedEndingBalance = player.getCashBalance();
        space.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testEqualsAndHashcode() {
        Space space1 = new Space("Space");
        Space space2 = new Space("Space");
        assertTrue(space1.equals(space2));
        assertTrue(space1.hashCode() == space2.hashCode());
    }
}
