import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static char[][] area;
	static boolean[][] vst1, vst2;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		vst1 = new boolean[N][N];
		vst2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			area[i] = str.toCharArray();
		}

		int ans1 = 0, ans2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vst1[i][j]) {
					bfs1(new Point(i, j));
					ans1++;
				}
				if (!vst2[i][j]) {
					bfs2(new Point(i, j));
					ans2++;
				}
			}
		}

		System.out.println(ans1 + " " + ans2);

	}

	// 적록색약이 아닌 사람
	private static void bfs1(Point start) {

		Queue<Point> que = new LinkedList<>();
		que.offer(start);
		vst1[start.x][start.y] = true;

		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (!vst1[nx][ny] && area[nx][ny] == area[x][y]) {
					que.offer(new Point(nx, ny));
					vst1[nx][ny] = true;
				}
			}
		}

	}

	// 적록색약인 사람
	private static void bfs2(Point start) {

		Queue<Point> que = new LinkedList<>();
		que.offer(start);
		vst2[start.x][start.y] = true;

		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (!vst2[nx][ny]) {
					if (!vst2[nx][ny] && (area[nx][ny] == area[x][y]) || (area[nx][ny] == 'R' && area[x][y] == 'G')
							|| (area[nx][ny] == 'G' && area[x][y] == 'R')) {
						que.offer(new Point(nx, ny));
						vst2[nx][ny] = true;
					}
				}
			}
		}

	}

}
