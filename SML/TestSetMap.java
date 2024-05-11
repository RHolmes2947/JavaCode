import java.util.Scanner;
/**
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name: Rian Olson
 * Student ID: 041073915
 * Program: Computer Engineering technology - Computing Science
 * Course: CST 8130
 * Lab Section: 302
 * @author Rian Olson
 */


/**
 * This class is used to demonstrate the usage of SetMapLib.
 */
public class TestSetMap {
    /**
     * The main method of the program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        SetMapLib setMapLib = new SetMapLib(); // Create an instance of SetMapLib
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        boolean exit = false;

        while (!exit) {
            displayMenu(); // Display the menu options
            int choice = scanner.nextInt(); // Read the user's choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    setMapLib.createTreeMapFromFile("productowners.txt"); // Create a TreeMap from a file
                    break;
                case 2:
                    setMapLib.displayTreeMap(); // Display the TreeMap
                    break;
                case 3:
                    System.out.print("Enter a key or value to search: ");
                    String searchTerm = scanner.nextLine();
                    setMapLib.searchKeyOrValue(searchTerm); // Search for a key or value in the TreeMap
                    break;
                case 4:
                    setMapLib.createKeysAndValuesTreeSet(); // Create and display keys TreeSet and values TreeSet from TreeMap
                    break;
                case 5:
                    setMapLib.sortValuesTreeSetDescending(); // Sort and display values TreeSet in descending order
                    break;
                case 6:
                    System.out.print("Enter new key-value data (e.g., Name, Key): ");
                    String newData = scanner.nextLine();
                    setMapLib.addNewDataToTreeMap(newData); // Add new key-value data to the TreeMap
                    break;
                case 7:
                    exit = true; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("...exiting...");
        scanner.close(); // Close the Scanner
    }

    /**
     * Displays the menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("1. Create a TreeMap of data from the text file.");
        System.out.println("2. Display the TreeMap.");
        System.out.println("3. Search for a given key or value in the TreeMap.");
        System.out.println("4. Create and display a keys TreeSet and a values TreeSet from the TreeMap.");
        System.out.println("5. Sort and display values TreeSet in descending order.");
        System.out.println("6. Add new key-value data to the TreeMap.");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}
