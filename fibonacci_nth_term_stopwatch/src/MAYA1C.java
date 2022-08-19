import java.util.Scanner;

public class MAYA1C {

	public static void main(String[] args) {
	
		// Takes user input for term n.
		System.out.print("N = ");
		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		
		Watch a = new Watch();
		
		a.start_timer();
		
		System.out.println("Term: " + fibRecursive(n));
				
		a.stop_timer();
		
		// Outputs elapsed time.
		System.out.println("Recursive elapsed time: " + a.getElapsed());
		
		
		
		
		// Iterative time.
		Watch b = new Watch();

		b.start_timer();

		System.out.println("Term: " + fibIterative(n));

		b.stop_timer();
		
		// Outputs elapsed time.
		System.out.println("Iterative elapsed time: " + b.getElapsed());

		userInput.close();
	}
	
	// Determines nth term value recursively.
	static int fibRecursive(int  n) {
			
		// Outputs base.
		if ((n <= 1)) {
			return n;
		}
			
		// Adds n-1 and n-2 term values to get nth term.
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}
	
	// Calculates the nth term iteratively.
	static int fibIterative(int n) {
		
		// Returns the seeded value 0 or 1 if entered.
		if (n <= 1)
			return n;
		
		n = n + 1;
		
		int firstTerm = 0;
		int secondTerm = 1;
		
		// n-2
		int a = firstTerm;
		
		// n-1
		int b =secondTerm;
		
		// placeholder
		int newNum;
		
		// Finds n-1 and n-2 term values.
		for (int i = 0; i < (n-3); i++) {
			newNum = a + b;
			a = b;
			b = newNum;
		}
		
		// Adds n-1 and n-2 term values to get nth term.
		return a + b;
	}
}


// Stopwatch.
class Watch{
	private long startClock;
	private long endClock;
	
	public Watch(){
		startClock = System.currentTimeMillis();
	}
	
	public void start_timer() {
		startClock = System.currentTimeMillis();
	}
	
	public void stop_timer() {
		endClock = System.currentTimeMillis();
	}
	
	public long getElapsed() {
		return endClock - startClock;
	}
}