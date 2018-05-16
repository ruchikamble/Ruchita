package assgn.reverse;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String splitted[] = str.split(" ");
		String op = "";
		
		for(int i = 0; i < splitted.length; i++)
		{
			String temp = "";
			for(int j = splitted[i].length()-1; j>=0 ; j--)
			{
				temp = temp + splitted[i].charAt(j);
			}
			
			op = op + temp + " ";
		}
			System.out.println(op);
	}
	

}
