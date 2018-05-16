package com.capg.Testjunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DuplicateTest 
{
	@Test
	public void duplicateTest()
	{
		int arr[] = {5,5,7,4,6};
		assertEquals(5, Duplicate.duplicateElement(arr));
	}
}
