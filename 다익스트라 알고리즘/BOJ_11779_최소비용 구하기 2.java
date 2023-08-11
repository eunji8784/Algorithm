import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	
	private static int n, m, start, end;
	private static ArrayList<Edge>[] adjLst;
	private static ArrayList<Integer> ansPath;
	private static int[] dist;
	
	private static class Edge implements Comparable<Edge> {
		int node, cost;
		ArrayList<Integer> path;
		
		public Edge(int node, int cost, ArrayList<Integer> path) {
			this.node = node;
			this.cost = cost;
			this.path = path;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		getInput();
		dijkstra();
		printAnswer();
	}
	
	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n").append(ansPath.size()).append("\n");
		for (int i = 0; i < ansPath.size(); i++) {
			sb.append(ansPath.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static void dijkstra() {
		dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0, new ArrayList<>(Arrays.asList(start))));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			ArrayList<Integer> path = current.path;
			
			if (dist[current.node] < current.cost) {
				continue;
			}
			
			for (Edge edge : adjLst[current.node]) {
				if (edge.cost + current.cost < dist[edge.node]) {
					dist[edge.node] = edge.cost + current.cost;
					ArrayList<Integer> nextPath = new ArrayList<>(path);
					nextPath.add(edge.node);
					pq.offer(new Edge(edge.node, dist[edge.node], nextPath));
					if (edge.node == end) {
						ansPath = new ArrayList<>(nextPath);
					}
				}
			}
		}
	}
	
	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adjLst = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			adjLst[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjLst[from].add(new Edge(to, cost, new ArrayList<>()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		br.close();
	}

}
