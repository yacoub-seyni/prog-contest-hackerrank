import java.util.*;

public class SimpleTextEditor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt(), hold = 0;
		Stack<String> stack = new Stack<String>();
		stack.push("");
		
		for (int i = 0; i < q; i++) {
			hold = sc.nextInt();
			
			if (hold == 1) {
				stack.push(stack.peek() + sc.next());
			} else if (hold == 2) {
				stack.push(stack.peek().substring(0, stack.peek().length() - sc.nextInt()));
			} else if (hold == 3) {
				System.out.println("" + stack.peek().charAt(sc.nextInt() - 1));
			} else if (hold == 4) {
				stack.pop();
			}
		}
		sc.close();
	}
}
