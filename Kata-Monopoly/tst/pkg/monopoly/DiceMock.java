package pkg.monopoly;

public class DiceMock extends Dice {

    private int twoDieRollValue;

    public Boolean rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        twoDieRollValue =  die1 + die2;
        return die1 == die2;
    }

    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }

    private int rollDie() {
        return 1;
    }
}
