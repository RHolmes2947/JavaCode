package src;

import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class demonstrates the menu processing 
 * Student Name: Rian Olson
 * Student Number: 041073915
 * Section number: 302
 * Course: CST8130 - Data Structures
 * @author/Rian Olson
 * 
  */
/**
 * The Assign1 class represents the main program that manages the inventory of items.
 */
public class Assign2 {

    /**
     * The main method that executes the inventory management program.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice = 0;
        while (choice != 8) {
            displayMenu();
            System.out.print("> ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid choice. chose between 1-8");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    inventory.addItem(scanner);
                    break;
                case 2:
                    System.out.println(inventory);
                    break;
                case 3:
                    if (inventory.inventory.isEmpty()) {
                        System.out.println("Error... Could not buy item. Inventory is empty.");
                    } else {
                        System.out.print("Enter the item code: ");
                        int itemCode = scanner.nextInt();
                        scanner.nextLine(); 

                        int quantity = 0;
                        while (quantity <= 0) {
                            System.out.print("Enter the quantity to buy: ");
                            if (scanner.hasNextInt()) {
                                quantity = scanner.nextInt();
                                scanner.nextLine(); 

                                if (quantity <= 0) {
                                    System.out.println("Invalid quantity. Please enter a positive number.");
                                }
                            } else {
                                System.out.println("Invalid quantity. Please enter a valid number.");
                                scanner.nextLine();
                            }
                        }

                        boolean success = inventory.updateQuantity(itemCode, quantity, true);
                        if (success) {
                            System.out.println("Item(s) purchased successfully.");
                        } else {
                            System.out.println("Error... Could not buy item. Insufficient quantity in stock.");
                        }
                    }
                    break;
                case 4:
                    if (inventory.inventory.isEmpty()) {
                        System.out.println("Error... Could not sell item. Inventory is empty.");
                    } else {
                        System.out.print("Enter the item code: ");
                        int itemCode = scanner.nextInt();
                        scanner.nextLine(); 

                        int quantity = 0;
                        while (quantity <= 0) {
                            System.out.print("Enter the quantity to sell: ");
                            if (scanner.hasNextInt()) {
                                quantity = scanner.nextInt();
                                scanner.nextLine(); 

                                if (quantity <= 0) {
                                    System.out.println("Invalid quantity. Please enter a positive number.");
                                }
                            } else {
                                System.out.println("Invalid quantity. Please enter a valid number.");
                                scanner.nextLine(); 
                            }
                        }

                        boolean success = inventory.updateQuantity(itemCode, quantity, false);
                        if (success) {
                            System.out.println("Item(s) sold successfully.");
                        } else {
                            System.out.println("Error... Could not sell item. Insufficient quantity in stock.");
                        }
                    }
                    break;
                case 5:
                    inventory.searchForItem(scanner);
                    break;
                case 6:
                    inventory.saveToFile(scanner);
                    break;
                case 7:
                    inventory.readFromFile(scanner);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. choose between 1-8");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Displays the menu options for the inventory management program.
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Item to Inventory");
        System.out.println("2: Display Current Inventory");
        System.out.println("3: Buy Item(s)");
        System.out.println("4: Sell Item(s)");
        System.out.println("5: search for item");
        System.out.println("6: Save Inventory to File");
        System.out.println("7: Read Inventory From File");
        System.out.println("8: Exit");
    }
}
