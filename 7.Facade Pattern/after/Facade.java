package FacadePattern;

public class Facade {
	private OrderDepartment orderDeptpartment;
	private BillingDepartment billingDeptpartment;
	private ShippingDepartment shippingDeptpartment;
	
	public Facade(OrderDepartment orderDeptpartment, BillingDepartment billingDeptpartment,
				  ShippingDepartment shippingDeptpartment) {
		this.orderDeptpartment = orderDeptpartment;
		this.billingDeptpartment = billingDeptpartment;
		this.shippingDeptpartment = shippingDeptpartment;
	}
	
	public void makeOrder(Order order, Customer customer1, String item, int quantity) {
		try {
			order = orderDeptpartment.makeOrder(customer1, item, quantity, quantity >= 10);
			int price = order.getPrice();
			if(billingDeptpartment.makePayment(order, price)) {
				shippingDeptpartment.startShipping(order);
			}
			else {
				order.setPending(true);
				throw new NotEnoughBalanceException(order);
			}
		}
		catch(NotEnoughBalanceException e) {
			System.out.println("You have not enough money to buy " + order.getItem());
		}
	}
	
	public void cancelOrder(Order order) {		
		if ( orderDeptpartment.cancelOrder(order) ) {
			billingDeptpartment.refund(order);
			shippingDeptpartment.stopShipping(order);
		}
		else {
			System.out.println("The order cannot be cancelled");
		}
	}
}
