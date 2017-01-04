import java.util.Scanner;

public class InsertionSortPart1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt(),
				arr[] = new int[size], i;
		boolean isInserted = false;
		
		for (i = 0; i < size; i++) arr[i] = sc.nextInt();
		
		int hold = arr[size-1];
		
		for (i = size - 2; i >= 0; i--) {
			if (arr[i] > hold) {
				arr[i+1] = arr[i];
				printArray(arr);
			} else {
				arr[i+1] = hold;
				printArray(arr);
				isInserted = true;
				break;
			}
		}
			
		if (!isInserted) { arr[i+1] = hold; printArray(arr); }
		
		sc.close();
	}
	
	private static void printArray(int[] arr) {
		
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length; i++) 
			System.out.print(" " + arr[i]);
		System.out.println();
	}
}
