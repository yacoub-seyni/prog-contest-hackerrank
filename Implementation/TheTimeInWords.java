import java.util.Scanner;

public class TheTimeInWords {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(),
				m = sc.nextInt();
		String[] table = {"", "one", "two",
		                  "three", "four",
		                  "five", "six", 
		                  "seven", "eight",
		                  "nine", "ten",
		                  "eleven", "twelve",
		                  "thirteen", "fourteen",
		                  "quarter", "sixteen",
		                  "seventeen", "eighteen",
		                  "nineteen", "twenty",
		                  "twenty one", "twenty two",
		                  "twenty three",
		                  "twenty four", "twenty five",
		                  "twenty six", "twenty seven",
		                  "twenty eight", "twenty nine",
		                  "half"};
		String str = "";
		
		if (m == 0) {
			str = table[h] + " o' clock";
		} else if (m == 1) {
			str = table[m] + " minute past " + table[h];
		} else if (m > 1 && m < 30 && m != 15) {
			str = table[m] + " minutes past " + table[h];
		} else if (m == 15) {
			str = "quarter past " + table[h];
		} else if (m == 30) {
			str = table[m] + " past " + table[h];
		} else if (m > 30 && m != 45) {
			str = table[60 - m] + " minutes to " + table[h + 1];
		} else if (m == 45) {
			str = "quarter to " + table[h + 1];
		}
		
		System.out.println(str);
		
		sc.close();
	}
}
