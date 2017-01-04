import java.util.Scanner;

public class AlternatingCharacters {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int z = 0; z < t; z++) {
			String str = sc.next(); char hold = str.charAt(0);
			
			int i = 0, count = 0;
			
			while (i < str.length() - 1) {
				if (hold == str.charAt(i+1)) {
					count++;
				} else {
					hold = str.charAt(i+1);
				}
				i++;
			}
			
			System.out.println(count);
			
			
			
		}
		sc.close();
	}
}
