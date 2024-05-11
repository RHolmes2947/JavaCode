/**
* A class that implements Caesar cipher method
* This class extends the abstract EncryptionType class and implements its abstract methods.
* Student Name: Rian Olson
* Student Number:041073915
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fedor Ilitchev
*
*/
package encryption.ciphers;

import encryption.EncryptionType;

public class CaesarCipher extends EncryptionType {

    private int key;

    /**
     * Constructs a new instance of the CaesarCipher class with the given shift.
     * 
     * @param shift the number of positions to shift the letters in the alphabet
     */
    public CaesarCipher(int shift) {
        key = shift;
    }

    /**
     * Encrypts the given plaintext using the Caesar Cipher algorithm.
     * 
     * @param input the plaintext to be encrypted
     * @return the ciphertext resulting from encrypting the plaintext with the Caesar Cipher algorithm
     */
    @Override
    public String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= START_CHAR && c <= END_CHAR) {
                c = shiftChar(c, key);
            }
            result.append(c);
        }
        return result.toString();
    }
    /**
     * Decrypts the given ciphertext using the Caesar Cipher algorithm.
     * 
     * @param input the ciphertext to be decrypted
     * @return the plaintext resulting from decrypting the ciphertext with the Caesar Cipher algorithm
     */
    @Override
    public String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= START_CHAR && c <= END_CHAR) {
                c = shiftChar(c, -key);
            }
            result.append(c);
        }
        return result.toString();
    }
}