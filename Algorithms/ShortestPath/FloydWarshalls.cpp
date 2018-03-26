#include<bits/stdc++.h>
using namespace std;

#define V 4
#define INF 10000

void printSolution(int [][V]);
void floydWarshall(int [][V]);

int main()
{
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
    int graph[V][V] = { {0,   5,  INF, 10},
                        {INF, 0,   3, INF},
                        {INF, INF, 0,   1},
                        {INF, INF, INF, 0}
                      };

    floydWarshall(graph);

    return 0;
}

void floydWarshall (int graph[][V]) {
    int dist[V][V], i, j, k;

    for(i = 0; i < V; i++)
        for(j = 0; j < V; j++)
            dist[i][j] = graph[i][j];

    /** k for: via node  **/
    for(k = 0; k < V; k++) {
        /** i for: source node  **/
        for(i = 0; i < V; i++) {
            /** j for: destination node  **/
            for (j = 0; j < V; j++) {
                /**
                    if
                      (source, via) + (via, destination) < (source, destination)
                      then update,
                            (source, destination) = (source, via) + (via, destination)
                **/
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    printSolution(dist);
}

void printSolution(int dist[][V]) {
    printf("The shortest distances between every pair of vertices is:\n");
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (dist[i][j] == INF)
                printf("%7s", "INF");
            else
                printf ("%7d", dist[i][j]);
        }
        printf("\n");
    }
}
