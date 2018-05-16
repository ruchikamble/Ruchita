import java.util.Scanner;

public class TestGenerics {
	
	public static <T> void genericsTest(T[] arr)
	{
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.println(arr[i]);
		}
		
	}

	public static void main(String[] args) 
	{
		
		System.out.println("Enter the integer element");
		Integer intArr[] = new Integer[5];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < intArr.length; i++) 
		{
			intArr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the string element");
		Scanner scn = new Scanner(System.in);
		String string[] = new String[5];
		for (int i = 0; i < string.length; i++) 
		{
			string[i]= scn.nextLine();
		}
		
		TestGenerics.genericsTest(intArr);
		TestGenerics.genericsTest(string);

	}

	
	}


