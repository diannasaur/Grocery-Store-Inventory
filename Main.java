package cs180_GroceryStoreInventory;

import java.util.Scanner;
import java.util.ArrayList; 

public class Main {
	
	//sets up array lists
	static ArrayList<String> itemNames = new ArrayList<>();
	static ArrayList<Integer> itemQuantities = new ArrayList<>();
	static ArrayList<Double> itemPrices = new ArrayList<>();
	
	// function to add item to array lists
	public static void addItem(String itemName, int quantity, double price)
	{
		itemNames.add(itemName);
		itemQuantities.add(quantity);
		itemPrices.add(price);
		
		System.out.print("\nItem added: " + itemName + " - Quantity: " + quantity + " - Price Per Item: $" + price + "\n");
	}
		
	//function to update item's quantity and price
	public static void updateItem(String itemName, int quantity, double price)
	{
		for (int i = 0; i < itemNames.size(); i++)
		{
			if(itemName.equals(itemNames.get(i)))
			{
				itemQuantities.set(i, quantity);
				itemPrices.set(i, price);
				
				System.out.println("\nUpdated " + itemName + " - New Quantity: " + quantity + " - New Price: $" + price);
			}
		}
	}
	
	//function to display inventory
	public static void displayInventory()
	{
		for (int i = 0; i < itemNames.size(); i++)
		{
			System.out.print("\n" + itemNames.get(i) + " - Quantity: " + itemQuantities.get(i) + ", $" + itemPrices.get(i) + " per item");
		}
		
		double totalPrice = 0; 
		for (int j = 0; j < itemPrices.size(); j++)
		{
			totalPrice = totalPrice + (itemQuantities.get(j) * itemPrices.get(j));
		}
		System.out.print("\n");
		System.out.println("\nTotal Inventory Value: $" + totalPrice);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner in = new Scanner(System.in);
	boolean keepworking = true;
	
	//displays menu options  
	while(keepworking)	
	{
		System.out.println("\nGrocery Store Inventory Menu:");
		System.out.println("1. Add Item");
		System.out.println("2. Update Item");
		System.out.println("3. Display Inventory");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		int choice = in.nextInt(); 
		
		if(choice == 1)
		{
			System.out.print("\nEnter item name:");
			String item = in.next();
			
			System.out.print("Enter item quantity:");
			int quantity = in.nextInt();
				
			System.out.print("Enter item price:");
			double price = in.nextDouble();
			
			addItem(item, quantity, price);		
		}
		
		else if(choice == 2)
		{
			System.out.print("\nEnter item name to update:");
			String item = in.next();
			
			System.out.print("Enter new quantity:");
			int quantity = in.nextInt();
				
			System.out.print("Enter new price:");
			double price = in.nextDouble();
			
			updateItem(item, quantity, price);
		}
		
		else if(choice == 3)
		{
			System.out.print("\nCurrent Inventory:");
			displayInventory();
			
		}
		
		else if(choice == 4)
		{
			System.out.println("Existing program...");
			in.close(); 
			keepworking = false;
		}
		
		else 
		{
			System.out.println("Invalid input. Please try again."); 
		}
	}
	
	}

}
