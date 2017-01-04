import java.util.*;

public class TheMaximumSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n, a[];
        int maxSubArray = 0, maxSubSeq = 0, curr = 0;
        
        for (int z = 0; z < t; z++) {
            n = sc.nextInt(); 
            a = new int[n];
            maxSubArray = 0; maxSubSeq = 0; curr = 0;
            boolean found = false;
            
            for (int i = 0; i<n;i++) {
                a[i] = sc.nextInt();
                if (a[i] >= 0) {
                    maxSubSeq += a[i];
                    found = true;
                }
            }
            
            if (found == false) {
                maxSubSeq = max(a);
                maxSubArray = maxSubSeq;
            } else {
            
                for (int i = 0; i < n; i++) {
                    curr += a[i];
                    curr = Math.max(curr, 0);
                    maxSubArray = Math.max(curr, maxSubArray);
                }
            }
            
            System.out.println(maxSubArray + " " + maxSubSeq);
        }
        
        sc.close();
    }
    
    private static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) max = a[i];
        }
        
        return max;
    }
}