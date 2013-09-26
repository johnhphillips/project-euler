/* Problem 7:
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10001 prime number?
*/
public class ProblemSeven {
	public static void main(String[] args) {
		int range = 6;
		int count = 2;
		int primeCount = 0;
		while( primeCount < range) {
			if( isPrime(count)) {primeCount++;}
			count++;
		}
		System.out.println("The " + primeCount + "th prime is " + (count - 1));
		
	}
	/*
	 * Boolean function that checks if given
	 * number is prime
	 */
	public static boolean isPrime(long number) {
		/*
		 * Prime number is one that is divisible only
		 * by 1 and itself
		 * 
		 * Test if number is prime using trial division
		 * - test whether number is a multiple of any integer between 2
		 *   and number^(1/2)
		 */
		double x; long y;
		
		// find square root, round, convert back to int
		x = Math.sqrt(number);
		y = (long)Math.round(x);
		
		for( int i = 2; i <= y; i++) {
			// check if current i is divisor of number
			if( number % i == 0) { return false; }
		}
		// number is prime
		return true;
	}
}
