import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int l;
	static int[][] map;
	static boolean[][] vst;
	static Location target;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			vst = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Location start = new Location(x, y, 0);
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			target = new Location(x, y, 0);

			bfs(start);

		}

	}

	private static void bfs(Location start) {
		Queue<Location> que = new LinkedList<>();
		vst[start.x][start.y] = true;
		que.add(start);

		while (!que.isEmpty()) {
			Location current = que.poll();
			int x = current.x;
			int y = current.y;
			int depth = current.depth;

			if (x == target.x && y == target.y) {
				System.out.println(depth);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < l && 0 <= ny && ny < l && !vst[nx][ny]) {
					vst[nx][ny] = true;
					que.add(new Location(nx, ny, depth + 1));
				}
			}

		}

	}

	static class Location {
		int x;
		int y;
		int depth;

		public Location(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

}
