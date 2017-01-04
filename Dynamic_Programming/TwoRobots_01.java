import java.util.*;

public class TwoRobots_01 {
	
	static int a[], b[], dp[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		int max = 1000000000;
		
		for (int test = 0; test < tests; test++) {
			int m = sc.nextInt(), 
					n = sc.nextInt();
			a = new int[1005];
			b = new int[1005];
			dp = new int[1005][1005];
			
			for (int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}		
			
			for (int i = 0; i < 1005; i++) {
				for (int j = 1; j < 1005; j++) {
					dp[i][j] = max;
				}
			}
			
			int res = max;
			
			for (int i = 0; i < n; i++) {
				for (int j = i; j <= n; j++) {
					if (j == n) {
						res = Math.min(res, dp[i][j]);
						continue;
					}
					
					int me = dp[i][j];
					dp[i][j+1] = Math.min(dp[i][j+1], me + dist(j, j+1));
					dp[j][j+1] = Math.min(dp[j][j+1], me + dist(i, j+1));
				}
			}
			
			System.out.println(res);
		}	
		
		sc.close();
	}
	
	private static int dist(int i, int j) {
		if (i == 0) return Math.abs(b[j] - a[j]);
		return Math.abs(a[j] - b[i]) + Math.abs(b[j] - a[j]);
		
	}
}
