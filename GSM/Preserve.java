package src;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a preserve item in the inventory, extending the FoodItem class.
 */
public class Preserve extends FoodItem {

	private int jarSize;

	/**
	 * Constructs a new Preserve object.
	 */
	public Preserve() {

	}

	/**
	 * Returns a string representation of the preserve item, including the jar size.
	 *
	 * @return The string representation of the preserve item.
	 */
	@Override
	public String toString() {
		return super.toString() + " Jar size: " + jarSize + "ML";
	}

	/**
	 * Adds a new preserve item to the inventory, including the jar size.
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
				jarSize = scanner.nextInt();
				scanner.nextLine();
			}
			return true;
		} else {
			System.out.print("Enter the name size of the jar in millimeters: ");
			jarSize = scanner.nextInt();
			return true;
		}
	}

	/**
	 * Outputs the details of a preserve item to a file in a formatted manner.
	 *
	 * @param formatter The Formatter object used to write to the file.
	 */
	@Override
	public void outputItem(Formatter formatter) {
		formatter.format("p\n");
		super.outputItem(formatter);
		formatter.format("%d\n", jarSize);
	}

}
