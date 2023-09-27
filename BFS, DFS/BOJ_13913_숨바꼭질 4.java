import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N, K));
		br.close();
	}

	private static String bfs(int N, int K) {
		Queue<Integer> que = new LinkedList<>();
		
		int[] from = new int[100001];
		int[] time = new int[100001];
		
		que.offer(N);
		time[N] = 1;

		while (!que.isEmpty()) {
			int loc = que.poll();
			
			if (loc == K) {
				StringBuilder path = new StringBuilder();
				for (int i = K; i != N; i = from[i]) {
					path.insert(0, i + " ");
				}
				path.insert(0, N + " ");
				
				return time[K] - 1 + "\n" + path.toString();
			}
			
			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) next = loc + 1;
				if (i == 1) next = loc - 1;
				if (i == 2) next = loc * 2;
				
				if (next < 0 || next > 100000 || time[next] != 0) continue;
				
				que.offer(next);
				from[next] = loc;
				time[next] = time[loc] + 1;
			}
		}
		
		return null;
	}
}
