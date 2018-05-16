package com.capg.Testjunit;

import java.util.Scanner;

public class StringReverse 
{
	public StringReverse() {
		
	}
	
	public String reverseString(String str)
	{
//		System.out.println("Enter the String");
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		
		String splitted[] = str.split(" ");
		String op = "";
		for (int i = 0; i < splitted.length; i++) 
		{
			String temp = "";
			for (int j = splitted[i].length()-1; j >=0; j--) 
			{
				temp = temp + splitted[i].charAt(j);
			}
			
			op = op + temp + " ";
		}
		return op;
	}
}
