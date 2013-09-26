/* Problem 7:
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 * 
 * 		73167176531330624919225119674426574742355349194934
 *      96983520312774506326239578318016984801869478851843
 *		85861560789112949495459501737958331952853208805511
 *		12540698747158523863050715693290963295227443043557
 *		66896648950445244523161731856403098711121722383113
 *		62229893423380308135336276614282806444486645238749
 *		30358907296290491560440772390713810515859307960866
 *		70172427121883998797908792274921901699720888093776
 *		65727333001053367881220235421809751254540594752243
 *		52584907711670556013604839586446706324415722155397
 *		53697817977846174064955149290862569321978468622482
 *		83972241375657056057490261407972968652414535100474
 *		82166370484403199890008895243450658541227588666881
 *		16427171479924442928230863465674813919123162824586
 *		17866458359124566529476545682848912883142607690042
 *		24219022671055626321111109370544217506941658960408
 *		07198403850962455444362981230987879927244284909188
 *		84580156166097919133875499200524063689912560717606
 *		05886116467109405077541002256983155200055935729725
 *		71636269561882670428252483600823257530420752963450
 */
import java.io.*;

public class ProblemEight {
	public static void main(String[] args) {
		// start with 7316717653 and window of 2 with largest product = 42
		String number = "";
		// number of consecutive digits to consider when finding product
		int window = 2;
		
		// read number in line by line from text file
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Eclipse\\ProblemEight.txt"));
			String line = "";
			while((line = reader.readLine()) != null) {
				number += line;
			}
			// close file
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		}
		catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
		// position 0 is empty and will be ignored
		String[] digits = number.split("");
		int product = 0;
		System.out.println("Number " + number);
		for( int i = 1; i < (digits.length - window + 1); i++) {
			int innerProduct = Integer.parseInt(digits[i]);
//			System.out.println("i " + i);
			for( int j = (i + 1); j < (i + window); j++) {
//				System.out.println("i " + i + " j " + j);
//				System.out.println(digits[j] + " " + digits[j+1]);
				innerProduct = innerProduct * Integer.parseInt(digits[j]);
			}
			if( innerProduct >= product) { product = innerProduct; }
			System.out.println("Inner product: " + innerProduct );
		}
		System.out.println("Greatest product = " + product);

	}
}
