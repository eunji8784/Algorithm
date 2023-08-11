import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	
	private static int N, M, X;
	private static ArrayList<Edge>[] graph, reverseGraph;
	
	private static class Edge implements Comparable<Edge> {
		int node, cost;
		
		public Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(solution());
	}
	
	private static int solution() {
		int max = Integer.MIN_VALUE;
		int[] forwardDist = dijkstra(graph); // 목적지(X) -> 출발지 
		int[] reverseDist = dijkstra(reverseGraph); // 출발지 -> 목적지(X)
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, forwardDist[i] + reverseDist[i]);
		}
		return max;
	}
	
	private static int[] dijkstra(ArrayList<Edge>[] graph) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(X, 0));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			
			if (dist[current.node] < current.cost) {
				continue;
			}
			
			for (Edge edge : graph[current.node]) {
				if (edge.cost + current.cost < dist[edge.node]) {
					dist[edge.node] = edge.cost + current.cost;
					pq.offer(new Edge(edge.node, dist[edge.node]));
				}
			}
			
		}
		
		return dist;
	}
	
	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		reverseGraph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, time));
			reverseGraph[to].add(new Edge(from, time));
		}
		
		br.close();
	}
}
