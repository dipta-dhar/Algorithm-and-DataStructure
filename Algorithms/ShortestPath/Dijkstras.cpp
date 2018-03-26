/**
Pseudo Code for Dijkstra’s Algorithm:
------------------------------------

function Dijkstra(Graph, source):
       dist[source]  := 0                     // Distance from source to source
       for each vertex v in Graph:            // Initializations
           if v ≠ source
               dist[v]  := infinity           // Unknown distance function from source to v
               previous[v]  := undefined      // Previous node in optimal path from source
           end if
           add v to Q                         // All nodes initially in Q
       end for

      while Q is not empty:                  // The main loop
          u := vertex in Q with min dist[u]  // Source node in first case
          remove u from Q

          for each neighbor v of u:           // where v has not yet been removed from Q.
              alt := dist[u] + length(u, v)
              if alt < dist[v]:               // A shorter path to v has been found
                  dist[v]  := alt
                  previous[v]  := u
              end if
          end for
      end while
      return dist[], previous[]
  end function

**/

#include<bits/stdc++.h>
using namespace std;

#define INF 9999
#define MAX 10

void dijikstra(int G[MAX][MAX], int n, int startnode);

int main()
{
	int G[MAX][MAX], i, j, n, u;
	printf("\nEnter the no. of vertices:: ");
	scanf("%d", &n);

	printf("\nEnter the adjacency matrix::\n");
	for(i=0;i < n;i++)
		for(j=0;j < n;j++)
			scanf("%d", &G[i][j]);

	printf("\nEnter the starting node:: ");
	scanf("%d", &u);

	dijikstra(G,n,u);

	return 0;
}

void dijikstra(int G[MAX][MAX], int n, int startnode) {
	int cost[MAX][MAX], distance[MAX], pred[MAX];
	int visited[MAX], count, mindistance, nextnode, i,j;

	for(i=0; i<n; i++)
		for(j=0; j<n; j++)
			if(G[i][j]==0)
				cost[i][j]=INF;
			else
				cost[i][j]=G[i][j];

	for(i=0; i<n; i++) {
		distance[i]=cost[startnode][i];
		pred[i]=startnode;
		visited[i]=0;
	}

	distance[startnode]=0;
	visited[startnode]=1;
	count=1;
	while(count < n-1) {
		mindistance=INF;
		for(i=0; i<n; i++) {
			if(distance[i] < mindistance&&!visited[i]) {
				mindistance=distance[i];
				nextnode=i;
			}
		}

		visited[nextnode]=1;
		for(i=0; i<n; i++) {
			if(!visited[i]) {
				if(mindistance+cost[nextnode][i] < distance[i]) {
					distance[i]=mindistance+cost[nextnode][i];
					pred[i]=nextnode;
				}
			}
		}
        count++;
	}

	for(i=0; i<n; i++) {
		if(i!=startnode) {
			printf("\nDistance of %d = %d", i, distance[i]);
			printf("\nPath = %d", i);
			j=i;
			do {
				j=pred[j];
				printf(" <-%d", j);
			}
			while(j!=startnode);
		}
	}
}
