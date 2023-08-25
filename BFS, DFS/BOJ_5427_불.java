import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };

	private static int w, h;
	private static char[][] map;
	private static Queue<int[]> fireLocs, sanggeunLocs;
	private static boolean[][] vst;

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
				map[i] = br.readLine().toCharArray();

				for (int j = 0; j < w; j++) {
					if (map[i][j] == '@') {
						sanggeunLocs.offer(new int[] { i, j, 0 });
					}
					if (map[i][j] == '*') {
						fireLocs.offer(new int[] { i, j });
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
				int[] current = fireLocs.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current[0] + DX[i];
					int ny = current[1] + DY[i];

					if (!isInArea(nx, ny) || map[nx][ny] == '*' || map[nx][ny] == '#') {
						continue;
					}

					vst[nx][ny] = true;
					map[nx][ny] = '*';
					fireLocs.offer(new int[] { nx, ny });
				}
			}

			// sanggeun move
			length = sanggeunLocs.size();

			if (length == 0) {
				System.out.println("IMPOSSIBLE");
				return;
			}

			for (int l = 0; l < length; l++) {
				int[] current = sanggeunLocs.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current[0] + DX[i];
					int ny = current[1] + DY[i];

					if (!isInArea(nx, ny)) {
						System.out.println(current[2] + 1);
						return;
					}

					if (vst[nx][ny] || map[nx][ny] == '#') {
						continue;
					}

					vst[nx][ny] = true;
					sanggeunLocs.offer(new int[] { nx, ny, current[2] + 1 });
				}
			}
		}
	}

	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < h && ny >= 0 && ny < w;
	}
}
