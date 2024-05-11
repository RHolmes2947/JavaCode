
/**
 * Class to do the convolution calculation
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 24, 2023
 *
 */
package lab3.matrices;

public class Convolution {

	// instance variable
	Matrix kernel;

	// making a kernel matrix to be used in calculation
	public Convolution(Matrix kernel) {
		this.kernel = kernel;
	}

// method to do the actual convolution calculation
	public Matrix filter(Matrix image) {
		int rows = image.rows - kernel.rows + 1;
		int columns = image.columns - kernel.columns + 1;
		double[][] outputImage = new double[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				// making the submatrix and multiplying the submatrix by the kernel
				Matrix subMatrix = image.subMatrix(r, c, kernel.columns, kernel.rows);
				Matrix multipliedMatrix = subMatrix.mult(kernel);
				outputImage[r][c] = multipliedMatrix.sum();
			}
		}

		return new Matrix(outputImage);
	}

}
