import java.util.*;

public class BeautifulPairs {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n], b = new int[n];
		
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n; i++) b[i] = sc.nextInt();
		
		Arrays.sort(a); Arrays.sort(b);
		
		int a_count = 0, b_count = 0, sum = 0;
		
		while (a_count < n && b_count < n) {
			
			if (a[a_count] == b[b_count]) { sum++; a_count++; b_count++; }
			else if (a[a_count] < b[b_count]) a_count++;
			else b_count++;
				
		}
		
		if (sum < n) sum++; // for the one change
		
		System.out.println(sum);
		
		sc.close();		
		
	}
}
