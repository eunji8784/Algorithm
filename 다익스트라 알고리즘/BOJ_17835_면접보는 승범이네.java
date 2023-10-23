import java.io.*;
import java.util.*;

// main idea: 각 면접장에서 도시까지의 최단 거리를 구한다. (출발점을 면접장으로)
public class Main {
	private static class Edge implements Comparable<Edge> {
		int city;
		long dist;
		
		public Edge(int city, long dist) {
			this.city = city;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<List<Edge>> graph = new ArrayList<>();
		long[] dist = new long[N + 1];
		final long INF = Long.MAX_VALUE;
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(V).add(new Edge(U, C));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < K; i++) {
			int start = Integer.parseInt(st.nextToken());
			dist[start] = 0;
			pq.offer(new Edge(start, 0));
		}
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.dist > dist[cur.city]) {
				continue;
			}
			
			for (Edge next : graph.get(cur.city)) {
				if (cur.dist + next.dist < dist[next.city]) {
					dist[next.city] = cur.dist + next.dist;
					pq.offer(new Edge(next.city, dist[next.city]));
				}
			}
		}
		
		int maxCity = 0;
		long maxDist = -1;
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] > maxDist) {
				maxDist = dist[i];
				maxCity = i;
			}
		}
		
		System.out.println(maxCity + "\n" + maxDist);
		br.close();
	}
}
