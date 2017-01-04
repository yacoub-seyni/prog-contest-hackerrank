import java.util.*;

public class TwoArrays {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int z = 0; z < t; z++) {
			int n = sc.nextInt(), k = sc.nextInt();
			int[] a = new int[n], b = new int[n];
			boolean notPossible = false;
			
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			for (int i = 0; i < n; i++) b[i] = sc.nextInt();
			
			Arrays.sort(a); 
			Arrays.sort(b);
			
			for (int i = 0; i < n; i++) {
				if (a[i] + b[n - i - 1] < k) {
					notPossible = true;
					break;
				}
			}
			
			if (notPossible) System.out.println("NO");
			else System.out.println("YES");
			
			
			
		}
		
		sc.close();
	}
}
