import java.util.*;

public class Candies_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a[] = new int[n], 
				hold[] = new int[n], total = 0;
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		
		
		System.out.println(total);
		
		
		sc.close();
	}
	
	private static boolean isMin(int x) {
		return false;
	}
	
	private static boolean isMax(int x) {
		return false;
	}
	
	private static int getNextMin(int x) {
		return 1;
	}
	
	private static int getNextMax(int x) {
		return 1;
	}
}
