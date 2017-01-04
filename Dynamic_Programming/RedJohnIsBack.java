import java.util.*;

public class RedJohnIsBack {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), n;
		
		for (int z = 0; z < t; z++) {
			n = sc.nextInt();
			
			int configs = getNberOfConfig(n);
			// System.out.println(configs);
			int primes = getNberOfPrimes(configs);
			
			System.out.println(primes);
		}
		sc.close();
	}
	
	private static int getNberOfConfig(int n) {
		
		int[] cache = new int[n+1];
		cache[0] = 1;
		cache[1] = 1;
		
		if (n >= 2) cache[2] = 1;
		if (n >= 3) cache[3] = 1;
		
		for (int i = 4; i < n + 1; i++) {
			cache[i] = cache[i-1] +  cache[i-4];
		}
		
		return cache[n];		
	}
	
	private static int getNberOfPrimes(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		int count = 0;
		
		for (int i = 2; i < Math.sqrt(n + 1); i++) {
			if (isPrime[i]) {
				for (int j = i*i; j < n + 1; j = j+i) {
					isPrime[j] = false;
				}
			}
		}	
		
		for (int i = 2; i < n + 1; i++) 
			if (isPrime[i]) count++;
		
		return count;
	}
	
}
