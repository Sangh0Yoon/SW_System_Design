package VideoRentalShop.step2;

public class RegularPrice extends Price{
	public int getPriceCode() {return Movie.REGULAR;}
	public double getCharge(int daysRented) {
		double charge = 2;
		if(daysRented > 2) charge += (daysRented - 2) * 1.5;
		return charge;
	}
}
