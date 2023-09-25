import java.io.*;
import java.util.*;

// 위상 정렬
public class Main {
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[N + 1];
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) que.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			sb.append(curr + " ");
			
			for (int next : graph.get(curr)) {
				if (--indegree[next] == 0) que.offer(next);
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
}
