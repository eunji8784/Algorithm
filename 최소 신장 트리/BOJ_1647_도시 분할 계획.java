import java.io.*;
import java.util.*;

public class Main {
	private static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	private static class KruskalMST {
		int[] parent;
		
		public KruskalMST(int V) {
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
		}
		
		private int findMST(List<Edge> edges) {
			int mstWeight = 0, maxWeight = 0;
			Collections.sort(edges);
			for (Edge edge : edges) {
				if (union(edge.start, edge.end)) {
					mstWeight += edge.weight;
					maxWeight = edge.weight;
				}
			}
			return mstWeight - maxWeight;
		}
		
		private int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		private boolean union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if (rootX == rootY) return false;
			
			parent[rootY] = rootX;
			return true;
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Edge> edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges.add(new Edge(A, B, C));
		}
		
		KruskalMST kruskalMST = new KruskalMST(N);
		System.out.println(kruskalMST.findMST(edges));
		br.close();
	}
}
