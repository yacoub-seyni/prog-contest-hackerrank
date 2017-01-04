
import java.util.Scanner;

public class NewYearChaos_01 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int cases = sc.nextInt();
		
		
		for (int z = 0; z < cases; z++) {
			int n = sc.nextInt(),
					sum = 0;
			int[] a = new int[n+1];
			boolean chaotic = false, 
					modified = false;

			for (int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
				if (a[i] - i > 2) {					
					chaotic = true;					
				}
			}
			
			if (chaotic) System.out.println("Too chaotic");
			else {
				for (int i = 1; i < n; i++) {
					modified = false;
					
					for (int j = 1; j <= n - 1; j++) {
						
						if (a[j] > a[j+1]) {
							int temp = a[j];
							a[j] = a[j+1];
							a[j+1] = temp;
							
							sum++;
							modified = true;
						}
					}
					
					if (modified) modified = false;
					else break;
				}
				
				System.out.println(sum);
			}

		}
		sc.close();
	}
}
