import java.util.Scanner;

public class Palindrome {
	
	public Palindrome()
	{
		
	}

	public void isPalindrome(int num)
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
			System.out.println("True");
		}
		
		else
		{
			System.out.println("false");
		}
		
	}
	

}
