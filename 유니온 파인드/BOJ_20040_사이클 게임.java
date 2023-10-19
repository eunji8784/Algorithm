import java.io.*;
import java.util.*;

public class Main {
	private static class UnionFind {
		int[] parent;
		
		public UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		public int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		public boolean union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if (rootX == rootY) return true;
			
			parent[rootY] = rootX;
			return false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		UnionFind uf = new UnionFind(n);
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (uf.union(a, b)) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
