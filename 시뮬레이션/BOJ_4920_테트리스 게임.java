import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int[][][] BLOCKS = { 
			{ { 0, 1 }, { 0, 2 }, { 0, 3 } }, 
			{ { 0, 1 }, { 1, 1 }, { 1, 2 } },
			{ { 0, 1 }, { 0, 2 }, { 1, 2 } }, 
			{ { 0, 1 }, { 0, 2 }, { 1, 1 } }, 
			{ { 0, 1 }, { 1, 0 }, { 1, 1 } } 
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int caseNum = 1;

		while (true) {
			int n = Integer.parseInt(br.readLine().trim());

			if (n == 0) {
				break;
			}

			int max = Integer.MIN_VALUE;
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int[][] block : BLOCKS) {
						for (int rotate = 0; rotate < 4; rotate++) {
							int sum = map[i][j];
							boolean flag = true;

							for (int[] dir : block) {
								int nx = i + dir[0];
								int ny = j + dir[1];

								if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
									flag = false;
									break;
								}

								sum += map[nx][ny];
							}

							if (flag) max = Math.max(max, sum);
							rotate(block);
						}
					}

				}
			}

			bw.write(caseNum++ + ". " + max + "\n");
		}

		bw.close();
		br.close();
	}

	private static void rotate(int[][] block) {
		for (int[] dir : block) {
			int tmp = dir[0];
			dir[0] = dir[1];
			dir[1] = -tmp;
		}
	}
}
