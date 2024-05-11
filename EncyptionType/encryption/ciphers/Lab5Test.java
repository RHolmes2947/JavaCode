
/**
*the menu where you encrypt and decrypt text using the other classes.
* Student Name: Rian Olson
* Student Number: 041073915
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fedor Ilitchev
*
*/

package encryption.ciphers;

import java.util.ArrayList;

import encryption.EncryptionType;
import encryption.ScannerUtils;

public class Lab5Test {
	/**
	 * The main method runs a loop that allows the user to choose between encrypting text, decrypting text,
	 * displaying the encrypted list or exiting the program.
	 * 
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		System.out.println("encryption tester");
		ArrayList<String> encryptedText = new ArrayList<>();
		
		boolean exit = false;

		while (!exit) {
			int choice = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

			switch (choice) {
			case 1:
				String textToEncrypt = ScannerUtils.getString("Enter text to encrypt:");
				EncryptionType encryptionMethod = EncryptionType.getMethod();
				String encrypted = encryptionMethod.encrypt(textToEncrypt);
				encryptedText.add(encrypted);
				System.out.println("\nEncrypted text: " + encrypted + "\n");
				break;
			case 2:
				if (encryptedText.isEmpty()) {
					System.out.print("Nothing to decrypt.\n");
				} else {
					int index = ScannerUtils.getInt("Enter index of text to decrypt:", 0, encryptedText.size()-1);
					EncryptionType decryptionMethod = EncryptionType.getMethod();
					String decrypted = decryptionMethod.decrypt(encryptedText.get(index));
					System.out.println("\nDecrypted text: " + decrypted + "\n");
				}
				break;
			case 3:
				if (encryptedText.isEmpty()) {
					System.out.print("Nothing to display.\n");
				} else {
					System.out.print("------------");
					System.out.println("\nEncrypted list:");
					for (int i = 0; i < encryptedText.size(); i++) {
						System.out.println(i+1 + ": " + encryptedText.get(i));

					}
					System.out.println("------------");
					System.out.println();
				}
				break;
			case 4:
				exit = true;
				break;
			}
		}

		System.out.println("Goodbye");
	}
}