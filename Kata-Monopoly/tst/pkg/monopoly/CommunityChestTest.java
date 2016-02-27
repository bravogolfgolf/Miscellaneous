package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommunityChestTest {

    @Test
    public void testCreateCommunityChestCard() {
        CommunityChest communityChest = (CommunityChest) Card.create("CommunityChest", "Bank error in your favor – Collect $200");
        assertTrue("Bank error in your favor – Collect $200".equals(communityChest.getInstruction()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard() {
        Card.create("Invalid", "Invalid");
    }
}
