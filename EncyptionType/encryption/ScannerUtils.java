/**
*the menu where you get and validate user input using a series of methods
* Student Name: Rian Olson
* Student Number: 041073915
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fedor Ilitchev
*
*/
package encryption;

import java.util.Scanner;

public class ScannerUtils {
	public static Scanner input = new Scanner(System.in);
	
	
	/**
	 * This method displays a menu of options to the user and returns the user's
	 * choice.
	 * @param options a list of menu options
	 * @return the user's choice
	 */
	public static int getMenuItem(String... options) {
		int choice = -1;
		boolean validInput = false;

		while (!validInput) {
			for (int i = 0; i < options.length; i++) {
				System.out.println((i + 1) + " - " + options[i]);

			}
			System.out.print("Select an action:");
			try {
				choice = Integer.parseInt(input.nextLine());
				if (choice < 1 || choice > options.length) {
					System.out.println("Please select a number in the range");
				} else {
					validInput = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer.");
			}
		}
		return choice;
	}

	/**
	 * This method prompts the user for a string and returns the string entered by
	 * the user.
	 * 
	 * @param prompt the prompt to display to the user
	 * @return the string entered by the user
	 */
	public static String getString(String prompt) {
		System.out.println(prompt);
		return input.nextLine();
	}
	/**
	 * This method prompts the user for an integer in a specified range and returns
	 * the integer entered by the user.
	 * 
	 * @param prompt the prompt to display to the user
	 * @param min    the minimum value of the integer
	 * @param max    the maximum value of the integer
	 * @return the integer value entered by the user
	 */
	public static int getInt(String prompt, int min, int max) {
		int value = -1;
		while (value < min || value > max) {
			System.out.println(prompt);
			try {
				value = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
		return value;
	}
}