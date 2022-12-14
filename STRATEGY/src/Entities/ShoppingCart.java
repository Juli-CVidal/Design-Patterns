package Entities;

import java.util.ArrayList;
import java.util.List;

import PaymentMethods.Payment;
import lombok.Data;

@Data
public class ShoppingCart {
	private List<Item> items;
	
	
	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}
	
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(String itemName) {
		items.removeIf(item -> itemName.equals(item.getName()));
	}
	
	private Double calculateTotal() {
		return items.stream().map(item -> item.getPrice()).reduce(0d, (a,b) -> a + b);
	}
	
	
	public void pay(Payment payment) {
		payment.pay(calculateTotal());
	}


	@Override
	public String toString() {
		return "Items in the shopping cart: "
				+ "\n" + items
				+ "\nTotal: $" + calculateTotal();
	}
	
	
}
