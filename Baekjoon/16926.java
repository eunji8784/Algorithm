import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 }; // 우상좌하
	static int[] dy = { 1, 0, -1, 0 }; // 우상좌하

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int group = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {

			for (int j = 0; j < group; j++) {

				int x = j;
				int y = j;

				int value = map[x][y];
				int idx = 0;

				while (idx < 4) {

					int nx = x + dx[idx];
					int ny = y + dy[idx];

					if (nx >= j && nx < N - j && ny >= j && ny < M - j) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					} else {
						idx++;
					}

				}

				map[j + 1][j] = value;

			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}
