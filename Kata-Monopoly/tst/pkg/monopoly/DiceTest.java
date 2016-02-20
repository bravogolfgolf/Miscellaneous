package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testTwoDieRolled() {
        Dice dice = new Dice();
        dice.rollTwoDie();
        int rollValue = dice.getTwoDieRollValue();
        assertTrue(rollValue >= 2 && rollValue <= 12);
    }

    @Test
    public void testDoublesRolled() {
        DiceMock diceMock = new DiceMock();
        Boolean doubles = diceMock.rollTwoDie();
        assertTrue(doubles);

    }
}
