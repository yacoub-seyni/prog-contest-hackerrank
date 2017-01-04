import java.util.Arrays;
import java.util.Scanner;

public class Equal_01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for (int z = 0; z < tests; z++) {
			int n = sc.nextInt(), a[] = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			
			int diff = 0, count = 0;
			Arrays.sort(a);
			int min = a[0], ops = Integer.MAX_VALUE;
			
			for (int i = min - 4; i <= min; i++) {
				count = 0;
				for (int j = 0; j < n; j++) {
					diff = a[j] - i;
					
					count += (diff / 5); diff %= 5;
					count += (diff / 2); diff %= 2;
					count += diff;
				}
				
				ops = Math.min(ops, count);
			}
			
			System.out.println(ops);
		}
		sc.close();
	}

}
