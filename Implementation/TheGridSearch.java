import java.util.Scanner;

public class TheGridSearch {
	
	static int t, r, c, dr, dc, v, y;
	static String[] a, b;
	static Scanner sc;
	static boolean printed, firstPass;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			a = new String[r];
			printed = false;
			firstPass = true;
			
			for (int j = 0; j < r; j++) a[j] = sc.next();
			
			dr = sc.nextInt();
			dc = sc.nextInt();			
			b = new String[dr];
			
			for (int j = 0; j < dr; j++) b[j] = sc.next();
			
			v = 0;
			while (v < r) {
				int k = 0, index = -1;
				
				y = v;
				while ((k < dr) && (y < r) && a[y].contains(b[k])) {
					
					if (firstPass)	{
						index = a[y].indexOf(b[k]);
						firstPass = false;
					}
					else {
						if (index != a[y].indexOf(b[k])) break;
					}
					
					y++; k++;
				}
				
				if (k == dr) { System.out.println("YES"); printed = true; break; }
				v++;
			}
			
			if (printed) System.out.println("NO");
		}
		sc.close();
	}
}
