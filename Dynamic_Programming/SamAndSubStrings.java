import java.math.BigInteger;
import java.util.*;

public class SamAndSubStrings {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	//	long n_val = n, chop = 1; long sum = 0;
		BigInteger n = sc.nextBigInteger();
		BigInteger n_val = n;
		
		String temp = n.toString();
		long chop = 1;
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i < temp.length(); i++) {
			chop *= 10;
		}
		
		while (n.compareTo(BigInteger.ZERO) > 0 && chop > 0) {	
			n_val = n;
			// System.out.println("nval: " + n_val);
			
			while (n_val.compareTo(BigInteger.ZERO) > 0) {
				
				// System.out.println(n_val);
				sum = (sum.add(n_val).mod(BigInteger.valueOf(1000000000 + 7)));
				
				n_val = n_val.divide(BigInteger.valueOf(10));
			}			
			
			n = n.subtract( (n.divide(
					BigInteger.valueOf(chop)).multiply(
							BigInteger.valueOf(chop))));
			
			chop /= 10;
			
			if (chop <= 0) break;
		}
		
		System.out.println(sum);
	}
}
