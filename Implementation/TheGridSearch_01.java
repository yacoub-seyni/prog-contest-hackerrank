import java.io.*;
import java.util.*;

/**
 * Collaborated with Keith Lim
 * @author ys115
 *
 */
public class TheGridSearch_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int k = 0; k < n; k++) {
			int R = sc.nextInt(), C = sc.nextInt();
			String[] a = new String[R];

			for (int i = 0; i < R; i++) a[i] = sc.next();

			int r = sc.nextInt(), c = sc.nextInt();
			String[] compare = new String [r];

			for (int i = 0; i < r; i++)	compare[i] = sc.next();

			int count = 0, j = 0, index[] = new int[C],
					possCandidates = 0;
			Arrays.fill(index, -1);

			boolean firstPass = true,
					printed = false,
					found = false,
					isStillPos = false;

			for (int i = 0; i < R; i++) {
				found = false;
				
				if (a[i].contains(compare[count]) ) {

					if (firstPass) {
						index[j] = a[i].indexOf(compare[count]);
						while (index[j] >= 0 && (index[j] + 1 < a[i].length()) ) {
							j++;
//							System.out.println("index[" + (j-1) + "]: " + index[j-1]);
//							System.out.println("a[" + i + "]: " + a[i]);
//							System.out.println("com[" + count + "]: " + compare[count]);
							
							index[j] = a[i].indexOf(compare[count], index[j-1] + 1);
						}

						firstPass = false;
						count++;
						possCandidates = j;
//						System.out.println("candidates: " + possCandidates);
						if (j > 0) isStillPos = true;
						
					} else {
						for (int d = 0; d < possCandidates; d++) {
							found = false;
							
							if (index[d] != -1) {
								int hold = a[i].indexOf(compare[count]);
								
								while (hold >= 0) {
									if (index[d] != hold) {
										hold = a[i].indexOf(compare[count], hold + 1);									
									} else {
										count++;
										found = true;
										break;
									}
								}
								
								if (! found) { index[d] = -1; }
								else { isStillPos = true; }
							}
						}
					}

					if (! isStillPos) {
						count = 0;
						firstPass = true;
						j = 0;
						i--;
					}
					else if (count == r) {
						printed = true;
						System.out.println("YES");
						break;
					}
				} else {
					count = 0;
					firstPass = true;
					j = 0;
					i--;
				}
			}

			if (printed == false) {
				System.out.println("NO");
			}
		}

		sc.close();
	}
}