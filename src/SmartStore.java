import java.util.ArrayList;
import java.util.Date;

import Agents.Transaction;
import Agents.TransactionManager;
import Agents.User;
import Agents.UserManager;
import Evironment.StoreMap;
import Inventory.InventoryManager;
import Inventory.Item;
import Inventory.ListItem;
import Inventory.Location;

public class SmartStore {

	

	public static void main(String[] args) {
		
		try {
			InventoryManager invMang = InventoryManager.getInstance();
			UserManager userManager = UserManager.getInstance();
			TransactionManager transManager = TransactionManager.getInstance();
			
			
			invMang.DBInit();
			userManager.DBInit();
			transManager.DBInit();
			
			User user = userManager.getAllUsers().get(0);
			System.out.println(user.getName());

			
			Location newLocation = new Location(2,false,1,3);

			Item item1 = new Item("2345434f","XBOX",60.00,"electronics", 30, 100, 30,
					15, 300.00, newLocation);
			
			Item item2 = new Item("234656f","Nintendo",56.00,"electronics", 30, 100, 30,
					15, 356.00, newLocation);
			
			ListItem listItem1 = new ListItem(item1,3);
			ListItem listItem2 = new ListItem(item2,4);
			
			ArrayList<ListItem> items = new ArrayList<>();
			
			items.add(listItem1);
			items.add(listItem2);
			
			
			transManager.addTransaction(items, new Date(), "801124795", (300.00 * 3) + (356 * 4));
			StoreMap map = new StoreMap();
			
//			System.out.println(invMang.getSingleItem(newLocation));
//			invMang.userBuysItem(newLocation, 20);
//			invMang.minimunCapacityReach(newLocation);
//			invMang.needToBringItemsToFloor(newLocation);
//			ArrayList<Item> items = invMang.getAllItems();
			
			
			
			
			
			
			
			
			
		} catch (Exception  e) {
			System.err.println("Error" +  e.getClass().getName() + ": " + e.getMessage() );
		}

		
	}
	

}
