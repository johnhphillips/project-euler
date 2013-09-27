/* Problem 9:
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 
 * a^2 + b^2 = c^2
 * 		
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *		
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *		
 * Find the product abc.
 *		
 */

// BRUTE FORCE!?!
public class ProblemNine {
	public static void main(String[] args) {
		int max = 1000;
		int answer = 0;
		
		for(int a = 1; a <= max; a++) {
			for(int b = 1; b <= max; b++) {
				for(int c = 1; c <= max; c++) {
					// check if a + b + c = 1000 is true
					if( a + b + c == max) { 
//						System.out.println(a + " " + b + " " + c);
						// if true check if triple
						if( (int)Math.pow(a,2) + (int)Math.pow(b,2) == (int)Math.pow(c,2)) {
							answer = a * b * c;
						}
					}
				}
			}
		}
		System.out.println(answer);
	
	
	}
}
