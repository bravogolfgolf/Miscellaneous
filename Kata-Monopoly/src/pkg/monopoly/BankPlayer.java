package pkg.monopoly;

public class BankPlayer extends Player {

    public BankPlayer(String description) {
        super(description);
    }

    @Override
    public boolean isBank() {
        return true;
    }
}
