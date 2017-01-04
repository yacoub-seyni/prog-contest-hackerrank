import java.util.*;

public class LargestPermutation {

	static int[] a;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int maxPos = -1, leftmostPos = -1;
		
		for (int i = 0; i < k; i++) {
			
			swap(maxPos, leftmostPos, i);
			
		}
		
		sc.close();
	}
	
	public static void swap(int x, int y, int t) {
		
	}

}
