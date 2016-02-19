package pkg.monopoly;

public class PlayerMockTurnCounter extends Player {

    public int turnsTaken = 0;
    public int manageProperties = 0;

    public PlayerMockTurnCounter() {
        super();
    }

    @Override
    public void manageProperties() {
        manageProperties++;
    }

    @Override
    public void takeATurn(Dice die) {
        turnsTaken++;
    }

}