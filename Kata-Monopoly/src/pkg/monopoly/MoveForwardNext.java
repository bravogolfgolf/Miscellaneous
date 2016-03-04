package pkg.monopoly;

public class MoveForwardNext extends Card {
    private String group;

    public MoveForwardNext(String cardType, String cardText, String group) {
        setCardType(cardType);
        setCardText(cardText);
        this.group = group;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {

    }
}
