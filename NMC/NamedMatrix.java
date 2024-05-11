
/**
 * Makes a matrix with a name
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 24, 2023
 *
 */
package lab3.matrices;

public class NamedMatrix extends Matrix {

	// instance variable
	String Name;

	// Constructor to create a matrix and to input a 2d array
	public NamedMatrix(String name, double[][] array) {
		super(array);
		this.Name = name;
	}

	// getter for name
	public String getName() {
		return Name;
	}

}
