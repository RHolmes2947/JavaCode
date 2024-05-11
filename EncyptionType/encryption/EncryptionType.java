/**
* An abstract class that defines the basic structure of an encryption type.
* Student Name: Rian Olson
* Student Number:041073915
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fedor Ilitchev
*
*/
package encryption;

import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

public abstract class EncryptionType {

/** The ASCII code for the first printable character used for encryption. */
public static final int START_CHAR = 32;

/** The ASCII code for the last printable character used for encryption. */
public static final int END_CHAR = 122;

/** The number of printable characters used for encryption. */
public static final int RANGE = END_CHAR - START_CHAR + 1;

/**
Shifts the given character by the specified offset. If the resulting
character is outside of the range of printable characters, it is shifted
back into the range.
@param c the character to be shifted
@param offset the offset by which to shift the character
@return the shifted character
*/
    protected char shiftChar(char c, int offset) {
        int shifted = c + offset;
        while (shifted > END_CHAR) {
            shifted -= RANGE;
        }
        while (shifted < START_CHAR) {
            shifted += RANGE;
        }
        return (char) shifted;
    }

    /**
    Encrypts the given input using the specific encryption method.
    @param input the input string to be encrypted
    @return the encrypted string
    */
    public abstract String encrypt(String input);
    /**
    Decrypts the given input using the specific decryption method.
    @param input the input string to be decrypted
    @return the decrypted string
    */
    public abstract String decrypt(String input);
    
    /**
    Prompts the user to select an encryption method and returns the chosen method.
    @return the chosen encryption method
    */
	public static EncryptionType getMethod() {
		System.out.println("Choose an encryption method:");
		int choice = ScannerUtils.getMenuItem("Caesar Cipher", "Vigenere Cipher");

		EncryptionType method = null;
		if (choice == 1) {
			int shift = ScannerUtils.getInt("Enter the shift value:", 1, EncryptionType.RANGE -1);
			method = new CaesarCipher(shift);
		} else if (choice == 2) {
			String password = ScannerUtils.getString("Enter the password:");
			method = new VigenereCipher(password);
		}
		return method;
	}
}