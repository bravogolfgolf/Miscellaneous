package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommunityChestTest {

    @Test
    public void testCreation() {
        Space property = Space.create("CommunityChest", "Community Chest");
        assertEquals("Community Chest", property.getDescription());
    }
}
