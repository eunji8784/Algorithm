import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, time;
	static boolean success;
	static char[][] map;
	static Queue<Location> devilQ;
	static Queue<Location> suyeonQ;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			devilQ = new LinkedList<>();
			suyeonQ = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
				if (devilQ.isEmpty() || suyeonQ.isEmpty()) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == '*') {
							devilQ.add(new Location(i, j));
						} else if (map[i][j] == 'S') {
							suyeonQ.add(new Location(i, j));
						}
					}
				}
			}

			time = 0;
			success = false;
			solve();
			
			StringBuilder sb = new StringBuilder();
			if (success) {
				sb.append("#").append(tc).append(" ").append(time).append("\n");
				System.out.print(sb.toString());
			} else {
				sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
				System.out.print(sb.toString());
			}

		}

	}

	private static void solve() {

		while (true) {
			int length = devilQ.size();
			for (int l = 0; l < length; l++) {
				Location current = devilQ.poll();
				int x = current.x;
				int y = current.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (isRange(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						devilQ.add(new Location(nx, ny));
					}
				}
			}

			length = suyeonQ.size();
			for (int l = 0; l < length; l++) {
				Location current = suyeonQ.poll();
				int x = current.x;
				int y = current.y;
				if (map[x][y] == 'D') {
					success = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (isRange(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						if (map[nx][ny] != 'D') {
							map[nx][ny] = 'S';
						}
						suyeonQ.add(new Location(nx, ny));
					}
				}
			}

			if (suyeonQ.isEmpty() || success) {
				return;
			} else {
				time++;
			}
		}

	}

	private static boolean isRange(int nx, int ny) {

		if (0 <= nx && nx < N && 0 <= ny && ny < M) {
			return true;
		}
		return false;

	}

	static class Location {

		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
