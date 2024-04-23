import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author/Rian Olson
 * 
  */

public class Lab2 {
	/**

	This method is the entry point for running the Numbers program. It prompts 
	the user for input and performs the requested actions on the Numbers object.
	@param args the command-line arguments (not used)
	*/
    public static void main(String[] args) {
        Numbers numbers = null;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = readIntegerInput(scanner);
            switch (choice) {
                case 1:
                    numbers = new Numbers();
                    System.out.println("Default array initialized.");
                    break;
                case 2:
                    int size = 0;
                    while (size <= 0) {
                        System.out.print("Enter the max size of the array: ");
                        size = readIntegerInput(scanner);
                        if (size <= 0) {
                            System.out.println("Invalid input. Please enter a positive integer.");
                        }
                    }
                    numbers = new Numbers(size);
                    System.out.println("Array of size " + size + " initialized.");
                    break;
                case 3:
                    if (numbers != null) {
                        System.out.print("Enter value: ");
                        float value = readIntegerInput(scanner);
                        numbers.addValue(scanner, value);
                    } else {
                        System.out.println("Array is not initialized.");
                    }
                    break;
                case 4:
                    if (numbers != null) {
                        System.out.println(numbers.toString());
                    } else {
                        System.out.println("Array is empty.");
                    }
                    break;
                case 5:
                    if (numbers != null) {
                        float average = numbers.calcAverage();
                        String minMaxMod = numbers.findMinMax();
                        int factorialMax = numbers.getFactorialMax();
                        System.out.println("Average is: " + average);
                        System.out.println(minMaxMod);
                        System.out.println("Factorial of Max value: " + factorialMax);
                    } else {
                        System.out.println("Array is not initialized.");
                    }
                    break;
                case 6:
                    if (numbers != null) {
                        numbers.addMultipleValues(scanner);
                    } else {
                        System.out.println("Array is not initialized.");
                    }
                    break;
                case 7:
                    if (numbers != null) {
                        System.out.print("Enter the filename: ");
                        String fileName = scanner.next();
                        numbers.readValuesFromFile(fileName);
                    } else {
                        System.out.println("Array is not initialized.");
                    }
                    break;
                case 8:
                    if (numbers != null) {
                        System.out.print("Enter the file name: ");
                        String fileName = scanner.next();
                        numbers.saveValuesToFile(fileName);
                    } else {
                        System.out.println("Array is not initialized.");
                    }
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input, enter options 1-9");
                    break;
            }
        }

        scanner.close();
    }
	/**
	This method prompts the user for an integer input and returns the integer value entered by the user.
	If the user enters a non-integer value, the method will continue to prompt the user until a valid integer is entered.
	@param scanner the Scanner object used to read user input
	@return the integer value entered by the user
	*/
    private static int readIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer value.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
    This method displays the main menu options to the user.
    */
    private static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: Specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display the average of the values, minimum value, maximum value, maxValue mod minValue, maxFactorial");
        System.out.println("6: Enter multiple values");
        System.out.println("7: Read values from a file");
        System.out.println("8: Save values to a file");
        System.out.println("9: Exit");
        System.out.print("> ");
    }
}

