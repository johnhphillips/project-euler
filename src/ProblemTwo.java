/* Problem 2: 
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous 
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not 
 * exceed four million, find the sum of the even-valued terms.

*/
public class ProblemTwo {
	
	private static int maxNumber = 4000000;
	public static int sum = 0;
	
	public static void main(String[] args) {
		int seedZero = 0;
		int seedOne = 1;
		
		Fibonacci(seedZero, seedOne);
		
		System.out.println(sum);
		

	}
	// function to find the first n fibonacci numbers where n is the max
	public static int Fibonacci(int a, int b) {
		// find next fibonacci number	
		int c = a + b;
		a = b;
		b = c;
		// check if below limit
		if( c <= maxNumber){ Fibonacci(a, b); }
		// check if even
		if( c % 2 == 0) { sum += c; }
//		System.out.println(c);
		return c;
	}
}
