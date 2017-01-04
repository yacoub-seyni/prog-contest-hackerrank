import java.util.Scanner;

public class LonelyInteger {
	
	static long bits_lower = 0, bits_upper = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		
		int num = sc.nextInt();
		
		int[] a = new int[num];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			
			if (a[i] >= 50) {
				if (getBit(a[i], 1)) clearBit(a[i], 1);
				else setBit(a[i], 1);				
				
			} else {
				if (getBit(a[i], 0)) clearBit(a[i], 0);
				else setBit(a[i], 0);
			}			
		}
		
		boolean solved = false;
		
		for (int i = 0; i < bits_lower; i++) {
			if (getBit(i, 0)) {
				System.out.println(a[i]);
				solved = true;
				break;
			}			
		}
		
		if (solved == false) {
			for (int i = 0; i < bits_upper; i++) {
				if (getBit(i, 1)) {
					System.out.println(a[i]);
					solved = true;
					break;
				}			
			}
		}
		
		sc.close();
	}
	
	static boolean getBit(int i, int x) {
		if (x == 0)
			return ( (bits_lower & (1 << i)) == 0);
		else
			return ( (bits_upper & (1 << (i - 50))) == 0);
	}
	
	static void clearBit(int i, int x) {
		if (x == 0)
			bits_lower = bits_lower & (~(1 << i));
		else
			bits_upper = bits_upper & (~(1 << (i - 50)));
	}
	
	static void setBit(int i, int x) {
		if (x == 0)
			bits_lower = bits_lower | (1 << i);
		else
			bits_upper = bits_upper | (1 << (i - 50));
	}

}
