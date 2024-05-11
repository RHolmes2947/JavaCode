import java.util.Arrays;

//Instance variables
public class Matrix {
	double array[][];
	int rows;
	int columns;

	// constructors
	public Matrix(int rows, int cols) {
		this.array = new double[rows][cols];
		this.rows = rows;
		this.columns = cols;
	}

//constructors
	public Matrix(double[][] array) {
		this.array = array;
		this.rows = array.length;
		this.columns = array[0].length;
	}

	public Matrix add(Matrix matrix2) {
		double[][] Array = new double[matrix2.array.length][matrix2.array[0].length];
		for (int i = 0; i < matrix2.array.length; i++) {
			for (int j = 0; j < matrix2.array[i].length; j++) {
				Array[i][j] +=this.array[i][j] + matrix2.array[i][j];
			}
		}
	Matrix result = new Matrix(this.rows, this.columns);
	result.array = Array;
	return result;
	}

	public Matrix sub(Matrix matrix2) {
		double[][] Array = new double[matrix2.array.length][matrix2.array[0].length];
		for (int i = 0; i < matrix2.array.length; i++) {
			for (int j = 0; j < matrix2.array[i].length; j++) {
			Array[i][j] -=this.array[i][j] - matrix2.array[i][j];
			}
		}
		Matrix result = new Matrix(this.rows, this.columns);
		result.array = Array;
		return result;
	}

	public Matrix mult(Matrix matrix1) {
		int newCols = this.columns;
		int newRows = this.rows;
		double[][] Array = new double[newRows][newCols];
		for (int i = 0; i < newRows; i++) {
			for (int j = 0; j < newCols; j++) {
				double[] row = matrix1.array[i];
				double result = 0d;
				for (int k = 0; k < row.length; k++) {
					result += this.array[i][k];
				}
				Array[i][j] = result;
			}
		}
		Matrix result = new Matrix(newRows, newCols);
		result.array = Array;
		return result;
	}

	public double sum() {
		double sum = 0d;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum += this.array[i][j];
			}
		}
		return sum;
	}

	public Matrix subMatrix(int i, int j, int k, int l) {
		double[][] Array = new double[k][l];
		for (int a = i; a < i + k; a++) {
			for (int b = j; b < j + l; b++) {
				Array[a - i][b - j] = this.array[a][b];
			}
		}
		Matrix result = new Matrix(k, l);
		result.array = Array;
		return result;
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
