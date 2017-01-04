import java.util.*;

public class AlmostSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), a[] = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		
		if (n == 2) { 
			if (a[0] < a[1]) System.out.println("yes");
			else System.out.println("yes\nswap " + 1 + " " + 2);
		} else {
			if (! swapped(a)) reversed(a);
		}
		
		sc.close();
	}
	
	private static boolean swapped(int[] a) {
		int i = 0, x = 0,
				bound[] = {-1, -1},
				bound_left[] = {-1, -1}, 
				bound_right[] = {1000005, 1000005},
				index1 = -1, index2 = -1;
				
		while (i < a.length - 1) {
			
			if (a[i] < a[i+1] && (bound[x] != 1 && bound[x] < a[i])) { i++; }
			else if (x == 2) return false;
			else {
				if (x == 0) {					
					bound[x] = a[i];
					index1 = i;
					bound_left[x] = (i - 1 >= 0) ? a[i-1] : -1;
					bound_right[x] = a[i+1];
				} else {
					bound[x] = a[i+1];
					index2 = i + 1;
					bound_left[x] = a[i];
					bound_right[x] = (i + 1 < a.length - 1)? a[i+2] : 1000005;
				}
				
				if (bound_left[x] < bound_right[x]) i++;			
				else {
					return false;
				}
				x++;
			}
		}
		
		if (x == 0) { System.out.println("yes"); return true; }		
		else if (bound_left[0] < bound[1] && bound_right[0] > bound[1] 
				&& bound_left[1] < bound[0] && bound_right[1] > bound[0]) {
			System.out.println("yes\nswap " + (index1 + 1) + " " + (index2 + 1));
			return true;
		} else {
			return false;
		}		
	}
	
	private static void reversed(int[] a) {
		// System.out.println("trying reversed");
		
		// find decreasing segment
		int left = -1, right = 1000005, i = 0;
		
		while (i < a.length - 1) {
			if (a[i] < a[i+1]) i++;	
			else { left = i; break; }
		}
		
		i = a.length - 1;
		while (i > 0) {
			if (a[i] > a[i-1]) i--;
			else { right = i; break; }
		}
		
		i = left;		
		while (i < right) {
			if (a[i] > a[i+1]) i++;
			else break;
		}
		
		if (i == right && a[left + 1] > a[right] && 
				((right < a.length && a[right+1] > a[left]) || 
						(right == a.length))) { 
			System.out.println("yes\n" +
					"reverse " + (left + 1) + " " + (right + 1));
		} else System.out.println("no");
	
	}
}
