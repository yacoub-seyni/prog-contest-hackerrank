import java.util.*;

public class AbsolutePermutation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int t0 = 0; t0 < t; t0++) {
			int n = sc.nextInt(), 
					k = sc.nextInt();
			
			if (k == 0) printIncreasing(n);
			else if (n % (2*k) != 0) System.out.println("-1");
			else {
				StringBuilder sb = new StringBuilder();
				
				for (int i = 1; i <= n - 2*k + 1; i += (2*k)) {
					int mid = ((i + 2*k) + i ) / 2;
					// System.out.println("mid: " + mid);
					
					for (int j = mid; j < i + 2*k; j++) {
						sb.append(j + " ");
					}
					
					for (int j = i; j < mid; j++) {
						sb.append(j + " ");
					}					
				}
				
				sb.delete(sb.length()-1, sb.length());
				
				System.out.println(sb.toString());
			}
			
		}
		
		
		sc.close();
	}
	
	private static void printIncreasing(int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < n; i++) {
			sb.append(i + " ");
		}
		sb.append(n);
		
		System.out.println(sb.toString());
	}
}
