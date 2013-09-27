/* Problem 10:
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 		
 */

public class ProblemTen {
	public static void main(String[] args) {
		long max = 2000000L;
		long sum = 0;
		
		// 
		for(long i = 2L; i < max; i++ ) {
			if(isPrime(i)) { sum += i;}
		}
		System.out.println(sum);

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
