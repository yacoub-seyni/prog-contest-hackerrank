import java.util.*;

public class Candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a[] = new int[n],
				hold[] = new int[n];
		long total = 0;
		
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		
		Arrays.fill(hold, 1);
		
		for (int i = 1; i < n; i++) {
			if (a[i-1] < a[i]) hold[i] = hold[i-1] + 1;
		}
		
		for (int i = n - 2; i >= 0; i--) {
			
			if (a[i] > a[i+1]) {
				if (hold[i] <= hold[i+1]) 
					hold[i] = hold[i+1] + 1;
			}
		}
		
		for (int i = 0; i < n; i++) total += hold[i];
		
		System.out.println(total);
		
		sc.close();
	}
	
}
