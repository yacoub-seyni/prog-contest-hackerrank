import java.util.*;

public class LargestPalindromeProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		
		for (int t0 = 0; t0 < t; t0++) {
			int n = sc.nextInt();
			String str = String.valueOf(n);
			char[] left = str.substring(0, 3).toCharArray(), 
					right = str.substring(3).toCharArray();
			
			if (left[2] < right[0]) {
				left[2] = right[0];
			}
			
			
			
			
			
		}
		sc.close();
	}
}
