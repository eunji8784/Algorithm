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

	private static int R, C;
	private static char[][] map;
	private static Queue<FLocation> fires;
	private static Queue<JLocation> jihuns;

	private static class FLocation {
		int x, y;

		public FLocation(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class JLocation {
		int x, y, time;

		public JLocation(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		fires = new LinkedList<>();
		jihuns = new LinkedList<>();
		boolean vst[][] = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				char chr = tmp.charAt(j);
				if (chr == 'F') {
					fires.add(new FLocation(i, j));
				} else if (chr == 'J') {
					jihuns.add(new JLocation(i, j, 0));
					vst[i][j] = true;
					chr = '.';
				}
				map[i][j] = chr;
			}
		}

		while (true) {
			fireSpread();
			int time = jihunMove(vst);
			if (time != -1) {
				bw.write(time + "\n");
				break;
			}
			if (jihuns.size() == 0) {
				bw.write("IMPOSSIBLE");
				break;
			}
		}

		bw.close();
		br.close();
	}

	public static void fireSpread() {
		int length = fires.size();

		while (length-- > 0) {
			FLocation fire = fires.poll();

			for (int i = 0; i < 4; i++) {
				int nx = fire.x + DX[i];
				int ny = fire.y + DY[i];

				if (!isIn(nx, ny) || map[nx][ny] == '#') {
					continue;
				}

				if (map[nx][ny] == '.') {
					map[nx][ny] = 'F';
					fires.add(new FLocation(nx, ny));
				}
			}
		}
	}

	public static int jihunMove(boolean[][] vst) {
		int length = jihuns.size();

		while (length-- > 0) {
			JLocation jihun = jihuns.poll();

			for (int i = 0; i < 4; i++) {
				int nx = jihun.x + DX[i];
				int ny = jihun.y + DY[i];

				if (!isIn(nx, ny)) {
					return jihun.time + 1;
				}

				if (map[nx][ny] == '.' && !vst[nx][ny]) {
					vst[nx][ny] = true;
					jihuns.add(new JLocation(nx, ny, jihun.time + 1));
				}
			}
		}

		return -1;
	}

	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < R && y >= 0 && y < C);
	}
}
