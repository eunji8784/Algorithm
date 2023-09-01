import java.io.*;
import java.util.*;

public class Main {
	
	private static int n, m;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1]; // 인덱스: 노드 번호, 값: 부모 노드 번호 
		
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int act = Integer.parseInt(st.nextToken());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			if (act == 0) {
				union(node1, node2);
			} else {
				if (find(node1) == find(node2)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}

	private static int find(int node) {
		if (parent[node] == node) {
			return node;
		} else {
			return parent[node] = find(parent[node]);
		}
	}

	private static void union(int node1, int node2) {
		node1 = find(node1);
		node2 = find(node2);
		
		if (node1 != node2) {
			parent[node2] = node1; // 경로 압축
		}		
	}

}
