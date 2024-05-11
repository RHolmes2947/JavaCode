
/**
 * This class does all of the operations and returns the new matricies
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 24, 2023
 *
 */
package lab3.matrices;

import java.util.Arrays;

public class Matrix {
	//instance variables
	protected double[][] array;
	protected int rows;
	protected int columns;

	// constructor
	// creates a zero matrix of the given number of rows and columns
	public Matrix(int rows, int cols) {
		this.array = new double[rows][cols];
		this.rows = rows;
		this.columns = cols;
	}

	
	// constructor
	// creates a 2d empty array
	public Matrix(double[][] array) {
		this.array = array;
		this.rows = array.length;
		this.columns = array[0].length;

		this.array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.array[i][j] = array[i][j];
			}
		}
	}
	// Addition method.
	// In this method first set Array as a new double for the rows and the columns.
	// I then use a nested forloop to traverse the array to get the values for the
	// matrix
	public Matrix add(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] + matrix.array[i][j];

			}
		}

		return new Matrix(array);
	}
	// Subtraction method
	// This method is basically the same as my addition method
	// the one change is the 2 matrices are being subtracted
	public Matrix sub(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] - matrix.array[i][j];

			}
		}
		return new Matrix(array);

	}
	// Multiplication method
	// This method is basically the same as my addition method
	// the one change is the 2 matrices are being multiplied
	public Matrix mult(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] * matrix.array[i][j];

			}
		}
		return new Matrix(array);

	}
	// a method to get the summation of all of the matrix elements
	// I use a nested forloop to get the values for an array then
	// set the sum variable as the sum of all of the values in the forloop
	public double sum() {
		double sum = 0d;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum += this.array[i][j];
			}
		}
		return sum;
	}

	// A method to get the submatrix
	// this method takes certain rows from a bigger matrix
	// to make a smaller submatrix
	public Matrix subMatrix(int i, int j, int length, int width) {
		double[][] array = new double[length][width];
		for (int row = i; row < i + length; row++) {
			for (int column = j; column < j + width; column++) {
				array[row - i][column - j] = this.array[row][column];
			}
		}
		return new Matrix(array);

	}

	public String toString() {
		StringBuffer result = new StringBuffer();

		for (double[] row : array) {
			result.append(Arrays.toString(row));
			result.append('\n');
		}

		return result.toString();
	}

}
