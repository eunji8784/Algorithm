import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, k, min;
	private static int[][] map;
	private static int[][] operation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		operation = new int[k][3];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			operation[i][0] = Integer.parseInt(st.nextToken());
			operation[i][1] = Integer.parseInt(st.nextToken());
			operation[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0, new boolean[k]);

		bw.write(min + "\n");
		bw.close();
		br.close();
	}

	private static void permutation(int depth, boolean[] vst) {
		if (depth == k) {
			calculateMin();
			return;
		}

		for (int i = 0; i < k; i++) {
			if (!vst[i]) {
				vst[i] = true;
				rotateMap(i, 1);
				permutation(depth + 1, vst);
				rotateMap(i, -1);
				vst[i] = false;
			}
		}
	}

	private static void calculateMin() {
		int value = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += map[i][j];
			}
			value = Math.min(value, sum);
		}
		min = Math.min(value, min);
	}

	private static void rotateMap(int idx, int dir) {
		int r = operation[idx][0];
		int c = operation[idx][1];
		int s = operation[idx][2];

		int x1 = r - s - 1;
		int y1 = c - s - 1;
		int x2 = r + s - 1;
		int y2 = c + s - 1;

		while (x1 != x2 && y1 != y2) {
			int tmp = map[x1][y1];

			if (dir == 1) {
				for (int i = x1; i < x2; i++) {
					map[i][y1] = map[i + 1][y1];
				}

				for (int j = y1; j < y2; j++) {
					map[x2][j] = map[x2][j + 1];
				}

				for (int i = x2; i > x1; i--) {
					map[i][y2] = map[i - 1][y2];
				}

				for (int j = y2; j > y1 + 1; j--) {
					map[x1][j] = map[x1][j - 1];
				}

				map[x1][y1 + 1] = tmp;
			}

			if (dir == -1) {
				for (int j = y1; j < y2; j++) {
					map[x1][j] = map[x1][j + 1];
				}

				for (int i = x1; i < x2; i++) {
					map[i][y2] = map[i + 1][y2];
				}

				for (int j = y2; j > y1; j--) {
					map[x2][j] = map[x2][j - 1];
				}

				for (int i = x2; i > x1 + 1; i--) {
					map[i][y1] = map[i - 1][y1];
				}

				map[x1 + 1][y1] = tmp;
			}

			x1++;
			y1++;
			x2--;
			y2--;
		}
	}

}
