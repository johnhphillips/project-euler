/* Problem 4:
 * A palindromic number reads the same both ways. The 
 * largest palindrome made from the product of two 
 * 2-digit numbers is 9009 = 91 99.
 * 
 * Find the largest palindrome made from the product of 
 * two 3-digit numbers.
 */

public class ProblemFour {
	
	public static void main(String[] args) {
		int product = 0;
		int largeProduct = 0;
		// find all products of two digit numbers (LOTS OF OVERLAP TO REMOVE)
		
		for( int i = 100; i < 1000; i++) {
			for( int j = 100; j < 1000; j++) {
				product = i * j;
				// check if product is palindrome and larger than largeProduct
				if( isPalindrome(product) && product > largeProduct) {
					largeProduct = product;
				}
			}
		}
		System.out.println(largeProduct);
	}
	public static boolean isPalindrome(int number) {
		// assumed true at start of function
		boolean palindrome = true;
		int length = 0;
		int temp = number;
		
		// find length of number
		while( temp > 0) {
			temp = temp / 10;
			length++;
		}
		// initialize array to hold digits
		int[] digits = new int[length]; 
		temp = number;
		
		// convert number into array of digits
		while( temp > 0) {
			digits[length - 1] = temp % 10;
			temp = temp / 10;
			length--;
		}
		// compare first and last part of array, ignore center if odd length
		for(int i = 0; i < (digits.length / 2); i++) {
//			System.out.println(digits[i] + " " + digits[digits.length - 1 - i]);
			if( digits[i] != digits[digits.length - 1 - i]) { 
				// if anything doesn't match, stop
				palindrome = false;
				break;
			}
		}
		
//		System.out.println(palindrome);
			
		return palindrome;
	}
}