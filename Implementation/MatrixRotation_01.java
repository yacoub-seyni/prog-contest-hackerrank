import java.util.LinkedList;
import java.util.Scanner;

// code copied from Hackerrank discussion page
// @author: maximshen
public class MatrixRotation_01 {
	
	private static LinkedList<Integer> changeHead(
		LinkedList<Integer> list, int newStartIndex) {
	
		// wrap around the number of rotations. For instance,
		// if rotation = 1005, and the size of the matrix is
		// 1000 (100 rows x 10 cols), we just need to rotate
		// 5 times (1005 % 1000 = 5).
		int rot = newStartIndex % list.size();
	
		for (int i = 0; i < rot; i++) {
			list.addLast(list.pollFirst());
		}
		return list;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int rot = sc.nextInt();
		int mat[][] = new int[rows][cols];
		
		// 1) create original matrix
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				mat[r][c] = sc.nextInt();
			}
		}
		
		// 2) find num of layers to rotate
		// The number of layers to rotate is half the
		// number of the minimum of rows and cols.
		int layers = Math.min(rows,  cols) / 2;
		
		for (int layer = 0; layer < layers; layer++) {
			
			// 3) store each layer as a linked list
			LinkedList<Integer> list = new LinkedList<>();
			
			// add top row to list from left to right
			for (int c = layer; c < cols - layer; c++) {
				list.add(mat[layer][c]);
			}
			
			// add most right column to list from top to bottom
			for (int r = layer + 1; r < rows - layer - 1; r++) {
				list.add(mat[r][cols-1-layer]);
			}
			
			// add bottom row to list from right to left
			for (int c = cols-1-layer; c >= layer; c--) {
				list.add(mat[rows-1-layer][c]);
			}
			
			// add most left column to list from bottom to top
			for (int r = rows-1-layer-1; r>= layer+1; r--) {
				list.add(mat[r][layer]);
			}
			
			// 4) adjust start node of each linked list
			changeHead(list, rot);
			
			// 5) fill result matrix from rot of linked list for
			// 	  each layer
			
			// add top row to list from left to right
			for (int c = layer; c < cols-layer; c++) {
				mat[layer][c] = list.pollFirst();
			}
			
			// add most right column to list from to to bottom
			for (int r=layer+1; r < rows-layer-1; r++) {
				mat[r][cols-1-layer] = list.pollFirst();
			}
			
			// add bottom row to list from right to left
			for (int c = cols-1-layer; c >= layer; c--) {
				mat[rows-1-layer][c] = list.pollFirst();
			}
			
			// add most left column to list from bottom to top
			for (int r = rows-1-layer-1; r >= layer+1; r--) {
				mat[r][layer] = list.pollFirst();
			}
		}
		
		// 6) print out a result matrix after rotations
		StringBuilder sb = new StringBuilder();
		final String NEW_LINE = System.lineSeparator();
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				sb.append(mat[r][c]);
				sb.append(" ");
			}
			sb.append(NEW_LINE);
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
	
}
