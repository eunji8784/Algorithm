import java.io.*;
import java.util.*;

public class Main {
	private static final int N = 5;
	private static final int[] DX = { -1, 1, 0, 0, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1, 0, 0 };
	private static final int[] DZ = { 0, 0, 0, 0, -1, 1 };

	private static int[][][] origin, copy;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		origin = new int[N][N][N];
		copy = new int[N][N][N];
		answer = Integer.MAX_VALUE;

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					origin[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		solve(0, new int[N], new boolean[N]);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		br.close();
	}

	private static void solve(int depth, int[] order, boolean[] vst) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.arraycopy(origin[order[i]][j], 0, copy[i][j], 0, N);
				}
			}

			for (int r1 = 0; r1 < 4; r1++) {
				rotate(0);
				for (int r2 = 0; r2 < 4; r2++) {
					rotate(1);
					for (int r3 = 0; r3 < 4; r3++) {
						rotate(2);
						for (int r4 = 0; r4 < 4; r4++) {
							rotate(3);
							for (int r5 = 0; r5 < 4; r5++) {
								rotate(4);
								if (copy[0][0][0] == 1 && copy[N - 1][N - 1][N - 1] == 1) {
									bfs();
								}				
							}
						}
					}
				}
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!vst[i]) {
				vst[i] = true;
				order[depth] = i;
				solve(depth + 1, order, vst);
				vst[i] = false;
			}
		}
	}

	private static void rotate(int k) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[k][i][j] == 0) continue;
				tmp[j][N - 1 - i] = copy[k][i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			System.arraycopy(tmp[i], 0, copy[k][i], 0, N);
		}
	}

	private static class Location {
		int z, x, y, dist;

		public Location(int z, int x, int y, int dist) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	private static void bfs() {
		Queue<Location> que = new LinkedList<>();
		boolean[][][] vst = new boolean[N][N][N];

		que.offer(new Location(0, 0, 0, 0));
		vst[0][0][0] = true;
		
		while (!que.isEmpty()) {
			Location cur = que.poll();

			if (cur.z == N - 1 && cur.x == N - 1 && cur.y == N - 1) {
				answer = Math.min(answer, cur.dist);
				break;
			}
			
			if (cur.dist > answer) {
				break;
			}

			for (int dir = 0; dir < 6; dir++) {
				int nz = cur.z + DZ[dir];
				int nx = cur.x + DX[dir];
				int ny = cur.y + DY[dir];

				if (!isIn(nz, nx, ny) || copy[nz][nx][ny] == 0 || vst[nz][nx][ny]) {
					continue;
				}

				vst[nz][nx][ny] = true;
				que.offer(new Location(nz, nx, ny, cur.dist + 1));
			}
		}
	}

	private static boolean isIn(int z, int x, int y) {
		return (z >= 0 && z < N && x >= 0 && x < N && y >= 0 && y < N);
	}
}
