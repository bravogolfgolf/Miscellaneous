package pkg.monopoly;

public class Die {

    public int rollTwoDie() {
        int die1 = rollDie();
        int die2 = rollDie();
        return die1 + die2;
    }

    public int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }
}