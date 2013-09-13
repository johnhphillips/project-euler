/* Problem 5:
 * 2520 is the smallest number that can be divided 
 * by each of the numbers from 1 to 10 without any 
 * remainder. 
 * 
 * What is the smallest positive number that is 
 * evenly divisible by all of the numbers from 1 to 20?
*/

/*
 * Turns out this is the same as find:
 * lcm(1,2,3, ... ,19,20)
 */

public class ProblemFive {
	public static void main(String[] args) {
		
		// start with 1 to 10, find prime factors for each
		for( int i = 1; i < 11; i++) {
			System.out.println("Number: " + i);
			primeFactors(i);
			System.out.println("-----");
		}
		
		
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
		if( isPrime(number)) { System.out.println("Prime Factor = " + number); return number; }
			
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