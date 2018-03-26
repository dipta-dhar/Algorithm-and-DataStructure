package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class PrimsMST {
    public class Node implements Comparable<Node> {
        int vertice, key;

        Node(int vertice, int key) {
            this.vertice = vertice;
            this.key = key;
        }

        @Override
        public int compareTo(Node o) {
            return this.key - o.key;
        }
    }

    public class AdjList {
        ArrayList<Node> nodes;
    }

    public class Graph {
        int V;
        AdjList[] adjLists;
    }


    public Graph createGraph(int v) {
        Graph graph = new Graph();
        graph.V = v;
        graph.adjLists = new AdjList[v];
        for (int i = 0; i < v; i++) {
            AdjList adjList = new AdjList();
            adjList.nodes = new ArrayList<Node>(); //initialize its node list too
            graph.adjLists[i] = adjList;
        }
        return graph;
    }

    public void addEdge(Graph graph, int src, int dest, int key) {
        Node srcNode = new Node(src, key);
        Node destNode = new Node(dest, key);
        graph.adjLists[src].nodes.add(destNode);
        graph.adjLists[dest].nodes.add(srcNode);
    }

    public void printGraph(Graph graph) {
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i + " ->");
            for (Node node : graph.adjLists[i].nodes) {
                System.out.print(" " + node.vertice);
            }
            System.out.println();
        }
    }

    public void getPrimsMST(Graph graph) {
        Node keys[] = new Node[graph.V];
        int parent[] = new int[graph.V];
        boolean mstSet[] = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            keys[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
            mstSet[i] = false;
        }
        keys[0].key = 0;
        Queue<Node> pQueue = new PriorityQueue<>();
        pQueue.addAll(Arrays.asList(keys));


        while (pQueue.size() > 1) {
            Node u = pQueue.remove();
            mstSet[u.vertice] = true;

            for (Node node : graph.adjLists[u.vertice].nodes) {

                if (mstSet[node.vertice] == false && node.key < keys[node.vertice].key) {
                    pQueue.remove(keys[node.vertice]); //remove that node from q

                    keys[node.vertice].key = node.key; //change key
                    parent[node.vertice] = u.vertice;

                    pQueue.add(keys[node.vertice]); //add back
                    //remove add can me made single function by using a visited flag 
                    //remove_add() in O(lg(n))
                 }

            }
        }
        print_mst(keys, parent, graph);

    }

    public void print_mst(Node[] keys, int[] parent, Graph graph) {
        for (int i = 1; i < graph.V; i++) {
            System.out.println(parent[keys[i].vertice] + "-" + keys[i].vertice + " " +keys[i].key);
        }
    }

    public static void main(String[] args) {
        int V = 9;
        PrimsMST MST = new PrimsMST();
        Graph graph = MST.createGraph(V);
        MST.addEdge(graph, 0, 1, 4);
        MST.addEdge(graph, 0, 7, 8);
        MST.addEdge(graph, 1, 2, 8);
        MST.addEdge(graph, 1, 7, 11);
        MST.addEdge(graph, 2, 3, 7);
        MST.addEdge(graph, 2, 8, 2);
        MST.addEdge(graph, 2, 5, 4);
        MST.addEdge(graph, 3, 4, 9);
        MST.addEdge(graph, 3, 5, 14);
        MST.addEdge(graph, 4, 5, 10);
        MST.addEdge(graph, 5, 6, 2);
        MST.addEdge(graph, 6, 7, 1);
        MST.addEdge(graph, 6, 8, 6);
        MST.addEdge(graph, 7, 8, 7);


        // print the adjacency list representation of the above graph
        MST.printGraph(graph);
        System.out.println();
        MST.getPrimsMST(graph);

    }
}