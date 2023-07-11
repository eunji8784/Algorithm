import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] iceberg;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		boolean flag;

		while (true) {
			flag = false;
			ans++;
			// 빙산 녹이기
			int icebergCnt = icebergMelts();
			if (icebergCnt == 0) {
				System.out.println(0);
				System.exit(0);
			}
			// 구역 검사
			for (int i = 0; i < N; i++) {
				if (flag) {
					break;
				}
				for (int j = 0; j < M; j++) {
					if (iceberg[i][j] > 0) {
						if (bfs(icebergCnt, new Point(i, j))) {
							System.out.println(ans);
							System.exit(0);
						}
						flag = true;
						break;
					}
				}
			}
		}

	}

	private static boolean bfs(int icebergCnt, Point start) {

		Queue<Point> que = new LinkedList<>();
		boolean[][] vst = new boolean[N][M];
		que.offer(start);
		vst[start.x][start.y] = true;
		int cnt = 1;

		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (!vst[nx][ny] && iceberg[nx][ny] != 0) {
					que.offer(new Point(nx, ny));
					vst[nx][ny] = true;
					cnt++;
				}
			}
		}

		if (cnt == icebergCnt) {
			return false;
		} else {
			return true;
		}

	}

	private static int icebergMelts() {

		int icebergCnt = 0;
		boolean vst[][] = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iceberg[i][j] != 0) {
					vst[i][j] = true;
					int cnt = 0;
					for (int idx = 0; idx < 4; idx++) {
						int x = i + dx[idx];
						int y = j + dy[idx];
						if (x < 0 || x >= N || y < 0 || y >= M) {
							continue;
						}
						if (iceberg[x][y] == 0 && !vst[x][y]) {
							cnt++;
						}
					}
					if (iceberg[i][j] > cnt) {
						iceberg[i][j] -= cnt;
						icebergCnt++;
					} else {
						iceberg[i][j] = 0;
					}
				}
			}
		}

		return icebergCnt;

	}

}
