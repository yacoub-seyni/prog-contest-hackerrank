import java.util.*;

public class PriyankaAndToys {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), a[] = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		
		int cost = a[0], num = 1, i = 1;
		
		while (cost <= a[n-1] && i < n) {
			cost += 4;
			
			while (i < n && cost >= a[i]) {
				i++;
			}
			
			if (i < n && cost < a[i]) {
				cost = a[i];
				num++;
			}
			
		}
		
		System.out.println(num);
		
		sc.close();
	}
}
