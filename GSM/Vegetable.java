package src;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a vegetable item in the inventory, extending the FoodItem class.
 */
public class Vegetable extends FoodItem {

	private String farmName;

	/**
	 * Constructs a new Vegetable object.
	 */
	public Vegetable() {

	}

	/**
	 * Returns a string representation of the vegetable item, including the farm
	 * name.
	 *
	 * @return The string representation of the vegetable item.
	 */
	@Override
	public String toString() {
		return super.toString() + " Farm name: " + farmName;
	}

	/**
	 * Adds a new vegetable item to the inventory, including the farm name.
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
				farmName = scanner.nextLine();
			}
			return true;
		} else {
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.nextLine();
			return true;
		}
	}

	/**
	 * Outputs the details of a vegetable item to a file in a formatted manner.
	 *
	 * @param formatter The Formatter object used to write to the file.
	 */
	@Override
	public void outputItem(Formatter formatter) {
		formatter.format("v\n");
		super.outputItem(formatter);
		formatter.format("%s\n", farmName);
	}

}
