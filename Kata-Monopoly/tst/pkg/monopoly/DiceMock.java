package pkg.monopoly;

public class DiceMock extends Dice {

    private int twoDieRollValue;

    @Override
    public boolean rolledDouble() {
        return false;
    }

    @Override
    public void rollTwoDie() {
        twoDieRollValue = 2;
    }

    @Override
    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }
}
