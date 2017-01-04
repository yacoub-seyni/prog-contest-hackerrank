import java.util.*;

public class SummingPieces {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] A = new long[n];
		for (int i = 0; i < n; i++) A[i] = sc.nextLong();

		long[] cache = new long[(1 << n) + 1];
		long hold = 0; int count = 0;
		
		for (int i = 0; i <= (1 << (n - 1)); i++) {
			hold = 0; count = 0;
			
			for (int j = 0; j < n; j++) {
				if ( (i & (1 << j)) != 0 ) {
					hold += A[i]; count++;
				}
			}
			cache[i] = hold * count;
		}
		
		
		sc.close();
	}
}
