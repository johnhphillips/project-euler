/* Problem 6:
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 	1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first then natural numbers is,
 * 	(1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is 3025 - 385 = 2640
 * 
 * Find the difference between the sum of the squares of the first 100
 * natural numbers and the square of the sum
 * 
*/
public class ProblemSix {
	public static void main(String[] args) {
		int range = 101;
		int power = 2;
		
		int sumSquares = 0;
		int squareSum = 0;
		
		// Find sum of squares
		for(int i = 1; i < range; i++ ) {
			sumSquares += (int)Math.pow(i, power);
		}
		// Find square of sums
		int sum = 0;
		for(int i = 1; i < range; i++) {
			sum += i;
		}
		squareSum = (int)Math.pow(sum, power);
		
		System.out.println("For numbers 1 through " + (range - 1) + ":");
		System.out.println("Sum of squares = " + sumSquares);
		System.out.println("Square of sum = " + squareSum);
		System.out.println("Difference = " + Math.abs(sumSquares - squareSum));
	}
}
