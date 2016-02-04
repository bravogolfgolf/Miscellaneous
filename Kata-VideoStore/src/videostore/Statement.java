package videostore;


import java.util.ArrayList;
import java.util.List;

public class Statement 
{
	private String customerName;
	private List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount;
	private int frequentRenterPoints;
	
	public Statement (String name) {

		this.customerName = name;
	}

	public void addRental (Rental rental) {

		rentals.add (rental);
	}

	public String getName () {

		return customerName;
	}

	public String generate () {
		totalAmount = 0;
		frequentRenterPoints = 0;

		String result = "Rental Record for " + getName () + "\n";

		for (Rental each:rentals	) {
			double thisAmount = 0;

			// determines the amount for each line
			switch (each.getMovie ().getPriceCode ()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented () > 2)
					thisAmount += (each.getDaysRented () - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented () * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented () > 3)
					thisAmount += (each.getDaysRented () - 3) * 1.5;
				break;
			}

			frequentRenterPoints++;

			if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE 
					&& each.getDaysRented () > 1)
				frequentRenterPoints++;

			result += "\t" + each.getMovie ().getTitle () + "\t"
					+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;

		}

		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


		return result;
	}


	public double getTotal() {
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
}