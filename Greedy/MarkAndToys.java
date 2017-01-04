import java.util.*;

public class MarkAndToys {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int a[] = new int[n];
		for (int i=0; i < n; i++) a[i] = sc.nextInt();
		
		Arrays.sort(a);
		int i = 0, count = 0;
		
		while (k > 0 && k >= a[i]) {
			k -= a[i];
			count++;
			i++;
		}
		
		System.out.println(count);
		sc.close();
	}
}
