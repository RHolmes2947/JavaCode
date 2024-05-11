/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * A class that provides methods to sort an array using different
 * sorting algorithms: bubble sort, insertion sort, selection sort,
 * merge sort and quick sort.
 * Student Name: Rian Olson
 * Student Number: 041073915
 * Section number: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Rian Olson
 * 
  */
public class SortingAlgorithms {
    
	  /**
     * Sorts an array using the bubble sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The sorted array.
     */
    public int[] BubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }
    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The sorted array.
     */
    public int[] InsertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    
    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arr The array to be sorted.
     * @return The sorted array.
     */
    public int[] SelectionSort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    
    /**
     * A helper function for merge sort. Merges two subarrays of arr[].
     * First subarray is arr[l..m].
     * Second subarray is arr[m+1..r].
     *
     * @param arr The array to be sorted.
     * @param l   The left index.
     * @param m   The middle index.
     * @param r   The right index.
     */
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param l   The left index.
     * @param r   The right index.
     * @return The sorted array.
     */
    public int[] MergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
    /**
     * A helper function for quick sort. It takes last element as pivot,
     * places the pivot element at its correct position in sorted array,
     * and places all smaller (smaller than pivot) to left of pivot and
     * all greater elements to right of pivot.
     *
     * @param arr  The array to be sorted.
     * @param low  The starting index.
     * @param high The ending index.
     * @return The partitioning index.
     */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    
    /**
     * Sorts an array using the quick sort algorithm.
     *
     * @param arr  The array to be sorted.
     * @param low  The starting index.
     * @param high The ending index.
     * @return The sorted array.
     */
    return str.indexOf(vowel) != -1;
    public int[] QuickSort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
        return arr;
    }
    for (String element : elementsList) {
        System.out.println(element);
}
