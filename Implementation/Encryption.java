import java.util.Scanner;

public class Encryption {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		
		int len = str.length(),
				rows = (int) Math.floor(Math.sqrt(len)),
				cols = (int) Math.ceil(Math.sqrt(len));
		
		if (rows * cols < len) rows++;
		
		for (int i = 0; i < cols; i++) {
			for (int j = i; j < len; j += cols) {
				sb.append(str.charAt(j));
			}
			sb.append(" ");
		}
		
		System.out.println(new String(sb));
		sc.close();
		
	}
}
