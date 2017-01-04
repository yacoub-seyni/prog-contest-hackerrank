import java.util.*;

public class MandragoraForest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int t_0 = 0; t_0 < TC; t_0++) {
			int N = sc.nextInt();
			int[] H = new int[N];
			
			for (int i = 0; i < N; i++) H[i] = sc.nextInt();
			
			Arrays.sort(H);
			
			long[] C = new long[N];
			C[N-1] = H[N-1];
			for (int i = N - 2; i >= 0; i--) C[i] = C[i+1] + H[i];
			
			System.out.println(dp(0, H, C, 1, 0, Action.EATS));			
		}
		
		sc.close();
	}
	
	public static long dp(int i, int[] H, long[] C, int S, long P, Action a) {
		if (i >= H.length) { return P; }
		
		if (a == Action.BATTLES) {			
			return (P + S * C[i]);
		}
		
		return Math.max( (dp(i + 1, H, C, S + 1, P, Action.EATS)),
				(dp(i + 1, H, C, S, P + S * H[i], Action.BATTLES)) );
	}
}

enum Action { EATS, BATTLES; }