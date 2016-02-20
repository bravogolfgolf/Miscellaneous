package pkg.monopoly;

public class DiceMock extends Dice {

    private int twoDieRollValue;

    @Override
    public Boolean rollTwoDie() {
        twoDieRollValue = 2;
        return false;
    }

    @Override
    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }
}
