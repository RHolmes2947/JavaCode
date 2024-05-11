/**
* A class that implements vigenere cipher method
* This class extends the abstract EncryptionType class and implements its abstract methods.
* Student Name: Rian Olson
* Student Number: 041073915
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fedor Ilitchev
*
*/

package encryption.ciphers;

import encryption.EncryptionType;

public class VigenereCipher extends EncryptionType {

    private String key;
    private int keyLength;

    
    /**
     * Constructs a new VigenereCipher object with the specified password.
     * @param password The password used as the key to encrypt and decrypt messages.
     */
    public VigenereCipher(String password) {
        key = password;
        keyLength = key.length();
    }
    /**
     * Encrypts the specified input string using the Vigenere cipher.
     * @param input The input string to be encrypted.
     * @return The encrypted string.
     */
    @Override
    public String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        int inputLength = input.length();
        int j = 0;

        for (int i = 0; i < inputLength; i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                int shift = key.charAt(j) - START_CHAR;
                c = shiftChar(c, shift);
                j = (j + 1) % keyLength;
            }
            result.append(c);
        }

        return result.toString();
    }
    
    /**
     * Decrypts the specified input string using the Vigenere cipher.
     * @param input The input string to be decrypted.
     * @return The decrypted string.
     */

    @Override
    public String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        int inputLength = input.length();
        int j = 0;

        for (int i = 0; i < inputLength; i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                int shift = key.charAt(j) - START_CHAR;
                c = shiftChar(c, -shift);
                j = (j + 1) % keyLength;
            }
            result.append(c);
        }

        return result.toString();
    }
}
