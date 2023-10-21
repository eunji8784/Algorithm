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
				if (union(edge.start, edge.end)) {
					mstWeight += edge.weight;
				}
			}
			return mstWeight;
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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Edge> edges = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			int weight = Integer.parseInt(br.readLine());
			edges.add(new Edge(i, 0, weight)); // 직접 논에 우물을 파는 것 -> 0이라는 가상의 노드에 연결
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int weight = Integer.parseInt(st.nextToken());
				if (j > i) {
					edges.add(new Edge(i, j, weight));
				}
			}
		}
		
		KruskalMST kruskalMST = new KruskalMST(N);
		System.out.println(kruskalMST.findMST(edges));
		br.close();
	}
}
