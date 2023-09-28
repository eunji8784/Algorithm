import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}
		
		int[] result = new int[N + 1];
		int max = -1;
		
		for (int i = 1; i <= N; i++) {
			int count = bfs(i);
			result[i] = count;
			max = Math.max(max, count);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			if (result[i] == max) sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	private static int bfs(int start) {
		int count = 0;
		
		Queue<Integer> que = new LinkedList<>();
		boolean[] vst = new boolean[N + 1];
		
		que.offer(start);
		vst[start] = true;
		
		while (!que.isEmpty()) {
			int now = que.poll();
			
			for (int next : graph.get(now)) {
				if (!vst[next]) {
					vst[next] = true;
					que.offer(next);
					count++;
				}
			}
		}
        
		return count;
	}

}
