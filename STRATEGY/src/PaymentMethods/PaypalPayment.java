package PaymentMethods;

import Constants.Constants;
import lombok.Data;

@Data
public class PaypalPayment implements Payment{
	private String email;
	private String password;
	
	
	@Override
	public void pay(Double amount) {
		System.out.println(Constants.PAYING_WITH_PAYPAL + amount * 1.05);
	}
}
