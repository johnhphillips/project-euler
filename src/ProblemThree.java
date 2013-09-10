/* Problem 3: 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
*/
public class ProblemThree {
	
	public static void main(String[] args) {
	
		int testNumber = 2147483647;
		System.out.println(isPrime(testNumber));
	}
	/*
	 * Boolean function that checks if given
	 * number is prime
	 */
	public static boolean isPrime(int number) {
		/*
		 * Prime number is one that is divisible only
		 * by 1 and itself
		 * 
		 * Test if number is prime using trial division
		 * - test whether number is a multiple of any integer between 2
		 *   and number^(1/2)
		 */
		double x; int y;
		
		// find square root, round, convert back to int
		x = Math.sqrt(number);
		y = (int)Math.round(x);
		
		for( int i = 2; i <= y; i++) {
			// check if current i is divisor of number
			if( number % i == 0) { return false; }
		}
		// number is prime
		return true;
	}
}
