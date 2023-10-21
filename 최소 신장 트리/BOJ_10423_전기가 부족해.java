import java.io.*;
import java.util.*;

public class Main {
	
	private static class Edge implements Comparable<Edge> {
		int u, v, w;
		
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	private static class KruskalMST {
		int[] parent;
		
		public KruskalMST(int N) {
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
		}
		
		private int findMST(List<Edge> edges) {
			Collections.sort(edges);
			int mstWeight = 0;
			for (Edge edge : edges) {
				if (union(edge.u, edge.v)) {
					mstWeight += edge.w;
				}
			}
			return mstWeight;
		}
		
		private int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		private boolean union(int x, int y) {
			x = find(x);
			y = find(y);		
			if (x == y) return false;	
			parent[y] = x;
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Edge> edges = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(st.nextToken());
			edges.add(new Edge(k, 0, 0));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(u, v, w));
		}
		
		KruskalMST kruskalMST = new KruskalMST(N);
		System.out.println(kruskalMST.findMST(edges));
		br.close();
	}
}
