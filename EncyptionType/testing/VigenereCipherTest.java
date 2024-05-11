package testing;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import encryption.ciphers.VigenereCipher;


class VigenereCipherTest {

	@Test
	public void testVigenereCipherEncrypt() {
		VigenereCipher cipher = new VigenereCipher("yes");
		String encrypted = cipher.encrypt("hello");
		assertEquals("fOdjY", encrypted);
		//Testing a basic encryption with a simple password
		
		cipher = new VigenereCipher("test");
		encrypted = cipher.encrypt("How are you");
		assertEquals("AYo ZkO qhn", encrypted);
		//Testing an actual sentence with still a basic password
		
		cipher = new VigenereCipher("Have a nice day");
		encrypted = cipher.encrypt("Have a nice day");
		assertEquals("pGqO a TiVS LKy", encrypted);
		//Testing for both the password and the text being the same thing
		
		cipher = new VigenereCipher("Programming123#");
		encrypted = cipher.encrypt("Java, C++, python, HTML5");
		assertEquals("zXjM, :++, VkfVbZ, Yf`Oe", encrypted);
		//Testing for numbers and symbols in the text and in the password
	}

	@Test
	public void testVigenereCipherDecrypt() {
		VigenereCipher cipher = new VigenereCipher("yes");
		String decrypted = cipher.decrypt("fOdjY");
		assertEquals("hello", decrypted);
		//Testing for basic test and password
		
		
		cipher = new VigenereCipher("test");
		decrypted = cipher.decrypt("AYo ZkO qhn");
		assertEquals("How are you", decrypted);
		//Testing an actual sentence with a still basic password
		
		cipher = new VigenereCipher("Have a nice day");
		decrypted = cipher.decrypt("pGqO a TiVS LKy");
		assertEquals("Have a nice day", decrypted);
		//Testing for a decryption where the initial text and password were the same
		
		cipher = new VigenereCipher("Programming123#");
		decrypted = cipher.decrypt("zXjM, :++, VkfVbZ, Yf`Oe");
		assertEquals("Java, C++, python, HTML5", decrypted);
		
	//Testing for numbers and symbols in the text and in the password
	}
}
