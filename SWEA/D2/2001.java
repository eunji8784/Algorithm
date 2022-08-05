import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합
public class Solution {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
				}
			}

			int sum, max;
			max = 0;

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = M; j <= N; j++) {
					sum = 0;
					for (int k = i; k < M + i; k++) {
						sum += map[k][j] - map[k][j - M];
					}
					if (sum > max) {
						max = sum;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, max);

		}
    
	}

}
