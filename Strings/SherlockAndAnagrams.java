import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), ans = 0;
		String str = "";
		char[] a;
		Map<Character, Integer> map;
		
		for (int z = 0; z < t; z++) {
			str = sc.next();
			a = str.toCharArray();
			ans = 0;
			map = new HashMap<Character, Integer>();
			
			for (int i = 0; i < str.length(); i++) {
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
				} else {
					map.put(a[i], 1);
				}
			}
			
			int countSame = 0, next = 0, neg = 0;
			for (int i = 0; i < str.length(); i++) {
				countSame = 0; next = 0; neg = 0;
				
				if (map.get(a[i]) > 1) {
					 
					int start = str.indexOf(str.charAt(i));
					
					while ((next = 
							str.indexOf(str.charAt(i), start + 1)) != -1) {
						
						if (next - start == 1) neg++;
						if (next == str.length() - 1) neg++;
						
						start = next;
					}
					countSame = map.get(a[i]);
					ans += calc(countSame);
					ans -= calc(neg);
					
					map.put(a[i], -1);
				}
				
			}
			
			System.out.println(ans);
			
		}
		
		
		sc.close();
	}
	
	private static int calc(int x) {
		int sum = 0;
		for (int i = 1; i <= x; i++) sum += i;
		return sum;
	}
	
	private static boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
		Arrays.sort(a1); Arrays.sort(a2);
		
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) return false;
		}		
		
		return true;
	}
}
