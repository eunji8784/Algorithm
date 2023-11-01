import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static final int[][][] CCTV_DIR = { { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 } },
			{ { 0, 1, 2, 3 } } };

	private static int N, M, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] office = new int[N][M];
		min = N * M;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, office);

		System.out.println(min);
		br.close();
	}

	private static void solve(int x, int y, int[][] office) {
		if (x == N) {
			min = Math.min(min, countBlindSpot(office));
			return;
		}

		if (y == M) {
			solve(x + 1, 0, office);
			return;
		}

		if (office[x][y] == 0 || office[x][y] == 6 || office[x][y] == 9) {
			solve(x, y + 1, office);
		} else {
			int[][] cctvDir = CCTV_DIR[office[x][y] - 1];
			for (int[] dir : cctvDir) {
				int[][] copy = copy(office);
				for (int d : dir) {
					int nx = x;
					int ny = y;
					while (true) {
						nx += DIR[d][0];
						ny += DIR[d][1];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= M || copy[nx][ny] == 6) {
							break;
						}
						
						if (copy[nx][ny] == 0) {
							copy[nx][ny] = 9;
						}
					}
				}
				solve(x, y + 1, copy);
			}
		}
	}
	
	private static int countBlindSpot(int[][] office) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0) count++;
			}
		}
		return count;
	}

	private static int[][] copy(int[][] office) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = office[i][j];
			}
		}
		return copy;
	}
}
