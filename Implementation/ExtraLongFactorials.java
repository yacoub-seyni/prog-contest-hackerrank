import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fact(n));
		
		sc.close();
	}
	
	private static BigInteger fact(int n) {
		BigInteger x = BigInteger.valueOf(n);
		if (n <= 2) 
			return x;
		else 
			return (x.multiply(fact(n - 1)));
	}
}
