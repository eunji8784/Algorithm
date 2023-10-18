import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		List<Integer> answer = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int num = pq.poll();
			for (int n : graph.get(num)) {
				if (--indegree[n] == 0) pq.offer(n);
			}
			answer.add(num);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int num : answer) {
			sb.append(num + " ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
