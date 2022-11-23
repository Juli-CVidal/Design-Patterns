package PaymentMethods;

import Constants.Constants;

public class CashPayment implements Payment{
	@Override
	public void pay(Double amount) {
		System.out.println(Constants.PAYING_WITH_CASH + amount);
	}
}
