package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommunityChestCardTest {

    @Test
    public void testCreateCommunityChestCard() {
        CommunityChestCard communityChest = (CommunityChestCard) Card.create("CommunityChestCard", "Bank error in your favor – Collect $200");
        assertTrue("Bank error in your favor – Collect $200".equals(communityChest.getInstruction()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard() {
        Card.create("Invalid", "Invalid");
    }
}
