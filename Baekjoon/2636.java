import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean exit = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		int resCount = 0;
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(new Location(i, j));
					int tmp = remove();
					if (!exit) {
						resCount = tmp;
						time++;
					} else {
						break;
					}
					initVisited();
				}
			}
			if (exit) {
				break;
			}
		}

		System.out.println(time + "\n" + resCount);

	}

	private static void initVisited() {

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

	}

	private static int remove() {

		int count = 0;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					count++;
				}
			}
		}

		if (count == 0) {
			exit = true;
		}

		return count;

	}

	private static void bfs(Location location) {

		Queue<Location> queue = new LinkedList<>();
		queue.add(location);
		visited[location.x][location.y] = true;

		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = loc.x + dx[i];
				int ny = loc.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!visited[nx][ny]) {
						if (map[nx][ny] == 1) {
							visited[nx][ny] = true;
							map[nx][ny] = 2;
						} else if (map[nx][ny] == 0) {
							visited[nx][ny] = true;
							queue.add(new Location(nx, ny));
						}
					}
				}
			}
		}

	}

	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
