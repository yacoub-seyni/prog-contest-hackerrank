import java.util.*;

public class MandragoraForest_01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t0 = 0; t0 < T; t0++) {
			int N = sc.nextInt();
			int[] H = new int[N];
			for (int i = 0; i < N; i++) H[i] = sc.nextInt();
			Arrays.sort(H);
			
			long[] C = new long[N]; C[N-1] = H[N-1];
			for (int i = N-2; i >= 0; i--) C[i] = C[i+1] + H[i];
			
			long S = 1, P = 0;
			
			int ptr = 0;
			
			while (ptr < N && P < C[ptr] * S ) {
				P = C[ptr] * S;
				ptr++;
				S++;
			}
			
			System.out.println(P);
		}
		
		sc.close();
	}
}
