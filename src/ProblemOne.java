/* Problem 1: 
 * 
 * If we list all the natural numbers below 10 
 * that are multiples of 3 or 5, we get 3, 5, 6 
 * and 9. The sum of these multiples is 23. Find 
 * the sum of all the multiples of 3 or 5 below 1000.
*/
public class ProblemOne {
	
	private static int maxNumber = 1000;
	
	public static void main(String[] args) {
		int sum = 0;
		// pass through all natural numbers up to maxNumber
		for( int i = 1; i < maxNumber; i ++) {
			// check if current number is divisible by 3 or 5 and print if true
			if( i % 3 == 0 || i % 5 == 0) { 
				System.out.println(i);
				sum += i;
				}
		}
		System.out.println(sum);
	}
}
