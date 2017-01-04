import java.util.Arrays;

public class Test {
	
	public static void main(String args[]) {
		String[] code1 = {"function is_even_sum(a, b) {",
		         "  return (a + b) % 2 === 0;",
		         "}"};
		         
		String[] code2 = {"function is_even_sum(a, b) {",
		                  "  return (a + b) % 2 !== 1;",
		                  "}"};
		                  
		if (plagiarismCheck(code1, code2)) System.out.println("TRUE");
		else System.out.println("FALSE");
	}
	static boolean plagiarismCheck(String[] code1, String[] code2) {
	  int size = 1000;
	  String[] a = new String[size],
	    b = new String[size];
	  Arrays.fill(a, ""); Arrays.fill(b, "");
	  
	  if (code1.length != code2.length) return false;
	  
	  for (int z = 0; z < code1.length; z++) {
	  
	    int i = code1[0].indexOf(" "), j = 0;
	    
	    while (i >= 0 && i < code1[z].length() - 1) {      
	      if (Character.isLetter(code1[z].charAt(i+1)) 
	          || (code1[z].charAt(i+1) == '_') ) {
	        int hold = code1[z].indexOf(" ", i + 1);
	        if (hold != -1) {
	          a[j] = code1[z].substring(i+1, hold);
	          j++;
	        } else {
	          a[j] = code1[z].substring(i+1);
	          j++;
	        }      
	      }
	      i++;
	    }
	
	    i = code2[0].indexOf(" ");
	    j = 0;
	    while (i >= 0 && i < code2[z].length() - 1) {
	      if (Character.isLetter(code2[z].charAt(i+1))
	         || (code2[z].charAt(i+1) == '_') ) {
	        int hold = code2[z].indexOf(" ", i+1);
	        if (hold != -1) {
	          b[j] = code2[z].substring(i+1, hold);
	          j++;
	        } else {
	          b[j] = code2[z].substring(i+1);
	          j++;
	        }
	      }
	      i++;
	    }
	
	    i = 0;
	    while (!a[i].equals("")) {
	      code1[z].replaceAll(a[i], b[i]);
	      i++;
	    }
	    if (! code1[z].equals(code2[z])) return false;
	  }
	  return true;
	}
}