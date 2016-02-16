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
    public void testEqualityAndHashcode(){
        Space space1 = new Space(0,"Go");
        Space space2 = new Space(0,"Go");
        assertTrue(space1.equals(space2));
        assertTrue(space1.hashCode() == space2.hashCode());
    }
}
