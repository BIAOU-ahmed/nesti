package nesti;

import junit.framework.TestCase;

public class CheckTest extends TestCase {

	/**
	 * test the validity of the password
	 */
	public void testCheckPassword() {

		assertEquals(0, Check.calculatePasswordStrength(""));
		assertEquals(0, Check.calculatePasswordStrength("qsdq"));
		assertEquals(0, Check.calculatePasswordStrength("aZ1"));
		assertEquals(5, Check.calculatePasswordStrength("azerty1a"));
		assertEquals(7, Check.calculatePasswordStrength("azerty1A"));
		assertEquals(9, Check.calculatePasswordStrength("Azerty1!"));
		assertEquals(10, Check.calculatePasswordStrength("Azerty1!azer"));
	}

	/**
	 * test the validity of the email
	 */
	public void testCheckEmail() {

		assertEquals(false, Check.isValidEmail(""));
		assertEquals(false, Check.isValidEmail("ahmed"));
		assertEquals(false, Check.isValidEmail("ahmed@example"));
		assertEquals(false, Check.isValidEmail("ahmed@example.c"));
		assertEquals(true, Check.isValidEmail("ahmed@example.com"));
	}

}
