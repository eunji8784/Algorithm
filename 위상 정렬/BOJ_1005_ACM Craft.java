import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] indegree = new int[N + 1];
			int[] time = new int[N + 1];
			int[] result = new int[N + 1];
			
			List<List<Integer>> graph = new ArrayList<>();
			graph.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				graph.add(new ArrayList<>());
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				indegree[b]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			Queue<Integer> que = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					result[i] = time[i];
					que.offer(i);
				}
			}
			
			while (!que.isEmpty()) {
				int cur = que.poll();
				if (cur == W) break;
				
				for (int next : graph.get(cur)) {
					result[next] = Math.max(result[next], result[cur] + time[next]);
					if (--indegree[next] == 0) que.offer(next);
				}
			}
			
			sb.append(result[W] + "\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
