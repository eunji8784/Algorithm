import java.io.*;
import java.util.*;

public class Main {
	private static class Edge implements Comparable<Edge> {
		int u, v;
		long w;
		
		public Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	private static class Planet {
		int	idx, x, y, z;
		
		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private static class KruskalMST {
		int[] parent;
		
		public KruskalMST(int N) {
			parent = new int[N + 1];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
		}
		
		private long findMST(List<Edge> edges) {
			Collections.sort(edges);
			long mstWeight = 0;
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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Edge> edges = new ArrayList<>();
		Planet[] planets = new Planet[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(i, x, y, z);
		}
		
		Arrays.sort(planets, (a, b) -> a.x - b.x);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs((long)planets[i].x - planets[i + 1].x)));
		}
		
		Arrays.sort(planets, (a, b) -> a.y - b.y);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs((long)planets[i].y - planets[i + 1].y)));
		}
		
		Arrays.sort(planets, (a, b) -> a.z - b.z);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs((long)planets[i].z - planets[i + 1].z)));
		}
		
		KruskalMST kruskalMST = new KruskalMST(N);
		System.out.println(kruskalMST.findMST(edges));
		br.close();
	}
}
