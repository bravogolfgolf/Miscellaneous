package pkg.monopoly;

public class Repair extends Card {
    private int hotelAssesmentAmount = 0;
    private int houseAssesmentAmount = 0;

    public Repair(String cardType, String cardText, int house, int hotel) {
        setCardType(cardType);
        setCardText(cardText);
        setHouseAssessmentAmount(house);
        setHotelAssessmentAmount(hotel);
    }

    public void setHouseAssessmentAmount(int houseAssessmentAmount) {
        this.houseAssesmentAmount = houseAssessmentAmount;
    }

    public void setHotelAssessmentAmount(int hotelAssessmentAmount) {
        this.hotelAssesmentAmount = hotelAssessmentAmount;
    }

    @Override
    void action(Player player) throws GoToJail.GoToJailException {

    }
}
