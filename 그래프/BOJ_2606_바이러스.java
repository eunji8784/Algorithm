import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int computerCnt = Integer.parseInt(br.readLine());
		int pairCnt = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= computerCnt; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < pairCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		Queue<Integer> que = new LinkedList<>();
		boolean[] vst = new boolean[computerCnt + 1];
		que.offer(1);
		vst[1] = true;
		int answer = 0;

		while (!que.isEmpty()) {
			int v = que.poll();
			for (int next : graph.get(v)) {
				if (!vst[next]) {
					vst[next] = true;
					que.offer(next);
					answer++;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

}
