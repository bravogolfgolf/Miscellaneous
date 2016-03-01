package pkg.monopoly;

import java.util.List;

public class Repair extends Card {
    private int hotelAssessmentAmount = 0;
    private int houseAssessmentAmount = 0;

    public Repair(String cardType, String cardText, int house, int hotel) {
        setCardType(cardType);
        setCardText(cardText);
        setHouseAssessmentAmount(house);
        setHotelAssessmentAmount(hotel);
    }

    public void setHouseAssessmentAmount(int houseAssessmentAmount) {
        this.houseAssessmentAmount = houseAssessmentAmount;
    }

    public void setHotelAssessmentAmount(int hotelAssessmentAmount) {
        this.hotelAssessmentAmount = hotelAssessmentAmount;
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
