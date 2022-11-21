package Entities;

import lombok.Data;

@Data
public class Item {
	private String name;
	private Double price;
	@Override
	public String toString() {
		return name + ": $" + price;
	}
	
	
	
}
