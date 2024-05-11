package src;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a fruit item in the inventory, extending the FoodItem class.
 */
public class Fruit extends FoodItem {

	private String orchardName;

	/**
	 * Constructs a new Fruit object.
	 */
	public Fruit() {

	}

	/**
	 * Returns a string representation of the fruit item, including the orchard
	 * supplier.
	 *
	 * @return The string representation of the fruit item.
	 */
	@Override
	public String toString() {
		return super.toString() + " orchard supplier: " + orchardName;
	}

	/**
	 * Adds a new fruit item to the inventory, including the orchard supplier.
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
				orchardName = scanner.nextLine();
			}
			return true;
		} else {
			System.out.print("Enter the name of the orchard supplier: ");
			orchardName = scanner.nextLine();
			return true;
		}
	}

	/**
	 * Outputs the details of a Fruit item to a file in a formatted manner.
	 *
	 * @param formatter The Formatter object used to write to the file.
	 */
	@Override
	public void outputItem(Formatter formatter) {
		formatter.format("f\n");
		super.outputItem(formatter);
		formatter.format("%s\n", orchardName);
	}

}
