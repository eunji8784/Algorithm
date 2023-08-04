import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hdx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hdy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int K, W, H;
	static int[][] board;

	static class Point {
		int x, y, depth, k;

		Point(int x, int y, int depth, int k) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.k = k;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(new Point(0, 0, 0, 0));
		
		System.out.println(-1);
	}

	private static void bfs(Point start) {

		Queue<Point> que = new LinkedList<>();
		boolean[][][] vst = new boolean[H][W][K + 1];
		que.offer(start);
		vst[start.x][start.y][start.k] = true;

		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;
			int depth = current.depth;
			int k = current.k;
			
			if (x == H - 1 && y == W - 1) {
				System.out.println(depth);
				System.exit(0);
			}

			// 원숭이
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == 1) {
					continue;
				}

				if (!vst[nx][ny][k]) {
					que.offer(new Point(nx, ny, depth + 1, k));
					vst[nx][ny][k] = true;
				}
			}

			// 말
			if (k < K) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hdx[i];
					int ny = y + hdy[i];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == 1) {
						continue;
					}

					if (!vst[nx][ny][k + 1]) {
						que.offer(new Point(nx, ny, depth + 1, k + 1));
						vst[nx][ny][k + 1] = true;
					}
				}
			}
		}

	}

}
