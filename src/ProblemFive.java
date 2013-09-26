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
		int[][] factors = new int[2][21];
		// start with 1 to 10, find prime factors for each
		for( int i = 1; i < 21; i++) {
			int[][] currentFactors = new int[2][21];
//			System.out.println("Number = " + i);
			currentFactors = primeFactors(i, currentFactors);
//			for( int j = 0; j < currentFactors[1].length; j++) {
//				if( currentFactors[0][j] != 0) {
//					System.out.println( "Current Factor: " + currentFactors[0][j] + " Power: " + currentFactors[1][j]);
//				}
//			}
			// compare current factor list to factor list
			for( int j = 0; j < currentFactors[1].length; j++) {
				for( int k = 0; k < factors[1].length; k++) {
					// if the same factor check the power and choose the highest
					if( currentFactors[0][j] == factors[0][k] && currentFactors[0][j] != 0) {
						if( currentFactors[1][j] >= factors[1][k]) {
//							System.out.println("Changing: " + factors[0][k] + "^" + factors[1][k] + " to " + currentFactors[0][j] + "^" + currentFactors[1][j]);
							factors[1][k] = currentFactors[1][j];
							break;
						}
					}
					// if factor has smaller power, ignore
					else if( currentFactors[0][j] < factors[0][k] ) {
						break;
					}
					// end of factor list
					else if( factors[0][k] == 0) {
						factors[0][k] = currentFactors[0][j];
						factors[1][k] = currentFactors[1][j];
						break;
					}
				}
			}
//			System.out.println("-----");
		}
		for( int j = 0; j < factors[1].length; j++) {
			if( factors[0][j] != 0) {
				System.out.println( "Factor: " + factors[0][j] + " Power: " + factors[1][j]);
			}
		}

	}
   /*
 	* Function that prints the prime factorization of the 
 	* given number to the console
 	*/
	public static int[][] primeFactors(long number, int[][] factors) {
		/*
		 * Prime number is one that is divisible only
		 * by 1 and itself
		 * 
		 * Test if number is prime using trial division
		 * - test whether number is a multiple of any integer between 2
		 *   and number^(1/2)
		 */
		double x; long y;
//		System.out.println(number);
		// check if number is prime, if true done
		if( isPrime(number)) { 
//			System.out.println("Prime Factor = " + number);
			// add to factor list, if already found increment power
			factors = addFactor( number, factors);
			return factors; 
		}
			
		// find square root (trial division), round, convert back to int
		x = Math.sqrt(number);
		y = (int)Math.round(x);
		
		for( int i = 2; i <= y; i++) {
			// check if current i is factor of number
			if( number % i == 0) { 
				// check that factor is prime
				if( isPrime(i)) {
					// print factor to console
//					System.out.println("Prime Factors = " + i);
					factors = addFactor( i, factors);
					// divide out
					number = number / i;
					primeFactors( number, factors);
					break;
				}
			 }
		}
		return factors;
	}
	
	public static int[][] addFactor(long number, int[][] factors) {
		// check if factor is already present
		for( int i = 0; i < factors[1].length; i++) {
			if( factors[0][i] == number) {
				// increment power
				factors[1][i]++;
//				System.out.println("Factor: " + factors[0][i] + " Power = " + factors[1][i]);
				return factors;
				
			}
			else if( factors[0][i] == 0) {
				factors[0][i] = (int)number;
				factors[1][i] = 1;
//				System.out.println("Factor: " + factors[0][i] + " Power = " + factors[1][i]);;
				return factors;
			}
			
		}
		return factors;
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
