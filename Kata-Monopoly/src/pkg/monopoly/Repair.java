package pkg.monopoly;

import java.util.List;

public class Repair extends Card {
    private int hotelAssessmentAmount = 0;
    private int houseAssessmentAmount = 0;

    public Repair(String cardType, String cardText, int house, int hotel) {
        setCardType(cardType);
        setCardText(cardText);
        houseAssessmentAmount = house;
        hotelAssessmentAmount = hotel;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {
        int assessment = 0;
        List<RealEstate> realEstateHoldings = Space.getAllRealEstateOf(player);
        for (RealEstate realEstate : realEstateHoldings) {
            int numberOfImprovements = realEstate.getImprovements();
            if (numberOfImprovements == 5)
                assessment += hotelAssessmentAmount;
            else
                assessment += (numberOfImprovements * houseAssessmentAmount);
        }
        player.changeCashBalanceBy(-assessment);
    }
}
