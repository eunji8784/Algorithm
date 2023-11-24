import java.io.*;
import java.util.*;

public class Main {
	private static final String RED = "red";
	private static final String BLUE = "blue";

	private static List<List<Integer>> graph;
	private static String[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			color = new String[V + 1];
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}

			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			String answer = "YES";

			for (int i = 1; i <= V; i++) {
				if (color[i] == null && !bfs(i)) {
					answer = "NO";
					break;
				}
			}

			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		color[start] = RED;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int next : graph.get(cur)) {
				if (color[next] == null) {
					color[next] = (color[cur].equals(RED) ? BLUE : RED);
					que.offer(next);
				} else if (color[next] == color[cur]) {
					return false;
				}
			}
		}

		return true;
	}
}
