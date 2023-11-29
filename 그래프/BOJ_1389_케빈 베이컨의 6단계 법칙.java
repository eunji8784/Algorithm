import java.io.*;
import java.util.*;

public class Main {
	private static List<List<Integer>> graph;
	private static boolean[] vst;
	
	private static class Node {
		int node, depth;
		
		public Node(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int min = Integer.MAX_VALUE;
		int answer = 0;
		vst = new boolean[n + 1];
		int[] count = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			bfs(i, count);
			int sum = 0;
			for (int c = 1; c <= n; c++) {
				sum += count[c];
			}

			if (min > sum) {
				min = sum;
				answer = i;
			}
			Arrays.fill(vst, false);
			Arrays.fill(count, 0);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int v, int[] count) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(v, 0));
		vst[v] = true;

		while (!que.isEmpty()) {
			Node cur = que.poll();
			count[cur.node] = cur.depth;
			for (int next : graph.get(cur.node)) {
				if (!vst[next]) {
					vst[next] = true;
					que.offer(new Node(next, cur.depth + 1));
				}
			}
		}
	}

}
