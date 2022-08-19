import java.util.Scanner;

public class MAYA1B {

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
	
	
	// Calculates the nth term.
	static int fibTerm(int n) {
		
		// Returns the seeded value 0 or 1 if entered.
		if (n <= 1)
			return n;
		
		n = n + 1;
		
		// Seeds or base cases.
		int firstTerm = 0;
		int secondTerm = 1;
		
		// Takes n-2 term value.
		int a = firstTerm;
		
		// Takes n-1 term value.
		int b =secondTerm;
		
		// Acts as placeholder for sum of n-1 and n-2 terms.
		int temp;
		
		// Finds n-1 and n-2 term values.
		for (int i = 0; i < (n-3); i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		
		// Adds n-1 and n-2 term values to get nth term.
		return a + b;
	}
}
