import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	
	private static int N, E, v1, v2;
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
		System.out.println(solution());
	}
	
	private static long solution() {
		long middle = dijkstra(v1, v2); // == dijkstra(v2, v1)
		long res1 = dijkstra(1, v1) + middle + dijkstra(v2, N);
		long res2 = dijkstra(1, v2) + middle + dijkstra(v1, N);
		
		return (Math.min(res1, res2) >= INF ? -1 : Math.min(res1, res2));
	}
	
	private static long dijkstra(int start, int end) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			
			if (current.node == end) {
				return dist[end];
			}
			
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		br.close();
	}

}
