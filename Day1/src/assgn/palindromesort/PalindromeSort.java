package assgn.palindromesort;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeSort {
	
	public void palindromeCheck(String arr[])
	{
		
		
		for(int i=0; i<arr.length; i++)
		{
			String rev="";
			for(int j=arr[i].length()-1; j>=0; j--)
			{
				rev = rev + arr[i].charAt(j);
			}
			if(arr[i].equals(rev))
			{
				System.out.println(arr[i] +" is palindome");
				System.out.println("The no. of characters are "+arr[i].length());
				char temp[] = arr[i].toCharArray();
				Arrays.sort(temp);
				String str = String.copyValueOf(temp);
				StringBuilder sb = new StringBuilder(str);
				sb= sb.reverse();
				System.out.println("Sorted in descending order : "+sb);
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		String input[] = new String[10];
		System.out.println("Enter the elements");
		Scanner  sc = new Scanner(System.in);
		for(int i=0; i<input.length; i++)
			 input[i] = sc.nextLine();
			
		
		PalindromeSort palindrome = new PalindromeSort();
		palindrome.palindromeCheck(input);
	}

}
