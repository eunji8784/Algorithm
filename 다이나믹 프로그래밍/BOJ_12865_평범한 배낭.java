import java.io.*;
import java.util.*;

public class Main {

	private static int N, K;
	private static int[] w, v;

	public static void main(String[] args) throws IOException {
		getInput();
		System.out.println(solve());
	}

	private static int solve() {
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {

				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}

				if (w[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		return dp[N][K];
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N];
		v = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
	}
}
