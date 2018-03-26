#include<bits/stdc++.h>
using namespace std;

struct Edge {
    int source;
    int dest;
    int weight;
};

void printPath(vector<int> const &parent, int v) {
    if (v < 0)  return;

    printPath(parent, parent[v]);
    cout << v << " ";
}

void BellmanFord(vector<Edge> const &edges, int source, int N) {
    int E = edges.size();

    vector<int> distance (N, INT_MAX);
    distance[source] = 0;

    vector<int> parent (N, -1);

    int u,v, w, K=N;
    while(--K) {
        for(int j=0; j<E; j++) {
            u = edges[j].source;
            v = edges[j].dest;
            w = edges[j].weight;

            if (distance[u] != INT_MAX && distance[u]+w < distance[v]) {
                distance[v] = distance[u] + w;
                parent[v]   = u;
            }
        }
    }

    /// Check for negative weight cycles
    for(int i=0; i<E; i++) {
        u = edges[i].source;
        v = edges[i].dest;
        w = edges[i].weight;

        if (distance[u] != INT_MAX && distance[u]+w < distance[v]) {
            cout << "Negative weight cycle Found!!\n";
            return;
        }
    }

    for(int i=0; i<N; i++) {
        cout << "Distance of vertex " << i << " from the source is " << setw(2) << distance[i] << ". It's path is[ " ;
        printPath(parent, i);
        cout << "]" << endl;
    }
}

int main() {
    vector<Edge> edges = {
        /// (u,v, w) -> edge from u to v having weight w
        {0, 1,-1},  {0, 2, 4}, {1, 2, 3},  {1, 3, 2},
        {1, 4, 2},  {3, 2, 5}, {3, 1, 1},  {4, 3,-3}
    };

    int source = 0;
    int N = 5;
    BellmanFord(edges, source, N);

    return 0;
}

/**
OUTPUT:
        Distance of vertex 0 from the source is  0. It's path is[ 0 ]
        Distance of vertex 1 from the source is -1. It's path is[ 0 1 ]
        Distance of vertex 2 from the source is  2. It's path is[ 0 1 2 ]
        Distance of vertex 3 from the source is -2. It's path is[ 0 1 4 3 ]
        Distance of vertex 4 from the source is  1. It's path is[ 0 1 4 ]

**/
