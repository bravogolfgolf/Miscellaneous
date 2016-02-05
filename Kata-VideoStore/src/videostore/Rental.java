package videostore;

public class Rental
{
	private Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented () {
		return daysRented;
	}

	public Movie getMovie () {
		return movie;
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public int getPriceCode() {
		return movie.getPriceCode();
	}

	double determineAmount() {
        double rentalAmount = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (getDaysRented() > 2)
                    rentalAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (getDaysRented() > 3)
                    rentalAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

	int determineFrequentRenterPoints() {
        boolean bonusIsEarned = getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1;
        if (bonusIsEarned)
            return 2;
        return 1;
    }
}