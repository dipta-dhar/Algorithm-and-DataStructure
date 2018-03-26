package ShortestPath;

import java.util.*;

class Edge {
	int source;
    int dest;
    int weight;
    
    public Edge(int source, int dest, int weight) {
    	this.source = source;
    	this.dest   = dest;
    	this.weight = weight;
    }
}

public class BellmanFords {
	
	public static void printPath(int parent[], int v) {
		if (v < 0)	return;
		
		printPath(parent, parent[v]);
		System.out.print(v + " ");
	}
	
	public static void BellmanFord(List<Edge> edges, int source, int N) {
		int E = edges.size();
		
		int distance[] = new int[N];
		int parent[]   = new int[N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		
		Arrays.fill(parent, -1);
		int K = N;
		while (--K > 0) {
			for(int j=0; j<E; j++) {
				int u = edges.get(j).source;
				int v = edges.get(j).dest;
				int w = edges.get(j).weight;
				
				if (distance[u] != Integer.MAX_VALUE && (distance[u]+w) < distance[v]) {
					distance[v] = distance[u] + w;
					parent[v] = u;
				}
			}
		}
		
		/// Check for negative weight cycles
		for(int i=0; i<E; i++) {
			int u = edges.get(i).source;
			int v = edges.get(i).dest;
			int w = edges.get(i).weight;
			
			if (distance[u] != Integer.MAX_VALUE && (distance[u]+w) < distance[v]) {
				System.out.println("Negative weight cycle Found!!");
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print("Distance of vertex " + i + " from the source is " + distance[i] + ". It's path is [ ");
			printPath(parent, i);
			System.out.println("]");
		}
		
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1,-1),  new Edge(0, 2, 4),
				new Edge(1, 2, 3),  new Edge(1, 3, 2),
				new Edge(1, 4, 2),  new Edge(3, 2, 5),
				new Edge(3, 1, 1),  new Edge(4, 3,-3)
		);
		int source = 0;
		int N = 5;
		
		BellmanFord(edges, source, N);
	} 
}
