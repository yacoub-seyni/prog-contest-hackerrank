import java.util.Scanner;

public class SherlockAndArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), n, a[];
		
		for (int z = 0; z < t; z++) {
			n = sc.nextInt();
			a = new int[n];
			int left = 0, right = 0;
			
			a[0] = sc.nextInt();
			for (int i = 1; i < n; i++) {
				a[i] = sc.nextInt();
				right += a[i];
			}
			
			int x = 0;
			boolean found = false;
			
			while (x < n - 1) {
				if (left == right) {
					found = true;
					break;
				}
				
				left += a[x];
				right -= a[x+1];				
				x++;
			}
			
			if (found || n == 1) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
		
		sc.close();
	}
}
