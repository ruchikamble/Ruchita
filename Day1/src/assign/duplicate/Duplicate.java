package assign.duplicate;

import java.util.Scanner;

public class Duplicate {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		System.out.println("Enter the elements");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i]==arr[j])
				{
					
					System.out.println("The duplicate element is "+arr[i]);
					
				}
			}
		}
		
	}

}
