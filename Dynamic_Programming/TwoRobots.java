import java.util.*;

public class TwoRobots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for (int test = 0; test < tests; test++) {
			int m = sc.nextInt(), 
					n = sc.nextInt();
			int[][] queries = new int[n][2];

			for (int i = 0; i < n; i++) {
				queries[i][0] = sc.nextInt();
				queries[i][1] = sc.nextInt();
			}

			System.out.println(solve(queries, 0, -1, -1));

		}

		sc.close();
	}

	private static int solve(int[][] q, int n, int r1,
			int r2) {

		if (n >= q.length) return 0;
		if (r1 == -1) {
			r1 = q[n][1];
			return Math.abs(q[n][0] - q[n][1]) +
					solve(q, n + 1, r1, r2);
		}
		else if (r2 == -1) {

			return Math.abs(q[n][0] - q[n][1]) +
					Math.min(
							solve(q, n + 1, r1, q[n][1]),

							Math.abs(r1 - q[n][0]) +
							solve(q, n + 1, q[n][1], r2));
		}

		return Math.abs(q[n][0] - q[n][1]) +
				Math.min(
						solve(q, n + 1, r1, q[n][1]) +
						Math.abs(r2 - q[n][0]),
						
						solve(q, n + 1, q[n][1], r2) +
						Math.abs(r1 - q[n][0])
						);
	}
}
