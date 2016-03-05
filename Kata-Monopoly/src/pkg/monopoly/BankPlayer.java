package pkg.monopoly;

public class BankPlayer extends Player {

    public BankPlayer() {
        super("Bank");
    }

    @Override
    public boolean isBank() {
        return true;
    }
}
