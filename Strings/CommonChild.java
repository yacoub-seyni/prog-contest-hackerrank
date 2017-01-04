import java.util.*;

public class CommonChild {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s1, s2;
		s1 = sc.next();
		s2 = sc.next();
		int index = 0, sum = 0;
		Map<Integer, Character> map = new LinkedHashMap<Integer, Character>();
		
		for (int i = 0; i < s1.length(); i++) {
			int start = 0;
			if (s2.contains(s1.substring(i, i + 1))) {
				index = s2.indexOf(s1.substring(i, i + 1), start);
					map.put(index, s1.charAt(i));
					start = index + 1;
			}			
		}
		int prev = -1, hold = 0;
		for (Integer i : map.keySet()) {
			System.out.println("val: " + i);
			
			if (i > prev) {
				hold++; prev = i;
			} else {	
				sum = Math.max(sum, hold);
				hold = 1; prev = i;
			}
		}
		
		sum = Math.max(sum, hold);
		System.out.println(sum);
		
		sc.close();
	}
}
