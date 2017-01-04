import java.util.Scanner;

public class TwoStrings {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int z = 0; z < t; z++) {
			String a = sc.next(),
					b = sc.next();
			int map_a = 0, map_b = 0, ptr = 0;
			
			for (int i = 0; i < a.length(); i++) {
				ptr = 1 << (
						Character.getNumericValue(a.charAt(i)) - 10);
				map_a = map_a | ptr;
			}
			
			for (int i = 0; i < b.length(); i++) {
				ptr = 1 << (
						Character.getNumericValue(b.charAt(i)) - 10);
				map_b = map_b | ptr;
			}
			
			if ((map_a & map_b) == 0) System.out.println("NO");
			else System.out.println("YES");
		}
		sc.close();
	}
}
