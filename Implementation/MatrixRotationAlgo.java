import java.util.Scanner;

public class MatrixRotationAlgo {
	
	static int m, n, r, mat[][], x, y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		r = sc.nextInt();
		mat = new int[m][n];
		x = 0; y = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		// wrap around rotation times
		r = r % ( (m + n) * 2);
		
		for (int i = 0; i < m / 2; i++) {
		
			// save first element of layer
			int first = mat[i][i];
		
			for (int j = i; j <= n - i - 1; j++) {
				int offset = j - i;
				findNext();
				
				while ( !((x == i) && (y == i) ) ) {
					move(mat[x][y], m, n, r);
					findNext();
				}
				
				
			}
		}
		
		
		sc.close();
	}
	
	public static void move(int val, int rows, 
			int cols, int numRots) {
		
		
	}
	
	public static void findNext() {
		
	}
}
