package Utils;

import java.util.Arrays;
import java.util.List;

import Constants.Constants;
import Entities.ShoppingCart;
import PaymentMethods.CreditCardPayment;
import PaymentMethods.Payment;
import PaymentMethods.PaypalPayment;
import Services.Input;
import Services.ItemService;

public class Menu {

	public static void MainMenu(ShoppingCart cart) {
		Integer option;
		final Integer EXIT_OPTION = 4;

		do {
			System.out.println(Constants.MAIN_MENU_OPTIONS);
			option = Input.askInteger(Constants.ASK_OPTION);
			System.out.println("");

			if (0 >= option || EXIT_OPTION <= option) {
				continue;
			}

			switch (option) {
			case 1: // ADD AN ITEM
				cart.addItem(ItemService.createItem());
				break;

			case 2: // DELETE AN ITEM
				System.out.println(cart);
				cart.removeItem(Input.askString(Constants.ASK_ITEM_NAME));
				break;
			case 3: // PAY
				pay(cart);
				break;
			}

		} while (EXIT_OPTION != option);

	}
	

	private static void pay(ShoppingCart cart) {
		if (cart.getItems().isEmpty()) {
			System.out.println(Constants.EMPTY_CART);
			return;
		}
		System.out.println(cart);
		Payment paymentMethod = selectPaymentMethod();
		cart.pay(paymentMethod);
		cart.getItems().clear();
	}
	
	private static Payment selectPaymentMethod() {
		final List<Payment> PAYMENT_METHODS = Arrays.asList(new CreditCardPayment(), new PaypalPayment());
		Integer option;
		final Integer EXIT_OPTION = 3;
		
		
		do {
			System.out.println(Constants.PAYMENT_OPTIONS);
			option = Input.askInteger(Constants.ASK_OPTION);
			System.out.println("");
			
			if (0 >= option || EXIT_OPTION <= option) {
				continue;
			}
		} while (EXIT_OPTION != option);
		
		return PAYMENT_METHODS.get(option);
	}
}
