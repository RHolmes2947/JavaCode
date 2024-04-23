import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class tests the BinaryLinearSearch class and does the menu processing
 * Student Name: Rian Olson
 * Student Number: 041073915
 * Section number: 302
 * Course: CST8130 - Data Structures
 * @author/Rian Olson
 */
 
/**
 * Class to test the BinaryLinearSearch class.
 */
public class Lab3BinLinSearchTest {
    /**
     * Main method to run the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryLinearSearch binaryLinearSearch = new BinaryLinearSearch();

        int choice;
        do {
            System.out.println("Select your option in the menu:");
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform recursive binary and linear search.");
            System.out.println("3. Perform iterative binary and linear search.");
            System.out.println("4. Exit.");
            System.out.print("> ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        binaryLinearSearch.generateRandomInts();
                        break;
                    case 2:
                        binaryLinearSearch.performBinarySearch();
                        break;
                    case 3:
                        binaryLinearSearch.performLinearSearch();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Enter option 1-4");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
                choice = 0;
            }
        } while (choice != 4);
    }
}
