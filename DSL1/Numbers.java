import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] values;
	private int size;
	private int numItems;

	/**
	 * Store the number of items currently in the array.
	 */

	/**
	 * Default Constructor
	 * 
	 */
	public Numbers() {

		size = 3;
		numItems = 0;
		values = new Float[size];

		/**
		 * Constructor that initializes the numbers array.
		 * 
		 * @param size - Max size of the numbers array
		 */
	}

	public Numbers(int size) {
		this.size = size;
		numItems = 0;
		values = new Float[size];

	}

	public void addValue(Scanner scanner, float value) {
		if (numItems < size) {
			values[numItems] = value;
			numItems++;
		} else {
			System.out.println("Array is full. Cannot add more values.");
		}
	}

	/**
	 * This method initializes a variable for the sum then loops through the array
	 * values and adds up all the numbers. The average is then calculated by
	 * dividing the sum by the number of items in the array, rounding to 2 decimal
	 * places, then dividing by 100 to move the decimal point back to the correct
	 * place.
	 * 
	 * @return float value that represents the average
	 */

	public float calcAverage() {
		if (numItems == 0) {
			return 0;
		}

		float sum = 0;
		for (int i = 0; i < numItems; i++) {
			sum += values[i];
		}

		return Math.round((sum / numItems) * 100) / 100f;
	}

	/**
	 * This method finds the minimum and maximum values in an array. It sets the
	 * minimum and maximum values as the first value in the array. It then loops
	 * through the array, updating the minimum and maximum values if a smaller or
	 * larger value is found. After looping through the array, it calculates the
	 * result of the modulo operation of the maximum value and the minimum value. It
	 * then returns a string containing the minimum value, maximum value.
	 * 
	 * @return a String containing the minimum value, maximum value, and modulus of
	 *         max and min values
	 */
	public String findMinMax() {
		if (numItems == 0) {
			return "No values in the array.";
		}

		float min = values[0];
		float max = values[0];
		for (int i = 1; i < numItems; i++) {
			if (values[i] < min) {
				min = values[i];
			}
			if (values[i] > max) {
				max = values[i];
			}
		}

		float result = max % min;
		return String.format("Minimum is: %.2f, Maximum is: %.2f, Mod(Max, Min): %.2f", min, max, result);
	}

	/**
	 * This method calculates the factorial of the maximum value in the array. First
	 * the maximum value in the array is found, then its factorial is calculated by
	 * multiplying all numbers from the maximum value down to 1. The method then
	 * returns the factorial as an integer.
	 * 
	 * @return the factorial of the maximum value
	 */
	public int getFactorialMax() {
		if (numItems == 0) {
			return 0;
		}

		float max = values[0];
		for (int i = 1; i < numItems; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}

		int intMax = Math.round(max);
		int factorial = 1;
		for (int i = intMax; i > 0; i--) {
			factorial *= i;
		}

		return factorial;
	}

	/**
	 * Returns a string representation of the array.
	 *
	 * @return The string representation of the array.
	 */
	@Override
	public String toString() {
		String result = "Numbers are:\n";
		for (int i = 0; i < numItems; i++) {
			result += values[i] + "\n";
		}
		return result;
	}

	/**
	 * Adds multiple values to the array. If there is not enough room in the array
	 * to add all values, it will display a message indicating that there is no
	 * room.
	 *
	 * @param scanner The scanner object used for user input.
	 */
	public void addMultipleValues(Scanner scanner) {
		System.out.print("How many values do you wish to add? ");
		int numValues = scanner.nextInt();
		scanner.nextLine();

		if (numItems + numValues > values.length) {
			System.out.println("No room in the array to add all values.");
			return;
		}

		for (int i = 0; i < numValues; i++) {
			System.out.print("Enter value: ");
			float value = scanner.nextFloat();
			scanner.nextLine();
			addValue(scanner, value);
		}
	}

	/**
	 * Reads values from a file and adds them to the array. The file should contain
	 * the number of values followed by each value on a new line.
	 *
	 * @param fileName The name of the file to read values from.
	 */
	public void readValuesFromFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);

			int numValues = scanner.nextInt();
			scanner.nextLine();

			for (int i = 0; i < numValues; i++) {
				float value = scanner.nextFloat();
				scanner.nextLine();
				addValue(scanner, value);
			}

			scanner.close();
			System.out.println("Values read from file successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (InputMismatchException e) {
			System.out.println("Invalid data format in file: " + fileName);
		}
	}

	/**
	 * Saves the values in the array to a file. The file will contain the number of
	 * values followed by each value on a new line.
	 *
	 * @param fileName The name of the file to save the values to.
	 */
	public void saveValuesToFile(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName);

			writer.println(numItems);
			for (int i = 0; i < numItems; i++) {
				writer.println(values[i]);
			}

			writer.close();
			System.out.println("Values saved to file successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Error saving values to file: " + e.getMessage());
		}
	}
}
