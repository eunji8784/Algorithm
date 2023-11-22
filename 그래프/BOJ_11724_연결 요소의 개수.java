import java.io.*;
import java.util.*;

public class Main {
	
	private static boolean[] vst;
	private static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		vst = new boolean[N + 1];
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
		
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			if (!vst[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		vst[start] = true;
		
		while (!que.isEmpty()) {
			int v = que.poll();
			for (int next : graph.get(v)) {
				if (!vst[next]) {
					vst[next] = true;
					que.offer(next);
				}
			}
		}
	}
}
