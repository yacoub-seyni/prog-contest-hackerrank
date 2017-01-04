import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// scan in the number of test cases
		int t = sc.nextInt();

		for (int cases = 0; cases < t; cases++) {
			int n = sc.nextInt(),
					k = sc.nextInt();
			int[] a = new int[n];
			int count = 0; 	// number of students who 
							// showed up on time

			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
				// as you read in the times students come
				// to class, increment count
				if (a[i] <= 0) count++;
			}
			
			// if at least k students are on time,
			// class is not cancel
			if (count >= k)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		sc.close();
	}
}
