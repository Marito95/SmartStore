package Agents;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import Inventory.InventoryManager;
import Inventory.Item;
import Inventory.ListItem;

public class AVGTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InventoryManager.getInstance().DBInit();
		UserManager.getInstance().DBInit();
		TransactionManager.getInstance().DBInit();
//		addTransactions(3,5,20);
		runAgent();

	}

	public static void addTransactions(int months, int transactions, int topProducts){
		ArrayList<User> users = UserManager.getInstance().getAllUsers();
		ArrayList<Item> items = InventoryManager.getInstance().getAllItems();
		TransactionManager tm = TransactionManager.getInstance();

		User u = users.get(0);
		Random r = new Random();
		ArrayList<ListItem> cartItems = new ArrayList<>();
		GregorianCalendar cal = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		for(int iter = 0; iter<2; iter++){
			Date d = cal.getTime();
			for(int index = 0; index<3; index++){
				for(Item i: items){
					u.userPickItem(i, r.nextInt(10));
				}
				cartItems = new ArrayList<>();
				cartItems.addAll(u.getVirtualCart());
				tm.addTransaction(u.getVirtualCart(), d, u.getId(), u.getCartTotal());
				u.setVirtualCart(new ArrayList<>());
			}
			cal.roll(Calendar.MONTH, true);
		}
	}

	public static void runAgent(){
		TrendingAgent agent = new TrendingAgent(TransactionManager.getInstance().getAllTransactions());

		agent.determineMinStock();
		agent.determineTrends();

	}

}