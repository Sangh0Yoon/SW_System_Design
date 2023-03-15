package VideoRentalShop.step1;

class Rental {
	private Movie _movie;
	private int _daysRented;
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() { return _daysRented; }
	public Movie getMovie() { return _movie; }
	double getCharge() {
		double charge = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			charge += 2;
			if (getDaysRented() > 2)
				charge += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			charge += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			charge += 1.5;
			if (getDaysRented() > 3)
				charge += (getDaysRented() - 3) * 1.5;
			break;
		}
		return charge;
	}
	int getFrequentRenterPoints() {
		final boolean isNew_Release = getMovie().getPriceCode() == Movie.NEW_RELEASE;
		if (isNew_Release && getDaysRented() > 1)
			return 2;
		else
			return 1;
	}
}
