import java.util.*;


public class TheCoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), m = sc.nextInt(),
				coins[] = new int[m];
		for (int i = 0; i < coins.length; i++) 
			coins[i] = sc.nextInt();
		Arrays.sort(coins);
		
		long[][] ways = new long[n+1][m];
//		for (int i = 1; i < ways[0].length; i++)
			Arrays.fill(ways[0], 1);
		
		System.out.println(solve(n, coins, coins.length, ways));
		
		
		sc.close();
	}
	
	private static long solve(int n, int[] coins, 
			int numToUse, long[][] ways) {
		
		if (n < 0 || numToUse < 0) return 0;
		else if (n == 0) return 1;
		
		if (ways[n][numToUse] == -1) {
			ways[n][numToUse] = solve(n, coins, numToUse - 1, ways) +
					solve(n - coins[numToUse], coins, numToUse, ways);
		}
		return ways[n][numToUse];
				
	}
}
