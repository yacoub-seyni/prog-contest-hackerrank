package easy;

import java.util.*;

public class RichieRich {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),
				k = sc.nextInt();
		StringBuilder sb = new StringBuilder(sc.next());
		sc.close();
		boolean touched[] = new boolean[n];
		
		int left = (int) Math.floor((n - 1) / 2.0);
		int right = (int) Math.ceil((n - 1) / 2.0);
		int count = 0;
		
		if (n == 1 && k > 0) {
			System.out.println("9");
			return;
		}
		else if (n == 1 && k == 0) {
			System.out.println(n);
			return;
		}
		
		while (left >= 0 && right < n) {
			
			if (sb.charAt(left) != sb.charAt(right))
				count++;			
			left--;
			right++;
		}
				
		if (count > k) System.out.println(-1);		
		else {		
			int ptr = 0;
			int i = 0;
			while (ptr < (n / 2) && i < count) {
				
				if (sb.charAt(ptr) != sb.charAt(n - 1 - ptr)) {

					if (sb.charAt(ptr) < sb.charAt(n - 1 - ptr)) {
						sb = sb.replace(ptr, ptr+1, 
								String.valueOf(sb.charAt(n-1-ptr)));
						touched[ptr] = true;
						// System.out.println("t: " + ptr);
					} else {
						sb = sb.replace(n-1-ptr, n-ptr, 
								String.valueOf(sb.charAt(ptr)));
						touched[n-1-ptr] = true;
						// System.out.println("p: " + (n-1-ptr));

					}
					i++;
				}
				ptr++;								
			}
			
			i = 0;
			ptr = 0;
			
			
			if (count == 0 && (n % 2) == 1) {
				sb = sb.replace((n-1)/2, (n-1)/2 + 1, "9");
				
			} else {
				while (ptr < (n / 2) && i < k - count) {
					if (sb.charAt(ptr) != '9' && touched[ptr] == false
							&& touched[n-1-ptr] == false
							&& !(i < k - count - 1)) {
						;
					}
					
					else if (sb.charAt(ptr) != '9') {
						sb = sb.replace(ptr, ptr+1, "9");
						sb = sb.replace(n-1-ptr, n-ptr, "9");
						if (!touched[ptr]) i++;
						if (!touched[n-1-ptr]) i++;
					
					}
					ptr++;
				}
			}
			
			System.out.println(sb.toString());
		}		
	}
}
