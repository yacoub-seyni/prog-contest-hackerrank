/* code written by author @Isming from Hackerrank.com/,
 * posted on discussion page
 */
import java.util.Scanner;

public class NewYearChaos {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int cases = sc.nextInt();
		
		for (int z = 0; z < cases; z++) {
			int n = sc.nextInt(), sum = 0;
			int[] array = new int[n];
			boolean tooChaotic = false;
			
			for (int i = 0; i < n; i++) array[i] = sc.nextInt();
			
			for (int i = n - 1; i >= 0; i--) {
				if (array[i] - (i + 1) > 2) {
					tooChaotic = true;
					break;
				}
				
				for (int j = Math.max(0, array[i] - 2); j < i; j++)
					if (array[j] > array[i]) sum++;
			}
			
			if (tooChaotic) System.out.println("Too chaotic");
			else System.out.println(sum);
			
			
		}
		
		sc.close();
	}
}
