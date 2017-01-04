import java.util.Scanner;

// solution based on the 15-puzzle solvability
//
public class LarrysArray_01 {

	private static int cases, n, array[], sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		cases = sc.nextInt();
		
		for (int z = 0; z < cases; z++) {
			n = sc.nextInt();
			array = new int[n];
			sum = 0;
			
			for (int i = 0; i < n; i++) array[i] = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if (array[i] > array[j]) sum++;
				}
			}
			
			if (sum % 2 == 0) System.out.println("YES");
			else System.out.println("NO");			
		}
		
		sc.close();
	}
}
