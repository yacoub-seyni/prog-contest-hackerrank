import java.util.*;

public class LuckBalance {

	static int[] luck, rating;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), k = sc.nextInt();
		luck = new int[n]; rating = new int[n];
		int neg = 0, sum = 0;
		
		for (int i = 0; i < n; i++) {
			luck[i] = sc.nextInt();
			rating[i] = sc.nextInt();
			if (rating[i] == 0) sum += luck[i];
			else neg += luck[i];
		}
		
		for (int i = 0; i < k; i++) {
			sum += (2 * findMax());
		}
		
		System.out.println(sum - neg);
		
		
		sc.close();

	}
	
	public static int findMax() {
		int max = 0, index = -1;
		
		for (int i = 0; i < luck.length; i++) {
			if (rating[i] == 1 && max < luck[i]) {
				max = luck[i]; index = i;
			}
		}
			
		luck[index] = -1;
		
		return max;
	}

}
