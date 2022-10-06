import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] idxTypes = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };
	static int N, M, L;
	static int[][] map;
	static boolean[][] vst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()) - 1;
			map = new int[N][M];
			vst = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(new Location(R, C, 0));

			System.out.printf("#%d %d\n", tc, getCount());

		}

	}

	private static void bfs(Location location) {
		Queue<Location> que = new LinkedList<>();
		que.add(location);
		vst[location.x][location.y] = true;

		while (!que.isEmpty()) {
			Location current = que.poll();
			
			if (current.time == L) {
				break;
			}
			
			for (int idx : idxTypes[map[current.x][current.y]]) {
				int nx = current.x + dx[idx];
				int ny = current.y + dy[idx];
				boolean move = false;

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					int tunnelType = map[nx][ny];
					if (!vst[nx][ny] && tunnelType != 0) {
						if (idx == 0) { // 상 
							if (tunnelType != 3 && tunnelType != 4 && tunnelType != 7) {
								move = true;
							}
						} else if (idx == 1) { // 하 
							if (tunnelType != 3 && tunnelType != 5 && tunnelType != 6) {
								move = true;
							}
						} else if (idx == 2) { // 좌 
							if (tunnelType != 2 && tunnelType != 6 && tunnelType != 7) {
								move = true;
							}
						} else if (idx == 3) { // 우 
							if (tunnelType != 2 && tunnelType != 4 && tunnelType != 5) {
								move = true;
							}
						}

						if (move) {
							que.add(new Location(nx, ny, current.time + 1));
							vst[nx][ny] = true;
						}
					}
				}
			}
		}

	}

	private static int getCount() {

		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (vst[i][j]) {
					count++;
				}
			}
		}

		return count;

	}

	static class Location {

		int x;
		int y;
		int time;

		public Location(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

}
