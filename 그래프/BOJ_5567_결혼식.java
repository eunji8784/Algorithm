import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		boolean[] vst = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st = null;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		vst[1] = true;
		
		int answer = 0;
		
		for (int i = 0; i < 2; i++) {
			int length = que.size();
			for (int l = 0; l < length; l++) {
				int cur = que.poll();
				for (int next : graph.get(cur)) {
					if (!vst[next]) {
						vst[next] = true;
						que.offer(next);
						answer++;
					}
				}
			}
			if (que.isEmpty()) {
				break;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

}
