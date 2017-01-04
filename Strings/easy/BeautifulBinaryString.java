package easy;

import java.util.*;

public class BeautifulBinaryString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		int steps = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i+3).equals("010")) {
				// pretend you have changed the last 0 to 1
				steps++;
				i += 2;
			}
		}
		
		System.out.println(steps);
		
	}
}
