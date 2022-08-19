import java.util.Scanner;
import java.math.BigInteger;

public class MAYA1D {
	
	public static void main(String[] args) {
		
		// Takes user input for n.
		System.out.print("N= ");
		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		
		// Will only output term if digits are less than 100 digits.
		try {
			System.out.println(fibTerm(n));
		} 
		catch(Exception e){
			System.out.println("Error.  Can only calculate up to 99 digits.");
		}
		
		userInput.close();
	}
	
	static BigInteger fibTerm(int n) {
		
		// Creates term arrays.
		int max = 100;
		byte[] arr1 = new byte[max];
		byte[] arr2 = new byte[max];
		byte[] fibTerm = new byte[max];
		
		// Seeds.
		arr1[0] = 1;
		arr2[0] = 1;
		
		// Calculates term.
		int d = 1;
		for(int i = 0; i < n-2; i++) {
			int carry = 0;
			for(int j = 0; j < d; j++) {
				
				// Determines current value with carry.
				fibTerm[j] = (byte)(arr1[j] + arr2[j] + carry);
				
				// Determines carry for next iteration.
				if(fibTerm[j] > 9) {
					fibTerm[j] %= 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
			}
			
			if(carry == 1) {
				fibTerm[d] = 1;
				d++;
				if(d == max) {
					max *= 2;
					fibTerm = grow(fibTerm, max);
					arr1 = grow(arr1, max);
					arr2 = grow(arr2, max);
					
				}
			}
			
			// Finds n-1 and n-2 term values.
			byte[] temp = fibTerm;
			fibTerm = arr2;
			arr2 = arr1;
			arr1 = temp;
		}
		
		// Creating string obj.
		StringBuilder b = new StringBuilder();
		for(int j = 0; j < d; j++) {
			b.append(arr1[d - j - 1]);
		}
		
		// Returns fibTerm as string representation.
		return new BigInteger(b.toString());
	}

	private static byte[] grow(byte[] fibTerm, int max) {
		// TODO Auto-generated method stub
		return null;
	}
}
