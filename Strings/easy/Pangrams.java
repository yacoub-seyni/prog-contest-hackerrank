package easy;

import java.util.*;

public class Pangrams {
	
	public static void main(String[] args) {
		int alpha = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toLowerCase();
		str = str.replaceAll(" ", "");
		
		sc.close();
		
		int i = 0, n = 1 << 26;
		
		while (i < str.length() && (n - alpha != 1)) {
			
			alpha = alpha | (1 << (str.charAt(i) - 'a'));
			i++;
		}
		
		if (n - alpha == 1) System.out.println("pangram");
		else System.out.println("not pangram");
		
		
	}
}
