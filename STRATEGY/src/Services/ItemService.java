package Services;

import Constants.Constants;
import Entities.Item;

public class ItemService {
	
	public static Item createItem() {

		Item newItem = new Item();
		newItem.setName(Input.askString(Constants.ASK_ITEM_NAME));
		newItem.setPrice(Input.askDouble(Constants.ASK_ITEM_PRICE));
		
		return newItem;
	}
}
