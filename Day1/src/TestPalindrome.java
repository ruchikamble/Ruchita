import java.util.Scanner;

public class TestPalindrome {

	public static void main(String[] args) {
		
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Palindrome p = new Palindrome();
		p.isPalindrome(num);
		
	}

}
