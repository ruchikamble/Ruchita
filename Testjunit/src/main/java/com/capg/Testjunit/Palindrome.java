package com.capg.Testjunit;

public class Palindrome 
{
	public static boolean isPalindrome(int num)
	{
		
		int temp = num;
		int sum = 0;
		
		while(num > 0)
		{
		int d = num%10;
		sum = (sum * 10) + d;
		num= num/10;
		}
		
		if(temp == sum)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
}
