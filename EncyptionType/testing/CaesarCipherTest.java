package testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import encryption.ciphers.CaesarCipher;

public class CaesarCipherTest {

	@Test
	public void testCaesarCipherEncrypt() {
		CaesarCipher cipher = new CaesarCipher(5);
		String encrypted = cipher.encrypt("hello");
		assertEquals("mjqqt", encrypted);
		// Testing a basic encryption with a small shift value

		cipher = new CaesarCipher(50);
		encrypted = cipher.encrypt("How are you doing today");
		assertEquals("zFNR8I<RPFLR;F@E>RKF;8P", encrypted);
		// Testing the encryption of a sentence with a much larger shift value

		cipher = new CaesarCipher(30);
		encrypted = cipher.encrypt("Java5678*&#");
		assertEquals("h$9$STUVHDA", encrypted);
		// Testing input with numbers and symbols

		cipher = new CaesarCipher(91);
		encrypted = cipher.encrypt("Wraparound");
		assertEquals("Wraparound", encrypted);
		// Testing wrap around
	}

	@Test
	public void testCaesarCipherDecrypt() {
		CaesarCipher cipher = new CaesarCipher(5);
		String decrypted = cipher.decrypt("mjqqt");
		assertEquals("hello", decrypted);
		//Testing the decryption of a basic word with a small shift value
		

		cipher = new CaesarCipher(50);
		decrypted = cipher.decrypt("zFNR8I<RPFLR;F@E>RKF;8P");
		assertEquals("How are you doing today", decrypted);
		//Testing the decryption of a sentence with a much larger shift value
		
		cipher = new CaesarCipher(30);
		decrypted = cipher.decrypt("h$9$STUVHDA");
		assertEquals("Java5678*&#", decrypted);
		//Testing the decryption with numbers and symbols
		
		cipher = new CaesarCipher(91);
		decrypted = cipher.decrypt("Wraparound");
		assertEquals("Wraparound", decrypted);
		//Testing the decryption for wrap around
	}
}