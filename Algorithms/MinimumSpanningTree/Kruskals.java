package MinimumSpanningTree;

public class Kruskals {
    
    public static class Graph {
        Vertex[] vertices;
        Edge edgeList;
        int maxSize;
        int size;
        int edgeNum;

        public Graph(int maxSize) {
            this.maxSize = maxSize;
            vertices = new Vertex[maxSize];
        }

        public class Vertex {
            int rank;
            Vertex representative;
            int name;
            Neighbour adj;

            Vertex(int name) {
                this.name = name;
                representative = this; // makeset
            }
        }

        public class Neighbour {
            int index;
            Neighbour next;
            int weight;

            Neighbour(int index, int weight, Neighbour next) {
                this.index = index;
                this.weight = weight;
                this.next = next;
            }
        }

        public class Edge {
            Vertex src;
            Vertex desti;
            Edge next;
            int weight;

            Edge(Vertex src, Vertex desti, int weight, Edge next) {
                this.src = src;
                this.desti = desti;
                this.weight = weight;
                this.next = next;
            }
        }

        public void addVertex(int name) {
            vertices[size++] = new Vertex(name);
        }

        public void addEdge(int src, int dest, int weight) {
            vertices[src - 1].adj = new Neighbour(dest - 1, weight, vertices[src - 1].adj);
            edgeList = new Edge(vertices[src - 1], vertices[dest - 1], weight, edgeList);
            edgeNum++;
        }

        public void applyKrushkalAlgo() {
            Edge[] edges = new Edge[edgeNum];
            int i = 0;
            while (edgeList != null) {
                edges[i] = edgeList;
                i++;
                edgeList = edgeList.next;
            }
            quicksort(edges, 0, edgeNum - 1);
            int MSTcost = 0;
            for (i = 0; i < edgeNum; i++) {
                Vertex u = findSet(edges[i].src);
                Vertex v = findSet(edges[i].desti);
                if (u != v) {
                    System.out.println("[" + edges[i].src.name + "," + edges[i].desti.name+"] --> "+edges[i].weight);
                    MSTcost += edges[i].weight;
                    union(u, v);
                }
            }
            System.out.println("Cost of the spanning tree is: " + MSTcost);
        }

        public Vertex findSet(Vertex u) {
            if (u.representative != u) {
                u.representative = findSet(u.representative); // path compression
            }
            return u.representative;
        }

        public void union(Vertex u, Vertex v) {
            if(u.rank == v.rank){
                v.representative = u;
                u.rank++;
            }else if(u.rank < v.rank){
                v.representative = u;
            }else{
                u.representative = v;
            }
        }

        public void quicksort(Edge[] edges, int start, int end) {
            if (start < end) {
                swap(edges, end, start + (end - start) / 2);
                int pIndex = pivot(edges, start, end);
                quicksort(edges, start, pIndex - 1);
                quicksort(edges, pIndex + 1, end);
            }
        }

        public int pivot(Edge[] edges, int start, int end) {
            int pIndex = start;
            Edge pivot = edges[end];
            for (int i = start; i < end; i++) {
                if (edges[i].weight < pivot.weight) {
                    swap(edges, i, pIndex);
                    pIndex++;
                }
            }
            swap(edges, end, pIndex);
            return pIndex;
        }

        public void swap(Edge[] edges, int index1, int index2) {
            Edge temp = edges[index1];
            edges[index1] = edges[index2];
            edges[index2] = temp;
        }
    }
    
    public static void main(String[] args) {
        /* Consider the following weighted graph:
          
        	10
   		1--------2
   		|  \     |
  	   6|   5\   |15
   		|      \ |
   		3--------4
       		4       */
        
        Graph graph = new Graph(4);
        
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 4, 5);
        graph.addEdge(3, 4, 4);
        graph.addEdge(2, 4, 15);
        
        graph.applyKrushkalAlgo();
    }
}