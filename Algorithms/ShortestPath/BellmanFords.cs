public struct Edge
{
	public int Source;
	public int Destination;
	public int Weight;
}

public struct Graph
{
	public int VerticesCount;
	public int EdgesCount;
	public Edge[] edge;
}

public static Graph CreateGraph(int verticesCount, int edgesCount)
{
	Graph graph = new Graph();
	graph.VerticesCount = verticesCount;
	graph.EdgesCount = edgesCount;
	graph.edge = new Edge[graph.EdgesCount];

	return graph;
}

private static void Print(int[] distance, int count)
{
	Console.WriteLine("Vertex   Distance from source");

	for (int i = 0; i < count; ++i)
		Console.WriteLine("{0}\t {1}", i, distance[i]);
}

public static void BellmanFord(Graph graph, int source)
{
	int verticesCount = graph.VerticesCount;
	int edgesCount = graph.EdgesCount;
	int[] distance = new int[verticesCount];

	for (int i = 0; i < verticesCount; i++)
		distance[i] = int.MaxValue;

	distance[source] = 0;

	for (int i = 1; i <= verticesCount - 1; ++i)
	{
		for (int j = 0; j < edgesCount; ++j)
		{
			int u = graph.edge[j].Source;
			int v = graph.edge[j].Destination;
			int weight = graph.edge[j].Weight;

			if (distance[u] != int.MaxValue && distance[u] + weight < distance[v])
				distance[v] = distance[u] + weight;
		}
	}

	for (int i = 0; i < edgesCount; ++i)
	{
		int u = graph.edge[i].Source;
		int v = graph.edge[i].Destination;
		int weight = graph.edge[i].Weight;

		if (distance[u] != int.MaxValue && distance[u] + weight < distance[v])
			Console.WriteLine("Graph contains negative weight cycle.");
	}

	Print(distance, verticesCount);
}