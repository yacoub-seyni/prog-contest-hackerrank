import java.util.*;

public class SherlockAndAnagrams_01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Map<String, Integer> map;
		
		for (int z = 0; z < t; z++) {
			String str = sc.next();
			int len = 1;
			map = new HashMap<String, Integer>();
			
			while (len < str.length()) {
				
				for (int i = 0; i < str.length() -
						(len - 1); i++) {
					String sub = str.substring(i, i + len);
					char[] a = sub.toCharArray();
					Arrays.sort(a);
					sub = String.valueOf(a);
					
					if (map.containsKey(sub)) {
						map.put(sub, map.get(sub) + 1);
						//System.out.println("*" + sub + ":" + map.get(sub));
					} else {
						map.put(sub, 1);
						//System.out.println("*" + sub + ":" + map.get(sub));
					}
				}
				len++;
			}
			
			int nPairs = 0;
			
			for (Integer i : map.values()) {
				if (i >= 2) {
					nPairs += (i * i - i) / 2;
				}
			}
			
			System.out.println(nPairs);			
		}
		
		sc.close();
	}
}
