package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    public void testDiceMockRollsDouble3sThenPlain4() {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        diceMock.rollTwoDie();
        assertTrue(diceMock.rolledDouble());
        assertEquals(6, diceMock.getTwoDieRollValue());
        diceMock.rollTwoDie();
        assertEquals(4, diceMock.getTwoDieRollValue());
    }
}
