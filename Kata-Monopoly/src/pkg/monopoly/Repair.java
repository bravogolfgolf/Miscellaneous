package pkg.monopoly;

public class Repair extends Card {
    private String hotelAssesmentAmount;
    private String houseAssesmentAmount;

    public Repair(String cardType, String cardText, String house, String hotel) {
        setCardType(cardType);
        setCardText(cardText);
        setHouseAssessmentAmount(house);
        setHotelAssessmentAmount(hotel);
    }

    public void setHouseAssessmentAmount(String houseAssessmentAmount) {
        this.houseAssesmentAmount = houseAssessmentAmount;
    }

    public void setHotelAssessmentAmount(String hotelAssessmentAmount) {
        this.hotelAssesmentAmount = hotelAssessmentAmount;
    }
}
