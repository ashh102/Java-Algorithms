import java.util.Scanner;

public class MAYA1A {

	public static void main(String[] args) {
		
		// Takes user input for term n.
		System.out.print("N = ");
		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		
		// Checks for positive input.
		if (n < 0) {
			System.out.println("Error.  N must be a positive number.");
			System.exit(0);
		}
		
		System.out.println("Term: " + fibTerm(n));
		
		userInput.close();
	}

	// Determines nth term value.
	static int fibTerm(int  n) {
		
		// Outputs base.
		if ((n <= 1)) {
			return n;
			}
		
		// Adds n-1 and n-2 term values to get nth term.
		return fibTerm(n - 1) + fibTerm(n - 2);
		}
}
