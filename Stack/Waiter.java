import java.util.*;

public class Waiter {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, q;
		Stack<Integer> stack = new Stack<Integer>();
		
		n = sc.nextInt();
		q = sc.nextInt();
		for (int i = 0; i < n; i++) stack.push(sc.nextInt());
		
		sc.close();
	}
}
