import java.util.Arrays;
import java.util.Scanner;

public class MissingNumbers {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, a[], m, b[];
		
		n = sc.nextInt();
		a = new int[n];		
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		
		m = sc.nextInt();	
		b = new int[m];
		for (int i = 0; i < m; i++) b[i] = sc.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int x = 0, y = 0, last = 0, count = 0;
		boolean firstPrint = true;
		
		while ( (x < a.length) && (y < b.length) && (count < (m - n)) ) {
			
			if (a[x] != b[y]) {
				
				while (a[x] != b[y]) {	
					
					if (last != b[y]) {
						
						
						if (firstPrint) {
							System.out.print(b[y]);
							firstPrint = false;
						} else {
							System.out.print(" " + b[y]);
						}
					}
					last = b[y];
					y++;
				}
				
				count++;
			} else {
				// last = b[y];
				x++;
				y++;
				
			}			
		}
		
		while (y < b.length && (count < (m - n))) {
			if (firstPrint) {
				System.out.print(b[y]);
				firstPrint = false;
			}
			else {
				System.out.print(" " + b[y]);
				
			}
			y++;
		}
		
		sc.close();
	}
}
