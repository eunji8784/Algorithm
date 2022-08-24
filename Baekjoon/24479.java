import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] adjLst;
	static boolean[] visited;
	static int[] seq;
	static int idx = 1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		adjLst = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		seq = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adjLst[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjLst[a].add(b);
			adjLst[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjLst[i]);
		}
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(seq[i]).append("\n");
		}
		
		System.out.print(sb.toString());

	}

	private static void dfs(int r) {
		
		visited[r] = true;
		seq[r] = idx;
		idx++;
		
		for (Integer v : adjLst[r]) {
			if (!visited[v]) {
				dfs(v);
			}
		}		
		
	}

}
