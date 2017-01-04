package own_tutorial;

import java.util.*;

public class Graph_AdjacencyList {
	
	static int V, E;
	static ArrayList<LinkedList<Integer>> lists;
	static LinkedList<Integer>[] test;
	
	public Graph_AdjacencyList(int V, int E) {
		this.V = V;
		this.E = E;
		lists = new ArrayList<LinkedList<Integer>>();
		
		createLists(lists, V);
	}
	
	private static void createLists(ArrayList<LinkedList<Integer>> lists,
			int V) {
		for (int i = 0; i <= V; i++) 
			lists.add(new LinkedList<Integer>());		
	}
	
	private boolean removeEdge(int a, int b) {
		if (a <= V && b <= V && lists.get(a).contains(Integer.valueOf(b))
				&& lists.get(b).contains(Integer.valueOf(a))) {
			lists.get(a).remove(Integer.valueOf(b));
			lists.get(b).remove(Integer.valueOf(a));
			return true;
		}
		return false;
	}
	
	private boolean addEgde(int a, int b) {
		if (a <= V && b <= V)	{
			lists.get(a).add(Integer.valueOf(b));
			lists.get(b).add(Integer.valueOf(a));
			return true;
		}
		
		return false;
	}
	
	private boolean areAdjacent(int a, int b) {
		if (lists.get(a).get(Integer.valueOf(b)) != null) 
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		int V = 10, E = 9;
		Graph_AdjacencyList graph = new Graph_AdjacencyList(10, 9);
		graph.addEgde(1, 5);
		graph.addEgde(1, 7);
		graph.addEgde(2, 9);
		graph.addEgde(3, 8);
		graph.addEgde(3, 10);
		graph.addEgde(5, 6);	// to be removed for testing
		graph.addEgde(4, 9);
		graph.addEgde(7, 9);
		graph.removeEdge(5, 6);
		
		for (int i = 1; i <= V; i++) {
			System.out.println("vertex " + i);
			
			for (int j = 0; j < graph.lists.get(i).size(); j++) {
				System.out.print(graph.lists.get(i).get(j) + " ");
			}
			
			System.out.println();
			
		}
	}
}


