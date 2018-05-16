package com.capg.Testjunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestReverse 
{
	StringReverse reverse = new StringReverse();
	
	@Test
	public void testReverse()
	{
		assertEquals("atihcur elbmak ",reverse.reverseString("ruchita kamble"));
	}

	
}
