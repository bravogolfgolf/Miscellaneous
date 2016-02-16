package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceTest {

    @Test
    public void testSpaceCreated() {
        Space space = new Space(0,"Go");
        assertEquals(0, space.getID());
        assertEquals("Go", space.getDescription());
    }
}
