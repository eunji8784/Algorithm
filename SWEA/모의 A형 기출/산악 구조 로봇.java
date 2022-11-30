import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, Ans;
	static int[][] map, memo;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			Ans = Integer.MAX_VALUE;
			map = new int[N][N];
			memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] v = new boolean[N][N];
			v[0][0] = true;
			dfs(0, 0, 0, v);

			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

	private static void dfs(int x, int y, int fuel, boolean[][] v) {

		if (fuel >= Ans) {
			return;
		}

		if (x == N - 1 && y == N - 1) {
			Ans = Math.min(Ans, fuel);
			return;
		}

		if (memo[x][y] == 0) {
			memo[x][y] = fuel;
		} else {
			if (memo[x][y] > fuel) {
				memo[x][y] = fuel;
			} else {
				return;
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
				v[nx][ny] = true;
				int val = 0;
				if (map[nx][ny] == map[x][y]) {
					val = 1;
				} else if (map[nx][ny] > map[x][y]) {
					val = (map[nx][ny] - map[x][y]) * 2;
				}
				dfs(nx, ny, fuel + val, v);
				v[nx][ny] = false;
			}
		}

	}

}
