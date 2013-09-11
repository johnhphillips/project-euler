/* Problem 3: 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
*/
public class ProblemThree {
	
	public static void main(String[] args) {
	
		long testNumber = 600851475143L;
		System.out.println("Factor " + testNumber);
		primeFactors(testNumber);
		
	}
	public static long primeFactors(long number) {
//		int factorOne, factorTwo;
		/*
		 * Prime number is one that is divisible only
		 * by 1 and itself
		 * 
		 * Test if number is prime using trial division
		 * - test whether number is a multiple of any integer between 2
		 *   and number^(1/2)
		 */
		double x; long y;
//		System.out.println("Number = " + number);
		// check if number is prime
		if( isPrime(number)) { 
//			System.out.println("1Prime Factor = " + number);
//			System.out.println("*****");
			return number;
		}
		
		// find square root, round, convert back to int
		x = Math.sqrt(number);
		y = (int)Math.round(x);
	
		for( int i = 2; i <= y; i++) {
			// check if current i is factor of number
			if( number % i == 0) { 
//				System.out.println("Number = " + number + " i = " + i);
//				// divide and print factors
//				factorOne = i;
				// check that factor is prime
				if( isPrime(i)) {
					System.out.println("Prime Factor = " + i);
					number = number / i;
//					System.out.println("New Number = " + number);
					number = primeFactors( number);
//					System.out.println("xxxxx " + number);
//					i = 2;
				}
				// factor isn't prime
				else {
					System.out.println("Not Prime Factor = " + i);
					number = primeFactors( i);
				}
				
//				factorTwo = number / i;
//				System.out.println(factorOne + " " + factorTwo);
			 }
		}
		// remainder after factorization
//		System.out.println("Last Factor = " + number);
//		System.out.println("-----");
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
