import java.io.*;
import java.util.*;

public class Main {
	
	private static boolean[] vst;
	private static List<List<Integer>> graph;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		
		vst = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		Arrays.fill(vst, false);
		bfs(V);
		
		System.out.println(sb.toString());
		br.close();
	}
	
	private static void dfs(int v) {
		vst[v] = true;
		sb.append(v + " ");
		for (int next : graph.get(v)) {
			if (!vst[next]) {
				dfs(next);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		vst[start] = true;
		
		while (!que.isEmpty()) {
			int v = que.poll();
			sb.append(v + " ");
			for (int next : graph.get(v)) {
				if (!vst[next]) {
					vst[next] = true;
					que.offer(next);
				}
			}
		}
	}
}
