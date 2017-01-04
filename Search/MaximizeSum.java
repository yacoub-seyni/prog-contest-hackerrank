import java.util.Scanner;

public class MaximizeSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int z = 0; z < t; z++) {
			int n = sc.nextInt();
			long m = sc.nextInt();
			long a[] = new long[n];
			
			for (int i = 0; i < n; i++) {
				a[i] = (sc.nextLong() % m);
			}
			
			long curr = 0, max = 0;
			
			for (int i = 0; i < n; i++) {
				curr = 0;
				for (int j = i; j < n; j++) {
					curr = Math.max(curr, (curr + a[j]) % m);
					if (curr == m - 1) break;
				}
				
				max = Math.max(curr, max);
				if (max == m - 1) break;
			}
			
			System.out.println(max);
			
			
			
		}
		
		
		
		sc.close();
	}
}
