import java.io.*;
import java.util.*;

public class Main {

	private static final long INF = 100000000000L;

	private static int N, M, start, end;
	private static ArrayList<Edge>[] graph;

	private static class Edge implements Comparable<Edge> {
		int node;
		long cost;

		public Edge(int node, long cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(dijkstra());
	}

	private static long dijkstra() {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge current = pq.poll();

			if (current.cost > dist[current.node]) {
				continue;
			}

			for (Edge edge : graph[current.node]) {
				if (current.cost + edge.cost < dist[edge.node]) {
					dist[edge.node] = current.cost + edge.cost;
					pq.offer(new Edge(edge.node, dist[edge.node]));
				}
			}
		}

		return dist[end];
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());

			graph[from].add(new Edge(to, cost));
		}

		st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		br.close();
	}

}
