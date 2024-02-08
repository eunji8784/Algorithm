import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int n, m;
	private static char[][] map;

	private static class Location {
		int x, y, time, key;

		public Location(int x, int y, int time, int key) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		int minsikX = 0, minsikY = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char chr = str.charAt(j);
				if (chr == '0') {
					minsikX = i;
					minsikY = j;
					chr = '.';
				}
				map[i][j] = chr;
			}
		}

		bw.write(solve(minsikX, minsikY) + "\n");
		bw.close();
		br.close();
	}

	private static int solve(int minsikX, int minsikY) {
		Queue<Location> que = new LinkedList<>();
		boolean[][][] vst = new boolean[n][m][64];
		que.offer(new Location(minsikX, minsikY, 0, 0));

		while (!que.isEmpty()) {
			Location cur = que.poll();

			if (map[cur.x][cur.y] == '1') {
				return cur.time;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#' || vst[nx][ny][cur.key]) {
					continue;
				}

				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					int key = cur.key | (1 << (map[nx][ny] - 'a'));
					que.offer(new Location(nx, ny, cur.time + 1, key));
					vst[nx][ny][key] = true;
				} else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					boolean flag = ((cur.key & (1 << (map[nx][ny] - 'A'))) != 0);
					if (flag) {
						vst[nx][ny][cur.key] = true;
						que.offer(new Location(nx, ny, cur.time + 1, cur.key));
					}
				} else {
					vst[nx][ny][cur.key] = true;
					que.offer(new Location(nx, ny, cur.time + 1, cur.key));
				}
			}
		}

		return -1;
	}
}
