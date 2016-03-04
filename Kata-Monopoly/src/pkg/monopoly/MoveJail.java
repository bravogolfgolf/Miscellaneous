package pkg.monopoly;

public class MoveJail extends Card {
    public MoveJail(String cardType, String cardText, String space) {
        super();
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {
    }
}
