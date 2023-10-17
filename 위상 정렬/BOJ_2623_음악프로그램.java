import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<>();
		List<Integer> lst = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
			
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < L - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				indegree[b]++;
				graph.get(a).add(b);
				a = b;
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) que.offer(i);
		}
		
		while (!que.isEmpty()) {
			int num = que.poll();
			lst.add(num);
			
			for (int n : graph.get(num)) {
				if (--indegree[n] == 0) que.offer(n);
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		if (lst.size() == N) {
			for (int i = 0; i < lst.size(); i++) answer.append(lst.get(i) + "\n");
		} else {
			answer.append(0 + "\n");
		}
		
		System.out.print(answer.toString());
		br.close();
	}
}
