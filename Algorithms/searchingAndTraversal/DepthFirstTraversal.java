/*

    Depth First Search (DFS) Program in java [Adjacency Matrix]

*/


package searchingAndTraversal;

import java.util.Scanner;

public class DepthFirstTraversal {
	public static int[][] G = new int [10][10];
	public static int[] visited = new int[10];
	public static int n;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Enter the number of vertices: ");
	    n = in.nextInt();
	    
	    System.out.printf("\nEnter adjacency matrix of the graph:\n");
	    for(int i=0; i<n; i++)
	       for(int j=0; j<n; j++)
	            G[i][j] = in.nextInt();
	    
	   //visited is initialized to zero
	    for (int i=0; i<n; i++)
	    	visited[i] = 0;
	    
	    DFS(0);
	    
	    in.close();
	}
	
	public static void DFS(int i) {
		System.out.printf("\n%d",i);
	    visited[i]=1;

	    for(int j=0; j<n; j++)
	       if(visited[j]==0 && G[i][j]==1)
	            DFS(j);
	}
}
