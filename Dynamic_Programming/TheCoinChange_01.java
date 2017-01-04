import java.util.*;

/*
 * Algorithms for solve function taken from "geeksforgeeks.org/"
 * at "http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/"
 */
public class TheCoinChange_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), m = sc.nextInt(),
				coins[] = new int[m];
		for (int i = 0; i < coins.length; i++) 
			coins[i] = sc.nextInt();
		Arrays.sort(coins);

		System.out.println(solve(n, coins, coins.length));


		sc.close();
	}

	private static long solve(int n, int[] coins, int m) {

		long[][] table = new long[n+1][m];
		
		for (int i = 0; i < m; i++) table[0][i] = 1;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < m; j++) {
				// count of solutions including coins[j]
				long x = (i - coins[j] >= 0)? table[i - coins[j]][j] : 0;
				
				// count of solutions excluding coins[j]
				long y = (j >= 1) ? table[i][j-1]:0;
				
				table[i][j] = x + y;
			}
		}
		return table[n][m-1];

	}
}
