public const int INF = 99999;

private static void Print(int[,] distance, int verticesCount)
{
	Console.WriteLine("Shortest distances between every pair of vertices:");

	for (int i = 0; i < verticesCount; ++i)
	{
		for (int j = 0; j < verticesCount; ++j)
		{
			if (distance[i, j] == INF)
				Console.Write("INF".PadLeft(7));
			else
				Console.Write(distance[i, j].ToString().PadLeft(7));
		}

		Console.WriteLine();
	}
}

public static void FloydWarshall(int[,] graph, int verticesCount)
{
	int[,] distance = new int[verticesCount, verticesCount];

	for (int i = 0; i < verticesCount; ++i)
		for (int j = 0; j < verticesCount; ++j)
			distance[i, j] = graph[i, j];

	for (int k = 0; k < verticesCount; ++k)
	{
		for (int i = 0; i < verticesCount; ++i)
		{
			for (int j = 0; j < verticesCount; ++j)
			{
				if (distance[i, k] + distance[k, j] < distance[i, j])
					distance[i, j] = distance[i, k] + distance[k, j];
			}
		}
	}

	Print(distance, verticesCount);
}