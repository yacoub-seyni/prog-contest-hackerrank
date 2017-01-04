import java.util.*;

public class PoisonousPlants {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) list.add(sc.nextInt());
		
		int i = 0, j = 0, hold = 0;
		
		while (i < list.size() && j < list.size()) {
			
			hold = list.get(i);
			j = i + 1;
			while (j < list.size() && hold < list.get(j)) {
				list.remove(j);
			}
			
			i++;
			
		}
		
		
		sc.close();

	}

}
