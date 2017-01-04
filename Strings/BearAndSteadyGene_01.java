import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene_01 {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, maxIndex = 0, limit, out = 999999;
		map = new HashMap<Character, Integer>();
		map.put('A', 0); map.put('C', 0);
		map.put('G', 0); map.put('T', 0);
		String str;
		
		n = sc.nextInt();
		str = sc.next();
		limit = n / 4;
		
		for (int i = n - 1; i >= 0; i--) {
			map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			if ( ! validityCheck(limit)) {
				maxIndex = i + 1;
				map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
				break;
			}
		}
		
		for (int minIndex = -1; minIndex < n - 1 && maxIndex < n &&
				minIndex < maxIndex; minIndex++) {
			
			while (!validityCheck(limit) && maxIndex < n) {
				map.put(str.charAt(maxIndex), map.get(str.charAt(maxIndex)) - 1);
				maxIndex++;
			}
			
			if (maxIndex > n || !validityCheck(limit)) {
				break;
			}
			
			int subLength = Math.max(0, maxIndex - minIndex - 1);
			if (subLength < out) {
				out = subLength;
			}
			map.put(str.charAt(minIndex + 1), map.get(str.charAt(minIndex + 1)) + 1);
		}
		
		System.out.println(out);
		sc.close();
	}
	
	private static boolean validityCheck(int limit) {
		
		if ( (map.get('A') <= limit) && (map.get('C') <= limit) 
				&& (map.get('G') <= limit) 
				&& (map.get('T') <= limit) ) {			
			return true;
		}
		return false;
	}
}
