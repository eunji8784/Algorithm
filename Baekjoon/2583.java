import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M;
	static int N;
	static int map[][];
	static boolean visited[][];
	static int width;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];
		int count = 0;
		ArrayList<Integer> widths = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					map[x][y] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && visited[i][j] == false) {
					count++;
					width = 1;
					dfs(i, j);
					widths.add(width);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(count).append("\n");

		Collections.sort(widths);

		for (int i = 0; i < widths.size(); i++) {
			sb.append(widths.get(i)).append(" ");
		}

		System.out.println(sb.toString());

	}

	private static void dfs(int x, int y) {

		visited[x][y] = true;

		int idx = 0;

		while (idx < 4) {

			int nx = x + dx[idx];
			int ny = y + dy[idx];

			if (0 <= nx && nx < M && 0 <= ny && ny < N && map[nx][ny] == 0 && visited[nx][ny] == false) {
				width++;
				dfs(nx, ny);
			} else {
				idx++;
			}

		}

	}
  
}
