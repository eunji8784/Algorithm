import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T = 10;
	static int N = 100;
	static int map[][] = new int[N][N];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= T; tc++) {

			Integer.parseInt(in.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int dx = 99;
			int dy = 0;

			for (int i = 0; i < N; i++) {
				if (map[dx][i] == 2) {
					dy = i;
					break;
				}
			}

			while (dx > 0) {

				dx--;
				
				if (dy != 0 && map[dx][dy - 1] == 1) {
					while (dy > 0 && map[dx][dy - 1] != 0) {
						dy--;
					}
				} else if (dy != 99 && map[dx][dy + 1] == 1) {
					while (dy < 99 && map[dx][dy + 1] != 0) {
						dy++;
					}
				}

			}

			System.out.printf("#%d %d\n", tc, dy);

		}

	}

}
