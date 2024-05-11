/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * A class that provides methods to search in an array using different
 * search algorithms: binary search and linear search.
 * Student Name: Rian Olson
 * Student Number: 041073915
 * Section number: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Rian Olson
 * 
  */

public class Searching {
    

    /**
     * Performs a binary search on a sorted array.
     *
     * @param arr The array to be searched.
     * @param l   The leftmost index of the subarray that is being searched.
     * @param r   The rightmost index of the subarray that is being searched.
     * @param x   The element to search for.
     * @return The index of the element if it is found in the array, otherwise -1.
     */
    public int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when the element is not present in array
        return -1;
    }

    /**
     * Performs a linear search on an array.
     *
     * @param arr The array to be searched.
     * @param l   The index to start the search from.
     * @param x   The element to search for.
     * @return The index of the element if it is found in the array, otherwise -1.
     */
    public int linearSearch(int arr[], int l, int x) {
        // If the array is empty, or we've searched the whole array and found nothing
        if (arr.length == l)
            return -1;

        // If we've found the element
        if (arr[l] == x)
            return l;

        // If we haven't found the element, go to the next index
        return linearSearch(arr, l + 1, x);
    }
}

