/* Problem 3: 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
*/

public class ProblemThree {
	
	public static void main(String[] args) {
		// number given in problem
		long testNumber = 600851475143L;
		
		System.out.println("Factoring: " + testNumber);
		
		// find prime factors
		primeFactors(testNumber);
	}
	
/*
 * Function that prints the prime factorization of the 
 * given number to the console
*/
	public static long primeFactors(long number) {
		/*
		 * Prime number is one that is divisible only
		 * by 1 and itself
		 * 
		 * Test if number is prime using trial division
		 * - test whether number is a multiple of any integer between 2
		 *   and number^(1/2)
		 */
		double x; long y;

		// check if number is prime, if true done
		if( isPrime(number)) { return number; }
		
		// find square root (trial division), round, convert back to int
		x = Math.sqrt(number);
		y = (int)Math.round(x);
	
		for( int i = 2; i <= y; i++) {
			// check if current i is factor of number
			if( number % i == 0) { 
				// check that factor is prime
				if( isPrime(i)) {
					// print factor to console
					System.out.println("Prime Factor = " + i);
					// divide out
					number = number / i;
					number = primeFactors( number);
				}
			 }
		}
		return number;
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
