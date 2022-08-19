import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] edge = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a][b] = edge[b][a] = 1;
		}
		
		sb = new StringBuilder();
		
		dfs(V);
		
		System.out.println(sb.toString());
		
		visited = new boolean[1001];
		
		sb = new StringBuilder();
		
		bfs(V);
		
		System.out.println(sb.toString());
		
	}

	private static void bfs(int v) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			
			for (int i = 1; i <= N; i++) {
				if (edge[queue.peek()][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			
			sb.append(queue.poll()).append(" ");
			
		}
		
	}

	private static void dfs(int v) {
		
		visited[v] = true;
		sb.append(v).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if (edge[v][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
		
	}

}
