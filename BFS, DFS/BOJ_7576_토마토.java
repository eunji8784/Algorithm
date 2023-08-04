import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	// 상하좌우
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int[][] box;
	static Queue<Point> que = new LinkedList<>();

	// 익은 토마토: 1, 익지 않은 토마토: 0, 토마토가 들어있지 않은 칸: -1
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
				if (tomato == 1) {
					que.add(new Point(i, j));
				}
				if (tomato == 0) {
					cnt++;
				}
			}
		}

		// 모든 토마토가 익어있는 상태
		// 0 출력 후 종료
		if (cnt == 0) {
			System.out.println(0);
			System.exit(0);
		}

		bfs(N, M);

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				if (box[i][j] != -1) {
					ans = Math.max(ans, box[i][j]);
				}
			}
		}

		System.out.println(ans - 1);
	}

	private static void bfs(int N, int M) {

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

				if (box[nx][ny] == 0) {
					que.offer(new Point(nx, ny));
					box[nx][ny] = box[x][y] + 1;
				}
			}
		}

	}

}
