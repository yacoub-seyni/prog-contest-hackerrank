package easy;

import java.util.*;

public class SuperReducedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		sb = new StringBuilder(sc.next());

		int i = 1;
		boolean changed = false;
		
		while (true) {
			changed = false;
			i = 1;
			
			while(i > 0 && i < sb.length()) {
				if (sb.charAt(i-1) == sb.charAt(i)) {
					sb.delete(i-1, i+1);	
					changed = true;
				}
			
				i++;
			}
			
			if (changed) changed = false;
			else break;
		}

		if (sb.length() > 0)
			System.out.println(sb.toString());
		else System.out.println("Empty String");
	}
}
