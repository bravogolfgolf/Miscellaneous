package pkg.monopoly;

public class Dice {

    private int twoDieRollValue;

    public void rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        twoDieRollValue =  die1 + die2;
    }

    public int getTwoDieRollValue() {
        return twoDieRollValue;
    }

    private int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }
}