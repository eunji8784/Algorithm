import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 익은 토마토: 1, 익지 않은 토마토: 0, 토마토가 들어있지 않은 칸: -1
public class Main {

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int[][][] box;
	static class Point {
		int x, y, z;

		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static Queue<Point> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];
		
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					int tomato = Integer.parseInt(st.nextToken());
					box[j][k][i] = tomato;
					if (tomato == 0) {
						cnt++;
					}
					if (tomato == 1) {
						que.offer(new Point(j, k, i));
					}
				}
			}
		}
		
		if (cnt == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		bfs(N, M, H);
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (box[i][j][k] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
					ans = Math.max(ans, box[i][j][k]);
				}
			}
		}
		
		System.out.println(ans - 1);

	}

	private static void bfs(int N, int M, int H) {
		
		while (!que.isEmpty()) {
			Point current = que.poll();
			int x = current.x;
			int y = current.y;
			int z = current.z;
			
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
					continue;
				}
				
				if (box[nx][ny][nz] == 0) {
					que.offer(new Point(nx, ny, nz));
					box[nx][ny][nz] = box[x][y][z] + 1;
				}
			}
		}
		
	}

}
