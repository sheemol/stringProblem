package test;

import org.testng.Assert;
import org.testng.annotations.*;

public class StringProblem {

	// Replace character from string using string utils
	public String replaceChar(String s, String s1) {
		String newString = null;
		if (s == null)
			return null;
		else {
			try {
				newString = s.replaceAll(s1, "");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			return newString;
		}
	}

	// String replace character one at a time in aloop
	public String replaceCharInLoop(String s, char ch) {
		if (s == null)
			return null;
		else {
			StringBuilder str = new StringBuilder();
			String newString = null;
			try {
				char[] c = s.toCharArray();

				for (char i : c) {
					if (i != ch) {
						str.append(i);
					}

				}

				newString = str.toString();
			}

			catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			return newString;
		}

	}

	// Test the methods with different set of data

	@DataProvider(name = "StringData")
	public Object[][] stringdata1() {

		Object[][] o = {{ "abcdcd", "abdd" }, { "ABCDCD", "ABCDCD" },
				{ null, null }, { "", "" } };
		return o;

	}

	@Test(dataProvider = "StringData")
	public void testStringReplce(String s, String s1) {

		String newString = replaceChar(s, "c");

		Assert.assertEquals(newString, s1);
	}

	@Test(dataProvider = "StringData")
	public void testStringReplceCharInLoop(String s, String s1) {

		String newString = replaceCharInLoop(s, 'c');

		Assert.assertEquals(newString, s1);
	}

}