import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 좌 상 우 하
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] dc = { {}, { 0, 0, 0, 1, 4 }, { 0, 1, 0, 1, 2 }, { 1, 1, 0, 0, 4 }, { 1, 1, 0, 1, 4 },
			{ 1, 1, 1, 1, 1 } };
	static int N, M, min;
	static int[][] map;
	static int cctvCnt;
	static int[] cctvRow = new int[8];
	static int[] cctvCol = new int[8];
	static int[] cctvType = new int[8];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvCnt = 0;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvRow[cctvCnt] = i;
					cctvCol[cctvCnt] = j;
					cctvType[cctvCnt] = map[i][j];
					cctvCnt++;
				}
			}
		}

		monitoring(0);

		System.out.println(min);

	}

	private static void copyMap(int[][] backup, int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				backup[i][j] = map[i][j];
			}
		}

	}

	private static void monitoring(int cnt) {

		if (cnt == cctvCnt) {
			int tmp = getCount();
			if (tmp < min) {
				min = tmp;
			}
			return;
		}

		int type = cctvType[cnt];
		int[][] backup = new int[N][M];

		for (int i = 0; i < dc[type][4]; i++) {
			copyMap(backup, map);
			for (int j = 0; j < 4; j++) {
				if (dc[type][j] == 1) {
					watch(cctvRow[cnt], cctvCol[cnt], (i + j) % 4);
				}
			}
			monitoring(cnt + 1);
			copyMap(map, backup);
		}

	}

	private static void watch(int x, int y, int i) {

		while (true) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][y] != 6) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = 9;
				}
				x = nx;
				y = ny;
			} else {
				break;
			}
		}

	}

	private static int getCount() {

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;

	}

}
