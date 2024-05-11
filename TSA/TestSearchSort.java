import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * A test driver class that provides functionalities for testing
 * different sorting and searching algorithms on an array of random integers.
 * Student Name: Rian Olson
 * Student Number: 041073915
 * Section number: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Rian Olson
 * 
  */

public class TestSearchSort {

    private static int[] randomArr = new int[1000];
    private static SortingAlgorithms sortAlgo = new SortingAlgorithms();
    private static Searching searchAlgo = new Searching();

    /**
     * The main method that provides a menu for the user to choose
     * between different functionalities.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect your option in the menu below:");
            System.out.println("1: Initialize and populate an array of 1000 random integers.");
            System.out.println("2: Perform a recursive binary search.");
            System.out.println("3: Perform recursive linear search.");
            System.out.println("4: Sort the array.");
            System.out.println("5: Quit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    randomArr = genRandomInts();
                    System.out.println("Generated array: " + Arrays.toString(randomArr));
                    break;
                case 2:
                    System.out.println("Enter the number to search:");
                    int number = input.nextInt();
                    System.out.println("Binary Search Index: " + searchAlgo.binarySearch(randomArr, 0, randomArr.length - 1, number));
                    break;
                case 3:
                    System.out.println("Enter the number to search:");
                    number = input.nextInt();
                    System.out.println("Linear Search Index: " + searchAlgo.linearSearch(randomArr, 0, number));
                    break;
                case 4:
                    sortMenu();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please enter a valid option.");
            }
        }
    }

    /**
     * Provides a submenu for the user to choose between different sorting
     * algorithms.
     */
    public static void sortMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nB. Bubble Sort");
        System.out.println("I. Insertion Sort");
        System.out.println("S. Selection Sort");
        System.out.println("M. Merge Sort");
        System.out.println("Q. Quick Sort");
        System.out.println("R. Return to main menu");

        char choice = input.next().charAt(0);
        int[] arrCopy;

        switch (choice) {
        case 'B':
            arrCopy = randomArr.clone();
            System.out.println("Unsorted array: " + Arrays.toString(arrCopy));
            long startTime = System.nanoTime();
            sortAlgo.BubbleSort(arrCopy);
            long endTime = System.nanoTime();
            System.out.println("Sorted array: " + Arrays.toString(arrCopy));
            System.out.println("Time taken for Bubble Sort in nanoseconds: " + (endTime - startTime));
            break;
            case 'I':
                arrCopy = randomArr.clone();
                System.out.println("Unsorted array: " + Arrays.toString(arrCopy));
                startTime = System.nanoTime();
                sortAlgo.InsertionSort(arrCopy);
                endTime = System.nanoTime();
                System.out.println("Sorted array: " + Arrays.toString(arrCopy));
                System.out.println("Time taken for Insertion Sort in nanoseconds: " + (endTime - startTime));
                break;
            case 'S':
                arrCopy = randomArr.clone();
                System.out.println("Unsorted array: " + Arrays.toString(arrCopy));
                startTime = System.nanoTime();
                sortAlgo.SelectionSort(arrCopy);
                endTime = System.nanoTime();
                System.out.println("Sorted array: " + Arrays.toString(arrCopy));
                System.out.println("Time taken for Selection Sort in nanoseconds: " + (endTime - startTime));
                break;
            case 'M':
                arrCopy = randomArr.clone();
                System.out.println("Unsorted array: " + Arrays.toString(arrCopy));
                startTime = System.nanoTime();
                sortAlgo.MergeSort(arrCopy, 0, arrCopy.length - 1);
                endTime = System.nanoTime();
                System.out.println("Sorted array: " + Arrays.toString(arrCopy));
                System.out.println("Time taken for Merge Sort in nanoseconds: " + (endTime - startTime));
                break;
            case 'Q':
                arrCopy = randomArr.clone();
                System.out.println("Unsorted array: " + Arrays.toString(arrCopy));
                startTime = System.nanoTime();
                sortAlgo.QuickSort(arrCopy, 0, arrCopy.length - 1);
                endTime = System.nanoTime();
                System.out.println("Sorted array: " + Arrays.toString(arrCopy));
                System.out.println("Time taken for Quick Sort in nanoseconds: " + (endTime - startTime));
                break;
            case 'R':
                return;
            default:
                System.out.println("Invalid option! Please enter a valid option.");
        }
    }
    /**
     * Generates an array of 1000 random integers between 120 and 1000 (exclusive).
     * 
     * @return The array of random integers.
     */
    public static int[] genRandomInts() {
        SecureRandom random = new SecureRandom();
        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 120 + random.nextInt(881); // generates a random number between 120 and 1000 exclusive
        }

        return arr;
    }
}

