package src;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a bagged goods item in the inventory, extending the FoodItem
 * class.
 */
public class BaggedGoods extends FoodItem {
	private String bakeryName;

	/**
	 * Constructs a new BaggedGoods object.
	 */
	public BaggedGoods() {

	}

	/**
	 * Returns a string representation of the bagged goods item, including the
	 * bakery name.
	 *
	 * @return The string representation of the bagged goods item.
	 */
	@Override
	public String toString() {
		return super.toString() + " Name of bakery: " + bakeryName;
	}

	/**
	 * Adds a new bagged goods item to the inventory, including the bakery name.
	 *
	 * @param scanner  The Scanner object used for user input.
	 * @param fromFile Indicates if the operation is being performed as a result of
	 *                 a file read operation. If true, the method expects the jar
	 *                 size to be the next line in the file.
	 * @return true if the item and the additional detail were successfully added;
	 *         false otherwise.
	 */
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (!super.addItem(scanner, fromFile)) {
			return false;
		}

		if (fromFile) {
			if (scanner.hasNextLine()) {
				bakeryName = scanner.nextLine();
			}
			return true;
		} else {
			System.out.print("Enter the name of the bakery: ");
			bakeryName = scanner.nextLine();
			return true;
		}
	}

	/**
	 * Outputs the details of a BaggedGoods item to a file in a formatted manner.
	 *
	 * @param formatter The Formatter object used to write to the file.
	 */
	@Override
	public void outputItem(Formatter formatter) {
		formatter.format("b\n");
		super.outputItem(formatter);
		formatter.format("%s\n", bakeryName);
	}

}
