package com.capg.Testjunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeTest 
{
	@Test
	public void testPalindrome()
	{
		assertEquals(true, Palindrome.isPalindrome(121));
		assertEquals(false, Palindrome.isPalindrome(-125));
	}
}
