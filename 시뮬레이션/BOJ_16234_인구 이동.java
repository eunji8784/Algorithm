import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int n, l, r;
	private static int[][] map;

	private static class Location {
		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Union {
		int population;
		Queue<Location> que;

		public Union(int population, Queue<Location> que) {
			this.population = population;
			this.que = que;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(solution() + "\n");
		bw.close();
		br.close();
	}

	private static int solution() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, n);
		}
		boolean[][] vst = new boolean[n][n];
		int day = 0;

		while (true) {
			boolean isPopulationMove = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!vst[i][j]) {
						Union union = new Union(0, new LinkedList<>());
						if (bfs(copy, i, j, vst, union)) {
							isPopulationMove = true;
							Queue<Location> que = union.que;
							int populationCount = union.population;
							while (!que.isEmpty()) {
								Location loc = que.poll();
								map[loc.x][loc.y] = populationCount;
							}
						} else {
							vst[i][j] = false;
						}
					}
				}
			}

			if (!isPopulationMove) {
				break;
			} else {
				day++;
				for (int i = 0; i < n; i++) {
					System.arraycopy(map[i], 0, copy[i], 0, n);
					Arrays.fill(vst[i], false);
				}
			}
		}

		return day;
	}

	private static boolean bfs(int[][] copy, int i, int j, boolean[][] vst, Union union) {
		Queue<Location> que = new LinkedList<>();

		que.offer(new Location(i, j));
		union.que.offer(new Location(i, j));
		vst[i][j] = true;
		int count = 1, sum = copy[i][j];

		while (!que.isEmpty()) {
			Location cur = que.poll();
			int x = cur.x;
			int y = cur.y;

			for (int idx = 0; idx < 4; idx++) {
				int nx = x + DX[idx];
				int ny = y + DY[idx];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || vst[nx][ny]) {
					continue;
				}

				int sub = Math.abs(copy[nx][ny] - copy[x][y]);

				if (l <= sub && sub <= r) {
					vst[nx][ny] = true;
					que.offer(new Location(nx, ny));
					union.que.offer(new Location(nx, ny));
					count++;
					sum += copy[nx][ny];
				}
			}
		}

		if (count > 1) { // 연합이 존재하는 경우
			union.population = sum / count;
			return true;
		}

		return false;
	}
}
