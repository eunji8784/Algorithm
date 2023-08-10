import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	
	private static int V, E, start;
	private static int[] distance;
	private static ArrayList<Edge>[] adjLst;
	
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
		dijkstra();
		printAnswer();
	}
	
	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] != INF ? distance[i] : "INF").append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void dijkstra() {
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			
			if (distance[current.node] < current.cost) {
				continue;
			}
			
			for (Edge edge : adjLst[current.node]) {
				if (current.cost + edge.cost < distance[edge.node]) {
					distance[edge.node] = current.cost + edge.cost;
					pq.offer(new Edge(edge.node, distance[edge.node]));
				}
			}
		}
	}
	
	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[V + 1];
		adjLst = new ArrayList[V + 1];
		
		for (int i = 1; i <= V; i++) {
			adjLst[i] = new ArrayList<>();
		}
		
		start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjLst[from].add(new Edge(to, cost));
		}
		
		br.close();
	}

}
