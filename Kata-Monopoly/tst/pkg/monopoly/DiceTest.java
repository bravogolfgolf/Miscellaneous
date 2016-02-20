package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testTwoDieRolled() {
        Dice dice = new Dice();
        Boolean doubles = dice.rollTwoDie();
        int rollValue = dice.getTwoDieRollValue();
        assertTrue(rollValue >= 2 && rollValue <= 12);
        assertTrue(doubles || !doubles);
    }

    @Test
    public void testDoublesRolled() {
        DiceMock diceMock = new DiceMock();
        Boolean doubles = diceMock.rollTwoDie();
        assertTrue(doubles);

    }
}
