import java.util.*;

public class GridChallenge {

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		int tests = sc.nextInt();
		
		for (int z = 0; z < tests; z++) {
			int n = sc.nextInt();
			char[][] mat = new char[n][n];
			String hold = "";
			boolean notSorted = false;
			
			for (int i = 0; i < n; i++) {
				hold = sc.next();				
				for (int j = 0; j < n; j++) {
					mat[i][j] = hold.charAt(j);
				}				
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.sort(mat[i]);
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (mat[j-1][i] > mat[j][i]) {
						notSorted = true; break;
					}
				}
				
				if (notSorted) break;
			}
			
			if (notSorted) System.out.println("NO");
			else System.out.println("YES");
			
		}
		
		sc.close();
	}

}
