import java.util.Scanner;

public class CommonChild_01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next(), s2 = sc.next();
		int[][] a = new int[s1.length()+1][s2.length()+1];
		
		for (int i = 0; i < s1.length(); i++) {
			a[i][0] = 0;
		}
		
		for (int j = 0; j < s2.length(); j++) {
			a[0][j] = 0;
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					a[i][j] = a[i - 1][j - 1] + 1;
				} else {
					a[i][j] = Math.max(a[i][j - 1], a[i - 1][j]);
				}
			}
		}
		
		System.out.println(a[s1.length()][s2.length()]);
		
		sc.close();
	}
	
//	function LCSLength(X[1..m], Y[1..n])
//    C = array(0..m, 0..n)
//    for i := 0..m
//       C[i,0] = 0
//    for j := 0..n
//       C[0,j] = 0
//    for i := 1..m
//        for j := 1..n
//            if X[i] = Y[j]
//                C[i,j] := C[i-1,j-1] + 1
//            else
//                C[i,j] := max(C[i,j-1], C[i-1,j])
//    return C[m,n]
}
