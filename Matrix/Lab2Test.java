

/**
 * This class tests the Matrix class
 *
 * @author Rian Olson
 *
 */
public class Lab2Test {

	/**
	 * Description: Entry point for the application. Tests all the methods of Matrix
	 * class
	 * 
	 * @param args Commandline parameters, not used
	 */
	public static void main(String[] args) {

		Matrix matrix0 = new Matrix(4, 5);
		System.out.println("Matrix 0\n" + matrix0);

		double[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Matrix matrix1 = new Matrix(array1);
		array1[1][1] = 5; // test common error
		System.out.println("Matrix 1\n" + matrix1);

		Matrix matrix2 = new Matrix(new double[][] { { 1, 2, 3 }, { 2, 4, 6 }, { 3, 6, 9 } });
		System.out.println("Matrix 2\n" + matrix2);

		// add
		System.out.println("Matrix 1 + Matrix 2\n" + matrix1.add(matrix2));
		System.out.println("Matrix 2 + Matrix 1\n" + matrix2.add(matrix1));

		// subtract
		System.out.println("Matrix 1 - Matrix 2\n" + matrix1.sub(matrix2));
		System.out.println("Matrix 2 - Matrix 1\n" + matrix2.sub(matrix1));

		// multiply
		System.out.println("Matrix 1 * Matrix 2\n" + matrix1.mult(matrix2));
		System.out.println("Matrix 2 * Matrix 1\n" + matrix2.mult(matrix1));

		// sum
		System.out.printf("sum of Matrix 1 = %.2f%n", matrix1.sum());
		System.out.printf("sum of Matrix 2 = %.2f%n", matrix2.sum());
		System.out.printf("sum of (Matrix 1 * Matrix 2) = %.2f%n", matrix1.mult(matrix2).sum());
		System.out.printf("(sum of Matrix 1) * (sum of Matrix 2) = %.2f%n", matrix1.sum() * matrix2.sum());
		System.out.println();

		// submMatrix
		System.out.println("subMatrix(1,1,1,1) of Matrix 1\n" + matrix1.subMatrix(1, 1, 1, 1));
		System.out.println("subMatrix(1,1,2,1) of Matrix 1\n" + matrix1.subMatrix(1, 1, 2, 1));
		System.out.println("subMatrix(1,1,2,2) of Matrix 1\n" + matrix1.subMatrix(1, 1, 2, 2));

	}

}
