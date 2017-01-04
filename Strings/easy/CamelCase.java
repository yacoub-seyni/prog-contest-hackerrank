package easy;

import java.util.*;

public class CamelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int sum = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') sum++;
		}
		
		System.out.println(sum);
		
	}
}
