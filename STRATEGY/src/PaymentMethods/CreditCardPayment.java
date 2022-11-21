package PaymentMethods;

import Constants.Constants;
import lombok.Data;

@Data
public class CreditCardPayment implements Payment{
	private String name;
	private String cardNumber;
	private String expiryDate;
	
	@Override
	public void pay(Double amount) {
		System.out.println(Constants.PAYING_WITH_CREDIT_CARD +  amount * 1.12);
		
	}

}