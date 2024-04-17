import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static final int[][][] PUZZLE = { { { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 1, 0 }, { 2, 0 }, { 1, -1 } },
			{ { 0, -1 }, { 0, -2 }, { -1, -1 } }, { { -1, 0 }, { -2, 0 }, { -1, 1 } } };

	private static int n, m;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int max = -1;
		map = new int[n][m];
		boolean[][] vst = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				vst[i][j] = true;
				max = Math.max(max, dfs(i, j, vst, 0));
				vst[i][j] = false;

				// ㅗ ㅓ ㅏ ㅜ
				for (int[][] puzzle : PUZZLE) {
					int sum = map[i][j];
					boolean flag = true;

					for (int[] dir : puzzle) {
						int nx = i + dir[0];
						int ny = j + dir[1];

						if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
							flag = false;
							break;
						}

						sum += map[nx][ny];
					}

					if (flag) {
						max = Math.max(max, sum);
					}
				}
			}
		}

		bw.write(max + "\n");
		bw.close();
		br.close();
	}

	private static int dfs(int x, int y, boolean[][] vst, int depth) {
		if (depth == 3) {
			return map[x][y];
		}

		int res = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || vst[nx][ny]) {
				continue;
			}

			vst[nx][ny] = true;
			res = Math.max(res, dfs(nx, ny, vst, depth + 1));
			vst[nx][ny] = false;
		}

		return res + map[x][y];
	}

}
