import java.util.*;

public class StockMaximize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int z = 0; z < t; z++) {
			int n = sc.nextInt(), a[] = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();

			System.out.println(dp(a));
			
		}
		
		sc.close();
	}
	
	private static long dp(int[] a) {
		long total = 0L;
		int maxSoFar = 0;
		
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] >= maxSoFar) {
				maxSoFar = a[i];
			}
			
			total += maxSoFar - a[i];
		}
		return 0L;
	}

}



