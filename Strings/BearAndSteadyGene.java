import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {
	
	static int n = 0;
	static Map<Character, Integer> map;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		map = new HashMap<Character, Integer>();
		
		n = sc.nextInt();
		int maxIndex, minIndex, minLength;
		String str = sc.next();
		
		maxIndex = 0;
		map.put('A', 0); map.put('C', 0); 
		map.put('G', 0); map.put('T', 0);
		
		// start from the rightmost character.
		// find the index maxIndex such that the sequence of all
		// the characters to the right of maxIndex (including
		// maxIndex) is a valid gene.
		for (int i = n - 1; i >= 0; i--) {
			map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			
			if (! isValid()) {
				map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
				maxIndex = i + 1;
				break;
			}
		}
				
		if (maxIndex == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		minLength = maxIndex;
		
		for (minIndex = 0; minIndex < maxIndex 
				&& maxIndex < n; minIndex++) {
			map.put(str.charAt(minIndex), 
					map.get(str.charAt(minIndex)) + 1);
			
			while ((! isValid()) && (maxIndex < n)) {
				map.put(str.charAt(maxIndex), 
						map.get(str.charAt(maxIndex)) - 1);
				maxIndex++;
			}
			
			if (minLength > maxIndex - minIndex - 1) {
				minLength = maxIndex - minIndex - 1;
			}
		}
		
		System.out.println(minLength);	
		
		sc.close();
	}
	
	private static boolean isValid() {
		if ( (map.get('A') <= n / 4) && (map.get('C') <= n / 4) 
				&& (map.get('G') <= n / 4) 
				&& (map.get('T') <= n / 4) ) {			
			return true;
		}
		return false;
	}
}
