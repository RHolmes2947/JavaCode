import java.util.Arrays;
import java.util.Scanner;

public class BinaryLinearSearch {
    private int[] array;
    public Scanner scanner;

    /**
     * Constructs a new instance of BinaryLinearSearch.
     */
    public BinaryLinearSearch() {
        scanner = new Scanner(System.in);
    }

    /**
     * Performs iterative binary search on the sorted array.
     *
     * @param array     The array to search. Must be sorted in ascending order.
     * @param searchKey The number to search for.
     */
    public void iterativeBinarySearch(int[] array, int searchKey) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == searchKey) {
                index = mid;
                break;
            } else if (array[mid] < searchKey) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (index != -1) {
            System.out.println("Number " + searchKey + " found at index " + index + ": Iterative Binary Search");
        } else {
            System.out.println("Number " + searchKey + " was not found.");
        }
    }

    /**
     * Performs recursive binary search on the sorted array.
     *
     * @param array       The array to search. Must be sorted in ascending order.
     * @param firstIndex  The first index of the search range.
     * @param lastIndex   The last index of the search range.
     * @param searchKey   The number to search for.
     */
    public void recursiveBinarySearch(int[] array, int firstIndex, int lastIndex, int searchKey) {
        Arrays.sort(array); 
        int mid = (firstIndex + lastIndex) / 2;

        if (firstIndex <= lastIndex) {
            if (array[mid] == searchKey) {
                System.out.println("Number " + searchKey + " found at index " + mid + ": Recursive Binary Search");
            } else if (array[mid] < searchKey) {
                recursiveBinarySearch(array, mid + 1, lastIndex, searchKey);
            } else {
                recursiveBinarySearch(array, firstIndex, mid - 1, searchKey);
            }
        } else {
            System.out.println("Number " + searchKey + " was not found.");
        }
    }

    /**
     * Generates an array of 32 random integers.
     *
     * @return The generated array of random integers.
     */
    public int[] generateRandomInts() {
        if (array == null) {
            array = new int[32];

            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }

            System.out.println("Unsorted Random Array: " + Arrays.toString(array));
            Arrays.sort(array);
            System.out.println("Sorted Random Array: " + Arrays.toString(array));
        }

        return array;
    }

    /**
     * Prints the remaining elements of the array.
     *
     * @param array The array to print.
     */
    public void remainingElements(int[] array) {
        int numElements = array.length;

        for (int i = 0; i < numElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Performs iterative linear search on the array.
     *
     * @param array     The array to search.
     * @param searchKey The number to search for.
     */
    public void iterativeLinearSearch(int[] array, int searchKey) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchKey) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Number " + searchKey + " found at index " + index + ": Iterative Linear Search");
        } else {
            System.out.println("Number " + searchKey + " was not found.");
        }
    }

    /**
     * Performs recursive linear search on the array.
     *
     * @param array     The array to search.
     * @param size      The number of elements in the array.
     * @param searchKey The number to search for.
     */
    public void recursiveLinearSearch(int[] array, int size, int searchKey) {
        if (size == 0) {
            System.out.println("Number " + searchKey + " was not found.");
            return;
        }

        if (array[size - 1] == searchKey) {
            System.out.println("Number " + searchKey + " found at index " + (size - 1) + ": Recursive Linear Search");
        } else {
            recursiveLinearSearch(array, size - 1, searchKey);
        }
    }

    /**
     * Performs binary search operations.
     * Generates a random array, prompts for a search key, and performs iterative and recursive binary searches.
     */
    public void performBinarySearch() {
        int[] array = generateRandomInts();

        System.out.print("Enter the number to search: ");
        int searchKey = scanner.nextInt();

       
        remainingElements(array);

        long startTime = System.nanoTime();
        iterativeBinarySearch(array, searchKey);
        long endTime = System.nanoTime();
        long elapsedTimeNano = endTime - startTime;
        long elapsedTimeMilli = elapsedTimeNano / 1_000_000;
        System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
        System.out.println("Time taken in milliseconds: " + elapsedTimeMilli);

        startTime = System.nanoTime();
        recursiveBinarySearch(array, 0, array.length - 1, searchKey);
        endTime = System.nanoTime();
        elapsedTimeNano = endTime - startTime;
        elapsedTimeMilli = elapsedTimeNano / 1_000_000;
        System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
        System.out.println("Time taken in milliseconds: " + elapsedTimeMilli);
    }

    /**
     * Performs linear search operations.
     * Generates a random array, prompts for a search key, and performs iterative and recursive linear searches.
     */

    public void performLinearSearch() {
        int[] array = generateRandomInts();

        System.out.print("Enter the number to search: ");
        int searchKey = scanner.nextInt();


        remainingElements(array);

        long startTime = System.nanoTime();
        iterativeLinearSearch(array, searchKey);
        long endTime = System.nanoTime();
        long elapsedTimeNano = endTime - startTime;
        long elapsedTimeMilli = elapsedTimeNano / 1_000_000;
        System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
        System.out.println("Time taken in milliseconds: " + elapsedTimeMilli);

        startTime = System.nanoTime();
        recursiveLinearSearch(array, array.length, searchKey);
        endTime = System.nanoTime();
        elapsedTimeNano = endTime - startTime;
        elapsedTimeMilli = elapsedTimeNano / 1_000_000;
        System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
        System.out.println("Time taken in milliseconds: " + elapsedTimeMilli);
    }
}
