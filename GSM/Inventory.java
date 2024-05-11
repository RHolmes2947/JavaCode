package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Represents an inventory of food items.
 */
public class Inventory {

	List<FoodItem> inventory = new ArrayList<>();

	/**
	 * Constructs a new Inventory object.
	 */
	public Inventory() {
		inventory = new ArrayList<>();
	}

	/**
	 * Returns a string representation of the inventory, including all the food
	 * items.
	 *
	 * @return The string representation of the inventory.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Inventory: " + "\n");
		for (FoodItem item : inventory) {
			sb.append(item).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Checks if a given food item already exists in the inventory.
	 *
	 * @param item The food item to check.
	 * @return The index of the item in the inventory if it exists, or -1 if it does
	 *         not exist.
	 */
	public int alreadyExists(FoodItem item) {
		for (int index = 0; index < inventory.size(); index++) {
			if (inventory.get(index).itemCode == item.itemCode) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Adds a new food item to the inventory.
	 *
	 * @param scanner The Scanner object to read input from. *
	 * @return True if the item was added successfully, false otherwise.
	 */
	public boolean addItem(Scanner scanner) {
		if (inventory.size() >= 20) {
			System.out.println("Inventory is full. Cannot add more items.");
			return false;
		}

		System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p) or a Bagged good(b)? ");
		String itemType = scanner.nextLine();

		FoodItem item = null;
		if (itemType.equalsIgnoreCase("f")) {
			item = new Fruit();
		} else if (itemType.equalsIgnoreCase("v")) {
			item = new Vegetable();
		} else if (itemType.equalsIgnoreCase("p")) {
			item = new Preserve();
		} else if (itemType.equalsIgnoreCase("b")) {
			item = new BaggedGoods();
		} else {
			System.out.println("Invalid entry");
			return false;
		}

		if (item.addItem(scanner, false)) {
			if (alreadyExists(item) != -1) {
				System.out.println("An item with this code already exists.");
				return false;
			}
			inventory.add(item);
			inventory.sort(Comparator.comparingInt(FoodItem::getItemCode));
			System.out.println("Item added to inventory.");
			return true;
		} else {
			System.out.println("Failed to add item to inventory.");
			return false;
		}
	}

	/**
	 * Updates the quantity of a food item in the inventory.
	 *
	 * @param itemCode The code of the item to update.
	 * @param quantity The quantity to add or subtract.
	 * @param isBuying Indicates if it is a buying operation (true) or a selling
	 *                 operation (false).
	 * @return True if the quantity was updated successfully, false otherwise.
	 */
	public boolean updateQuantity(int itemCode, int quantity, boolean isBuying) {
		for (FoodItem item : inventory) {
			if (item.itemCode == itemCode) {
				if (isBuying) {
					item.itemQuantityInStock += quantity;
				} else {
					if (item.itemQuantityInStock - quantity >= 0) {
						item.itemQuantityInStock -= quantity;
					} else {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Prompts the user to enter an item code and then searches for that item in the
	 * inventory. If the item is found, it is printed.
	 *
	 * @param scanner The Scanner object to read input from.
	 */
	public void searchForItem(Scanner scanner) {
		System.out.print("Enter the code for the item: ");

		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter an integer.");
			scanner.next();
		}

		int code = scanner.nextInt();
		scanner.nextLine();
		for (FoodItem item : inventory) {
			if (item.getItemCode() == code) {
				System.out.println(item.toString());
				return;
			}
		}

		System.out.println("Code not found in inventory...");
	}

	/**
	 * Prompts the user to enter a filename and then saves the inventory to that
	 * file. If an error occurs, it is printed.
	 *
	 * @param scanner The Scanner object to read input from.
	 */
	public void saveToFile(Scanner scanner) {
		System.out.print("Enter the filename to save to:");
		String filename = scanner.nextLine();
		try (Formatter formatter = new Formatter(filename)) {
			for (FoodItem item : inventory) {
				item.outputItem(formatter);
			}
		} catch (Exception e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}

	}

	/**
	 * Prompts the user to enter a filename and then reads inventory data from that
	 * file. If an error occurs, it is printed.
	 *
	 * @param scanner The Scanner object to read input from.
	 */
	public void readFromFile(Scanner scanner) {
		System.out.print("Enter the name of the file to read from: ");
		String filename = scanner.nextLine();

		try (Scanner fileScanner = new Scanner(new File(filename))) {
			while (fileScanner.hasNextLine()) {
				String type = fileScanner.nextLine();

				FoodItem item;

				switch (type) {
				case "f":
					item = new Fruit();
					break;
				case "v":
					item = new Vegetable();
					break;
				case "p":
					item = new Preserve();
					break;
				case "b":
					item = new BaggedGoods();
					break;
				default:
					System.out.println("Invalid item type in file.");
					continue;
				}

				if (item.addItem(fileScanner, true)) {
					if (alreadyExists(item) != -1) {
						System.out.println("An item with this code already exists in the file, skipping.");
						continue;
					}
					inventory.add(item);
					inventory.sort(Comparator.comparingInt(FoodItem::getItemCode));
				} else {
					System.out.println("Error reading item data from file.");
				}
			}

			System.out.println("Inventory read from file.");

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (Exception e) {
			System.out.println("Error reading from file.");
		}
	}

}
