package PaymentMethods;

import Constants.Constants;

public class CreditCardPayment implements Payment{
	@Override
	public void pay(Double amount) {
		System.out.println(Constants.PAYING_WITH_CREDIT_CARD +  amount * 1.12);
		
	}

}
