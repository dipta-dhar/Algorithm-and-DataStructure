package ShortestPath;

public class FloydWarshalls {
	public static int N = 4;
	public static int INF = 10000;
	public static int[][] dist = new int[N][N];
	
	public static void floydWarshall(int graph[][]) {
		/** Copy the graph value **/
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				dist[i][j] = graph[i][j];
		
		/** k for: via node  **/
		for(int k=0; k<N; k++) {
			/** i for: source node  **/
			for(int i=0; i<N; i++) {
				/** j for: destination node  **/
				for(int j=0; j<N; j++) {
					/**
                      if
                        (source, via) + (via, destination) < (source, destination)
                        then update,
                              (source, destination) = (source, via) + (via, destination)
                    **/
					if (dist[i][k]+dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		System.out.println("The shortest distances between every pair of vertices is:");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (dist[i][j] == INF) System.out.print("INF ");
				else				   System.out.print(dist[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		/**
	     Consider the following weighted graph:

	            10
	       (0)------->(3)
	        |         /|\
	      5 |          |
	        |          | 1
	      '\|/         |
	       (1)------->(2)
	            3
	    **/
		
		int[][] graph = { {0,   5,  INF, 10},
						 {INF, 0,   3, INF},
						 {INF, INF, 0,   1},
						 {INF, INF, INF, 0} 
					   };
		floydWarshall(graph);
	}

}
