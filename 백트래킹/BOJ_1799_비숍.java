import java.io.*;
import java.util.*;

public class Main {

	private static final int[] DX = { -1, -1, 1, 1 };
	private static final int[] DY = { -1, 1, -1, 1 };

	private static int N, ans1 = -1, ans2 = -1;
	private static int[][] map;
	private static boolean[][] vst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vst = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(0, 0, 0, 1);
		solution(0, 1, 0, 0);

		System.out.println(ans1 + ans2);
		br.close();
	}

	private static void solution(int x, int y, int count, int color) {
		if (y >= N) {
			x++;
			y = (y % 2 == 0 ? 1 : 0);
		}
		
		if (x >= N) {
			if (color == 1) {
				ans1 = Math.max(ans1, count);
			} else {
				ans2 = Math.max(ans2, count);
			}
			return;
		}
		
		if (map[x][y] == 1 && check(x, y)) {
			vst[x][y] = true;
			solution(x, y + 2, count + 1, color);
			vst[x][y] = false;
		}
		
		solution(x, y + 2, count, color);
	}

	private static boolean check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x, ny = y;
			while (true) {
				nx += DX[i];
				ny += DY[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
				if (vst[nx][ny]) return false;
			}
		}
		return true;
	}

}
