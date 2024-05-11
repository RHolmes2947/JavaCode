
/**
 * Reading in a matrix to a text file
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 24, 2023
 *
 */
package lab3.matrices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileMatrix extends Matrix {

//importing scanner for other constructors to use
	public FileMatrix(Scanner input) {
		super(input.nextInt(), input.nextInt());
	}

// creating a file matrix from a file
	public FileMatrix(File file) throws FileNotFoundException {
		this(new Scanner(file));

	}

// creating a fileMatrix from an existing file
	public FileMatrix(Matrix matrix) {
		super(matrix.columns, matrix.rows);
	}

// method to save a matrix to a text file
// sets the printwriter to outputfile and then writes out a matrix
// into a text file and then uses the rows, columns and array from the 
// matrix class.
	 public boolean save(File outputFile) throws FileNotFoundException {
	       try {
	            PrintWriter writer = new PrintWriter(outputFile);
	            writer.println(rows + " " + columns);
	            for (int i = 0; i < rows; i++) {
	                for (int j = 0; j < columns; j++) {
	                    writer.print(array[i][j] + " ");
	                }
	                writer.println();
	            }
	            writer.close();
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	



	}


