package pkg.monopoly;

public class Dice {

    private int twoDieRollValue;
    private boolean rolledDouble;

    public void rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        twoDieRollValue = die1 + die2;
        rolledDouble = (die1 == die2);
    }

    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }

    int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public boolean rolledDouble() {
        return rolledDouble;
    }
}