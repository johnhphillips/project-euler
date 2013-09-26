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
		int dimension = 2;	// one for the factor and one for the power
		int range = 21; 	// 1 through 20
		
		int[][] factors = new int[dimension][range];
		// find prime factors for each number within range
		for( int i = 1; i < range; i++) {
			// temp array to hold prime factors of current number
			int[][] currentFactors = new int[dimension][range];
			// find prime factors of current number
			currentFactors = primeFactors(i, currentFactors);

			// compare current factor array to factor array
			for( int j = 0; j < range; j++) {
				for( int k = 0; k < range; k++) {
					// if the same factor check the power and choose the highest
					if( currentFactors[0][j] == factors[0][k] && currentFactors[0][j] != 0) {
						if( currentFactors[1][j] >= factors[1][k]) {
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
		}
		// answer time
		long answer = 1L;
		for( int j = 0; j < range; j++) {
			int power = factors[1][j];
			if( factors[0][j] != 0) {
				while( power != 0) {
					answer = answer * factors[0][j];
					power--;
				}
			}
		}
		System.out.println("The smallest number that can be divided by each number from 1 to " + (range - 1) + " is " + answer);

	}
   /*
 	* Function that returns an array containing the prime factorization of the 
 	* given number in the format factor^power
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
		// check if number is prime
		if( isPrime(number)) { 
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
	/*
	 * Function that checks if given number is present in factor
	 * array, if present increments power. If not adds to array.
	 */
	
	public static int[][] addFactor(long number, int[][] factors) {
		// check if factor is already present
		for( int i = 0; i < factors[1].length; i++) {
			if( factors[0][i] == number) {
				// increment power
				factors[1][i]++;
				return factors;	
			}
			else if( factors[0][i] == 0) {
				factors[0][i] = (int)number;
				factors[1][i] = 1;
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
