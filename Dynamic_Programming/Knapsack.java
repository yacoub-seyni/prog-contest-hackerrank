import java.util.*;

public class Knapsack {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt(), k = sc.nextInt();
			int[] a = new int[n], store = new int[k + 1];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
						
			Arrays.sort(a);
			Arrays.fill(store, -1);
			
			System.out.println(solve(a, k, store));	
			
		}
		
		sc.close();
	}
	
	private static int solve(int[] a, int k, int[] store) {
		
		int max = 0;
		
		for (int i = 1; i <= k; i++) {
			max = Math.max(max, dp(a, k, i, store));
		}
		
		return max;
	}
	
	private static int dp(int[] a, int k, int ptr, int[] store) {
		
        if (store[ptr] != -1) return store[ptr];
        
		for (int i = 0; i < a.length; i++) {
			
			if (ptr - a[i] >= 0)
				store[ptr] = Math.max(store[ptr], a[i] + dp(a, k, ptr - a[i], store));
			else
				store[ptr] = Math.max(store[ptr], 0);
			
		}
		return store[ptr];
	}
}
