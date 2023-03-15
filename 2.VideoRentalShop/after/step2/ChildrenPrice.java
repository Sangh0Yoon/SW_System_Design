package VideoRentalShop.step2;

public class ChildrenPrice extends Price{
	public int getPriceCode() {return Movie.CHILDRENS;}
	public double getCharge(int daysRented) {
		double charge = 1.5;
		if(daysRented > 3) charge += (daysRented - 3) * 1.5;
		
		return charge;
	}
}
