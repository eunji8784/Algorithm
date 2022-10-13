import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1767 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, coreCnt, min, max, core;
	static int[][] map;
	static int[] coreX, coreY;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreX = new int[12];
			coreY = new int[12];
			coreCnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && 0 < i && i < N - 1 && 0 < j && j < N - 1) {
						coreX[coreCnt] = i;
						coreY[coreCnt] = j;
						coreCnt++;
					}
				}
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			core = 0;
			solve(0);

			System.out.printf("#%d %d\n", tc, min);

		}

	}

	private static void solve(int cnt) {

		if (cnt == coreCnt) {
			int tmp = getCount();
			if (core > max) {
				max = core;
				min = tmp;
			} else if (core == max) {
				if (tmp < min) {
					max = core;
					min = tmp;
				}
			}
			return;
		}

		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			flag = false;
			int x = coreX[cnt];
			int y = coreY[cnt];

			if (isConnected(x, y, i)) {
				flag = true;
				connect(x, y, i, 2);
				core++;
				solve(cnt + 1);
				core--;
				connect(x, y, i, 0);
			}
		}

		if (!flag) {
			solve(cnt + 1);
		}

	}

	private static void connect(int x, int y, int i, int num) {
		while (true) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (num == 2 && map[nx][ny] != 1 && map[nx][ny] != 2) {
					map[nx][ny] = 2;
				} else if (num == 0 && map[nx][ny] == 2) {
					map[nx][ny] = 0;
				}
				x = nx;
				y = ny;
			} else {
				break;
			}
		}
	}

	private static boolean isConnected(int x, int y, int i) {
		while (true) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != 1 && map[nx][ny] != 2) {
				if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
					return true;
				}
				x = nx;
				y = ny;
			} else {
				break;
			}
		}
		return false;
	}

	private static int getCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					count++;
				}
			}
		}
		return count;
	}

}
