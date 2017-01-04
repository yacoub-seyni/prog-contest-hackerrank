import java.util.Arrays;
import java.util.Scanner;

public class LarrysArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int z = 0; z < cases; z++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] val = new int[3];
			
			boolean notPossible = false;
			
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			
			for (int i = 0; i < n - 2; i++) {
				val[0] = a[i]; val[1] = a[i+1]; val[2] = a[i+2];
				
				Arrays.sort(val);

				// if sorted array has the permutation of
				// ACB, BAC or CBA from the original ABC sequence,
				// then it's impossible to sort the whole array
				
				// it's better to check for permutation that will result in possible
				// sorting, and then negate it to get the impossible sequence.
				// this is because there may be duplicate values (A may be equal to B,
				// or C).
				if ( ! ( ((val[0] == a[i]) && (val[1] == a[i+1]) && (val[2] == a[i+2])) ||
						((val[0] == a[i+1]) && (val[1] == a[i+2]) && (val[2] == a[i])) ||
						((val[0] == a[i+2]) && (val[1] == a[i]) && (val[2] == a[i+1])) )) {
					notPossible = true;
					break;
				} else {
					// update array's values a[i], a[i+1] and a[i+2]
					a[i] = val[0]; a[i+1] = val[1]; a[i+2] = val[2];
				}
			}
			
			if (notPossible) System.out.println("NO");
			else System.out.println("YES");
			
		}
		
		
		
		sc.close();
	}
}
