package com.test.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAdd 
{
	static int i;
	static int j;
	Calculator cal = new  Calculator();
	
	@BeforeClass
	public static void beforeMe()
	{
		System.out.println("Before");
		j = 10;
		i = 20;
	}
	
	@Test
	public void addTest()
	{
		assertEquals(30, cal.addNumber(j, i));
	}
	
	@Test
	public void substractTest()
	{
		assertEquals(10, cal.substractNumber(i, j));
	}
}
