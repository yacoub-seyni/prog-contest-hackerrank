import java.util.*;

public class Equal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for (int z = 0; z < tests; z++) {
			int n = sc.nextInt(), a[] = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			
			int j = n - 1, diff = 0, count = 0;
			Arrays.sort(a);
			
			while (j > 0) {
	
				diff = (a[j] - a[0]);
				count += (diff / 5); diff %= 5;
				count += (diff / 2); diff %= 2;
				count += diff;
				
				j--;
			}
			
			System.out.println(count);
		}
		sc.close();
	}
}
