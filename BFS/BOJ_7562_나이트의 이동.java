import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static class Point {
		int x, y, depth;

		Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine(), " ");
			Point goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			bfs(l, start, goal);
		}

	}

	private static void bfs(int l, Point start, Point goal) {

		Queue<Point> que = new LinkedList<>();
		boolean[][] vst = new boolean[l][l];
		que.offer(start);
		vst[start.x][start.y] = true;

		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;
			int depth = current.depth;

			if (x == goal.x && y == goal.y) {
				System.out.println(depth);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
					continue;
				}

				if (!vst[nx][ny]) {
					que.offer(new Point(nx, ny, depth + 1));
					vst[nx][ny] = true;
				}
			}
		}

	}

}
