import java.util.*;

/***
 * Solution written by @author vsoskov on Hackerrank.com/
 *
 */
public class AndXorOr {

	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>(); 
		int max = Integer.MIN_VALUE;
		int [] a = new int[N];
		
		for(int i = 0; i < N; i++){
			int n = in.nextInt();
			
			while(!stack.isEmpty() && n < stack.peek()){
				int t = f(n, stack.pop());
				if (max < t)
					max = t;
			}
			
			if (!stack.isEmpty()){
				int t = f(n, stack.peek());
				if(max < t)
					max = t;
			}
			
			stack.push(n);
			a[i] = n;
		}
		
		System.out.println(max);
		
		in.close();
	}

	private static final int f(int a, int b){
		return (((a&b)^(a|b))&(a^b));
	}

}
