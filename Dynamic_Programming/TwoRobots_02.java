/**
 * @author alesanz from hackerrank
 * url of solution: "https://www.hackerrank.com/rest/
 * 			contests/master/challenges/
 * 			two-robots/hackers/alesanz/download_solution"
 */

import java.util.*;

public class TwoRobots_02 {

	static class Loc {
		public int orig;
		public int dest;

		public Loc (int x, int y) {
			this.orig = x;
			this.dest = y;
		}
	}

	private int M;
	private int N;
	private Loc[] A;
	private int[][] dp;

	public TwoRobots_02 (int m, int n, Loc[] a) {
		this.M = m;
		this.N = n;
		this.A = a;
		this.dp = new int[this.N+1][this.M+1];
	}

	public int solve () {
		// If there's no movements
		if (this.N == 0) {
			return 0;
		} else {
			// No matter where the other robot is, in one step,
			// I need to consider the distance of the first point
			for (int j = 1; j<=this.M; j++) {
				dp[1][j] = Math.abs(A[0].dest - A[0].orig);
			}
			// Fill the rest of the matrix with the highest
			// possible distance
			for (int i = 2; i<=this.N; i++) {
				for (int j = 1; j<=this.M; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			// Compute the minimum distance at all points
			for (int i = 2; i<=this.N; i++) {
				for (int j = 1; j<=this.M; j++) {
					// The last step is taken by the other robot
					dp[i][A[i-2].dest] = Math.min(
										  dp[i][A[i-2].dest],
										  dp[i-1][j] +
                                            Math.abs(A[i-1].dest-A[i-1].orig) +
											Math.abs(j-A[i-1].orig));
					// The last step is taken by me
					dp[i][j] = Math.min(dp[i][j],
											dp[i-1][j] +
												Math.abs(A[i-1].dest - A[i-1].orig) +
											 	Math.abs(A[i-2].dest - A[i-1].orig));
				}
			}
			int dist = Integer.MAX_VALUE;
			for (int j = 1; j<=this.M; j++) {
				dist = Math.min (dist, dp[this.N][j]);
			}
			return dist;
		}
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		final int T = sc.nextInt();
		for (int t=0; t<T; t++) {
			final int M = sc.nextInt();
			final int N = sc.nextInt();
			Loc[] A = new Loc[N];
			for (int n=0; n<N; n++) {
				A[n] = new Loc(sc.nextInt(), sc.nextInt());
			}
			TwoRobots_02 s = new TwoRobots_02(M,N,A);
			System.out.println (s.solve());
		}
	}
}
