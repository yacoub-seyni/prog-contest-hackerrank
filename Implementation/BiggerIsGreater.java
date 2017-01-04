import java.util.*;

public class BiggerIsGreater {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String str, sorted, toPrint;

		for (int t0 = 0; t0 < t; t0++) {
			str = sc.next();
			char a[];			
			int i = str.length() - 1;
			boolean found = false;
			
			while(i > 0) {
				if (str.charAt(i-1) >= str.charAt(i)) {
					i--;
				} else {
					a = str.substring(i-1).toCharArray();
					Arrays.sort(a);
					sorted = String.valueOf(a);
					
					toPrint = (i - 1 >= 0 ? str.substring(0, i-1) :
						" ") + biggerThan(str.substring(i-1, i), sorted);
					System.out.println(toPrint);
					found = true;
					break;					
				}

			}
			
			if (found == false) System.out.println("no answer");
		}

		sc.close();
	}
	
	private static String biggerThan(String str, String a) {
		
		int index = a.lastIndexOf(str);
		String bigger = a.substring(index+1, index+2);
		String replace = a.replaceFirst(bigger, "");
		return bigger + replace;
	}
}
