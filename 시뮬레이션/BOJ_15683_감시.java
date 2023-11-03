import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static final int[][][] CCTV_DIR = { { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 } },
			{ { 0, 1, 2, 3 } } };

	private static int N, M, min;
	private static List<CCTV> cctvs = new ArrayList<>();

	private static class CCTV {
		int x, y, type;

		public CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

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
				if (1 <= office[i][j] && office[i][j] <= 5) {
					cctvs.add(new CCTV(i, j, office[i][j]));
				}
			}
		}

		solve(0, office);

		System.out.println(min);
		br.close();
	}

	private static void solve(int idx, int[][] office) {
		if (idx == cctvs.size()) {
			min = Math.min(min, countBlindSpot(office));
			return;
		}

		CCTV now = cctvs.get(idx);

		for (int[] dir : CCTV_DIR[now.type - 1]) {
			int[][] copy = copy(office);
			
			for (int d : dir) {
				int nx = now.x;
				int ny = now.y;
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
			
			solve(idx + 1, copy);
		}
	}

	private static int countBlindSpot(int[][] office) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0)
					count++;
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
