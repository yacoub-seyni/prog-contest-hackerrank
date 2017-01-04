import java.util.*;

public class LargestRectangle_01 {
	
	static int a[], n;
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = sc.nextInt();
	
		System.out.println(solve());
		
		sc.close();
	}
	
	public static int solve() {
		
		// the bars stored in stack are always in increasing order
		// of their heights.
		Stack<Integer> stack = new Stack<Integer>();
		int top = 0, max_area = 0, area_with_top = 0;
		
		int i = 0;
		
		// run thru all bars
		while (i < n) {
			
			// if this bar is higher than the bar on top of stack,
			// push it to the stack
			if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
				stack.push(i);
				i++;
				
			// if this bar is lower than the top of the stack, calculate
			// area of rectangle with stack top as the smallest bar. 
			// 'i' is the "index on the right" for the top element,
			// and element before top in stack is the "index on the left"
			} else {
				top = stack.pop();
				// calc the area with a[top] stack as smallest bar
				area_with_top = a[top] * 
						(stack.isEmpty() ? i : i - stack.peek() - 1);
				max_area = Math.max(max_area, area_with_top);	
			}
			
		}
		
		// now, pop the remaining bars from stack and calculate area
		// with every popped bar as the smallest bar
		while (stack.isEmpty() == false) {
			
			top = stack.pop();
			area_with_top = a[top] * 
					(stack.isEmpty() ? i : i - stack.peek() - 1);
			
			max_area = Math.max(max_area, area_with_top);
		}
		
		return max_area;		
	}
}
