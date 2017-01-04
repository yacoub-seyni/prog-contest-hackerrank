import java.util.*;

public class LargestRectangle {
	
	static int n, a[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); a = new int[n];
		int largestRect = 0;
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int left = 0, right = n - 1;
		
		largestRect = a[indexMin(left, right)] * n;
		System.out.println("length: " + a[indexMin(left, right)]);
		System.out.println(left + ", " + right + ", " + largestRect);
		
		while (left <= n - 1 && right >= 0 && left <= right) {
			
			// deal with left side
			while ( (left <= n - 1 && left <= right) ) {
				
				if (largestRect <= a[indexMin(left, right)] * (right - left + 1)) {
					largestRect = a[indexMin(left, right)] * (right - left + 1);
					System.out.println(left + ", " + right + ", " + largestRect);
					left++;
				} else {
					left--;
					break;
				}
			}
				
			// deal with right side
			while ( (right >= 0 && left <= right) ) {
					
				if (largestRect <= a[indexMin(left, right)] * (right - left + 1)) {
					largestRect = a[indexMin(left, right)] * (right - left + 1);
					System.out.println(left + ", " + right + ", " + largestRect);
	
					right--;
				} else {
					right++;
					break;
				}
			}
		}
		
		System.out.println(largestRect);
		
		sc.close();

	}
	
	public static int indexMin(int left, int right) {
		int min = left;
		for (int i = left; i <= right; i++) {
			if (a[i] < a[min]) {
				min = i;
			}
		}
		return min;
	}

}
