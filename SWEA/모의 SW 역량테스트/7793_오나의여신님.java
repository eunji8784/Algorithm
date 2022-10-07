import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static char[][] map;
	static Queue<Location> devilQ, suyeonQ;
	static int count;
	static boolean success;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			devilQ = new LinkedList<>();
			suyeonQ = new LinkedList<>();
			count = 0;
			success = false;
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

			bfs();

			if (success) {
				System.out.printf("#%d %d\n", tc, count);
			} else {
				System.out.println("#" + tc + " " + "GAME OVER");
			}

		}

	}

	private static void bfs() {

		int len = 0;

		while (true) {
			
			len = devilQ.size();
			for (int l = 0; l < len; l++) {
				Location devilLoc = devilQ.poll();

				for (int i = 0; i < 4; i++) {
					int nx = devilLoc.x + dx[i];
					int ny = devilLoc.y + dy[i];

					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							devilQ.add(new Location(nx, ny));
						}
					}
				}

			}

			len = suyeonQ.size();
			for (int l = 0; l < len; l++) {
				Location suyeonLoc = suyeonQ.poll();

				if (map[suyeonLoc.x][suyeonLoc.y] == 'D') {
					success = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = suyeonLoc.x + dx[i];
					int ny = suyeonLoc.y + dy[i];

					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
							if (map[nx][ny] != 'D') {
								map[nx][ny] = 'S';
							}
							suyeonQ.add(new Location(nx, ny));
						}
					}
				}
				
			}

			if (suyeonQ.isEmpty() || success) {
				break;
			} else {
				count++;
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
