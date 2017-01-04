import java.util.*;

public class LargestPrimeFactor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int t_i = 0; t_i < t; t_i++) {
			long n = sc.nextLong();
			
			while (n % 2 == 0) n /= 2;
			
			if (n == 1) System.out.println(2);
			else {
				int i, root_n = (int) Math.sqrt(n);
				boolean printed = false;
				
				for (i = 3; i <= root_n; i += 2) {
					while (n % i == 0) n /= i;
					if (n == 1) {
						System.out.println(i); printed = true;
						break;
					}
				}
				
				if (printed == false) System.out.println(n);
				
			}			
		}
		sc.close();
	}
}
