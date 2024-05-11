package src;

import java.util.Comparator;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a food item in the inventory.
 */
public class FoodItem implements Comparator<FoodItem> {

	protected int itemCode;
	protected String itemName;
	protected float itemPrice;
	protected int itemQuantityInStock;
	protected float itemCost;

	/**
	 * Constructs a new FoodItem object.
	 */
	public FoodItem() {
	}

	/**
	 * Returns a string representation of the food item.
	 *
	 * @return The string representation of the food item.
	 */
	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
				+ itemCost;
	}

	/**
	 * Adds a new item to the inventory.
	 *
	 * @param scanner  The Scanner object to read input from.
	 * @param fromFile The flag to indicate if the input is from a file or not.
	 * @return True if the item was added successfully, false otherwise.
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		boolean validCode = inputCode(scanner, fromFile);
		if (!validCode) {
			return false;
		}

		System.out.print("Enter the name for the item: ");
		itemName = scanner.nextLine();

		while (true) {
			System.out.print("Enter the quantity for the item: ");
			if (scanner.hasNextInt()) {
				itemQuantityInStock = scanner.nextInt();
				scanner.nextLine();
				if (itemQuantityInStock > 0) {
					break;
				} else {
					System.out.println("Invalid entry. Quantity must be a positive integer.");
				}
			} else {
				System.out.println("Invalid entry. Quantity must be an integer.");
				scanner.nextLine();
			}
		}

		while (true) {
			System.out.print("Enter the cost of the item: ");
			if (scanner.hasNextFloat()) {
				itemCost = scanner.nextFloat();
				scanner.nextLine();
				if (itemCost > 0) {
					break;
				} else {
					System.out.println("Invalid entry. Cost must be a positive number.");
				}
			} else {
				System.out.println("Invalid entry. Cost must be a number.");
				scanner.nextLine();
			}
		}

		while (true) {
			System.out.print("Enter the sales price of the item: ");
			if (scanner.hasNextFloat()) {
				itemPrice = scanner.nextFloat();
				scanner.nextLine();
				if (itemPrice > 0) {
					break;
				} else {
					System.out.println("Invalid entry. Sales price must be a positive number.");
				}
			} else {
				System.out.println("Invalid entry. Sales price must be a number.");
				scanner.nextLine();
			}
		}

		return true;
	}

	/**
	 * Updates the quantity of the item in the inventory.
	 *
	 * @param amount The amount by which to update the quantity.
	 * @return True if the quantity was updated successfully, false if the resulting
	 *         quantity would be negative.
	 */
	public boolean updateItem(int amount) {
		if (itemQuantityInStock + amount >= 0) {
			itemQuantityInStock += amount;
			return true;
		}
		return false;
	}

	/**
	 * Checks if the given food item code is equal to this food item's code.
	 *
	 * @param foodItem The food item code to compare.
	 * @return True if the codes are equal, false otherwise.
	 */
	public boolean isEqual(int foodItem) {
		return itemCode == foodItem;
	}

	/**
	 * Reads and validates the item code input.
	 *
	 * @param scanner  The Scanner object to read input from.
	 * @param fromFile The flag to indicate if the input is from a file or not.
	 * @return True if a valid code was entered, false otherwise.
	 */
	private boolean inputCode(Scanner scanner, boolean fromFile) {
		boolean validCode = false;
		do {
			System.out.print("Enter the code for the item: ");
			if (scanner.hasNextInt()) {
				itemCode = scanner.nextInt();
				scanner.nextLine();
				validCode = true;
			} else {
				System.out.println("Invalid entry. Code must be an integer.");
				scanner.nextLine();
			}
		} while (!validCode);
		return true;
	}

	/**
	 * Returns the item code of this item.
	 *
	 * @return The item code.
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Formats the item details to be written to a file. The details are separated
	 * by new lines.
	 * 
	 * @param formatter The Formatter object used to format the item details.
	 */
	public void outputItem(Formatter formatter) {
		formatter.format("%s\n%d\n%s\n%d\n%f\n%f\n", "", itemCode, itemName, itemQuantityInStock, itemPrice, itemCost);
	}

	/**
	 * Compares two food item objects bases on there item codes
	 * 
	 * @param item1 the first food item to compare
	 * @param item2 the second food item to compare
	 * 
	 * @return a negative integer if food item1 items code is less than item2's item
	 *         code, zero is the codes are equal, or positive integer if item1's
	 *         item code is greater that item2's item code
	 * 
	 */

	@Override
	public int compare(FoodItem item1, FoodItem item2) {
		return Integer.compare(item1.getItemCode(), item2.getItemCode());
	}

}
