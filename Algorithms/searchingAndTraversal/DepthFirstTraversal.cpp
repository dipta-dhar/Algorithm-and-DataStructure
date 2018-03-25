/*

    Depth First Search (DFS) Program in C [Adjacency Matrix]

*/

#include<bits/stdc++.h>
using namespace std;

void DFS(int);
int G[10][10], visited[10], n;

int main()
{
    int i, j;
    printf("Enter the number of vertices: ");
    scanf("%d",&n);

    printf("\nEnter adjacency matrix of the graph:\n");
    for(i=0; i<n; i++)
       for(j=0;j<n;j++)
            scanf("%d",&G[i][j]);

    //visited is initialized to zero
    memset(visited, 0, sizeof visited);

    DFS(0);
}

void DFS(int i) {
    int j;
    printf("\n%d",i);
    visited[i]=1;

    for(j=0; j<n; j++)
       if(!visited[j]&&G[i][j]==1)
            DFS(j);
}
