package pkg.monopoly;

public class PlayerMockTurnCounter extends Player {

    public int turnsTaken = 0;

    public PlayerMockTurnCounter() {
        super("PlayerMockTurnCounter");
    }

    @Override
    public void takeATurn(Dice die) {
        turnsTaken++;
    }

}