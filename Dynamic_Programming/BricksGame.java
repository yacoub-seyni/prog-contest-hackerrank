import java.util.*;

public class BricksGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int test = 0; test < t; test++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
			
			System.out.println(solve(a, 0, 0, 0, true));
		}
		sc.close();
	}
	
	private static long solve(int[] a, int i, 
			long score1, long score2, boolean turn) {
		
		if (i == a.length - 1) return score1;
//		score1 = Math.max(solve(a, i-1, score1, score2, ), b)
		return 0L;
	}
}
