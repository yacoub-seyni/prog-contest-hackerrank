import java.util.Arrays;

public class Graph {
	private int[][] weights;
	private boolean[][] conn;

	public Graph(int n) {
		weights = new int[n][n];
		conn = new boolean[n][n];
		for(int	i = 0; i < n; i++) {
			Arrays.fill(weights[i], -1);
			Arrays.fill(conn[i], false);
		}
	}

	public void addEdge( int source, int dest, int weight) {
		conn[source][dest] = true;
		weights[source][dest] = weight;
		conn[dest][source] = true;
		weights[dest][source] = weight;
	}

	public void removeEdge(int source, int dest) {
		conn[source][dest] = false;
		conn[dest][source] = false;
	}

	public int size() {
		return conn.length;
	}
	
	/*
	finds shortest path from source to dest
	*/
	public int dijkstra(int source, int dest) {
		boolean[] visited = new boolean[size()];
		int[] value = new int[size()];
		int[] prev = new int[size()];
		int[] dists = new int[size()];
		Arrays.fill(visited, false);
		Arrays.fill(value, Integer.MAX_VALUE);
		value[source] = 0;
		prev[source] = -1;
		dists[source] = 1;
		int	current = source;
		
		while (!visited[dest]) {
			for (int i = 0; i < size(); i++) {
				if(visited[i] || i == current) 
					continue;
				if(!conn[current][i])
					continue;
				int dist = value[current] + weights[current][i];
				if (dist < value[i]) {
					value[i] = dist;
					prev[i] = current;
					dists[i] = dists[current] + 1;
				}
			}
			visited[current] = true;
			current = dest;
			for	(int i = 0; i < size(); i++) {
				if (!visited[i] && value[i] < value[current])
					current = i;
			}
		}
		
		int[] path = new int[dists[dest]];
		current = dest;
		
		for (int i = dists[dest] - 1; i >= 0; i--) {
			path[i] = prev[current];
			current = prev[current];
		}
		// path contains the path
		// return path;
		// value is the distance
		return value[dest];
	}
}
