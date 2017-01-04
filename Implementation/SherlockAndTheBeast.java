import java.util.Scanner;

public class SherlockAndTheBeast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		// scan in the number of test cases
		int t = sc.nextInt();
		
		for (int cases = 0; cases < t; cases++) {
			int n = sc.nextInt();
			boolean found = false;
			
			// There are "n" combinations of length "n" using
			// 5 and 3. For instance, if n = 6, the 6 combinations
			// are: 555553, 555533, 555333, 553333, 533333, 333333.
			// So we iterate n times, and start with the possibility
			// of having all n digits be 5. If such number does not
			// satisfy the conditions given, we try the next largest
			// possibility: (n-1) digits of 5, and 1 digit of 3. 
			// We continue until we find a decent number, or until
			// we reach the end of the loop.
			for (int i = n; i >= 0; i--) {
				// use a StringBuilder (a string whose length
				// can be modified) which is more efficient 
				// than a simple String
				StringBuilder str = new StringBuilder();
				
				// If the current number is a decent number
				if ( ((i % 3) == 0) && ( ((n - i) % 5) == 0) ) {			
					for (int j = 0; j < i; j++)	str.append("5");
					for (int j = i; j < n; j++)	str.append("3");
					
					// convert the StringBuilder to a String
					String s = str.toString();				
                    
					// set found to true, so that we know that
					// we have found a decent number
					found = true;
					System.out.println(s);
					break;
				} 				
			}
			
			// if we haven't found a decent number
			if (found == false) 
				System.out.println("-1");
		}	
		
		sc.close();
	}
}

