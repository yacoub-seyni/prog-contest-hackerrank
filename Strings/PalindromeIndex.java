import java.util.Scanner;

public class PalindromeIndex {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for (int z = 0; z < t; z++) {
			String str = sc.next();
			
			int i = 0, j = str.length() - 1;
			boolean found = false, possible = true;
			
			while (i <= j) {
				if (str.charAt(i) == str.charAt(j)) {
					i++; j--;
				} else if (found == true) {
					possible = false;
					break;
				} else if (isPalin(str.substring(i, j))) {
					System.out.println(j);
					found = true;
					break;
					
				} else if (isPalin(str.substring(i+1, j+1))) {
					System.out.println(i);
					found = true;
					break;
				} else {
					break;
				}
				
			}
			
			if ((possible == false) || (found == false)) System.out.println(-1);
			
		}		
		sc.close();
	}
	
	private static boolean isPalin(String s) {
		int x = 0, y = s.length() - 1;
		
		while (x <= y) {
			if (s.charAt(x) != s.charAt(y)) {
				return false;
			}
			
			x++; y--;
		}
		return true;
	}
}
