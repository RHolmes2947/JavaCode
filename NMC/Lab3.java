
/**
 * Method main
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 24, 2023
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import lab3.matrices.Convolution;
import lab3.matrices.FileMatrix;
import lab3.matrices.Matrix;
import lab3.matrices.NamedMatrix;

/**
 * This class provides the driver of the image processing application
 *
 * @author rosenbh
 *
 */
public class Lab3 {

	/**
	 * Fields Description: Kernels that can be used to do image processing based on
	 * https://en.wikipedia.org/wiki/Kernel_(image_processing)
	 * 
	 * kernels Array of convolution kernels
	 */
	private NamedMatrix[] kernels = {
			new NamedMatrix("identity", new double[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }),

			new NamedMatrix("ridge", new double[][] { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } }),

			new NamedMatrix("sharpen", new double[][] { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } }),

			new NamedMatrix("unsharpen masking 5x5",
					new double[][] { { -1.0 / 256, -1.0 / 64, -3.0 / 128, -1.0 / 64, -1.0 / 256 },
							{ -1.0 / 64, -16.0 / 256, -3.0 / 64, -16.0 / 256, -1.0 / 64 },
							{ -3.0 / 128, -3.0 / 64, 119.0 / 64, -3.0 / 64, -6.0 / 256 },
							{ -1.0 / 64, -16.0 / 256, -3.0 / 64, -16.0 / 256, -1.0 / 64 },
							{ -1.0 / 256, -1.0 / 64, -3.0 / 128, -1.0 / 64, -1.0 / 256 } }),

			new NamedMatrix("laplace", new double[][] { // ridge + identity
					{ -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } }) };

	/**
	 * Description: Method that opens a dialog box to load an image file
	 * 
	 * @return The selected File. If the dialog box is canceled, a non existent File
	 *         is returned
	 */
	public File getImageFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		File file;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			System.out.println("You chose to open this file: " + file.getAbsolutePath());
		} else {
			file = new File("noneExistent");
			System.out.println("No file chosen");
		}
		return file;
	}

	/**
	 * Description: Method that returns the selected kernel. This method handled all
	 * invalid kernel selections
	 * 
	 * @return A NamedMatrix of the kernel
	 */
	private NamedMatrix getKernel() {

		Scanner input = new Scanner(System.in);
		// Display prompts and list of kernels
		int choice = 0;
		int userkernel = 0;
		// Get user input
		System.out.println("Select a value in the range. Please select one of the following");
		System.out .println("1 Identity \n" + "2 Ridge \n" + "3 sharpen \n" + "4 unsharpen masking 5x5 \n" + "5 laplace");
		System.out.println("Select a filter");
		choice = input.nextInt();

		while (choice < 0 || choice >= 5) {
			//checking for user input
			try {

				if (choice < 1 || choice > 5) {
					System.out.println("Number must be between 1 and 5. Please try again.");
					break;
				} else if (input.hasNextInt()) {
					System.out.println("Please enter a number");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer between 1 and 5.");
			}
			
			
		}
		// switch case to select the correct value of the array for kernel
		switch (choice) {
		case 1:
			userkernel = 0;
		case 2:
			userkernel = 1;
		case 3:
			userkernel = 2;
		case 4:
			userkernel = 3;
		case 5:
			userkernel = 4;

		}
// Returning the kernel value
		return kernels[userkernel];

		

		// Select kernel from input

	}

	/**
	 * Description: Entry point for the application. Gets an image file and selects
	 * kernel then applies filter to the image and saves the file
	 * 
	 * @param args Commandline parameters, not used
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Lab3 lab3 = new Lab3();

		double[][] grd = {{1,2},{3,4},{5,6}};
		Matrix m = new Matrix(grd);
		FileMatrix fm = new FileMatrix(m);
		fm.save(new File("grd.txt"));
		
		
		// Choose image file
		File imageFile = lab3.getImageFile();
		if (!imageFile.exists())
			return;

		// Choose kernel
		NamedMatrix kernel = lab3.getKernel();

		try {
			// Create filtered image using original image and kernal
			Matrix originalImage = new FileMatrix(imageFile);
			Convolution convolve = new Convolution(kernel);
			FileMatrix filteredImage = new FileMatrix(convolve.filter(originalImage));

			// Save filtered image in a file named:
			// "image file name" "-" "kernel name" "." "image file extension"
			String fileName = imageFile.getAbsolutePath();
			int dot = fileName.indexOf('.');
			String output = fileName.substring(0, dot) + "-" + kernel.getName() + fileName.substring(dot);
			File outputFile = new File(output);
			if (filteredImage.save(outputFile))
				System.out.println("File: " + output + " succesfully written");
			else
				System.out.println("Could not write file: " + output);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file: " + imageFile.getAbsolutePath());
		}

	}

}
