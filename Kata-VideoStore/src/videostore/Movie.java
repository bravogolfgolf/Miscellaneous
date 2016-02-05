package videostore;


public abstract class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public void setPriceCode(int code) {
        priceCode = code;
    }

    public String getTitle() {
        return title;
    }

    abstract double determineAmount(int daysRented);

    abstract int determineFrequentRenterPoints(int daysRented);
}