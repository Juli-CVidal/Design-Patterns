package Utils;

import Constants.Constants;
import Entities.ShoppingCart;
import PaymentMethods.CreditCardPayment;
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
			if (EXIT_OPTION == option) {
				continue;
			}

			if (0 >= option || EXIT_OPTION < option) {
				System.out.println(Constants.INVALID_OPTION);
				continue;
			}

			switch (option) {
			case 1: // ADD AN ITEM
				cart.addItem(ItemService.createItem());
				break;
			
			case 2: // DELETE AN ITEM
				cart.removeItem(Input.askString(Constants.ASK_ITEM_NAME));
				break;
			case 3: //PAY
				pay(cart);
				break;
			}

			
		} while (EXIT_OPTION != option);

	}
	
	
	public static void pay(ShoppingCart cart) {
		Integer option;
		final Integer EXIT_OPTION = 3;
		
		if (cart.getItems().isEmpty()) {
			System.out.println(Constants.EMPTY_CART);
			return;
		}
		
		System.out.println(cart);
		do {
			System.out.println(Constants.PAYMENT_OPTIONS);
			option = Input.askInteger(Constants.ASK_OPTION);
			System.out.println("");
			
			if (EXIT_OPTION == option) {
				continue;
			}

			if (0 >= option || EXIT_OPTION < option) {
				System.out.println(Constants.INVALID_OPTION);
				continue;
			}
			
			switch(option) {
			case 1: //CREDIT CARD
				cart.pay(new CreditCardPayment());
				break;
			case 2: //PAYPAL
				cart.pay(new PaypalPayment());
				break;
			}
			cart.getItems().clear();
		}while (EXIT_OPTION != option);
	}
}