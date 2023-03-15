package VideoRentalShop.step1;

import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each: _rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t" + 
						String.valueOf(each.getCharge()) + "\n";
		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRentersPoints()) + " frequent renter points";

		return result;
	}
	public String htmlStatement() {
		String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
		
		for (Rental each: _rentals) {
			result += "\t" + each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}
		
		result += "<P>You owe <EM> " + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "You earned <EM>" + String.valueOf(getTotalFrequentRentersPoints()) + "</EM> frequent renter points<P>";
		
		return result;
	}
	public double getTotalCharge() {
		double charge = 0;
		
		for(Rental each: _rentals) charge += each.getCharge();
		
		return charge;
	}
	public double getTotalFrequentRentersPoints() {
		int points = 0;
		
		for(Rental each: _rentals) points += each.getFrequentRenterPoints();
		
		return points;
	}
	public static void main(String[] args) {
		Customer customer1 = new Customer("David");
		Movie movie1 = new Movie("Madagascar", Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, 6); // 6 day rental
		Movie movie2 = new Movie("Star Wars", Movie.NEW_RELEASE);
		Rental rental2 = new Rental(movie2, 2); // 2 day rental
		Movie movie3 = new Movie("Gone with the Wind", Movie.REGULAR);
		Rental rental3 = new Rental(movie3, 8); // 8 day rental
		customer1.addRental(rental1);
		customer1.addRental(rental2);
		customer1.addRental(rental3);
		System.out.println(customer1.statement()) ;
	}
}
