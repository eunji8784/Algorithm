import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int[] DX = { 0, 0, -1, 1 };
	private static final int[] DY = { 1, -1, 0, 0 };

	private static int n, m, x, y, k;
	private static int[][] map;
	private static int[] dice = new int[7];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (k-- > 0) {
			int dir = Integer.parseInt(st.nextToken());
			diceMove(dir - 1);
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void diceMove(int dir) {
		int nx = x + DX[dir];
		int ny = y + DY[dir];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
			return;
		}

		x = nx;
		y = ny;
		int tmp = 0;

		switch (dir) {
		case 0:
			tmp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = tmp;
			break;
		case 1:
			tmp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = tmp;
			break;
		case 2:
			tmp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = tmp;
			break;
		case 3:
			tmp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;
		}

		if (map[x][y] == 0) {
			map[x][y] = dice[6];
		} else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}

		sb.append(dice[1] + "\n");
	}

}
