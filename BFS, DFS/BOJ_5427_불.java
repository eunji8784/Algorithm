import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int w, h;
	private static char[][] map;
	private static Queue<Position> fireLocs, sanggeunLocs;
	private static boolean[][] vst;

	private static class Position {
		int x, y, time;

		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			vst = new boolean[h][w];
			fireLocs = new LinkedList<>();
			sanggeunLocs = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();

				for (int j = 0; j < w; j++) {
					if (map[i][j] == '@') {
						sanggeunLocs.offer(new Position(i ,j, 0));
					}
					if (map[i][j] == '*') {
						fireLocs.offer(new Position(i, j, 0));
						vst[i][j] = true;
					}
				}
			}
			bfs();
		}

		br.close();
	}

	private static void bfs() {

		while (true) {
			// fire move
			int length = fireLocs.size();

			for (int l = 0; l < length; l++) {
				Position current = fireLocs.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current.x + DX[i];
					int ny = current.y + DY[i];

					if (!isInArea(nx, ny) || map[nx][ny] == '*' || map[nx][ny] == '#') {
						continue;
					}

					vst[nx][ny] = true;
					map[nx][ny] = '*';
					fireLocs.offer(new Position(nx, ny, 0));
				}
			}

			// sanggeun move
			length = sanggeunLocs.size();

			if (length == 0) {
				System.out.println("IMPOSSIBLE");
				return;
			}

			for (int l = 0; l < length; l++) {
				Position current = sanggeunLocs.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current.x + DX[i];
					int ny = current.y + DY[i];

					if (!isInArea(nx, ny)) {
						System.out.println(current.time + 1);
						return;
					}

					if (vst[nx][ny] || map[nx][ny] == '#') {
						continue;
					}

					vst[nx][ny] = true;
					sanggeunLocs.offer(new Position(nx, ny, current.time + 1));
				}
			}
		}
	}

	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < h && ny >= 0 && ny < w;
	}
}
