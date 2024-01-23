import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int n, answer;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		answer = 0;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 1, 0);

		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

	private static void solve(int x, int y, int direction) {
		if (x == n - 1 && y == n - 1) {
			answer++;
			return;
		}

		switch (direction) {
		case 0: // 오른쪽 방향
			if (y + 1 < n && map[x][y + 1] != 1) {
				solve(x, y + 1, 0);
			}
			break;
		case 1: // 아래 방향
			if (x + 1 < n && map[x + 1][y] != 1) {
				solve(x + 1, y, 1);
			}
			break;
		case 2: // 대각선 방향
			if (y + 1 < n && map[x][y + 1] != 1) {
				solve(x, y + 1, 0);
			}
			if (x + 1 < n && map[x + 1][y] != 1) {
				solve(x + 1, y, 1);
			}
		}

		if (x + 1 < n && y + 1 < n && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1 && map[x][y + 1] != 1) {
			solve(x + 1, y + 1, 2);
		}
	}
  
}
