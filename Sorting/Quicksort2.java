import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort2 {
	static ArrayList<Integer> a = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) a.add(sc.nextInt());

		quicksort();
		for (int i = 0; i < a.size(); i++)
			System.out.println(a.get(i));

		sc.close();
	}

	private static int partition(int start, int end) {

		int pivot = a.get(end);
		int hold = start;

		for (int i = start; i <= end - 1; i++) {
			if (a.get(i) < pivot) { 
				swap(i, hold);
				hold++;
			}			
		}
		swap(hold, pivot);

		return hold;		
	}

	private static void swap(int x, int y) {
		int temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
	}

	private static void quicksort() {
		quicksortHelper(0, a.size() - 1);		
	}

	private static void quicksortHelper(int start, int end) {
		if (start < end) {
			int p = partition(start, end);
			quicksortHelper(start, p - 1);
			quicksortHelper(p + 1, end);
		}
	}

}
