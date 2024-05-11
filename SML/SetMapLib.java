import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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
 * This class provides utility methods for manipulating a TreeMap.
 */
public class SetMapLib {
    private TreeMap<Integer, String> treeMap;

    /**
     * Creates a TreeMap from data in a file.
     *
     * @param filename The name of the file containing the data.
     */
    public void createTreeMapFromFile(String filename) {
        treeMap = new TreeMap<>(); // New treemap object
        try {
            File file = new File(filename);	// sets variable for file
            Scanner scanner = new Scanner(file); // scans file
            while (scanner.hasNextLine()) { 
                String line = scanner.nextLine(); 
                String[] parts = line.split(", ");
                int key = Integer.parseInt(parts[1]); // parses the second key in the parts array
                String value = parts[0]; // sets value to the first value in the parts array
                treeMap.put(key, value); // add the value from the file to the treemap
            }
            System.out.println("...TreeMap created...");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    /**
     * Displays the contents of the TreeMap.
     */
    public void displayTreeMap() {
        if (treeMap.isEmpty()) { // checking if the treemap is empty 
            System.out.println("TreeMap is empty.");
        } else {
            for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {  // Formatting tree
                System.out.println(entry.getKey() + ": " + entry.getValue()); // Printing the contents of the tree
            }
        }
    }

    /**
     * Searches for a given key or value in the TreeMap.
     *
     * @param searchTerm The key or value to search for.
     */
    public void searchKeyOrValue(String searchTerm) {
        boolean found = false; // Setting new variable
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) { 
            if (entry.getKey().toString().equals(searchTerm) || entry.getValue().equals(searchTerm)) { // searching for the values
                System.out.println("Found: " + entry.getKey() + ": " + entry.getValue()); // Values found and printed
                found = true;
            }
        }
        if (!found) { // value not found
            System.out.println("Not found: " + searchTerm);
        }
    }

    /**
     * Creates and displays a TreeSet of keys and a TreeSet of values from the TreeMap.
     */
    public void createKeysAndValuesTreeSet() {
        TreeSet<Integer> keysSet = new TreeSet<>(treeMap.keySet()); // Creates an integer keyset
        TreeSet<String> valuesSet = new TreeSet<>(treeMap.values()); // Creates a string keyset

        System.out.println("Keys TreeSet: " + keysSet);
        System.out.println("Values TreeSet: " + valuesSet);
    }

    /**
     * Sorts and displays the values of the TreeMap in descending order.
     */
    public void sortValuesTreeSetDescending() {
        TreeSet<String> valuesSet = new TreeSet<>(Collections.reverseOrder()); // Sorting the values
        valuesSet.addAll(treeMap.values()); // formatting the values in the treemap

        System.out.println("Values TreeSet sorted in descending order: " + valuesSet);
    }

    /**
     * Adds new key-value data to the TreeMap.
     *
     * @param newData The new data to add in the format "Value, Key".
     */
    public void addNewDataToTreeMap(String newData) {
        String[] parts = newData.split(", "); // formatting the values
        int key = Integer.parseInt(parts[1]); 
        String value = parts[0];
        treeMap.put(key, value); // adding the values
        System.out.println("Data added to TreeMap.");
    }

    /**
     * Returns the TreeMap.
     *
     * @return The TreeMap.
     */
    public TreeMap<Integer, String> getTreeMap() {
        return treeMap; // returning a treemap
    }
}
