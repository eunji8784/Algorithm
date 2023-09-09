import java.io.*;
import java.util.*;

public class Main {

	private static int[] parent, cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		cost = new int[N + 1];
		parent = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			union(node1, node2);
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		
		int result = 0;
		for (int root : set) {
			result += cost[root];
		}
		
		if (result <= k) {
			System.out.println(result);
		} else {
			System.out.println("Oh no");
		}
		
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
		int x = find(node1);
		int y = find(node2);
		if (x != y) {
			if (cost[x] <= cost[y]) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

} 
